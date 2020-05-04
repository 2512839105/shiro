package com.sdzy.xiaomi.report.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@TableName("salePayOrder")
public class SalePayOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("payOrderId")
    private String payOrderId;
    @TableField("storeId")
    private String storeId;
    @TableField("payType")
    private Integer payType;
    /**
     * 0:销售, 1:退货
     */
    @TableField("orderType")
    private Integer orderType;
    @TableField("saleOrderNo")
    private String saleOrderNo;
    @TableField("payOrderNo")
    private String payOrderNo;
    @TableField("payDate")
    private Date payDate;
    @TableField("payMoney")
    private BigDecimal payMoney;
    /**修改支付人*/
    private String modifyPayTypeUserName;
    public String getModifyPayTypeUserName() {
		return modifyPayTypeUserName;
	}

	public void setModifyPayTypeUserName(String modifyPayTypeUserName) {
		this.modifyPayTypeUserName = modifyPayTypeUserName;
	}

	/**修改支付时间*/
    private Date modifyPayTypeDate;
    public Date getModifyPayTypeDate() {
		return modifyPayTypeDate;
	}

	public void setModifyPayTypeDate(Date modifyPayTypeDate) {
		this.modifyPayTypeDate = modifyPayTypeDate;
	}

	private BigDecimal otherMoney;
    /**备注*/
    private String remark;
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getOtherMoney() {
		return otherMoney;
	}

	public void setOtherMoney(BigDecimal otherMoney) {
		this.otherMoney = otherMoney;
	}
	
	private BigDecimal socialMoney;

	public BigDecimal getSocialMoney() {
		return socialMoney;
	}

	public void setSocialMoney(BigDecimal socialMoney) {
		this.socialMoney = socialMoney;
	}

	/**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;
    @TableField("authCode")
    private String authCode;
    @TableField("tradeNo")
    private String tradeNo;
    @TableField("receiptAmount")
    private BigDecimal receiptAmount;
    @TableField("invoiceAmount")
    private BigDecimal invoiceAmount;
    @TableField("buyerPayAmount")
    private BigDecimal buyerPayAmount;
    @TableField("realMoney")
    private BigDecimal realMoney;
    @TableField("changeMoney")
    private BigDecimal changeMoney;
    /**0线下，1线上*/
    private Integer payMethod;
    
    public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	/**
     * 营业员
     */
    private String seller;
    /**
     * 最后修改时间
     */
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;


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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "SalePayOrder{" +
        ", payOrderId=" + payOrderId +
        ", storeId=" + storeId +
        ", payType=" + payType +
        ", orderType=" + orderType +
        ", saleOrderNo=" + saleOrderNo +
        ", payOrderNo=" + payOrderNo +
        ", payDate=" + payDate +
        ", payMoney=" + payMoney +
        ", deleteFlag=" + deleteFlag +
        ", authCode=" + authCode +
        ", tradeNo=" + tradeNo +
        ", receiptAmount=" + receiptAmount +
        ", invoiceAmount=" + invoiceAmount +
        ", buyerPayAmount=" + buyerPayAmount +
        ", realMoney=" + realMoney +
        ", changeMoney=" + changeMoney +
        ", seller=" + seller +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
