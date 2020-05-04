package com.sdzy.xiaomi.cashSale.constant;

import java.math.BigDecimal;

/**
 * 销售里的常量
 * @Author: charlin
 * @Date: 2018/6/4 16:08
 * @Package: com.asdzy.purpleredgourd.sale.constant
 * @Project: yaodian-web
 * @Description:
 */
public class SaleConstant {

    /**保存支付宝银联社保*/
    public static final Integer SAVE_TYPE_ZERO = 0;
    /**保存微信现金*/
    public static final Integer SAVE_TYPE_ONE = 0;

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


    /**组合支付*/
    public static final Integer UN_UNION_PAY = 0;
    public static final Integer IS_UNION_PAY = 1;

    /**挂单*/
    public static final Integer IS_PENDING = 1;
    public static final Integer UN_PENDING = 0;

    /**线下交易*/
    public static final Integer PAYMETHOD_OFFLINE = 0;
    /**线上交易*/
    public static final Integer PAYMETHOD_ONLINE = 1;

    /**删除标记*/
    public static final Integer DELETE_FLAG = -1;

    /**赠品价格*/
    public static final BigDecimal GIVE_PRICE = new BigDecimal(0.01);
    /**默认价格、数量*/
    public static final BigDecimal ZERO = new BigDecimal(0);

    /**500*/
    public static final String PAY_STATE_FAILURE = "500";
    /**200*/
    public static final String PAY_STATE_SUCCESS = "200";
    /**0*/
    public static final String PAY_STATE_ZERO = "0";
    /**1*/
    public static final String PAY_STATE_ONE = "1";
    /**需要用户输入支付密码*/
    public static final String PAY_NEED_PASSWORD = "需要用户输入支付密码";
    /**-1*/
    public static final String PAY_STATE_NEGATIVE_ONE = "-1";

    public static final String SUCCESS = "success";

    /**
     * 交易终止
     */
    public static final String SALE_ERROR_400 = "400";
    public static final String SALE_ERROR_501 = "501";
    public static final String SALE_ERROR_502 = "502";
    public static final String SALE_ERROR_503 = "503";
    public static final String SALE_ERROR_504 = "504";
    public static final String SALE_ERROR_505 = "505";

    public static final String SALE_SUCC_200 = "200";


    /**查询标记*/
    public static final Integer QUERY_FLAG_BARCODE = 0;
    public static final Integer QUERY_FLAG_PRODUCTCODE = 1;
}
