package com.sdzy.xiaomi.report.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
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
@TableName("saleOrder")
public class SaleOrder implements Serializable {

    public List<SaleOrderDetail> getSaleOrderDetails() {
		return saleOrderDetails;
	}

	public void setSaleOrderDetails(List<SaleOrderDetail> saleOrderDetails) {
		this.saleOrderDetails = saleOrderDetails;
	}

	public List<SalePayOrder> getSalePayOrders() {
		return salePayOrders;
	}

	public void setSalePayOrders(List<SalePayOrder> salePayOrders) {
		this.salePayOrders = salePayOrders;
	}

	private static final long serialVersionUID = 1L;

    @TableId("saleOrderId")
    private String saleOrderId;
    @TableField("storeId")
    private String storeId;
    @TableField("saleOrderType")
    private Integer saleOrderType;
    @TableField("saleOrderNo")
    private String saleOrderNo;
    @TableField("saleDate")
    private Date saleDate;
    private String member;
    @TableField("memberNo")
    private String memberNo;
    @TableField("isPending")
    private Integer isPending;
    @TableField("pendingRemark")
    private String pendingRemark;
    @TableField("totalCount")
    private BigDecimal totalCount;
    @TableField("totalRetailAmount")
    private BigDecimal totalRetailAmount;
    @TableField("totalMemberAmount")
    private BigDecimal totalMemberAmount;
    @TableField("totalDiscountFee")
    private BigDecimal totalDiscountFee;
    @TableField("toalOtherFee")
    private BigDecimal toalOtherFee;
    /**
     * 实付金额
     */
    @TableField("paymentMoney")
    private BigDecimal paymentMoney;
    /**
     * 实收金额
     */
    @TableField("receiveMoney")
    private BigDecimal receiveMoney;
    /**
     * 找零金额
     */
    @TableField("changeMoney")
    private BigDecimal changeMoney;
    /**
     * 共购买
     */
    @TableField("totalSaleNum")
    private BigDecimal totalSaleNum;
    /**
     * 共优惠(元)
     */
    @TableField("totalReduceAmount")
    private BigDecimal totalReduceAmount;
    /**
     * 共赠送
     */
    @TableField("totalGiveNum")
    private BigDecimal totalGiveNum;
    @TableField("isPay")
    private Integer isPay;
    @TableField("payType")
    private String payType;
    @TableField("isRxDrug")
    private Integer isRxDrug;
    @TableField("isEphedrine")
    private Integer isEphedrine;
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    @TableField("sellerId")
    private String sellerId;
    private String seller;
    @TableField("operaterId")
    private String operaterId;
    private String operater;
    private String remark;
    /**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;
    @TableField("buyerName")
    private String buyerName;
    @TableField("buyerCardNo")
    private String buyerCardNo;
    @TableField("buyerPhone")
    private String buyerPhone;
    /**
     * 购买都 人脸id
     */
    @TableField("buyerFaceId")
    private String buyerFaceId;
    /**
     * 退货状态 0 或null：表示没退货, 1:表示部分退货, 2: 表示完成退货
     */
    @TableField("returnStatus")
    private Integer returnStatus;
    
    private Integer payMethod;
    private Integer paying;
    private BigDecimal payedMoney;
    
    /**销售订单明细*/
    List<SaleOrderDetail> saleOrderDetails;
    /**销售订单支付明细*/
    List<SalePayOrder> salePayOrders;
    


    public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getPaying() {
		return paying;
	}

	public void setPaying(Integer paying) {
		this.paying = paying;
	}

	public BigDecimal getPayedMoney() {
		return payedMoney;
	}

	public void setPayedMoney(BigDecimal payedMoney) {
		this.payedMoney = payedMoney;
	}

