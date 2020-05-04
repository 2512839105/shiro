package com.sdzy.mall.stock.constant;

import java.util.regex.Pattern;

/**
 * 常量
 * @Author: charlin
 * @Date: 2018/5/18 09:48
 * @Package: com.asdzy.purpleredgourd.stock
 * @Project: yaodian-web
 * @Description:
 */
public class StockConstant {
    /**拆零前缀*/
    public static String ZERO = "0";
    public static String SPLIT_PREF = "9";
    public static String SPLIT_UNIT_KG = "千克";
    public static String SPLIT_UNIT_G = "克";

    public static void main(String[] args) {
        Boolean chineseMathc = Pattern.matches("^[\\u4e00-\\u9fa5]*$", "aa");
        System.out.printf(chineseMathc + "");
    }
}

