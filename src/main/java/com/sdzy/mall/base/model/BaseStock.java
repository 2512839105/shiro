package com.sdzy.mall.base.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author charlin
 * @create 2018-03-05 16:50
 **/
public class BaseStock implements Serializable{
    /**门店号*/
    private String storeId;
    /**货号Id*/
    private String productId;
    /**货号code*/
    private String productCode;
    /**批号*/
    private String batchNo;
    /**数量*/
    private BigDecimal count;

    public BaseStock() {
    }

    public BaseStock(String storeId, String productId, BigDecimal count, String batchNo, String productCode) {
        this.storeId = storeId;
        this.productId = productId;
        this.count = count;
        this.batchNo = batchNo;
        this.productCode = productCode;
    }

    public BaseStock(String storeId, String productId, BigDecimal count) {
        this.storeId = storeId;
        this.productId = productId;
        this.count = count;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
