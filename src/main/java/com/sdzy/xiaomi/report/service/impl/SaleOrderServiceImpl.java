package com.sdzy.xiaomi.report.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.modal.BaseStock;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;
import com.sdzy.xiaomi.report.model.SaleOrder;
import com.sdzy.xiaomi.report.model.SaleOrderDetail;
import com.sdzy.xiaomi.report.model.SalePayOrder;
import com.sdzy.mall.stock.constant.StockConstant;
import com.sdzy.mall.util.OrderUtil;
import com.sdzy.xiaomi.cashSale.constant.SaleConstant;
import com.sdzy.xiaomi.report.mapper.SaleOrderDetailMapper;
import com.sdzy.xiaomi.report.mapper.SaleOrderMapper;
import com.sdzy.xiaomi.report.service.SaleOrderDetailService;
import com.sdzy.xiaomi.report.service.SaleOrderService;
import com.sdzy.xiaomi.util.ServiceUtils;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@Service
public class SaleOrderServiceImpl extends BaseServiceImpl<SaleOrderMapper, SaleOrder> implements SaleOrderService {

    @Autowired
	SaleOrderDetailService saleOrderDetailService;
    @Autowired
    SaleOrderDetailMapper saleOrderDetailDAO;
	
    @Override
    public SaleOrder findById(String modelId) {
        return baseMapper.findById(modelId);
    }

    
	@Override
	public  Page<SaleOrder>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		Page<SaleOrder> page = new Page<SaleOrder>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String,Object> map=new HashMap<String,Object>();
		List<Condition> whereList=queryParams.filtersToDBConditionals(); 
	     
		
		map.put("whereList",whereList);
		Wrapper<SaleOrder> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
	    page.setRecords(baseMapper.selectModelsByPage(page, map));	
		return page;
	}



	@Override
	public List<Map<String, Object>> listFlowNum(String storeId, String userId, String dateType) {
	
		if(dateType==null){
			dateType="r";
		}
		
		
		if(dateType.equals("y")){
			 
		 	  return baseMapper.listFlowNumByYear(storeId);
		
		}else if(dateType.equals("m")){
			
			return baseMapper.listFlowNumByMoth(storeId);
		}else if(dateType.equals("w")){
			
			return baseMapper.listFlowNumByWeek(storeId);
		}else if(dateType.equals("d")){
			
			return baseMapper.listFlowNumByDay(storeId);
		}else if(dateType.equals("r")){
			return baseMapper.listFlowNumByRealTime(storeId);
			/*return baseMapper.selectJSCXT();*/
		}else{			
			return baseMapper.listFlowNumByDate(storeId,dateType);
		}		
	}


	@Override
	public List<Map<String, Object>> listReport(String js_code,String appid,String secrect,String storeId, String userId, String dateType) {
		// TODO Auto-generated method stub
			if(storeId==null)
			{
				throw new CustomerException("门店编号不能为空！");
			}
			
			if(dateType.equals("y")){
				 
			 	  return baseMapper.listReportByYear(storeId);
			
			}else if(dateType.equals("m")){
				
				return baseMapper.listReportByMoth(storeId);
			}else if(dateType.equals("w")){
				
				return baseMapper.listReportByWeek(storeId);
			}else if(dateType.equals("d")){
				
				return baseMapper.listReportByDay(storeId);
			}
			
		return null;
	}


	@Override
	public List<Map<String, Object>> saleOrderNo(String storeId ,String dateType) {
		 
		if(dateType.equals("y")){
			 
		 	  return baseMapper.listSaleOrderByYear(storeId);
		
		}else if(dateType.equals("m")){
			
			return baseMapper.listSaleOrderByMoth(storeId);
		}else if(dateType.equals("w")){
			
			return baseMapper.listSaleOrderByWeek(storeId);
		}else if(dateType.equals("d")){
			
			return baseMapper.listSaleOrderByDay(storeId);
		}
		
		return null;
	}



	@Override
	public SaleOrder saveSaleOrderAndDetails(SaleOrder saleOrder,String user) {
		JSONObject jsUser = JSONObject.parseObject(user)	;
		 String storeId =(String) jsUser.get("storeId");
		 String storeCode=jsUser.getString("storeCode");
		 String userId =(String) jsUser.get("userId");
		 String userName =(String) jsUser.get("userName");
		  if (saleOrder == null) throw new CustomerException("没有销售单据");
	        // 查询是否有添加
	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        List<SaleOrder> listOrder = null;
	        String oldSaleOrderNo = saleOrder.getSaleOrderNo();
	        String saleOrderId = saleOrder.getSaleOrderId();
	        String saleOrderNo = saleOrder.getSaleOrderNo();
	        Date current = new Date();
	        // 默认线下支付 0
	     // int payMethod = getPayMethod(storeCode);
	        int payMethod = 0;
	        if(StringUtils.isNotEmpty(oldSaleOrderNo) && StringUtils.isNotEmpty(storeId)){
	            paramMap.put("saleOrderNo", oldSaleOrderNo);
	            paramMap.put("storeId", storeId);
	            listOrder = baseMapper.listByOrderNo(paramMap);
	        }
	        if (listOrder == null || listOrder.size() == 0) {
	            // 添加支付标志 XC 20180829
	            if (StringUtils.isEmpty(saleOrder.getSaleOrderNo())) {// 如果不为空，说明来自处方，已经添加过order
	                // 生成销售订单
	                saleOrder.setStoreId(storeId);
	                saleOrderId = StringUtil.generate16ShortUUID();
	                saleOrder.setSaleOrderId(saleOrderId); // 销售单id
	                saleOrder.setStoreId(storeId);
	                saleOrderNo = OrderUtil.createXSBillNo(storeCode); // 销售单号
	                saleOrder.setSaleOrderNo(saleOrderNo);
	                saleOrder.setSaleDate(current);
	                saleOrder.setCreateDate(current);
	                saleOrder.setModifyDate(current);
	                saleOrder.setSaleOrderType(0);
	                saleOrder.setDeleteFlag(0);
	                saleOrder.setIsPay(0);
	                saleOrder.setOperaterId(userId);
	                saleOrder.setOperater(userName);
	                saleOrder.setPayMethod(payMethod);
	                baseMapper.insertSaleOrder(saleOrder);
	            }
	        }
	        List<SaleOrderDetail> saleOrderDetails = saleOrder.getSaleOrderDetails();
	        if (saleOrderDetails == null) throw new CustomerException("订单没有销售产品信息");
	        // 判断是否添加过销售明细
	        List<SaleOrderDetail> listDeails = null;
	        if(StringUtils.isNotEmpty(oldSaleOrderNo) && StringUtils.isNotEmpty(storeId)){
	            listDeails = saleOrderDetailDAO.listByOrderNo(paramMap);
	        }
	        if (listDeails == null || listDeails.size() == 0) {
	            List<SaleOrderDetail> newDetails = new ArrayList<>();
	            for (SaleOrderDetail detail : saleOrderDetails) {
	                //this.initCommission(detail);
	                detail.setPayMethod(payMethod);
	                detail.setStoreId(storeId);
	                detail.setSaleOrderId(saleOrderId);
	                detail.setSaleOrderDetailId(StringUtil.getUUID());
	                detail.setSaleOrderNo(saleOrderNo);
	                detail.setCreateDate(current);
	                detail.setModifyDate(current);
	                detail.setSaleDate(current);
	                // detail.setFirstSplitDate(null);
	                // 计算让利
	                detail.setDiscountFee(detail.getSellAmount());
	                saleOrderDetailDAO.insertDetail(detail);
	                newDetails.add(detail);
	            }
	            saleOrder.setSaleOrderDetails(newDetails);
	        }
	        return saleOrder;
		 
	}



	/**
     * 组合支付 1. 先保存销售订单与明细 2. 确认是否有支付及支付是否成功 2.1 调用支付的tradePay，进行支付交易 200:调用接口成功。
     * 1:调用接口成功且支付成功。 -1:调用接口成功但支付不成功，结束支付， 其中包括需要用户输入密码，这时需要等待用户输入密码:
     * 调用findTradePaying，正在支付中会返回0，支付成功会返回1 2.2 如果tradePay返回1 或 findTradePaying返回1,
     * 3. 保存支付明细 4. 更新库存与销售订单状态
     *
     * @param saleOrder
     * @return
     */
    @Override
    public SaleOrder submitSaleOrders(SaleOrder saleOrder,String user) {
    	JSONObject jsUser = JSONObject.parseObject(user)	;
		 String storeId =(String) jsUser.get("storeId");
		 String storeCode=jsUser.getString("storeCode");
		 String userId =(String) jsUser.get("userId");
		 String userName =(String) jsUser.get("userName");
        // 2.确认是否有支付及支付是否成功
        List<SalePayOrder> salePayOrders = this.checkPay(saleOrder);

        if (salePayOrders != null && salePayOrders.size() > 0) {
            saleOrder.setSalePayOrders(salePayOrders);
            // 保存支付明细
            this.savePayOrders(saleOrder, SaleConstant.SAVE_TYPE_ZERO,storeCode,storeId);

            // 不是组合支付时，直接更新销售状态
 
           this.updateSaleOrder(saleOrder,jsUser);
               
 
        }

        return saleOrder;
    }
    
    /**
     * 确认是否有支付及支付是否成功 组合支付时， 第一次是验证支付宝 第二次是验证微信 只有都通过了才返回
     *
     * @param saleOrder
     * @return
     */
    public List<SalePayOrder> checkPay(SaleOrder saleOrder) {
        List<SalePayOrder> salePayOrders = saleOrder.getSalePayOrders();
        if (salePayOrders == null || salePayOrders.size() == 0) throw new CustomerException("没有支付信息");
        List<SalePayOrder> list = new ArrayList<>();
        for (SalePayOrder salePayOrder : salePayOrders) {
         
                list.add(salePayOrder);
             
        }
        return list;
    }
    
    
    /**
     * 保存支付明细 条件1 金额 > 0 , 条件2 支付宝或微信依次保存,现金最后保存
     *
     * @param saleOrder
     * @return
     */
    @Override
    public SaleOrder savePayOrders(SaleOrder saleOrder, Integer saveOrder,String storeCode,String storeId) {
        List<SalePayOrder> salePayOrders = saleOrder.getSalePayOrders();
        if (salePayOrders == null || salePayOrders.size() == 0) throw new CustomerException("支付错误:没有支付信息");
        for (SalePayOrder salePayOrder : salePayOrders) {
            double payMoney = salePayOrder.getPayMoney().doubleValue();
            Integer payType = salePayOrder.getPayType();
            if (payMoney > 0) {
                // 支付宝与微信组合支付 ,先保存支付宝支付,然后保存现金与微信
             
                    ServiceUtils.saveSalePayOrder(saleOrder, salePayOrder,storeCode,storeId);
                 
            }
        }
        return saleOrder;
    }

    /**
     * 更新支付状态 在提单与支付单完成后调用 1)更新会员积分 2)把未支付的改成1 3)取消挂单状态减赠品库存 4)开始减库存 a、减自己的库存， b、
     *
     * @param saleOrder
     * @return
     */
    public Integer updateSaleOrder(SaleOrder saleOrder,JSONObject jsUser) {
          SaleOrder so = this.findById(saleOrder.getSaleOrderId());
        if (so == null)
            throw new CustomerException("订单不存在！");
        // 更新会员积分

        // 更新销售订单
        so.setIsPay(1);
        so.setIsPending(0);
        so.setPaymentMoney(saleOrder.getPaymentMoney());
        so.setReceiveMoney(saleOrder.getReceiveMoney());
        so.setChangeMoney(saleOrder.getChangeMoney());
        so.setDeleteFlag(0);
        Integer data = baseMapper.updateByPrimaryKeySelective(so);

        List<SaleOrderDetail> saleOrderDetails = saleOrder.getSaleOrderDetails();
        if (saleOrderDetails == null)
            throw new CustomerException("没有订单数据");

        for (SaleOrderDetail detail : saleOrderDetails) {
            // 更新库存，商品总数量，添加库存明细历史记录
            BigDecimal totalSaleCount = detail.getSaleCount();

            // 如果是以克为单位的，必须换算成千克减库存
            if (StockConstant.SPLIT_UNIT_G.equalsIgnoreCase(detail.getUnit())) {
                totalSaleCount = totalSaleCount.divide(new BigDecimal(1000));
            }
            // 减库存
            BaseStock baseStock = new BaseStock(jsUser.getString("storeId"), detail.getProductId(), totalSaleCount,
                    detail.getBatchNo(), detail.getProductCode());
            ServiceUtils.reduceStock(1, baseStock, false,jsUser);
        }
        return data;
    }


}
