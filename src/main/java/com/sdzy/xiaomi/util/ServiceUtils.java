package com.sdzy.xiaomi.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.modal.BaseStock;
import com.asdzy.common.query.Condition;

import com.asdzy.common.utils.StringUtil;

import com.sdzy.mall.stock.mapper.StockBatchHistoryDAO;
import com.sdzy.mall.stock.model.StockBatchHistory;
import com.sdzy.mall.util.OrderUtil;
import com.sdzy.xiaomi.report.mapper.BaseProductMapper;
import com.sdzy.xiaomi.report.mapper.SalePayOrderMapper;
import com.sdzy.xiaomi.report.mapper.StockBatchInventoryMapper;
import com.sdzy.xiaomi.report.model.BaseProduct;
import com.sdzy.xiaomi.report.model.SaleOrder;
import com.sdzy.xiaomi.report.model.SalePayOrder;
import com.sdzy.xiaomi.report.model.StockBatchInventory;
import com.sdzy.xiaomi.user.mapper.BaseStoreInfoMapper;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;

@Component
public class ServiceUtils {

    private static ServiceUtils serviceUtil;
    @Autowired
    private BaseProductMapper baseProductDAO;
    @Autowired
    private StockBatchInventoryMapper stockBatchInventoryDAO;
    @Autowired
    private StockBatchHistoryDAO batchHistoryDAO;
    @Autowired
	private SalePayOrderMapper salePayOrderDAO;
	@Autowired
	private BaseStoreInfoMapper baseStoreInfoDAO;	

    @PostConstruct
    public void init() {
        serviceUtil = this;
    }
	 /**
     * 减库存，商品总数量，添加库存明细历史记录
     * 1)减总库存
     * 2)减明细
     * 3)添加历史记录
     * @param operateType 操作：0:表示验收, 1:表示销售, 2:表示退货, 3:表示盘点, 4:验收, 5:不合格品报损, 6:拆零
     * @param stock
	 * @param jsUser 
     */
    public static void reduceStock(int operateType, BaseStock stock, boolean isGive, JSONObject jsUser) {
 
    	String storeId= jsUser.getString("storeId");
        if(StringUtils.isEmpty(stock.getProductId())){
            throw new CustomerException("操作失败，找不到此类商品..." + stock.getProductId());
        }

        //查询产品
        Map productMap = Condition.createEQMap(new String[]{"productId", "storeId"}, new String[]{stock.getProductId(),storeId});
        List<BaseProduct> baseProductList = serviceUtil.baseProductDAO.listByParam(productMap);
        if(baseProductList == null || baseProductList.size() == 0 ) throw new CustomerException("没找到产品");
        BaseProduct baseProduct = baseProductList.get(0);

        //4)更新产品表总库存
        String error = (isGive ? "赠品": "药品") + "号为 (" + baseProduct.getProductCode() + ") 总库存小于销售数量";
        if(stock.getCount().doubleValue() > baseProduct.getTotalStorage().doubleValue()){
            throw new CustomerException(error);
        }

        baseProduct.setTotalStorage(baseProduct.getTotalStorage().subtract(stock.getCount().abs()));
        baseProduct.setModifyDate(new Date());
        baseProduct.setAuditDate1(null);
        baseProduct.setAuditDate2(null);
        serviceUtil.baseProductDAO.updateByPrimaryKeySelective(baseProduct);

        //查询在库存中是否存在
        Map<String, Object> map = new HashMap();
        List<Condition> whereList = new ArrayList();
        if(StringUtil.isNotEmpty(stock.getBatchNo())){
            whereList.add(Condition.createEq("batchNo", stock.getBatchNo()));
        }
        whereList.add(Condition.createEq("productId", stock.getProductId()));
        whereList.add(Condition.createEq("storeId", storeId));
        map.put("whereList", whereList);
        List<StockBatchInventory> inventorieList = serviceUtil.stockBatchInventoryDAO.findByParam(map);
        //赠品数据也应当从库存里读取,否则销售的时候取不到数据
        error = (isGive ? "当前赠品" : "当前药品") + "没有库存";
        if(inventorieList == null || inventorieList.size() == 0) throw new CustomerException(error);
        double count = stock.getCount().abs().doubleValue();//数量

        for(StockBatchInventory currentInventory : inventorieList){
            double inventoryCount = currentInventory.getStockCount().doubleValue();
            count -= inventoryCount;
            currentInventory.setModifyDate(new Date());
            if(count <= 0){//说明当前库存大于数量，把多余的数量设置到当前的库存中
                currentInventory.setStockCount(new BigDecimal(count).abs());
                serviceUtil.stockBatchInventoryDAO.updateByPrimaryKeySelective(currentInventory);
                break;
            }else {//说明当前库存小于数量，从下一个库存减
                currentInventory.setStockCount(new BigDecimal(0));
                serviceUtil.stockBatchInventoryDAO.updateByPrimaryKeySelective(currentInventory);
            }
        }

        
        StockBatchHistory stockBatchHistory = new StockBatchHistory();
        try {
            BeanUtils.copyProperties(stockBatchHistory, stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stockBatchHistory.setOperateType(operateType);
        stockBatchHistory.setStoreId(storeId);
        stockBatchHistory.setDeleteFlag(0);
        stockBatchHistory.setModifyDate(new Date());
        stockBatchHistory.setCreateDate(new Date());
        stockBatchHistory.setCount(stock.getCount().doubleValue());
        stockBatchHistory.setCreateUserId(jsUser.getString("userId"));
        stockBatchHistory.setCreateUserName(jsUser.getString("userName"));
        stockBatchHistory.setHistoryId(StringUtil.getUUID());
        serviceUtil.batchHistoryDAO.insert(stockBatchHistory);
        
    }
    
    /**
     * 添加支付订单
     * @param saleOrder
     * @param salePayOrder
     */
    public static void saveSalePayOrder(SaleOrder saleOrder, SalePayOrder salePayOrder,String storeCode,String storeId) {
       
        if(salePayOrder.getPayMoney().doubleValue() == 0) return;
       // int payMethod = getPayMethod(storeCode);
        int payMethod=0;
        salePayOrder.setPayOrderId(StringUtil.generate16ShortUUID());
        salePayOrder.setSaleOrderNo(saleOrder.getSaleOrderNo());
        if(StringUtils.isEmpty(salePayOrder.getPayOrderNo())){
            salePayOrder.setPayOrderNo(OrderUtil.createFKBillNo(storeCode));
        }
        salePayOrder.setPayMethod(payMethod);
        salePayOrder.setDeleteFlag(0);
        salePayOrder.setModifyDate(new Date());
        salePayOrder.setPayDate(new Date());
        salePayOrder.setStoreId(storeId);
        salePayOrder.setOrderType(0); /**表示0:销售, 1:退款*/
        serviceUtil.salePayOrderDAO.insertSalePayOrder(salePayOrder);
    }

    

    /**
     * 获取支付方法
     * @return
     */
    public static Integer getPayMethod(String storeCode){
     
         BaseStoreInfo storeInfo = serviceUtil.baseStoreInfoDAO.findByStoreCode(storeCode);
        return storeInfo.getPayMethod();
    }

}
