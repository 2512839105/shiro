package com.sdzy.xiaomi.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售日汇总
 *
 * @author charlin
 * @create 2017-08-22 17:09
 **/
public class DaySummary {

    private String storeId;
    /**订单日期*/
    private String saleDate;
    /**数量*/
    private BigDecimal saleCount;
    /**成本价*/
    private BigDecimal costPrice;
    /**成本额*/
    private BigDecimal costAmount;
    /**价税合计*/
    private BigDecimal discountFee;
    /**毛利*/
    private BigDecimal grossProfit;
    /**让利*/
    private BigDecimal lessProfit;
    /**会员数量     */
    private long memberCount;
    /**客流量 = 有多少单据*/
    private long flow;
    /**均客单价 = 总金额/客流量啦*/
    private BigDecimal everyPrice;
    /**现金*/
    private BigDecimal cashPrice;
    /**银联*/
    private BigDecimal unionPayPrice;
    /**微信*/
    private BigDecimal weChatPrice;
    /**医保*/
    private BigDecimal medicinePrice;
    /**储值卡*/
    private BigDecimal cardPrice;
    /**最后修改时间*/
    private Date modifyDate;


    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getLessProfit() {
        return lessProfit;
    }

    public void setLessProfit(BigDecimal lessProfit) {
        this.lessProfit = lessProfit;
    }

    public long getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(long memberCount) {
        this.memberCount = memberCount;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }

    public BigDecimal getEveryPrice() {
        return everyPrice;
    }

    public void setEveryPrice(BigDecimal everyPrice) {
        this.everyPrice = everyPrice;
    }

    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    public BigDecimal getUnionPayPrice() {
        return unionPayPrice;
    }

    public void setUnionPayPrice(BigDecimal unionPayPrice) {
        this.unionPayPrice = unionPayPrice;
    }

    public BigDecimal getWeChatPrice() {
        return weChatPrice;
    }

    public void setWeChatPrice(BigDecimal weChatPrice) {
        this.weChatPrice = weChatPrice;
    }

    public BigDecimal getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(BigDecimal medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public BigDecimal getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(BigDecimal cardPrice) {
        this.cardPrice = cardPrice;
    }

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