	public String getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(String saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getSaleOrderType() {
        return saleOrderType;
    }

    public void setSaleOrderType(Integer saleOrderType) {
        this.saleOrderType = saleOrderType;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getIsPending() {
        return isPending;
    }

    public void setIsPending(Integer isPending) {
        this.isPending = isPending;
    }

    public String getPendingRemark() {
        return pendingRemark;
    }

    public void setPendingRemark(String pendingRemark) {
        this.pendingRemark = pendingRemark;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalRetailAmount() {
        return totalRetailAmount;
    }

    public void setTotalRetailAmount(BigDecimal totalRetailAmount) {
        this.totalRetailAmount = totalRetailAmount;
    }

    public BigDecimal getTotalMemberAmount() {
        return totalMemberAmount;
    }

    public void setTotalMemberAmount(BigDecimal totalMemberAmount) {
        this.totalMemberAmount = totalMemberAmount;
    }

    public BigDecimal getTotalDiscountFee() {
        return totalDiscountFee;
    }

    public void setTotalDiscountFee(BigDecimal totalDiscountFee) {
        this.totalDiscountFee = totalDiscountFee;
    }

    public BigDecimal getToalOtherFee() {
        return toalOtherFee;
    }

    public void setToalOtherFee(BigDecimal toalOtherFee) {
        this.toalOtherFee = toalOtherFee;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public BigDecimal getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(BigDecimal changeMoney) {
        this.changeMoney = changeMoney;
    }

    public BigDecimal getTotalSaleNum() {
        return totalSaleNum;
    }

    public void setTotalSaleNum(BigDecimal totalSaleNum) {
        this.totalSaleNum = totalSaleNum;
    }

    public BigDecimal getTotalReduceAmount() {
        return totalReduceAmount;
    }

    public void setTotalReduceAmount(BigDecimal totalReduceAmount) {
        this.totalReduceAmount = totalReduceAmount;
    }

    public BigDecimal getTotalGiveNum() {
        return totalGiveNum;
    }

    public void setTotalGiveNum(BigDecimal totalGiveNum) {
        this.totalGiveNum = totalGiveNum;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getIsRxDrug() {
        return isRxDrug;
    }

    public void setIsRxDrug(Integer isRxDrug) {
        this.isRxDrug = isRxDrug;
    }

    public Integer getIsEphedrine() {
        return isEphedrine;
    }

    public void setIsEphedrine(Integer isEphedrine) {
        this.isEphedrine = isEphedrine;
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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerCardNo() {
        return buyerCardNo;
    }

    public void setBuyerCardNo(String buyerCardNo) {
        this.buyerCardNo = buyerCardNo;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerFaceId() {
        return buyerFaceId;
    }

    public void setBuyerFaceId(String buyerFaceId) {
        this.buyerFaceId = buyerFaceId;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
        ", saleOrderId=" + saleOrderId +
        ", storeId=" + storeId +
        ", saleOrderType=" + saleOrderType +
        ", saleOrderNo=" + saleOrderNo +
        ", saleDate=" + saleDate +
        ", member=" + member +
        ", memberNo=" + memberNo +
        ", isPending=" + isPending +
        ", pendingRemark=" + pendingRemark +
        ", totalCount=" + totalCount +
        ", totalRetailAmount=" + totalRetailAmount +
        ", totalMemberAmount=" + totalMemberAmount +
        ", totalDiscountFee=" + totalDiscountFee +
        ", toalOtherFee=" + toalOtherFee +
        ", paymentMoney=" + paymentMoney +
        ", receiveMoney=" + receiveMoney +
        ", changeMoney=" + changeMoney +
        ", totalSaleNum=" + totalSaleNum +
        ", totalReduceAmount=" + totalReduceAmount +
        ", totalGiveNum=" + totalGiveNum +
        ", isPay=" + isPay +
        ", payType=" + payType +
        ", isRxDrug=" + isRxDrug +
        ", isEphedrine=" + isEphedrine +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", sellerId=" + sellerId +
        ", seller=" + seller +
        ", operaterId=" + operaterId +
        ", operater=" + operater +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        ", buyerName=" + buyerName +
        ", buyerCardNo=" + buyerCardNo +
        ", buyerPhone=" + buyerPhone +
        ", buyerFaceId=" + buyerFaceId +
        ", returnStatus=" + returnStatus +
        "}";
    }


}
