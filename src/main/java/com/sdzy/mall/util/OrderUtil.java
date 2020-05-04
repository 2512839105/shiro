package com.sdzy.mall.util;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asdzy.common.utils.DateUtil;
import com.sdzy.mall.base.service.BaseAutoIncrementService;

/**
 * 订单工具类
 *
 * @author dingjifeng
 * @create 2017-07-13 14:52
 **/
@Component
public class OrderUtil {

    @Autowired
    private BaseAutoIncrementService baseAutoIncrementService;

    private static OrderUtil orderUtil;


    @PostConstruct
    public void init() {
        orderUtil = this;
    }

    /**
     * 生成盘盈单号
     *
     * @param storeId
     * @return
     */
    public static String createPYBillNo(String storeId) {
        return createBillNo("PY", storeId);
    }

    /**
     * 生成盘亏单号
     *
     * @param storeId
     * @return
     */
    public static String createPKBillNo(String storeId) {
        return createBillNo("PK", storeId);
    }

    /**
     * 生成付款单号
     *
     * @param storeId
     * @return
     */
    public static String createFKBillNo(String storeId) {
        return createBillNo("FK", storeId);
    }

    /**
     * 生成采购单号
     *
     * @param storeId
     * @return
     */
    public static String createCGBillNo(String storeId) {
        return createBillNo("CG", storeId);
    }

    /**
     * 生成采购收货单号
     *
     * @param storeId
     * @return
     */
    public static String createSHBillNo(String storeId) {
        return createBillNo("SH", storeId);
    }

    /**
     * 生成验收入库单号
     *
     * @param storeId
     * @return
     */
    public static String createRKBillNo(String storeId) {
        return createBillNo("RK", storeId);
    }

    /**
     * 生成拆零单号
     *
     * @param storeId
     * @return
     */
    public static String createCLBillNo(String storeId) {
        return createBillNo("CL", storeId);
    }

    /**
     * 生成调价单号
     *
     * @param storeId
     * @return
     */
    public static String createTJBillNo(String storeId) {
        return createBillNo("TJ", storeId);
    }

    /**
     * 生成销售单号
     *
     * @param storeId
     * @return
     */
    public static String createXSBillNo(String storeId) {
        return createBillNo("XS", storeId);
    }

    /**
     * 生成支付单号
     *
     * @param storeId
     * @return
     */
    public static String createZFBillNo(String storeId) {
        return createBillNo("ZF", storeId);
    }

    /**
     * 生成报损单号
     *
     * @param storeId
     * @return
     */
    public static String createBSBillNo(String storeId) {
        return createBillNo("BS", storeId);
    }

    /**
     * 生成养护单号
     *
     * @param storeId
     * @return
     */
    public static String createYHBillNo(String storeId) {
        return createBillNo("YH", storeId);
    }

    /**
     * 生成培训单号
     *
     * @param storeId
     * @return
     */
    public static String createPXBillNo(String storeId) {
        return createBillNo("PX", storeId);
    }

    /**
     * 生成器具编号
     *
     * @param storeId
     * @return
     */
    public static String createQJBillNo(String storeId) {
        return createBillNo("QJ", storeId);
    }

    /**
     * 生成设备编号
     *
     * @param storeId
     * @return
     */
    public static String createSBBillNo(String storeId) {
        return createBillNo("SB", storeId);
    }
    /**
     * 生成会员编号
     *
     * @param storeId
     * @return
     */
    public static String createHYBillNo(String storeId) {
        return createBillNo("HY", storeId);
    }

    /**
     * 单据号生成
     *
     * @param prefix
     * @param storeId
     * @return
     */
    public static String createBillNo(String prefix, String storeId) {
        String autoNo = orderUtil.baseAutoIncrementService.createAutoNo(prefix, storeId);
        String suffix = "";
        if (autoNo.length() < 4) {
            int i = 0;
            while (i < 4 - autoNo.length()) {
                suffix = "0" + suffix;
                i++;
            }
        }
        String strDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
        strDate = strDate.substring(2);
        String billNo = prefix + storeId + strDate + suffix + autoNo;
        return billNo;
    }
    
    /**
     * 生成退货单号
     * @author 10504
     * @param storeId
     * @return 退货单号
     * 
     */
    public static String createTHBillno(String storeId){
    	return createBillNo("TH", storeId);
    }
    
    /**
     * 获取当前单号
     * @return
     */
    
    public static String getMaxNo() {
        return orderUtil.baseAutoIncrementService.selectNowNo();
    }
}
