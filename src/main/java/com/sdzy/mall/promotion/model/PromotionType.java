package com.sdzy.mall.promotion.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 促销类别
 * @author charlin
 */
public class PromotionType implements Serializable {

    /**促销类别ID*/
    private Integer promotionTypeID;
    /**促销类别名称*/
    private String promotinTypeName;
    /**状态:-1删除，1正常*/
    private Integer status;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;
    /**备注*/
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getPromotionTypeID() {
        return promotionTypeID;
    }

    public void setPromotionTypeID(Integer promotionTypeID) {
        this.promotionTypeID = promotionTypeID;
    }

    public String getPromotinTypeName() {
        return promotinTypeName;
    }

    public void setPromotinTypeName(String promotinTypeName) {
        this.promotinTypeName = promotinTypeName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", promotionTypeID=").append(promotionTypeID);
        sb.append(", promotinTypeName=").append(promotinTypeName);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}