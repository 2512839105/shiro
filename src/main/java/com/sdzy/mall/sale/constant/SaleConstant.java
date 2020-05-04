package com.sdzy.mall.sale.constant;

/**
 * 销售里的常量
 * @Author: charlin
 * @Date: 2018/6/4 16:08
 * @Package: com.asdzy.purpleredgourd.sale.constant
 * @Project: yaodian-web
 * @Description:
 */
public class SaleConstant {
    /**现金*/
    public static final Integer PAYTYPE_CASH = 1;
    /**支付宝*/
    public static final Integer PAYTYPE_ALI = 2;
    /**微信*/
    public static final Integer PAYTYPE_WX = 3;
    /**银联*/
    public static final Integer PAYTYPE_UNION = 4;
    /**社保*/
    public static final Integer PAYTYPE_SC = 5;

    /**线下交易*/
    public static final Integer PAYMETHOD_OFFLINE = 0;
    /**线上交易*/
    public static final Integer PAYMETHOD_ONLINE = 1;
}
