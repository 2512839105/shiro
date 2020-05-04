package com.sdzy.mall.util;

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

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.query.Condition;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.base.mapper.BaseAutoIncrementDAO;
import com.sdzy.mall.base.mapper.MallBaseProductMapper;
import com.sdzy.mall.base.mapper.MallBaseStoreInfoMapper;
import com.sdzy.mall.base.model.BaseStock;
import com.sdzy.mall.base.model.MallBaseProduct;
import com.sdzy.mall.base.model.MallBaseStoreInfo;
import com.sdzy.mall.stock.model.StockBatchHistory;
import com.sdzy.mall.stock.mapper.MallStockBatchInventoryDAO;
import com.sdzy.mall.stock.mapper.StockBatchHistoryDAO;
import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.system.mapper.SysConfigDAO;
import com.sdzy.mall.system.model.SysConfig;
import com.sdzy.xiaomi.base.service.SysUserService;

/**
 * 常用server共用工具类
 *
 * @author charlin
 * @create 2018-03-07 14:52
 **/
@Component
public class ServiceUtil {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private MallStockBatchInventoryDAO stockBatchInventoryDAO;
    @Autowired
    private StockBatchHistoryDAO batchHistoryDAO;
    @Autowired
    private MallBaseProductMapper baseProductDAO;
    @Autowired
    private BaseAutoIncrementDAO baseAutoIncrementDAO;
    @Autowired
    private MallBaseStoreInfoMapper baseStoreInfoDAO;
    @Autowired
    private SysConfigDAO sysConfigDAO;

    private static ServiceUtil serviceUtil;

    @PostConstruct
    public void init() {
        serviceUtil = this;
    }

    /**
     * 获取支付方法
     * @return
     */
    public static Integer getPayMethod(String storId){
        MallBaseStoreInfo storeInfo = (MallBaseStoreInfo) serviceUtil.baseStoreInfoDAO.selectById(storId);
        return storeInfo.getPayMethod();
    }

    /**
     * 获取支付方法
     * @return
     */
    public static String getSuperId(){
        String storeId = SessionUtil.getLocalUser().getStoreId();
        Map map = Condition.createEqMap("storeId", storeId);
        SysConfig sysConfig = serviceUtil.sysConfigDAO.findByParam(map);
        return sysConfig.getStoreSa();
    }


