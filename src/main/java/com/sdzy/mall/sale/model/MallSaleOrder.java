package com.sdzy.mall.sale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 销售订单
 * @author charlin
 */
public class MallSaleOrder implements Serializable {
    /**标识id*/
    private String saleOrderId;
    /**门店号*/
    private String storeId;
    /**单据类别 0销售， 1退货*/
    private Integer saleOrderType;
    /**销售单号*/
    private String saleOrderNo;
    /**销售日期*/
    private Date saleDate;
    /**会员*/
    private String member;
    /**会员编号*/
    private String memberNo;
    /**是否挂单 0不是, 1是*/
    private Integer isPending;
    /**挂单备注*/
    private String pendingRemark;
    /**总数量*/
    private BigDecimal totalCount;
    /**折前总金额*/
    private BigDecimal totalRetailAmount;
    /**折后总金额*/
    private BigDecimal totalMemberAmount;
    /**总折扣金额*/
    private BigDecimal totalDiscountFee;
    /**其它优惠*/
    private BigDecimal toalOtherFee;
//    /**实付*/
//    private BigDecimal payment;
//    /**实收*/
//    private BigDecimal payment3;
//    /**找零*/
//    private BigDecimal payment2;
    /**实付*/
    private BigDecimal paymentMoney;
    /**实收*/
    private BigDecimal receiveMoney;
    /**找零*/
    private BigDecimal changeMoney;
    /**是否付款*/
    private Integer isPay;
    /**支付方式*/
    private String payType;
    /**是否含处方药*/
    private Integer isRxDrug;
    /**是否含麻药*/
    private Integer isEphedrine;
    /**创建日期*/
    private Date createDate;
    /**修改日期*/
    private Date modifyDate;
    /**营业员id*/
    private String sellerId;
    /**营业员*/
    private String seller;
    /**操作人id*/
    private String operaterId;
    /**操作人*/
    private String operater;
    /**备注*/
    private String remark;
    /**删除标记-1表示删除*/
    private Integer deleteFlag;
    /**购买人*/
    private String buyerName;
    /**购买人身份证号*/
    private String buyerCardNo;
    /**购买人手机*/
    private String buyerPhone;
    /**退货状态 0 或null：表示正常, 1:有*/
    private int returnStatus;
    /** 订单来源：1POS，2小程序 */
    private Integer orderSource;

    //--促销相关------------------------------------------------------------------
    /**共购买*/
    private BigDecimal totalSaleNum;
    /**共优惠(元)*/
    private BigDecimal totalReduceAmount;
    /**共赠送*/
    private BigDecimal totalGiveNum;
    /**购买者人脸id号*/
    private String buyerFaceId;

    /**销售订单明细*/
    List<MallSaleOrderDetail> saleOrderDetails;
    /**销售订单支付明细*/
    List<MallSalePayOrder> salePayOrders;

    public MallSaleOrder() {
    }
    
    
    public Integer getOrderSource() {
        return orderSource;
    }


    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }


    public MallSaleOrder(String saleOrderId, int returnStatus) {
        this.saleOrderId = saleOrderId;
        this.returnStatus = returnStatus;
    }

    public String getBuyerFaceId() {
        return buyerFaceId;
    }

    public void setBuyerFaceId(String buyerFaceId) {
        this.buyerFaceId = buyerFaceId;
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

    public int getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(int returnStatus) {
        this.returnStatus = returnStatus;
    }

    public List<MallSaleOrderDetail> getSaleOrderDetails() {
        return saleOrderDetails;
    }

    public void setSaleOrderDetails(List<MallSaleOrderDetail> saleOrderDetails) {
        this.saleOrderDetails = saleOrderDetails;
    }

    public List<MallSalePayOrder> getSalePayOrders() {
        return salePayOrders;
    }

    public void setSalePayOrders(List<MallSalePayOrder> salePayOrders) {
        this.salePayOrders = salePayOrders;
    }

    private static final long serialVersionUID = 1L;

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

}