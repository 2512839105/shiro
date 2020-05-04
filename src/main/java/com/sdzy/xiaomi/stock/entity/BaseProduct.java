package com.sdzy.xiaomi.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @apiNote 产品类
 * @author charlin
 */
public class BaseProduct implements Serializable {
    /***/
    private String productId;
    /**门店ID*/
    private String storeId;
    /**类别id*/
    private String categoryId;
    /**类别名称*/
    private String categoryName;
    /**货号*/
    private String productCode;
    /**商品名*/
    private String productName;
    /**产地*/
    private String producingArea;
    /**规格*/
    private String standard;
    /**单位*/
    private String unit;
    private String productFactory;
    
    public String getProductFactory() {
		return productFactory;
	}

	public void setProductFactory(String productFactory) {
		this.productFactory = productFactory;
	}

	private List<Object> stockBatchInventories;

    private static final long serialVersionUID = 1L;

    public List<Object> getStockBatchInventories() {
        return stockBatchInventories;
    }

    public void setStockBatchInventories(List<Object> resultList) {
        this.stockBatchInventories = resultList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }


    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea == null ? null : producingArea.trim();
    }


    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }


}