    /**
     * 增加库存，商品总数量，添加库存明细历史记录
     * @param operateType 操作：0:表示验收, 1:表示销售, 2:表示退货, 3:表示盘点, 4:验收, 5:不合格品报损, 6:拆零
     * @param stock
     */
    public static void addStock(int operateType, BaseStock stock){
        if(StringUtils.isEmpty(stock.getProductId())){
            throw new CustomerException("操作失败，找不到此类商品..." + stock.getProductId());
        }
        //1加库存
        Map<String, Object> map = new HashMap();
        List<Condition> whereList = new ArrayList();
        if(StringUtil.isNotEmpty(stock.getBatchNo())){
            whereList.add(Condition.createEq("batchNo", stock.getBatchNo()));
        }
        whereList.add(Condition.createEq("productId", stock.getProductId()));
        map.put("whereList", whereList);
        List<MallStockBatchInventory> inventorieList = serviceUtil.stockBatchInventoryDAO.findByParam(map);
        //赠品数据也应当从库存里读取,否则销售的时候取不到数据
        if(inventorieList == null || inventorieList.size() == 0) throw new CustomerException("没有库存：" + stock.getProductId());
        double count = stock.getCount().abs().doubleValue();//数量
        //加库存，找其中一条加
        MallStockBatchInventory stockBatchInventory = inventorieList.get(0);
        //stockBatchInventory.setPurchaseCount(stockBatchInventory.getPurchaseCount().add(stock.getCount().abs()));
        stockBatchInventory.setStockCount(stockBatchInventory.getStockCount().add(stock.getCount().abs()));
        stockBatchInventory.setModifyDate(new Date());
        serviceUtil.stockBatchInventoryDAO.updateByPrimaryKeySelective(stockBatchInventory);

        //2更新产品表总库存
        Map productMap = Condition.createEqMap("productId", stock.getProductId());
        List<MallBaseProduct> baseProductList = serviceUtil.baseProductDAO.listByParam(productMap);
        if(baseProductList == null || baseProductList.size() == 0 ) throw new CustomerException("没找到产品");
        MallBaseProduct baseProduct = baseProductList.get(0);
        baseProduct.setTotalStorage(baseProduct.getTotalStorage().add(stock.getCount().abs()));
        baseProduct.setModifyDate(new Date());
        //baseProduct.setAuditDate1(null);
        //baseProduct.setAuditDate2(null);
        serviceUtil.baseProductDAO.updateByPrimaryKeySelective(baseProduct);

        //3历史表添加退货数据
        LocalUser localUser = SessionUtil.getLocalUser();
        StockBatchHistory stockBatchHistory = new StockBatchHistory();
        try {
            BeanUtils.copyProperties(stockBatchHistory, stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stockBatchHistory.setOperateType(operateType);
        stockBatchHistory.setStoreId(localUser.getStoreId());
        stockBatchHistory.setDeleteFlag(0);
        stockBatchHistory.setModifyDate(new Date());
        stockBatchHistory.setCreateDate(new Date());
        stockBatchHistory.setCount(stock.getCount().doubleValue());
        stockBatchHistory.setCreateUserId(localUser.getCreateUserId());
        stockBatchHistory.setCreateUserName(localUser.getUserName());
        stockBatchHistory.setHistoryId(StringUtil.getUUID());
        serviceUtil.batchHistoryDAO.insert(stockBatchHistory);
    }

    /**
     * 减库存，商品总数量，添加库存明细历史记录
     * 1)减总库存
     * 2)减明细
     * 3)添加历史记录
     * @param operateType 操作：0:表示验收, 1:表示销售, 2:表示退货, 3:表示盘点, 4:验收, 5:不合格品报损, 6:拆零
     * @param stock
     */
    public static void reduceStock(int operateType, BaseStock stock, boolean isGive) {
        if(StringUtils.isEmpty(stock.getProductId())){
            throw new CustomerException("操作失败，找不到此类商品..." + stock.getProductId());
        }

        //查询产品
        Map productMap = Condition.createEqMap("productId", stock.getProductId());
        List<MallBaseProduct> baseProductList = serviceUtil.baseProductDAO.listByParam(productMap);
        if(baseProductList == null || baseProductList.size() == 0 ) throw new CustomerException("没找到产品");
        MallBaseProduct baseProduct = baseProductList.get(0);

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
        map.put("whereList", whereList);
        List<MallStockBatchInventory> inventorieList = serviceUtil.stockBatchInventoryDAO.findByParam(map);
        //赠品数据也应当从库存里读取,否则销售的时候取不到数据
        error = (isGive ? "当前赠品" : "当前药品") + "没有库存";
        if(inventorieList == null || inventorieList.size() == 0) throw new CustomerException(error);
        double count = stock.getCount().abs().doubleValue();//数量

        for(MallStockBatchInventory currentInventory : inventorieList){
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

        //5）历史表添加退货数据
        LocalUser localUser = SessionUtil.getLocalUser();
        StockBatchHistory stockBatchHistory = new StockBatchHistory();
        try {
            BeanUtils.copyProperties(stockBatchHistory, stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stockBatchHistory.setOperateType(operateType);
        stockBatchHistory.setStoreId(localUser.getStoreId());
        stockBatchHistory.setDeleteFlag(0);
        stockBatchHistory.setModifyDate(new Date());
        stockBatchHistory.setCreateDate(new Date());
        stockBatchHistory.setCount(stock.getCount().doubleValue());
        stockBatchHistory.setCreateUserId(localUser.getCreateUserId());
        stockBatchHistory.setCreateUserName(localUser.getUserName());
        stockBatchHistory.setHistoryId(StringUtil.getUUID());
        serviceUtil.batchHistoryDAO.insert(stockBatchHistory);
    }

    /**
     * 创建用户id
     * @param storeId
     * @return
     */
    public static String getUserCodeByStoreId(String storeId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("prefix", "UC");
        paramMap.put("storeId", storeId);
        serviceUtil.baseAutoIncrementDAO.createAutoNo(paramMap);

        String returnValue = paramMap.get("returnVal").toString();
        if(returnValue.length()<2) {
            for(int i=0,length=2-returnValue.length();i<length;i++)
                returnValue = "0" + returnValue;
        }
        return returnValue;
    }


}
