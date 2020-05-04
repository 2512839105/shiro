package com.sdzy.mall.promotion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 促销产品
 * @author charlin
 */
public class PromotionProduct implements Serializable {

    /**促销产品ID*/
    private String promotionProductId;
    /**门店ID*/
    private String storeId;
    /**促销策略ID*/
    private String promotionStrategyId;
    /**供应商Id*/
    private String supplierId;
    /**供应商名称*/
    private String supplierName;
    /**产品id*/
    private String productId;
    /**货号*/
    private String productCode;
    /**商品图片*/
    private String productUrl;
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
    /**促销价*/
    private BigDecimal promotionPrice;
    /**促销类别*/
    private Integer spromotionType;
    /**满数量/金额*/
    private BigDecimal sreachedCountOrAmount;
    /**满数量/金额赠送数量*/
    private BigDecimal sreachedCAToGiveCount;
    /**满数量/金额 减免金额*/
    private BigDecimal sreachedCAToReduceMoney;
    /**满数量/金额 折扣*/
    private BigDecimal sreachedCAToDiscount;
    /**满数量/金额 加价送*/
    private BigDecimal sreachedCAToAddMoney;
    /**赠品类别：1原品，2另赠品*/
    private Integer spromotiomGiveType;
    /**限购数量*/
    private BigDecimal limitBuyCount;
    /**状态-1删除1正常*/
    private Integer status;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;
    /**备注*/
    private String remark;

    /**赠品明细*/
    private List<PromotionGiveProduct> details;
    /**赠品明细说明*/
    private String giveDetails;
    /**赠品明细ids*/
    private String giveIds;
    /**赠品总成本*/
    private BigDecimal giveAmount;

    /**促销策略名称*/
    //private String promotionStrategyName;

    /**促销策略*/
    private PromotionStrategy promotionStrategy;

    private static final long serialVersionUID = 1L;

    public String getGiveDetails() {
        String giveDetails =  "";

        if(spromotiomGiveType != null){
            if(spromotiomGiveType == 1){
                giveDetails = "原品 0.01元/个";
            }else {
                if(details != null && details.size() > 0){
                    for(PromotionGiveProduct p: details){
                        giveDetails += ( "{(" + p.getProductCode() + ")" + p.getGenericName() + " " +p.getStandard() + "/" + p.getUnit() + " 0.01元}" + "*1" + "+");
                    }
                }

                if(StringUtils.isNotEmpty(giveDetails)){
                    giveDetails = giveDetails.substring(0, giveDetails.length()-1);
                }
            }
        }

        return giveDetails;
    }

    public String getGiveIds() {
        String giveIds =  "";
        if(details != null && details.size() > 0){
            for(PromotionGiveProduct p: details){
                giveIds += (p.getProductId() + ":");
            }
        }
        if(StringUtils.isNotEmpty(giveIds)){
            giveIds = giveIds.substring(0, giveIds.length()-1);
        }
        return giveIds;
    }

    public BigDecimal getGiveAmount() {
        BigDecimal giveAmount = new BigDecimal(0);
        if(details != null && details.size() > 0){
            for(PromotionGiveProduct p: details){
                giveAmount = giveAmount.add(p.getAveragePrice());
            }
        }
        return giveAmount;
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        this.giveAmount = giveAmount;
    }

    public void setGiveIds(String giveIds) {
        this.giveIds = giveIds;
    }

    public PromotionStrategy getPromotionStrategy() {
        return promotionStrategy;
    }

    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void setGiveDetails(String giveDetails) {
        this.giveDetails = giveDetails;
    }

    public String getPromotionProductId() {
        return promotionProductId;
    }

    public void setPromotionProductId(String promotionProductId) {
        this.promotionProductId = promotionProductId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPromotionStrategyId() {
        return promotionStrategyId;
    }

    public void setPromotionStrategyId(String promotionStrategyId) {
        this.promotionStrategyId = promotionStrategyId;
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

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
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

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getSpromotionType() {
        return spromotionType;
    }

    public void setSpromotionType(Integer spromotionType) {
        this.spromotionType = spromotionType;
    }

    public BigDecimal getSreachedCountOrAmount() {
        return sreachedCountOrAmount;
    }

    public void setSreachedCountOrAmount(BigDecimal sreachedCountOrAmount) {
        this.sreachedCountOrAmount = sreachedCountOrAmount;
    }

    public BigDecimal getSreachedCAToGiveCount() {
        return sreachedCAToGiveCount;
    }

    public void setSreachedCAToGiveCount(BigDecimal sreachedCAToGiveCount) {
        this.sreachedCAToGiveCount = sreachedCAToGiveCount;
    }

    public BigDecimal getSreachedCAToReduceMoney() {
        return sreachedCAToReduceMoney;
    }

    public void setSreachedCAToReduceMoney(BigDecimal sreachedCAToReduceMoney) {
        this.sreachedCAToReduceMoney = sreachedCAToReduceMoney;
    }

    public BigDecimal getSreachedCAToDiscount() {
        return sreachedCAToDiscount;
    }

    public void setSreachedCAToDiscount(BigDecimal sreachedCAToDiscount) {
        this.sreachedCAToDiscount = sreachedCAToDiscount;
    }

    public BigDecimal getSreachedCAToAddMoney() {
        return sreachedCAToAddMoney;
    }

    public void setSreachedCAToAddMoney(BigDecimal sreachedCAToAddMoney) {
        this.sreachedCAToAddMoney = sreachedCAToAddMoney;
    }

    public Integer getSpromotiomGiveType() {
        return spromotiomGiveType;
    }

    public void setSpromotiomGiveType(Integer spromotiomGiveType) {
        this.spromotiomGiveType = spromotiomGiveType;
    }

    public BigDecimal getLimitBuyCount() {
        return limitBuyCount;
    }

    public void setLimitBuyCount(BigDecimal limitBuyCount) {
        this.limitBuyCount = limitBuyCount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<PromotionGiveProduct> getDetails() {
        return details;
    }

    public void setDetails(List<PromotionGiveProduct> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", promotionProductId=").append(promotionProductId);
        sb.append(", storeId=").append(storeId);
        sb.append(", promotionStrategyId=").append(promotionStrategyId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", productId=").append(productId);
        sb.append(", productCode=").append(productCode);
        sb.append(", productUrl=").append(productUrl);
        sb.append(", productName=").append(productName);
        sb.append(", genericName=").append(genericName);
        sb.append(", standard=").append(standard);
        sb.append(", unit=").append(unit);
        sb.append(", producingArea=").append(producingArea);
        sb.append(", produceFactory=").append(produceFactory);
        sb.append(", tradePrice=").append(tradePrice);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", retailPrice=").append(retailPrice);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", spromotionType=").append(spromotionType);
        sb.append(", sreachedCountOrAmount=").append(sreachedCountOrAmount);
        sb.append(", sreachedCAToGiveCount=").append(sreachedCAToGiveCount);
        sb.append(", sreachedCAToReduceMoney=").append(sreachedCAToReduceMoney);
        sb.append(", sreachedCAToDiscount=").append(sreachedCAToDiscount);
        sb.append(", sreachedCAToAddMoney=").append(sreachedCAToAddMoney);
        sb.append(", spromotiomGiveType=").append(spromotiomGiveType);
        sb.append(", limitBuyCount=").append(limitBuyCount);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}