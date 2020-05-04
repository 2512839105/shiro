package com.sdzy.xiaomi.user.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 服务订单主表
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
@TableName("serviceOrderBase")
public class ServiceOrderBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
    @TableId("orderBaseId")
    private String orderBaseId;
    /**
     * 订单号
     */
    @TableField("orderNo")
    private String orderNo;
    /**
     * 总金额
     */
    @TableField("totalFee")
    private BigDecimal totalFee;
    /**
     * 优惠金额
     */
    @TableField("discountFee")
    private BigDecimal discountFee;
    /**
     * 实付金额
     */
    private BigDecimal payment;
    /**
     * 买家类型：1企业，2门店，3会员
     */
    @TableField("buyerType")
    private Integer buyerType;
    /**
     * 买家ID
     */
    @TableField("buyerId")
    private String buyerId;
    /**
     * 买家名称
     */
    @TableField("buyerName")
    private String buyerName;
    /**
     * 买家账号
     */
    @TableField("buyerAccount")
    private String buyerAccount;
    /**
     * 支付类型:online在线支付，cod货到付款，bank银行转账
     */
    @TableField("payType")
    private String payType;
    /**
     * 是否支付:0否1是
     */
    @TableField("isPayed")
    private Integer isPayed;
    /**
     * 支付单号
     */
    @TableField("payOrderNo")
    private String payOrderNo;
    /**
     * 支付时间
     */
    @TableField("payTime")
    private Date payTime;
    /**
     * 订单状态:
            WAIT_BUYER_PAY：等待买家付款
            WAIT_SELLER_SEND_GOODS：等待卖家发货
            WAIT_BUYER_CONFIRM_GOODS：等待买家确认收货
            TRADE_BUYER_SIGNED：买家已签收
            TRADE_FINISHED：交易成功
            TRADE_CLOSED：交易关闭
     */
    private String state;
    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("modifyTime")
    private Date modifyTime;
    /**
     * 完成时间
     */
    @TableField("endTime")
    private Date endTime;
    /**
     * 备注
     */
    private String remark;


    public String getOrderBaseId() {
        return orderBaseId;
    }

    public void setOrderBaseId(String orderBaseId) {
        this.orderBaseId = orderBaseId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(Integer buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ServiceOrderBase{" +
        ", orderBaseId=" + orderBaseId +
        ", orderNo=" + orderNo +
        ", totalFee=" + totalFee +
        ", discountFee=" + discountFee +
        ", payment=" + payment +
        ", buyerType=" + buyerType +
        ", buyerId=" + buyerId +
        ", buyerName=" + buyerName +
        ", buyerAccount=" + buyerAccount +
        ", payType=" + payType +
        ", isPayed=" + isPayed +
        ", payOrderNo=" + payOrderNo +
        ", payTime=" + payTime +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", endTime=" + endTime +
        ", remark=" + remark +
        "}";
    }
}
