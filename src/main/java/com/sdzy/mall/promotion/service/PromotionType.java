package com.sdzy.mall.promotion.service;

public enum PromotionType {
    
    
    /**
     * 单品
     */
    SINGLE_PRODUCT(10),
    /**
     * 单品-满数量送赠品
     */
    SINGLE_PRODUCT_FULL_QUANTITY_OF_GIFTS(11),
    /**
     * 单品-满金额送赠品
     */
    SINGLE_PRODUCT_FULL_AMOUNT_OF_GIFTS(12),
    /**
     * 单品-满数量减金额
     */
    SINGLE_PRODUCT_FULL_QUANTITY_MINUS_AMOUNT(13),
    /**
     * 单品-满金额减金额
     */
    SINGLE_PRODUCT_FULL_AMOUNT_MINUS_AMOUNT(14),
    /**
     * 单品-满数量打折
     */
    SINGLE_PRODUCT_FULL_QUANTITY_OF_DISCOUNTS(15),
    /**
     * 单品-满金额打折
     */
    SINGLE_PRODUCT_FULL_AMOUNT_OF_DISCOUNTS(16),
    /**
     * 单品-满金额加x元兑换
     */
    SINGLE_PRODUCT_FULL_AMOUNT_PLUS_EXCHANGE(17),
    /**
     * 多品
     */
    MULTI_PRODUCT(20),
    /**
     * 多品-满数量送赠品
     */
    MULTI_PRODUCT_FULL_QUANTITY_OF_GIFTS(21),
    /**
     * 多品-满金额送赠品
     */
    MULTI_PRODUCT_FULL_AMOUNT_OF_GIFTS(22),
    /**
     * 多品-满数量减金额
     */
    MULTI_PRODUCT_FULL_QUANTITY_MINUS_AMOUNT(23),
    /**
     * 多品-满金额减金额
     */
    MULTI_PRODUCT_FULL_AMOUNT_MINUS_AMOUNT(24),
    /**
     * 多品-满数量打折
     */
    MULTI_PRODUCT_FULL_QUANTITY_OF_DISCOUNTS(25),
    /**
     * 多品-满金额打折
     */
    MULTI_PRODUCT_FULL_AMOUNT_OF_DISCOUNTS(26),
    /**
     * 多品-满金额加x元兑换
     */
    MULTI_PRODUCT_FULL_AMOUNT_PLUS_EXCHANGE(27),
    /**
     * 特价
     */
    SPECIAL_OFFER(30);
    
    private Integer dbValue;
    
    private PromotionType(Integer dbValue) {
        this.dbValue = dbValue;
    }
    
    public Integer getDbValue() {
        return dbValue;
    }
    
}
