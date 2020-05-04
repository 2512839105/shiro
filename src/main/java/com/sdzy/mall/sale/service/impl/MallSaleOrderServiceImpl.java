package com.sdzy.mall.sale.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.base.mapper.MallBaseProductMapper;
import com.sdzy.mall.base.mapper.MallBaseStoreInfoMapper;
import com.sdzy.mall.base.model.BaseStock;
import com.sdzy.mall.base.model.MallBaseProduct;
import com.sdzy.mall.base.model.MallBaseStoreInfo;
import com.sdzy.mall.sale.constant.SaleConstant;
import com.sdzy.mall.sale.mapper.MallSaleOrderDAO;
import com.sdzy.mall.sale.mapper.MallSaleOrderDetailDAO;
import com.sdzy.mall.sale.mapper.MallSalePayOrderDAO;
import com.sdzy.mall.sale.model.MallSaleOrder;
import com.sdzy.mall.sale.model.MallSaleOrderDetail;
import com.sdzy.mall.sale.model.MallSaleOrderPay;
import com.sdzy.mall.sale.model.MallSalePayOrder;
import com.sdzy.mall.sale.model.sample.MallSaleOrderDetailExample;
import com.sdzy.mall.sale.model.sample.MallSaleOrderExample;
import com.sdzy.mall.sale.service.MallSaleOrderService;
import com.sdzy.mall.stock.constant.StockConstant;
import com.sdzy.mall.stock.mapper.MallStockBatchInventoryDAO;
import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.stock.model.vo.MallStockBatchInventoryExample;
import com.sdzy.mall.util.BaseUtil;
import com.sdzy.mall.util.OrderUtil;
import com.sdzy.mall.util.ServiceUtil;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.user.mapper.BaseMemberMapper;
import com.sdzy.xiaomi.user.mapper.BaseStoreInfoMapper;
import com.sdzy.xiaomi.user.model.BaseMember;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;
import com.sdzy.xiaomi.util.PayUtil;


@Service
public class MallSaleOrderServiceImpl implements MallSaleOrderService {
    @Resource
    private MallSaleOrderDAO saleOrderDAO;
    @Resource
    private MallSaleOrderDetailDAO saleOrderDetailDAO;
    @Resource
    private BaseStoreInfoService baseStoreInfoService;
    @Resource
    private MallSalePayOrderDAO salePayOrderDAO;
    @Resource
    private MallStockBatchInventoryDAO stockBatchInventoryDAO;
    @Resource
    private MallBaseProductMapper baseProductDAO;
    @Resource
    private MallBaseStoreInfoMapper baseStoreInfoDAO;
    @Resource
    private BaseMemberMapper baseMemberMapper;

    private static final Logger logger = LoggerFactory.getLogger(MallSaleOrderServiceImpl.class);

    @Override
    public MallSaleOrder insert(MallSaleOrder model) {
        saleOrderDAO.insert(model);
        return model;
    }

    @Override
    public MallSaleOrder findById(String modelId) {
        return saleOrderDAO.findById(modelId);
    }

