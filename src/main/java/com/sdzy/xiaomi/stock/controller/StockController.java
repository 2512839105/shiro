package com.sdzy.xiaomi.stock.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.enums.AuditStatus;
import com.asdzy.common.enums.StockInventoryProfitLossType;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.util.OrderUtil;
import com.sdzy.xiaomi.report.service.StockBatchInventoryService;
import com.sdzy.xiaomi.stock.entity.BaseProduct;
import com.sdzy.xiaomi.stock.entity.DaySummary;
import com.sdzy.xiaomi.stock.entity.StockBatchInventory;
import com.sdzy.xiaomi.stock.entity.StockInventoryProfitLoss;
import com.sdzy.xiaomi.stock.entity.StockInventoryProfitLossDetail;
import com.sdzy.xiaomi.stock.entity.StockTaking;
import com.sdzy.xiaomi.util.BaseUtil;

@RestController
@EnableTransactionManagement // 开启事务
public class StockController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(StockController.class);

    @Autowired
    StockBatchInventoryService stockBatchInventoryService;
    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    /*
     * @GetMapping("/findInventorys.action")
     * 
     * @ResponseBody public String findInventorys(@RequestParam(value =
     * "vloginId",required = false) String vloginId, @RequestParam(value =
     * "vpwd",required = false) String vpwd,String keyword,String storeId,String
     * sort,Integer order){
     * data=stockBatchInventoryService.findInventorys(keyword,storeId,sort); return
     * BaseUtil.productJson(1, data,"获取成功"); }
     */
    /**
     * 获取库存商品接口
     * 
     * @param vloginId：接口验证登录名
     *            vpwd：接口验证密码 order:排序类别 0降序，1升序 sort:排序对象，根据什么字段排序
     * @return Json
     */
    @GetMapping("/findInventory.action")
    @ResponseBody
    public String findInventory(@RequestParam(value = "vloginId", required = false) String vloginId,
            @RequestParam(value = "vpwd", required = false) String vpwd, String keyword, String storeId, String sort,
            Integer order) {

        String barCodePattern = "^[0-9]{8,13}$";
        String keywordFind = "";
        String orderBy = "";
        if (Pattern.matches(barCodePattern, keyword)) {
            keywordFind = "barCode = '" + keyword+"'";
        } else {
            keywordFind = "b.productCode = CONCAT('" + keyword + "')";
        }
        orderBy = " order by stockCount desc,sb.createDate desc";

        // stockCount,sb.unit,sb.producingArea,sb.productCode,sb.productId,sb.productName,sb.storeId,sb.standard,sb.approvalNumber,sb.batchNo,sb.produceDate,sb.expiryDate
        String sql = "SELECT inventoryId, sb.storeId, sb.supplierId, sb.supplierName, sb.productId, sb.productCode, sb.productName,"
                + " sb.genericName, sb.standard, sb.unit, sb.producingArea, sb.produceFactory, sb.approvalNumber, sb.dosageForm,"
                + " sb.produceDate, sb.expiryDate, sb.batchNo, sb.lotNo, sb.purchasePrice,sb.produceFactory,"
                + " sb.operatorId, sb.operator, sb.inspectionOrderNo, sb.createDate, sb.modifyDate, sb.remark,"
                + " sb.deleteFlag,SUM(sb.stockCount) AS stockCount,SUM(sb.purchaseCount) AS purchaseCount,SUM(sb.purchaseFee) AS purchaseFee "
                + "from stockBatchInventory sb,baseProduct b where" + " sb.productId = b.productId and sb.storeId = "
                + "'" + storeId + "'" + " and " + keywordFind + " group by batchNo" + orderBy;
        try {
            data = BaseUtil.executeQueryByJdbc(sql, new StockBatchInventory(), new BaseProduct());
            log.info("-----------excuteSql ：" + sql);
            log.info("-----------param1 ：" + storeId + ",param2 ：" + keyword);
            return BaseUtil.productJson(1, data, "获取成功");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException | SQLException e) {
            // 异常回滚
            e.printStackTrace();
            System.out.println("打印异常" + e);
            throw new CustomerException("获取失败!");
        }
    }

    /**
     * 更新库存、商品及添加盘点订单接口
     * 
     * @param vloginId：接口验证登录名
     *            vpwd：接口验证密码 productCode：产品号 batchcNo：批号 checkCount：盘点数量
     *            storeId：门店ID 从登陆接口中获取 userId：当前用户D 从登陆接口中获取
     * 
     * @return Json
     */
    @RequestMapping("/updateInventory.action")
    @ResponseBody
    public String updateInventory(@RequestParam(value = "vloginId", required = false) String vloginId,
            @RequestParam(value = "vpwd", required = false) String vpwd, String updateList, String storeId,
            String userId, String userName) {

        JSONArray updateArray = JSONArray.parseArray(updateList);
        Map<String, Object> map = new HashMap<String, Object>();;
        List<String> sqList = new ArrayList<String>();
        /* 计算盘盈盘亏后的同一批号所有库存为总库存*/
        BigDecimal totalStorage = new BigDecimal(0);
        String productCode = (String) updateArray.getJSONObject(0).get("productCode");

        for (int i = 0; i < updateArray.size(); i++) {
            map.clear();
            JSONObject jsonOne = updateArray.getJSONObject(i);
            String checkCount = (String) jsonOne.get("checkCount");
            String batchNo = (String) jsonOne.get("batchcNo");

            String findstockBatchSql = "select s.*,b.storeCode from stockBatchInventory s inner join baseStoreInfo b on b.storeId = s.storeId where b.storeId = "
                    + "'" + storeId + "'" + " and productCode=" + productCode + " and batchNo='" + batchNo
                    + "'  order by stockCount desc";
            StockBatchInventory stockBatchInventory = null;
            List<StockBatchInventory> lists = null;
            try {
                // 根据批号，产品号，门店号获得批次库存数据
                lists = (List<StockBatchInventory>) BaseUtil.executeQueryByJdbc(findstockBatchSql,new StockBatchInventory(), null);
                stockBatchInventory = (StockBatchInventory) lists.get(0);

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException | SQLException | NullPointerException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return BaseUtil.productJson(null, null, "数据错误!请检查产品与批号！");
            }
            // 写方法计算盘点亏损
            Map<String, Object> maps = calculate(lists, checkCount);

            // 损益数量，可能大于0，可能小于0
            float profitLossCount = Float.parseFloat(maps.get("profitAndLossCount").toString());

            List<StockBatchInventory> updateListId = new ArrayList<StockBatchInventory>();
            
             /* 同一批号存在多个批次，因此在做库存加减的时候，如果是盘盈的，就全部加在同一批号最大库存的批次里，如果盘亏的，则减第一个批次的库存，如果不够减
                                    则寻找库存第二大的往下减，以此类推*/
            for (StockBatchInventory countBatchInventory : lists) {
                BigDecimal subtract = countBatchInventory.getStockCount().add(new BigDecimal(profitLossCount));
                if (subtract.floatValue() >= 0) {
                    countBatchInventory.setStockCount(subtract);
                    updateListId.add(countBatchInventory);
                    break;
                } else {
                    countBatchInventory.setStockCount(new BigDecimal(0));
                    profitLossCount = profitLossCount + countBatchInventory.getStockCount().floatValue();
                }
                updateListId.add(countBatchInventory);
            }

            /* 统计当前批号所有批次的数量,通过循环累加所有批号的数量，作为新库存总数 */
            for (StockBatchInventory countBatchInventory : lists) {
                totalStorage = totalStorage.add(countBatchInventory.getStockCount());
            }

            /* 批量更新所有加/减过库存的批次库存明细 */
            StringBuilder updatestockBatchSql = new StringBuilder("update stockBatchInventory set modifyDate = "
                    + changeNullObj(DateUtil.getCurrDateTime()) + ",stockCount = case ");
            StringBuilder updateId = new StringBuilder();
            
            for (StockBatchInventory updateBean : updateListId) {
                updatestockBatchSql = updatestockBatchSql.append(" when inventoryId='" + updateBean.getInventoryId()
                        + "' then " + updateBean.getStockCount().floatValue());
                updateId = updateId.append("'" + updateBean.getInventoryId() + "',");
            }
            updateId = updateId.deleteCharAt(updateId.length() - 1);
            updatestockBatchSql = updatestockBatchSql.append(" end where inventoryId in (" + updateId.toString() + ")");
            //添加更新批次库存明细sql
            sqList.add(updatestockBatchSql.toString());


            String mInsertProfit = new String();
            String dInsertProfit = new String();
            StockTaking stockTaking = setStockTaking(stockBatchInventory, maps, storeId, userId, jsonOne, userName);

            String insertSql = new String();
            try {
                insertSql = BaseUtil.createSql(stockTaking, "stockTaking");
                //添加新增盘点记录sql
                sqList.add(insertSql);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new CustomerException("生成盘点sql出错", e);
            }

            // 盘盈盘亏表插入,盘点数量>账面数量 盘盈，盘点数量<账面数量 盘亏 相等不做处理

            if (profitLossCount != 0) {
                StockInventoryProfitLoss sProfitLossData = null;
                StockInventoryProfitLossDetail sProfitLossDetailData = null;
                if (profitLossCount > 0) {
                    Map<String, Object> beanMap;
                    try {
                        beanMap = AddProfitLoss(userId, storeId, 0, maps, stockBatchInventory, stockTaking,
                                stockBatchInventory.getStoreCode(), userName);
                    } catch (Exception e) {
                        throw new CustomerException("复制盘点类属性失败", e);
                    }

                    sProfitLossData = (StockInventoryProfitLoss) beanMap.get("StockInventoryProfitLoss");
                    sProfitLossDetailData = (StockInventoryProfitLossDetail) beanMap
                            .get("StockInventoryProfitLossDetail");

                } else if (profitLossCount < 0) {
                    Map<String, Object> beanMap;
                    try {
                        beanMap = AddProfitLoss(userId, storeId, 1, maps, stockBatchInventory, stockTaking,
                                stockBatchInventory.getStoreCode(), userName);
                    } catch (Exception e) {
                        throw new CustomerException("复制盘点类属性失败", e);
                    }
                    sProfitLossData = (StockInventoryProfitLoss) beanMap.get("StockInventoryProfitLoss");
                    sProfitLossDetailData = (StockInventoryProfitLossDetail) beanMap
                            .get("StockInventoryProfitLossDetail");
                }

                try {
                    mInsertProfit = BaseUtil.createSql(sProfitLossData, "stockInventoryProfitLoss");
                    //添加新增盘盈盘亏主表sql
                    sqList.add(mInsertProfit);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    throw new CustomerException("生成盘盈盘亏主单出错", e);

                }
                try {
                    dInsertProfit = BaseUtil.createSql(sProfitLossDetailData, "stockInventoryProfitLossDetail");
                    //添加新增盘盈盘亏明细表sql
                    sqList.add(dInsertProfit);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    throw new CustomerException("生成盘盈盘亏明细出错", e);
                }
                
                
            }
        }
        
        /* 更新主表数量为更新后的所有批号的库存和 */
        String updatebaseProductSql = "update baseProduct set totalStorage = " + totalStorage.floatValue()
                + " ,modifyDate = " + changeNullObj(DateUtil.getCurrDateTime()) + " WHERE productCode = '"
                + productCode + "' and storeId = '" + storeId + "'";
       
        //添加更新商品数量sql
        sqList.add(updatebaseProductSql);
        
        try {
            BaseUtil.executeAllByJdbc(sqList.toArray(new String[sqList.size()]));
            log.info("---------inert sqlList :" + sqList.toString());
        } catch (SQLException e) {
            log.info("---------inert sqlList :" + sqList.toString());
            throw new CustomerException("更新失败!", e);
        }

        
        /*try {
            if (StringUtil.isEmpty(mInsertProfit) && StringUtil.isEmpty(dInsertProfit)) {
                BaseUtil.executeAllByJdbc(
                        new String[] { insertSql, updatestockBatchSql.toString(), updatebaseProductSql });
                log.info("---------inert stockTaking :" + insertSql);
                log.info("---------update stockBatchInventory :" + updatestockBatchSql);
                log.info("---------update baseProduct:" + updatebaseProductSql);
            } else {
                BaseUtil.executeAllByJdbc(new String[] { insertSql, updatestockBatchSql.toString(),
                        updatebaseProductSql, mInsertProfit, dInsertProfit });
                log.info("---------inert stockTaking :" + insertSql);
                log.info("---------update stockBatchInventory :" + updatestockBatchSql);
                log.info("---------update baseProduct:" + updatebaseProductSql);
                log.info("---------insert profitLoss:" + mInsertProfit);
                log.info("---------insert profitLossDetail:" + dInsertProfit);
            }
        } catch (Exception e) {
            // 异常回滚
            e.printStackTrace();
            log.error("---------inert stockTaking :" + insertSql);
            log.error("---------update stockBatchInventory :" + updatestockBatchSql);
            log.error("---------update baseProduct:" + updatebaseProductSql);
            throw new CustomerException("更新失败!", e);
        }*/
        return BaseUtil.productJson(1, "", "更新成功！");
    }

    private StockTaking setStockTaking(StockBatchInventory stockBatchInventory, Map<String, Object> maps,
            String storeId, String userId, JSONObject jsonOne, String userName) {
        StockTaking stockTaking = new StockTaking();
        stockTaking.setStockTakingId(StringUtil.getUUID());
        stockTaking.setStoreId(storeId);
        stockTaking.setStockTakingDate(DateUtil.getCurrDateTime());
        stockTaking.setProductId(stockBatchInventory.getProductId());
        stockTaking.setProductCode(stockBatchInventory.getProductCode());
        stockTaking.setProductName(stockBatchInventory.getProductName());
        stockTaking.setBatchNo(stockBatchInventory.getBatchNo());
        stockTaking.setUnit(stockBatchInventory.getUnit());
        stockTaking.setProduceFactory(stockBatchInventory.getProduceFactory());
        stockTaking.setPrice(stockBatchInventory.getPurchasePrice());
        stockTaking.setProduceDate(stockBatchInventory.getProduceDate());
        stockTaking.setExpiryDate(stockBatchInventory.getExpiryDate());
        stockTaking.setGenericName(stockBatchInventory.getGenericName());
        stockTaking.setProducingArea(stockBatchInventory.getProducingArea());
        stockTaking.setApprovalNumber(stockBatchInventory.getApprovalNumber());
        stockTaking.setDosageForm(stockBatchInventory.getDosageForm());
        stockTaking.setLotNo(stockBatchInventory.getLotNo());
        stockTaking.setBookCount(stockBatchInventory.getStockCount());
        stockTaking.setBookAmount(stockBatchInventory.getPurchaseFee());
        stockTaking.setCheckCount(new BigDecimal(jsonOne.get("checkCount").toString()));
        stockTaking.setCheckAmount(new BigDecimal(maps.get("checkAmount").toString()));
        stockTaking.setProfitAndLossCount(new BigDecimal(maps.get("profitAndLossCount").toString()));
        stockTaking.setProfitAndLossAmount(new BigDecimal(maps.get("profitAndLossAmount").toString()));
        stockTaking.setAuditState(1);
        stockTaking.setCreateUserId(userId);
        stockTaking.setCreateUserName(userName);
        stockTaking.setAuditUser(userName);
        stockTaking.setCreateDate(DateUtil.getCurrDateTime());
        stockTaking.setModifyDate(DateUtil.getCurrDateTime());
        stockTaking.setHasGspAdded(0);
        stockTaking.setDeleteFlag(0);
        return stockTaking;
    }

    private Map<String, Object> AddProfitLoss(String userId, String storeId, int type, Map<String, Object> dataMap,
            StockBatchInventory stockBatchInventory, StockTaking stockTaking, String storeCode, String userName)
            throws IllegalAccessException, InvocationTargetException {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        StockInventoryProfitLoss profitLoss = new StockInventoryProfitLoss();
        profitLoss.setInventoryProfitLossId(StringUtil.getUUID());
        profitLoss.setStoreId(storeId);
        profitLoss.setAuditState(AuditStatus.AUDITED.getValue());
        profitLoss.setCreateUserId(userId);
        profitLoss.setCreateUserName(userName);
        profitLoss.setCreateDate(DateUtil.getCurrDateTime());
        profitLoss.setModifyDate(DateUtil.getCurrDateTime());
        profitLoss.setBillDate(DateUtil.getCurrDateTime());
        profitLoss.setAuditUser(userName);
        String profitLossNo = (type == 0 ? OrderUtil.createPYBillNo(storeCode) : OrderUtil.createPKBillNo(storeCode));
        profitLoss.setInventoryProfitLossNo(profitLossNo);
        profitLoss.setBillMoney(BigDecimal.ZERO);
        profitLoss.setRemark("来自盘点的数据");
        Integer typeId = (type == 0 ? StockInventoryProfitLossType.PROFIT.getValue()
                : StockInventoryProfitLossType.LOSS.getValue());
        profitLoss.setTypeId(typeId);
        profitLoss.setDeleteFlag(0);
        StockInventoryProfitLossDetail detail = new StockInventoryProfitLossDetail();
        BeanUtils.copyProperties(detail, stockTaking);
        detail.setInventoryProfitLossDetailId(StringUtil.getUUID());
        detail.setPrice(stockTaking.getPrice());
        detail.setAmount(stockTaking.getProfitAndLossCount());
        detail.setStoreId(storeId);
        detail.setInventoryProfitLossNo(profitLossNo);
        detail.setAmountOfMoney(detail.getAmount().multiply(detail.getPrice()));
        detail.setCreateDate(DateUtil.getCurrDateTime());
        detail.setModifyDate(DateUtil.getCurrDateTime());
        detail.setDeleteFlag(0);
        profitLoss.setBillMoney(profitLoss.getBillMoney().add(detail.getAmountOfMoney()));
        resultMap.put("StockInventoryProfitLoss", profitLoss);
        resultMap.put("StockInventoryProfitLossDetail", detail);
        return resultMap;
    }

    private Map<String, Object> calculate(List<StockBatchInventory> lists, String checkCount) {
        Map<String, Object> map = new HashMap<String, Object>();
        float stockCount = 0;
        for (StockBatchInventory stockBatchInventory : lists) {
            stockCount += stockBatchInventory.getStockCount().floatValue();
        }
        map.put("checkAmount", lists.get(0).getPurchasePrice().multiply(new BigDecimal(checkCount)));
        map.put("profitAndLossCount", new BigDecimal(checkCount).subtract(new BigDecimal(stockCount)));
        map.put("profitAndLossAmount",
                lists.get(0).getPurchasePrice().multiply((BigDecimal) map.get("profitAndLossCount")));
        return map;
    }

    /**
     * 获取即时库存接口
     * 
     * @param vloginId：接口验证登录名
     *            vpwd：接口验证密码 productCode：产品号 batchcNo：批号 checkCount：盘点数量
     *            storeId：门店ID 从登陆接口中获取 userId：当前用户D 从登陆接口中获取 order:排序类别 0降序，1升序
     *            sort:排序对象，根据什么字段排序
     * @return Json
     */
    @RequestMapping("/listInstantStock.action")
    @ResponseBody
    public String listInstantStock(@RequestParam(value = "vloginId", required = false) String vloginId,
            @RequestParam(value = "vpwd", required = false) String vpwd, String storeId, String userId, String keyword,
            Integer pageIndex, Integer pageSize, String sort, Integer order) {
        logger.info("用户" + userId + " 正在调用获取即时库存接口");
        String orderBy = "";
        if (StringUtil.isEmpty(pageSize)) {
            pageSize = 10;
        }
        if (StringUtil.isEmpty(pageIndex) || pageIndex == 1) {
            pageIndex = 0;
        } else {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        String barCodePattern = "^[0-9]{13}$";
        String keywordFind = "";
        if (Pattern.matches(barCodePattern, keyword)) {
            keywordFind = "barCode = " + keyword + "or localBarCode = " + keyword;
        } else {
            keywordFind = "productCode like CONCAT('%','" + keyword + "','%') or productName like CONCAT('%','"
                    + keyword + "','%') or genericName like CONCAT('%','" + keyword + "','%')";
        }
        if (order != null && order == 0) {
            orderBy = " order by " + sort + " desc";
        } else if (order != null && order == 1) {
            orderBy = " order by " + sort + "";
        }
        String sql = "select * from stockBatchInventory  where storeId = " + storeId + " and " + keywordFind + orderBy
                + " limit " + pageIndex + "," + pageSize;
        try {
            data = BaseUtil.executeQueryByJdbc(sql, new StockBatchInventory(), new BaseProduct());
            return BaseUtil.productJson(1, data, "获取成功!");
        } catch (IllegalArgumentException | SecurityException | SQLException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            // 异常回滚
            e.printStackTrace();
            throw new CustomerException("获取失败!");
        }

    }

    /**
     * 获取效期品种接口
     * 
     * @param vloginId：接口验证登录名
     *            vpwd：接口验证密码 productCode：产品号 batchcNo：批号 checkCount：盘点数量
     *            storeId：门店ID 从登陆接口中获取 userId：当前用户D 从登陆接口中获取
     * @return Json
     */
    @RequestMapping("/listExpiredProduct.action")
    @ResponseBody
    public String listExpiredProduct(@RequestParam(value = "vloginId", required = false) String vloginId,
            @RequestParam(value = "vpwd", required = false) String vpwd, String storeId, String userId,
            Integer pageIndex, Integer dateType, Integer pageSize, String sort, Integer order) {
        logger.info("用户" + userId + " 正在调用获取效期品种接口");
        if (StringUtil.isEmpty(pageSize)) {
            pageSize = 10;
        }
        if (StringUtil.isEmpty(pageIndex) || pageIndex == 1) {
            pageIndex = 0;
        } else {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        String orderBy = "";
        if (order != null && order == 0) {
            orderBy = " order by " + sort + " desc";
        } else if (order != null && order == 1) {
            orderBy = " order by " + sort + "";
        }
        String time = "";
        // 0表示近1个月，1表示1到3月，2表示3到6月,3表示已过期
        switch (dateType) {
        case 0:
            time = " createDate >= date_sub(current_date(),interval 1 MONTH)";
            break;
        case 1:
            time = " createDate >= date_sub(current_date(),interval 3 MONTH) and createDate<=date_sub(current_date(),interval 1 MONTH)";
            break;
        case 2:
            time = " createDate >= date_sub(current_date(),interval 6 MONTH) and createDate<=date_sub(current_date(),interval 3 MONTH)";
            break;
        case 3:
            time = " createDate > expiryDate";
            break;
        }
        String sql = "select * from stockBatchInventory where storeId = " + storeId + " and " + time + orderBy
                + " limit " + pageIndex + "," + pageSize;
        System.out.println(sql);
        try {
            data = BaseUtil.executeQueryByJdbc(sql, new StockBatchInventory(), new BaseProduct());
            return BaseUtil.productJson(1, data, "获取成功!");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException | SQLException e) {
            // 异常回滚
            e.printStackTrace();
            throw new CustomerException("获取失败!");
        }
    }

    /**
     * 获取日销售报表接口
     * 
     * @param vloginId：接口验证登录名
     *            vpwd：接口验证密码 storeId：门店ID 从登陆接口中获取 userId：当前用户D 从登陆接口中获取 order:排序类别
     *            0降序，1升序 sort:排序对象，根据什么字段排序
     * @return Json
     */
    @RequestMapping("/listDaySummarys.action")
    @ResponseBody
    public String listDaySummarys(@RequestParam(value = "vloginId", required = false) String vloginId,
            @RequestParam(value = "vpwd", required = false) String vpwd, String storeId, String userId, String sort,
            Integer order) {
        logger.info("用户" + userId + " 正在调用获取日销售报表接口");
        String orderBy = "";
        if (order != null && order == 0) {
            orderBy = " order by " + sort + " desc";
        } else if (order != null && order == 1) {
            orderBy = " order by " + sort + "";
        }
        String sql = "select storeId,  count(*) flow, sum(saleCount) saleCount, sum(saleCount * IFNULL(costPrice, 0)) costAmount, sum(memberPrice * saleCount) discountFee, sum(retailPrice - memberPrice) grossProfit,"
                + "sum(memberPrice - IFNULL(costPrice, 0)) lessProfit, count(o.memberNo) memberCount, IFNULL(sum(cashPrice), 0) cashPrice , IFNULL(sum(unionPayPrice), 0) unionPayPrice, IFNULL(sum(medicinePrice), 0) medicinePrice, IFNULL(sum(cardPrice), 0) cardPrice, IFNULL(sum(weChatPrice), 0) weChatPrice,"
                + "date_format(IFNULL(o.saleDate, now()), '%Y-%m-%d') saleDate,  d.deleteFlag "
                + "from saleOrderDetail d left join "
                + "(select pay.*, o.saleDate, o.memberNo from saleOrder o left join "
                + "(select saleOrderNo, payDate,  IFNULL((CASE payType WHEN 1 THEN payMoney END) , 0) cashPrice, IFNULL((CASE payType WHEN 2 THEN payMoney END) , 0) cardPrice,"
                + "IFNULL((CASE payType WHEN 3 THEN payMoney END) , 0) weChatPrice, IFNULL((CASE payType WHEN 4 THEN payMoney END) , 0) unionPayPrice,"
                + "IFNULL((CASE payType WHEN 5 THEN payMoney END) , 0) medicinePrice from salePayOrder) pay on o.saleOrderNo = pay.saleOrderNo) o on d.saleOrderNo = o.saleOrderNo "
                + "where 1=1 and storeId = " + storeId
                + " GROUP BY date_format(IFNULL(o.saleDate, now()), '%Y-%m-%d'), storeId " + orderBy;
        try {
            data = BaseUtil.executeQueryByJdbc(sql, new DaySummary(), null);
            return BaseUtil.productJson(1, data, "获取成功!");
        } catch (IllegalArgumentException | SecurityException | SQLException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            // 异常回滚
            e.printStackTrace();
            throw new CustomerException("获取失败!");
        }

    }

    private String changeNullObj(Object obj) {
        if (obj instanceof Date) {
            obj = DateUtil.formatDateTime((Date) obj);
        }
        return obj == null ? null : "'" + obj + "'";
    }
}