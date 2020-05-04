package com.sdzy.mall.promotion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 促销赠品
 * @author charlin
 */
public class PromotionGiveProduct implements Serializable {

    /**促销赠品ID*/
    private String giveProductId;
    /**门店ID*/
    private String storeId;
    /**促销ID/促销产品ID*/
    private String strategyIdOrPid;
    /**赠品类别，0:属于促销策略;1:属于促销产品*/
    private Integer giveProductType;
    /**供应商Id*/
    private String supplierId;
    /**供应商名称*/
    private String supplierName;
    /**产品id*/
    private String productId;
    /**货号*/
    private String productCode;
    /**商品名*/
    private String productName;
    /**通用名*/
    private String genericName;
    /**规格*/
    private String standard;
    /**单位*/
    private String unit;
    /**产地*/
    private String producingArea;
    /**生产单位*/
    private String produceFactory;
    /**批发价*/
    private BigDecimal tradePrice;
    /**成本价*/
    private BigDecimal averagePrice;
    /**零售价*/
    private BigDecimal retailPrice;
    /**赠品价*/
    private BigDecimal givePrice;
    /**状态-1删除1正常*/
    private Integer status;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;

    /**批号*/
    private String batchNo;

    private static final long serialVersionUID = 1L;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }


    public String getGiveProductId() {
        return giveProductId;
    }

    public void setGiveProductId(String giveProductId) {
        this.giveProductId = giveProductId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStrategyIdOrPid() {
        return strategyIdOrPid;
    }

    public void setStrategyIdOrPid(String strategyIdOrPid) {
        this.strategyIdOrPid = strategyIdOrPid;
    }

    public Integer getGiveProductType() {
        return giveProductType;
    }

    public void setGiveProductType(Integer giveProductType) {
        this.giveProductType = giveProductType;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getProduceFactory() {
        return produceFactory;
    }

    public void setProduceFactory(String produceFactory) {
        this.produceFactory = produceFactory;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getGivePrice() {
        return givePrice;
    }

    public void setGivePrice(BigDecimal givePrice) {
        this.givePrice = givePrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", giveProductId=").append(giveProductId);
        sb.append(", storeId=").append(storeId);
        sb.append(", strategyIdOrPid=").append(strategyIdOrPid);
        sb.append(", giveProductType=").append(giveProductType);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", productId=").append(productId);
        sb.append(", productCode=").append(productCode);
        sb.append(", productName=").append(productName);
        sb.append(", genericName=").append(genericName);
        sb.append(", standard=").append(standard);
        sb.append(", unit=").append(unit);
        sb.append(", producingArea=").append(producingArea);
        sb.append(", produceFactory=").append(produceFactory);
        sb.append(", tradePrice=").append(tradePrice);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", retailPrice=").append(retailPrice);
        sb.append(", givePrice=").append(givePrice);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append("]");
        return sb.toString();
    }
}