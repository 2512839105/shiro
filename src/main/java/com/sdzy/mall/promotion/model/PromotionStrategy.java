package com.sdzy.mall.promotion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 促销策略
 * @author charlin
 */
public class PromotionStrategy implements Serializable {

    /**促销策略ID*/
    private String promotionStrategyId;
    /**门店ID*/
    private String storeId;
    /**促销类别*/
    private Integer promotionType;
    /**促销名称*/
    private String promotionName;
    /**封面URL*/
    private String coverUrl;
    /**促销范围：0指定产品1全场*/
    private Integer promotionRange;
    /**满数量/金额*/
    private BigDecimal reachedCountOrAmount;
    /**满数量/金额赠送数量*/
    private BigDecimal reachedCAToGiveCount;
    /**满数量/金额 减免金额*/
    private BigDecimal reachedCAToReduceMoney;
    /**满数量/金额 折扣*/
    private BigDecimal reachedCAToDiscount;
    /**满数量/金额 加价送*/
    private BigDecimal reachedCAToAddMoney;
    /**赠品类别：1原品，2另赠品*/
    private Integer promotiomGiveType;
    /**促销客户范围：0全部1会员2非会员*/
    private Integer customerRange;
    /**客户类别*/
    private String customerType;
    /**产品类别*/
    private String productCategoryID;
    /**产品品牌*/
    private String productBrandID;
    /**产品系列*/
    private String productType;
    /**开始时间*/
    private Date promotionStartDate;
    /**结束时间*/
    private Date promotionEndDate;
    /**促销状态：-1删除，0未开始，1进行中，2已结束，3暂停中*/
    private Integer promotionState;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;
    /**备注*/
    private String remark;
    /**促销产品*/
    private List<PromotionProduct> details;
    /**赠送产品*/
    private List<PromotionGiveProduct> giveProducts;

    private static final long serialVersionUID = 1L;

    public String getPromotionStrategyId() {
        return promotionStrategyId;
    }

    public void setPromotionStrategyId(String promotionStrategyId) {
        this.promotionStrategyId = promotionStrategyId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getPromotionRange() {
        return promotionRange;
    }

    public void setPromotionRange(Integer promotionRange) {
        this.promotionRange = promotionRange;
    }

    public BigDecimal getReachedCountOrAmount() {
        return reachedCountOrAmount;
    }

    public void setReachedCountOrAmount(BigDecimal reachedCountOrAmount) {
        this.reachedCountOrAmount = reachedCountOrAmount;
    }

    public BigDecimal getReachedCAToGiveCount() {
        return reachedCAToGiveCount;
    }

    public void setReachedCAToGiveCount(BigDecimal reachedCAToGiveCount) {
        this.reachedCAToGiveCount = reachedCAToGiveCount;
    }

    public BigDecimal getReachedCAToReduceMoney() {
        return reachedCAToReduceMoney;
    }

    public void setReachedCAToReduceMoney(BigDecimal reachedCAToReduceMoney) {
        this.reachedCAToReduceMoney = reachedCAToReduceMoney;
    }

    public BigDecimal getReachedCAToDiscount() {
        return reachedCAToDiscount;
    }

    public void setReachedCAToDiscount(BigDecimal reachedCAToDiscount) {
        this.reachedCAToDiscount = reachedCAToDiscount;
    }

    public BigDecimal getReachedCAToAddMoney() {
        return reachedCAToAddMoney;
    }

    public void setReachedCAToAddMoney(BigDecimal reachedCAToAddMoney) {
        this.reachedCAToAddMoney = reachedCAToAddMoney;
    }

    public Integer getPromotiomGiveType() {
        return promotiomGiveType;
    }

    public void setPromotiomGiveType(Integer promotiomGiveType) {
        this.promotiomGiveType = promotiomGiveType;
    }

    public Integer getCustomerRange() {
        return customerRange;
    }

    public void setCustomerRange(Integer customerRange) {
        this.customerRange = customerRange;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(String productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getProductBrandID() {
        return productBrandID;
    }

    public void setProductBrandID(String productBrandID) {
        this.productBrandID = productBrandID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public Integer getPromotionState() {
        return promotionState;
    }

    public void setPromotionState(Integer promotionState) {
        this.promotionState = promotionState;
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

    public List<PromotionProduct> getDetails() {
        return details;
    }

    public void setDetails(List<PromotionProduct> details) {
        this.details = details;
    }

    public List<PromotionGiveProduct> getGiveProducts() {
        return giveProducts;
    }

    public void setGiveProducts(List<PromotionGiveProduct> giveProducts) {
        this.giveProducts = giveProducts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", promotionStrategyId=").append(promotionStrategyId);
        sb.append(", storeId=").append(storeId);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", promotionRange=").append(promotionRange);
        sb.append(", reachedCountOrAmount=").append(reachedCountOrAmount);
        sb.append(", reachedCAToGiveCount=").append(reachedCAToGiveCount);
        sb.append(", reachedCAToReduceMoney=").append(reachedCAToReduceMoney);
        sb.append(", reachedCAToDiscount=").append(reachedCAToDiscount);
        sb.append(", reachedCAToAddMoney=").append(reachedCAToAddMoney);
        sb.append(", promotiomGiveType=").append(promotiomGiveType);
        sb.append(", customerRange=").append(customerRange);
        sb.append(", customerType=").append(customerType);
        sb.append(", productCategoryID=").append(productCategoryID);
        sb.append(", productBrandID=").append(productBrandID);
        sb.append(", productType=").append(productType);
        sb.append(", promotionStartDate=").append(promotionStartDate);
        sb.append(", promotionEndDate=").append(promotionEndDate);
        sb.append(", promotionState=").append(promotionState);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}