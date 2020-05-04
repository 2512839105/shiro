package com.sdzy.mall.sale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付表单
 * @author charlin
 */
public class MallSalePayOrder implements Serializable {

    private String payOrderId;
    /**门店ID*/
    private String storeId;
    /**支付类型*/
    private Integer payType;
    /**表示0:销售, 1:退款*/
    private Integer orderType;
    /**销售单号*/
    private String saleOrderNo;
    /**支付单号*/
    private String payOrderNo;
    /**支付日期*/
    private Date payDate;
    /**支付金额，总金额*/
    private BigDecimal payMoney;
    /**社保金额，来自销售明细中是否医保支付的金额*/
    private BigDecimal socialMoney;
    /**其它金额*/
    private BigDecimal otherMoney;
    /**删除标记-1表示删除*/
    private Integer deleteFlag;
    /**营业员*/
    private String seller;

    //-支付宝支付信息-------------------------------
    /**用户自己的支付宝付款码*/
    private String authCode;
    /**用户自己的支付宝付款码*/
    private String tradeNo;

    private BigDecimal receiptAmount;

    private BigDecimal invoiceAmount;

    private BigDecimal buyerPayAmount;

    private BigDecimal realMoney;

    private BigDecimal changeMoney;
    /**修改时间*/
    private Date modifyDate;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    private static final long serialVersionUID = 1L;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public BigDecimal getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(BigDecimal changeMoney) {
        this.changeMoney = changeMoney;
    }


    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getSocialMoney() {
        return socialMoney;
    }

    public void setSocialMoney(BigDecimal socialMoney) {
        this.socialMoney = socialMoney;
    }

    public BigDecimal getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigDecimal otherMoney) {
        this.otherMoney = otherMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", storeId=").append(storeId);
        sb.append(", payType=").append(payType);
        sb.append(", saleOrderNo=").append(saleOrderNo);
        sb.append(", payOrderNo=").append(payOrderNo);
        sb.append(", payDate=").append(payDate);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", authCode=").append(authCode);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", receiptAmount=").append(receiptAmount);
        sb.append(", invoiceAmount=").append(invoiceAmount);
        sb.append(", buyerPayAmount=").append(buyerPayAmount);
        sb.append(", realMoney=").append(realMoney);
        sb.append(", changeMoney=").append(changeMoney);
        sb.append("]");
        return sb.toString();
    }

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}