    @Override
    public List<MallSaleOrder> listByPage(Map<String, Object> paramMap) {
        return saleOrderDAO.listByPage(paramMap);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser) {
       /* Map<String, Object> map = null;
        if(queryParams.getFilters() == null){
            map = BaseUtil.getPageMap(queryParams, new String[]{"isPay"}, new String[]{"1"});
        }else {
            map = BaseUtil.getPageMap(queryParams, currentUser, true);
        }
        List list = saleOrderDAO.listByPage(map);
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public Integer deleteById(String modelId) {
        return saleOrderDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return saleOrderDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return saleOrderDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return saleOrderDAO.updateByParam(paramMap);
    }


    //---处理销售开始------------------------------------------------------------------------------------------------------------------

    /**
     * 暂存订单 /处方单与挂单使用
     * 3、更新或添加销售订单，如果提单，则更新，否则添加
     * 4、更新批次表及产品数据库减库存
     * 5、更新会员积分
     *
     * @param saleOrder 单号
     * @param isPending
     * @return 返回销售订单
     */
    @Override
    public MallSaleOrder pauseSaleOrder(MallSaleOrder saleOrder, Integer isPending) {
        if (saleOrder == null) throw new CustomerException("订单不存在");
        saleOrder.setSaleOrderType(0);
        saleOrder.setReturnStatus(0);
        saleOrder.setIsPending(isPending);
        saleOrder.setIsPay(0);
        //删除没有支付和没有挂单的数据，这些是处方生成的
        this.deleteOrders(0, 0);
        //添加
        return this.saveSaleOrder(saleOrder);
    }

    /**
     * 删除没有支付或挂单的订单及明细
     * 1)查询出没有支付的信息
     * 2) 删除明细
     * 3) 删除主单
     * @param isPay     0没支付
     * @param isPending 1挂单
     */
    public void deleteOrders(Integer isPay, Integer isPending) {
        MallSaleOrderExample saleOrderExample = new MallSaleOrderExample();
        MallSaleOrderExample.Criteria orderExampleCriteria = saleOrderExample.createCriteria();
        orderExampleCriteria.andIsPayEqualTo(isPay);
        orderExampleCriteria.andIsPendingEqualTo(isPending);
        List<MallSaleOrder> saleOrders = saleOrderDAO.selectByExample(saleOrderExample);
        if (saleOrders != null && saleOrders.size() > 0) {
            for (MallSaleOrder saleOrder : saleOrders) {
                //删除明细
                if (StringUtils.isNotEmpty(saleOrder.getSaleOrderNo())) {
                    MallSaleOrderDetailExample detailExample = new MallSaleOrderDetailExample();
                    MallSaleOrderDetailExample.Criteria detailExampleCriteria = detailExample.createCriteria();
                    detailExampleCriteria.andSaleOrderIdEqualTo(saleOrder.getSaleOrderId());
                    int countOrder = saleOrderDetailDAO.deleteByExample(detailExample);
                    //删除主单
                    int countDetail = saleOrderDAO.deleteById(saleOrder.getSaleOrderId());
                }
            }
        }
    }

    /**
     * 根据订单ID删除所有
     */
    public void deleteOrders(String saleOrderId) {
        //删除明细
        if (StringUtils.isNotEmpty(saleOrderId)) {
            MallSaleOrderDetailExample detailExample = new MallSaleOrderDetailExample();
            MallSaleOrderDetailExample.Criteria detailExampleCriteria = detailExample.createCriteria();
            detailExampleCriteria.andSaleOrderIdEqualTo(saleOrderId);
            int countOrder = saleOrderDetailDAO.deleteByExample(detailExample);
            //删除主单
            int countDetail = saleOrderDAO.deleteById(saleOrderId);
        }
    }


    /**
     * 提交表单
     *
     * @param saleOrder
     * @return
     */
    @Override
    public MallSaleOrder submitSaleOrder(MallSaleOrder saleOrder) {
        if (saleOrder == null) throw new CustomerException("订单不存在");
        saleOrder.setSaleOrderType(0);
        saleOrder.setReturnStatus(0);
        saleOrder.setIsPending(0);
        saleOrder.setIsPay(0);
        return this.saveSaleOrder(saleOrder);
    }

    /**
     * 保存销售订单 不产生支付信息
     * 1) 向销售订单添加数据
     * 2) 添加明细
     *
     * @param saleOrder
     * @return
     */
    public MallSaleOrder saveSaleOrder(MallSaleOrder saleOrder) {
        Date current = new Date();
        String storeId = saleOrder.getStoreId();
        MallBaseStoreInfo baseStoreInfo = (MallBaseStoreInfo) baseStoreInfoDAO.selectById(storeId);
        //生成销售订单
        saleOrder.setSaleOrderId(StringUtil.generate16ShortUUID());
        saleOrder.setSaleOrderNo(OrderUtil.createXSBillNo(baseStoreInfo.getStoreCode()));
        saleOrder.setSaleDate(current);
        saleOrder.setCreateDate(current);
        saleOrder.setModifyDate(current);
        
        saleOrder.setTotalRetailAmount(saleOrder.getTotalMemberAmount());
        saleOrder.setPaymentMoney(saleOrder.getTotalMemberAmount());
        saleOrder.setReceiveMoney(saleOrder.getTotalMemberAmount());
        saleOrder.setTotalSaleNum(saleOrder.getTotalCount());
        
        saleOrder.setOrderSource(2);
        saleOrderDAO.insert(saleOrder);

        List<MallSaleOrderDetail> saleOrderDetails = saleOrder.getSaleOrderDetails();
        if (saleOrderDetails == null) throw new CustomerException("订单没有销售产品信息");
        int i = 1;
        for (MallSaleOrderDetail detail : saleOrderDetails) {
            detail.setStoreId(saleOrder.getStoreId());
            detail.setSaleOrderId(saleOrder.getSaleOrderId());
            detail.setSaleOrderDetailId(StringUtil.getUUID());
            detail.setSaleOrderNo(saleOrder.getSaleOrderNo());
            detail.setCreateDate(current);
            detail.setLineNum(i++);
            //计算让利
            saleOrderDetailDAO.insert(detail);
        }
        return saleOrder;
    }

    /**
     * 更新支付状态 在提单与支付单完成后调用
     * 1)更新会员积分
     * 2)把未支付的改成1
     * 3)取消挂单状态
     * 4)开始减库存  a、减自己的库存， b、减赠品库存
     *
     * @param saleOrder
     * @return
     */
    public Integer updateSaleOrder(MallSaleOrder saleOrder,String userId) {
        String storeId = saleOrder.getStoreId();
        MallSaleOrder so = this.findSaleOrderByNo(saleOrder.getSaleOrderNo());
        if (so == null) throw new CustomerException("订单不存在！");
        //更新会员积分
        this.updateMemberScore(so, false,userId);
        //更新销售订单
        so.setIsPay(1);
        so.setIsPending(0);
        so.setReceiveMoney(saleOrder.getReceiveMoney());
        so.setChangeMoney(saleOrder.getChangeMoney());
        so.setPaymentMoney(saleOrder.getPaymentMoney());
        Integer data = saleOrderDAO.updateByPrimaryKeySelective(so);

        List<MallSaleOrderDetail> saleOrderDetails = saleOrder.getSaleOrderDetails();
        if (saleOrderDetails == null) throw new CustomerException("没有订单数据");

        for (MallSaleOrderDetail detail : saleOrderDetails) {
            //更新库存，商品总数量，添加库存明细历史记录
            BigDecimal totalSaleCount = detail.getSaleCount();
            //说明有促销，并且有赠品销售  【{(100067)冬凌草片 0.25g*12片*2板/盒/盒}*1+{(100009)珍菊降压片 100片/盒}*1】
            if (detail.getHasPromotion() == 1 && detail.getPromotionGiveCount() != null && detail.getPromotionGiveCount().doubleValue() > 0) {
                //取得产品Id ,以":"间隔
                if (StringUtil.isNotEmpty(detail.getPromotionGiveProductIds())) { //减其它赠品
                    String giveIds = detail.getPromotionGiveProductIds();
                    if (giveIds.contains(":")) {//如果有多个赠品
                        String[] giveIdsArr = giveIds.split("\\:");
                        if (giveIdsArr != null && giveIdsArr.length > 0) {
                            for (String giveId : giveIdsArr) {
                                BigDecimal saleCount = detail.getPromotionGiveCount().divide(new BigDecimal(giveIdsArr.length));
                                BaseStock baseStock = new BaseStock(storeId, giveId, saleCount);
                                ServiceUtil.reduceStock(1, baseStock, true);
                            }
                        }
                    } else { //单个赠品
                        BigDecimal saleCount = detail.getPromotionGiveCount();
                        BaseStock baseStock = new BaseStock(storeId, giveIds, saleCount);
                        ServiceUtil.reduceStock(1, baseStock, true);
                    }
                } else { //如果是赠送自己, 合计本品
                    totalSaleCount = totalSaleCount.add(detail.getPromotionGiveCount());
                }
            }
            //如果是以克为单位的，必须换算成千克减库存
            if(StockConstant.SPLIT_UNIT_G.equalsIgnoreCase(detail.getUnit())){
                totalSaleCount =  totalSaleCount.divide(new BigDecimal(1000));
            }
            //减库存
            BaseStock baseStock = new BaseStock(storeId, detail.getProductId(), totalSaleCount, detail.getBatchNo(), detail.getProductCode());
            ServiceUtil.reduceStock(1, baseStock, false);
        }
        return data;
    }

    //---处理销售结束------------------------------------------------------------------------------------------------------------------

    //---处理退货开始------------------------------------------------------------------------------------------------------------------

    /**
     * 退货
     * 1)判断单据是否存在
     * 2)会员减积分
     * 3)判断是否有退货数据
     * 4)判断是否有退货金额
     * 5)添加数据到支付订单中，orderType = 1 , payMoney为负数， 如果表单中有订单且saleCount为负数，说明已经退款过
     * 6)插入数据到销售明细中
     * 7) 判断是否有促销赠品，如果有退货
     * 7.1)切割赠品ids,先找库存中的数据加， 然后找产品数据加库存
     *
     * @param saleOrder
     * @return
     */
    @Override
    public void submitReturnOrder(MallSaleOrder saleOrder,String userId) {
        LocalUser localUser = SessionUtil.getLocalUser();

        //1）对数据进行判断
        if (saleOrder == null) throw new CustomerException("退款异常！");

        //2)会员减积分
        this.updateMemberScore(saleOrder, true,userId);

        //3)判断是否有退货数据
        List<MallSaleOrderDetail> saleOrderDetails = saleOrder.getSaleOrderDetails();
        if (saleOrderDetails == null || saleOrderDetails.size() == 0) throw new CustomerException("退款异常！");
        if (!this.hasReurn(saleOrderDetails)) throw new CustomerException("没有退款数据！");

        //4)判断是否有退货金额
        List<MallSalePayOrder> salePayOrders = saleOrder.getSalePayOrders();
        if (salePayOrders == null || salePayOrders.size() == 0) throw new CustomerException("没有退款信息！");


        //5）插入数据到支付订单中，设置detailType = 1,
        this.returnPayOrder(saleOrder, salePayOrders);

        //6）插入数据到销售明细中 设置detailType = 1,  /**订单类型 0:销售订单, 1:退货订单*/
        int i = 1;
        MallBaseProduct baseProduct = null;

        for (MallSaleOrderDetail detail : saleOrderDetails) {
            //6.1)判断是否有产品id
            if (StringUtil.isEmpty(detail.getProductId()) || StringUtil.isEmpty(detail.getBatchNo()))
                throw new CustomerException("当前退货产品异常！");

            //6.2)根据产品ID与批号查询在库存中是否存在
            MallStockBatchInventoryExample batchInventoryExample = new MallStockBatchInventoryExample();
            MallStockBatchInventoryExample.Criteria criteria = batchInventoryExample.createCriteria();
            criteria.andProductIdEqualTo(detail.getProductId());
            criteria.andBatchNoEqualTo(detail.getBatchNo());
            List<MallStockBatchInventory> inventorieList = stockBatchInventoryDAO.selectByExample(batchInventoryExample);
            if (inventorieList == null || inventorieList.size() <= 0) throw new CustomerException("当前退货产品在库存中找不到！");

            //6.3)根据产品ID查询在产品表中是否存在
            baseProduct = baseProductDAO.selectById(detail.getProductId());
            if (baseProduct == null) throw new CustomerException("当前退货产品在商品表找不到！");

            //6.4)添加退货数据
            detail.setTradePrice(baseProduct.getTradePrice());
            detail.setTradeAmount(baseProduct.getTradePrice().multiply(detail.getSaleCount()));
            detail.setStoreId(saleOrder.getStoreId() == null ? localUser.getStoreId() : saleOrder.getStoreId());
            detail.setSaleOrderId(saleOrder.getSaleOrderId());
            detail.setSaleOrderNo(saleOrder.getSaleOrderNo());
            detail.setSaleOrderDetailId(StringUtil.getUUID());
            detail.setCreateDate(new Date());
            detail.setModifyDate(new Date());
            detail.setDetailType(1);//退货
            detail.setLineNum(i++);

            Integer count = saleOrderDetailDAO.insert(detail);
            if (count <= 0) throw new CustomerException("退货失败！");

            //7)促销赠品退货
            BigDecimal totalSaleCount = detail.getSaleCount().abs();
            if (detail.getHasPromotion() == 1 && detail.getPromotionGiveCount() != null && detail.getPromotionGiveCount().doubleValue() > 0) {
                String giveIds = detail.getPromotionGiveProductIds();
                if (StringUtil.isNotEmpty(giveIds)) { // 增加赠品库存
                    if (giveIds.contains(":")) {//如果有多个赠品
                        String[] giveIdsArr = giveIds.split("\\:");
                        if (giveIdsArr != null && giveIdsArr.length > 0) {
                            for (String giveId : giveIdsArr) {
                                BigDecimal saleCount = detail.getPromotionGiveCount().divide(new BigDecimal(giveIdsArr.length));
                                BaseStock baseStock = new BaseStock(localUser.getStoreId(), giveId, saleCount);
                                ServiceUtil.addStock(2, baseStock);
                            }
                        }
                    } else {
                        BigDecimal saleCount = detail.getPromotionGiveCount();
                        BaseStock baseStock = new BaseStock(localUser.getStoreId(), giveIds, saleCount);
                        ServiceUtil.addStock(2, baseStock);
                    }
                } else {
                    totalSaleCount = totalSaleCount.add(detail.getPromotionGiveCount().abs());
                }
            }
            //如果是以克为单位的，必须换算成千克减库存
            if(StockConstant.SPLIT_UNIT_G.equalsIgnoreCase(detail.getUnit())){
                totalSaleCount =  totalSaleCount.divide(new BigDecimal(1000));
            }
            //更新库存，商品总数量，添加库存明细历史记录
            BaseStock baseStock = new BaseStock(localUser.getStoreId(), detail.getProductId(), totalSaleCount, detail.getBatchNo(), detail.getProductCode());
            ServiceUtil.addStock(2, baseStock);
        }

        /*//更新销售订单退货状态*/
        //SaleOrder newSaleOrder = new SaleOrder(saleOrder.getSaleOrderId(), 1);
        MallSaleOrder newSaleOrder = saleOrderDAO.findById(saleOrder.getSaleOrderId());
        newSaleOrder.setSaleOrderType(1);//退货
        newSaleOrder.setReturnStatus(1);//退货
        newSaleOrder.setModifyDate(new Date());
        saleOrderDAO.updateByPrimaryKeySelective(newSaleOrder);
    }

    /**
     * 处理退款
     *
     * @param saleOrder
     * @param localUser
     * @param salePayOrders
     */
    public void returnPayOrder(MallSaleOrder saleOrder, List<MallSalePayOrder> salePayOrders) {
        for (MallSalePayOrder salePayOrder : salePayOrders) {
            //5.1）判断是否可以退款
            Map<String, Object> map = new HashMap();
            List<Condition> whereList = new ArrayList();
            whereList.add(Condition.createEq("saleOrderNo", saleOrder.getSaleOrderNo()));
            map.put("whereList", whereList);
            List<MallSalePayOrder> salePayOrderList = salePayOrderDAO.listByParam(map);
            if (salePayOrderList == null) throw new CustomerException("此单不存在支付信息，不能退款！");

            //5.2）判断是否已经退款
            for (MallSalePayOrder spo : salePayOrderList) {
                if (spo.getOrderType() == 1) throw new CustomerException("此单已经退过款，不能再退款！");
            }

            //5.3）添加退款信息
            salePayOrder.setPayOrderId(StringUtil.generate16ShortUUID());
            salePayOrder.setPayOrderNo(OrderUtil.createZFBillNo(saleOrder.getStoreId()));  //storeCode
            salePayOrder.setPayDate(new Date());
            salePayOrder.setOrderType(1);//退款
            salePayOrder.setStoreId(saleOrder.getStoreId());
            salePayOrder.setSaleOrderNo(saleOrder.getSaleOrderNo());
            salePayOrderDAO.insert(salePayOrder);
        }
    }

    /**
     * 判断是否有退货数据
     *
     * @param saleOrderDetails
     * @return
     */
    private boolean hasReurn(List<MallSaleOrderDetail> saleOrderDetails) {
        boolean hasReturn = false;
        for (MallSaleOrderDetail detail : saleOrderDetails) {
            if (detail.getSaleCount().doubleValue() < 0) {
                hasReturn = true;
            }
        }
        return hasReturn;
    }


    //---处理退货结束------------------------------------------------------------------------------------------------------------------

    @Override
    public MallSalePayOrder findSalePayOrder(String saleOrderNo) {
        return salePayOrderDAO.findSalePayOrder(saleOrderNo);
    }


    @Override
    public MallSalePayOrder addSalePayOrder(MallSaleOrder saleOrder, MallSalePayOrder salePayOrder) {
        saleOrder = this.findById(saleOrder.getSaleOrderId());
        BaseStoreInfo store = baseStoreInfoService.selectById(saleOrder.getStoreId());
        salePayOrder.setPayDate(new Date());
        //如果采用了线上支付
        if(SaleConstant.PAYMETHOD_ONLINE == ServiceUtil.getPayMethod(saleOrder.getStoreId()) && StringUtils.isNotEmpty(salePayOrder.getAuthCode())){
            //2支付宝 3微信
            if (SaleConstant.PAYTYPE_ALI == salePayOrder.getPayType() || SaleConstant.PAYTYPE_WX == salePayOrder.getPayType()) {
                if (StringUtil.isEmpty(salePayOrder.getAuthCode())) {
                    throw new CustomerException("付款码不可为空");
                }
                MallSalePayOrder temp2 = salePayOrderDAO.findByParam(Condition.createEqMap("authCode", salePayOrder.getAuthCode()));
                if (temp2 != null) {
                    throw new CustomerException("付款码已经用于其他订单，请刷新手机");
                }
                //支付宝
                if (SaleConstant.PAYTYPE_ALI == salePayOrder.getPayType()) {
                    if (StringUtils.isEmpty(salePayOrder.getAuthCode()) || salePayOrder.getAuthCode().length() < 16) {
                        throw new CustomerException("支付宝付款码有误！");
                    }
                    String accountNo = store.getStoreCode();
                    String returnValue = PayUtil.tradePay(accountNo, PayUtil.ALIPAY, store.getStoreName(), "药品销售单", salePayOrder.getAuthCode(), saleOrder.getSaleOrderNo(), salePayOrder.getPayMoney(), saleOrder.getStoreId(), store.getStoreId(), "pos1", "");
                    JSONObject jsonObj = JSON.parseObject(returnValue);
                    if (!"200".equals(jsonObj.getString("code"))) {
                        throw new CustomerException(StringUtil.toStr(jsonObj.getString("msg")));
                    }
                    jsonObj = jsonObj.getJSONObject("responseBody");
                    if ("0".equals(jsonObj.getString("state"))) {
                        String jsonSaleOrder = JSON.toJSONString(saleOrder);
                        String jsonSalePayOrder = JSON.toJSONString(salePayOrder);
                        if (StringUtil.isEmpty(salePayOrder.getTradeNo())) {
                            throw new CustomerException("{\"saleOrder\":" + jsonSaleOrder + ",\"salePayOrder\":" + jsonSalePayOrder + ",\"tradeOrderId\":\"" + jsonObj.getString("tradeOrderId") + "\"}");
                        }
                    }

                    if ("1".equals(jsonObj.getString("state"))) {
                        salePayOrder.setInvoiceAmount(jsonObj.getBigDecimal("invoiceAmount"));
                        salePayOrder.setBuyerPayAmount(jsonObj.getBigDecimal("buyerPayAmount"));
                        salePayOrder.setReceiptAmount(jsonObj.getBigDecimal("receiptAmount"));
                        salePayOrder.setTradeNo(jsonObj.getString("tradeNo"));
                        salePayOrder.setPayDate(jsonObj.getDate("payDate"));
                    }
                    if (StringUtil.isEmpty(salePayOrder.getTradeNo())) {
                        throw new CustomerException("支付错误" + StringUtil.toStr(jsonObj.getString("subMsg"), jsonObj.getString("msg")));
                    }
                    //微信
                } else if (SaleConstant.PAYTYPE_WX == salePayOrder.getPayType()) {
                    String accountNo = store.getStoreCode();
                    String returnValue = PayUtil.tradePay(accountNo, PayUtil.WEIXINPAY, store.getStoreName(), "药品销售单", salePayOrder.getAuthCode(), saleOrder.getSaleOrderNo(), salePayOrder.getPayMoney(), store.getStoreId(), store.getStoreId(), "pos1", "");
                    JSONObject jsonObj = JSON.parseObject(returnValue);

                    if ("200".equals(jsonObj.getString("code"))) {
                        jsonObj = jsonObj.getJSONObject("responseBody");
                        if ("1".equals(jsonObj.getString("state"))) {
                            salePayOrder.setBuyerPayAmount(jsonObj.getBigDecimal("cashFee"));
                            salePayOrder.setTradeNo(jsonObj.getString("authCode"));
                            salePayOrder.setPayDate(jsonObj.getDate("payDate"));
                        } else {
                            if ("需要用户输入支付密码".equals(StringUtil.toStr(jsonObj.getString("errCodeDes"), jsonObj.getString("msg")))) {

                                String jsonSaleOrder = JSON.toJSONString(saleOrder);
                                String jsonSalePayOrder = JSON.toJSONString(salePayOrder);
                                if (StringUtil.isEmpty(salePayOrder.getTradeNo())) {
                                    throw new CustomerException("{\"saleOrder\":" + jsonSaleOrder + ",\"salePayOrder\":" + jsonSalePayOrder + ",\"tradeOrderId\":\"" + jsonObj.getString("tradeOrderId") + "\"}");
                                }
                            }
                        }
                        if (StringUtil.isEmpty(salePayOrder.getTradeNo())) {
                            throw new CustomerException(StringUtil.toStr(jsonObj.getString("errCodeDes"), jsonObj.getString("msg")));
                        }
                    } else if ("500".equals(jsonObj.getString("code"))) {
                        throw new CustomerException(StringUtil.toStr(jsonObj.getString("errCodeDes"), jsonObj.getString("msg")));
                    }
                }
            }
        }
        saleOrder.setPaymentMoney(salePayOrder.getPayMoney());
        salePayOrder.setSaleOrderNo(saleOrder.getSaleOrderNo());
        salePayOrder.setStoreId(saleOrder.getStoreId());
        salePayOrder.setPayOrderId(StringUtil.generate16ShortUUID());

        MallBaseStoreInfo baseStoreInfo = (MallBaseStoreInfo) baseStoreInfoDAO.selectById(saleOrder.getStoreId());
        salePayOrder.setPayOrderNo(OrderUtil.createFKBillNo(baseStoreInfo.getStoreCode()));

        salePayOrderDAO.insert(salePayOrder);
        List<Condition> updateList = new ArrayList<Condition>();
        Map map = Condition.createEqMap("modelId", saleOrder.getSaleOrderId());
        updateList.add(Condition.createEq("paymentMoney", saleOrder.getPaymentMoney()));
        updateList.add(Condition.createEq("payType", salePayOrder.getPayType()));
        updateList.add(Condition.createEq("isPay", "1"));
        map.put("updateList", updateList);
        saleOrderDAO.updateById(map);
        return salePayOrder;
    }

    /**
     * 查询提单信息
     *
     * @return
     */
    @Override
    public DataGrid findPending() {
       /* List list = saleOrderDAO.findSaleOrderByPending();
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    /**
     * 根据订单id查询订单明细,查询挂单信息
     * 1)添加的必须删除
     *
     * @return
     */
    @Override
    public List findPendginsByOrderId(String saleOrderId) {
        Map map = Condition.createEqMap("saleOrderId", saleOrderId);
        List list = saleOrderDetailDAO.listByParam(map);
        //删除
        this.deleteOrders(saleOrderId);
        //返回
        return list;
    }

    /**
     * 根据销售订单号查询销售订单明细信息， 一个销售单号可对应多条退货信息
     *
     * @param saleOrderNo
     * @return
     */
    @Override
    public MallSaleOrder findSaleOrderByNo(String saleOrderNo) {
        MallSaleOrder saleOrder = null;
        Map likeMap = Condition.createLikeMap("saleOrderNo", saleOrderNo);
        List<MallSaleOrder> list = saleOrderDAO.listByParam(likeMap);
        if (list != null && list.size() == 1) {
            saleOrder = list.get(0);
            if (saleOrder.getReturnStatus() == 1) throw new CustomerException("此订单已经退货！");
            //查询销售明细信息
            List<MallSaleOrderDetail> detailList = saleOrderDetailDAO.listByParam(Condition.createEqMap("saleOrderId", saleOrder.getSaleOrderId()));
            saleOrder.setSaleOrderDetails(detailList);
        } else {
            throw new CustomerException("订单号有误");
        }
        return saleOrder;
    }


    /**
     * 更新会员积分
     *
     * @param saleOrder
     */
    public void updateMemberScore(MallSaleOrder saleOrder, boolean isReturn,String userId) {
        if (StringUtils.isNotEmpty(saleOrder.getMemberNo())) {
            BaseMember baseMember = baseMemberMapper.selectById(userId);
            Integer totalScore = baseMember.getTotalScore() == null ? 0 : baseMember.getTotalScore();
            if (isReturn) {
                baseMember.setTotalScore(totalScore - saleOrder.getPaymentMoney().intValue());
            } else {
                baseMember.setTotalScore(totalScore + saleOrder.getPaymentMoney().intValue());
            }
            baseMember.setRemainScore(baseMember.getTotalScore());
            baseMember.setLastExpenseDate1(baseMember.getLastExpenseDate2() == null ? new Date() : baseMember.getLastExpenseDate2());
            baseMember.setLastExpenseDate2(new Date());
            baseMemberMapper.updateAllColumnById(baseMember);
        }
    }

    /**
     * 提交支付订单信息
     * 1)判断是否支付，如果已经支付就不用再支付
     *
     * @param saleOrder
     * @return
     */
    @Override
    public void savePayOrder(MallSaleOrder saleOrder,String userId) {
        //判断订单是否已经支付
        if (StringUtils.isEmpty(saleOrder.getSaleOrderNo())) throw new CustomerException("订单不存在!");

        MallSalePayOrder salePayOrder = this.findSalePayOrder(saleOrder.getSaleOrderNo());
        if (salePayOrder != null) throw new CustomerException("订单已经支付");

        List<MallSalePayOrder> salePayOrders = saleOrder.getSalePayOrders();
        if (salePayOrders == null || salePayOrders.size() == 0) throw new CustomerException("支付失败");

        for (MallSalePayOrder salePay : salePayOrders) {
            if (salePay.getPayMoney() == null || salePay.getPayMoney().doubleValue() <= 0)
                throw new CustomerException("支付金额异常");
            try {
                //销售
                salePay.setOrderType(0); /**表示0:销售, 1:退款*/
                salePay.setSaleOrderNo(saleOrder.getSaleOrderNo());
                this.addSalePayOrder(saleOrder, salePay);
            } catch (Exception e) {
                throw new CustomerException(e.getMessage());
            }
        }

        //更新支付订单信息与库存
        this.updateSaleOrder(saleOrder,userId);
    }
    

    @Override
    public List<MallSaleOrder> listByLastestDate(Map<String, Object> map) {
        return saleOrderDAO.listByLastestDate(map);
    }

    @Override
    public Integer findOrderPay(MallSaleOrderPay saleOrderPay) {
        MallSaleOrder saleOrder = saleOrderPay.getSaleOrder();
        
        BaseStoreInfo storeInfo = baseStoreInfoService.selectById(saleOrder.getStoreId());
        String tradeOrderId = saleOrderPay.getTradeOrderId();
        MallSalePayOrder salePayOrder = saleOrderPay.getSalePayOrder();
        int i = 0;
        //60秒内 没支付 弹出支付超时
        while (i < 60) {
            String accountNo = storeInfo.getStoreCode();
            String returnValues = PayUtil.findTradePaying(accountNo, tradeOrderId);
            JSONObject jsonObjs = JSON.parseObject(returnValues);
            jsonObjs = jsonObjs.getJSONObject("responseBody");
            String t = jsonObjs.getString("state");
            //支付成功
            if ("1".equals(jsonObjs.getString("state"))) {
                saleOrder.setPaymentMoney(salePayOrder.getPayMoney());
                salePayOrder.setSaleOrderNo(saleOrder.getSaleOrderNo());
                salePayOrder.setStoreId(saleOrder.getStoreId());
                salePayOrder.setPayOrderId(StringUtil.generate16ShortUUID());

                MallBaseStoreInfo baseStoreInfo = (MallBaseStoreInfo) baseStoreInfoDAO.selectById(saleOrder.getStoreId());
                salePayOrder.setPayOrderNo(OrderUtil.createFKBillNo(baseStoreInfo.getStoreCode()));

                salePayOrderDAO.insert(salePayOrder);
                List<Condition> updateList = new ArrayList<Condition>();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("modelId", saleOrder.getSaleOrderId());
                updateList.add(Condition.createEq("paymentMoney", saleOrder.getPaymentMoney()));
                updateList.add(Condition.createEq("payType", salePayOrder.getPayType()));
                updateList.add(Condition.createEq("isPay", "1"));
                map.put("updateList", updateList);
                return saleOrderDAO.updateById(map);
            }
            i++;
            logger.info("支付时间" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new CustomerException("输入密码超时，请重新扫码");
    }

    @Override
    public String findOrderPaySuccess(String tradeOrderId,String storeCode) {
        String returnValues = PayUtil.findTradePaying(storeCode, tradeOrderId);
        JSONObject jsonObjs = JSON.parseObject(returnValues);
        jsonObjs = jsonObjs.getJSONObject("responseBody");
        if ("1".equals(jsonObjs.getString("state"))) {
            return "success";
        }
        return "flase";
    }


}