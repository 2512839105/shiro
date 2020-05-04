package com.sdzy.xiaomi.serviceProduct.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户服务产品汇总
 * </p>
 *
 * @author charlin
 * @since 2018-07-30
 */
@TableName("serviceProductStat")
public class ServiceProductStat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 汇总ID
     */
    @TableId("statId")
    private String statId;
    /**
     * 用户类型：1企业，2门店，3会员
     */
    @TableField("buyerType")
    private Integer buyerType;
    /**
     * 用户ID
     */
    @TableField("buyerId")
    private String buyerId;
    /**
     * 服务产品类别ID
     */
    @TableField("productCateId")
    private String productCateId;
    /**
     * 数量
     */
    @TableField("totalCount")
    private BigDecimal totalCount;
    /**
     * 过期时间
     */
    @TableField("expiredDate")
    private String expiredDate;
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
     * 状态：0停用，1正常
     */
    private Integer state;
    /**
     * 备注
     */
    private String remark;


    public String getStatId() {
        return statId;
    }

    public void setStatId(String statId) {
        this.statId = statId;
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

    public String getProductCateId() {
        return productCateId;
    }

    public void setProductCateId(String productCateId) {
        this.productCateId = productCateId;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ServiceProductStat{" +
        ", statId=" + statId +
        ", buyerType=" + buyerType +
        ", buyerId=" + buyerId +
        ", productCateId=" + productCateId +
        ", totalCount=" + totalCount +
        ", expiredDate=" + expiredDate +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", state=" + state +
        ", remark=" + remark +
        "}";
    }
}
