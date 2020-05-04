package com.sdzy.xiaomi.user.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 服务订单明细表
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
@TableName("serviceOrderDetail")
public class ServiceOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
    @TableId("orderDetailId")
    private String orderDetailId;
    /**
     * 订单号
     */
    @TableField("orderNo")
    private String orderNo;
    /**
     * 子订单号
     */
    @TableField("childOrderNum")
    private String childOrderNum;
    /**
     * 产品ID
     */
    @TableField("productId")
    private String productId;
    /**
     * 企业Id
     */
    @TableField("companyId")
    private String companyId;
    /**
     * 产品编号
     */
    @TableField("productNo")
    private String productNo;
    /**
     * 产品外部id
     */
    @TableField("productOuterId")
    private String productOuterId;
    /**
     * 产品名称
     */
    @TableField("productName")
    private String productName;
    /**
     * 产品图片
     */
    @TableField("productPic")
    private String productPic;
    /**
     * 套餐ID
     */
    @TableField("packageId")
    private String packageId;
    /**
     * 规格
     */
    private String standard;
    /**
     * 规格值
     */
    @TableField("standardValue")
    private BigDecimal standardValue;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 数量
     */
    @TableField("buyCount")
    private BigDecimal buyCount;
    /**
     * 总价
     */
    @TableField("totalFee")
    private BigDecimal totalFee;
    /**
     * 折扣
     */
    @TableField("discountFee")
    private BigDecimal discountFee;
    /**
     * 实付款
     */
    private BigDecimal payment;
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
     * 退款状态:
            NO_REFUND无退款
            WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) 
            WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) 
            WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) 
            SELLER_REFUSE_BUYER(卖家拒绝退款) 
            CLOSED(退款关闭)
             SUCCESS(退款成功)
     */
    @TableField("refundStatus")
    private String refundStatus;
    /**
     * 退款单id
     */
    @TableField("refundId")
    private String refundId;
    /**
     * 备注
     */
    private String remark;


    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getChildOrderNum() {
        return childOrderNum;
    }

    public void setChildOrderNum(String childOrderNum) {
        this.childOrderNum = childOrderNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductOuterId() {
        return productOuterId;
    }

    public void setProductOuterId(String productOuterId) {
        this.productOuterId = productOuterId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public BigDecimal getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(BigDecimal standardValue) {
        this.standardValue = standardValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(BigDecimal buyCount) {
        this.buyCount = buyCount;
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

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ServiceOrderDetail{" +
        ", orderDetailId=" + orderDetailId +
        ", orderNo=" + orderNo +
        ", childOrderNum=" + childOrderNum +
        ", productId=" + productId +
        ", companyId=" + companyId +
        ", productNo=" + productNo +
        ", productOuterId=" + productOuterId +
        ", productName=" + productName +
        ", productPic=" + productPic +
        ", packageId=" + packageId +
        ", standard=" + standard +
        ", standardValue=" + standardValue +
        ", unit=" + unit +
        ", price=" + price +
        ", buyCount=" + buyCount +
        ", totalFee=" + totalFee +
        ", discountFee=" + discountFee +
        ", payment=" + payment +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", refundStatus=" + refundStatus +
        ", refundId=" + refundId +
        ", remark=" + remark +
        "}";
    }
}
