package com.sdzy.xiaomi.stock.entity;

import java.math.BigDecimal;
import java.util.Date;
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
 * @author sdzy
 * @since 2018-08-15
 */
@TableName("stockInventoryProfitLoss")
public class StockInventoryProfitLoss implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("inventoryProfitLossId")
    private String inventoryProfitLossId;
    @TableField("storeId")
    private String storeId;
    @TableField("typeId")
    private Integer typeId;
    @TableField("inventoryProfitLossNo")
    private String inventoryProfitLossNo;
    @TableField("billDate")
    private Date billDate;
    @TableField("billMoney")
    private BigDecimal billMoney;
    @TableField("auditState")
    private Integer auditState;
    @TableField("auditUserId")
    private String auditUserId;
    @TableField("auditUser")
    private String auditUser;
    @TableField("createUserId")
    private String createUserId;
    @TableField("createUserName")
    private String createUserName;
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    private String remark;
    /**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


    public String getInventoryProfitLossId() {
        return inventoryProfitLossId;
    }

    public void setInventoryProfitLossId(String inventoryProfitLossId) {
        this.inventoryProfitLossId = inventoryProfitLossId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getInventoryProfitLossNo() {
        return inventoryProfitLossNo;
    }

    public void setInventoryProfitLossNo(String inventoryProfitLossNo) {
        this.inventoryProfitLossNo = inventoryProfitLossNo;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "StockInventoryProfitLoss{" +
        ", inventoryProfitLossId=" + inventoryProfitLossId +
        ", storeId=" + storeId +
        ", typeId=" + typeId +
        ", inventoryProfitLossNo=" + inventoryProfitLossNo +
        ", billDate=" + billDate +
        ", billMoney=" + billMoney +
        ", auditState=" + auditState +
        ", auditUserId=" + auditUserId +
        ", auditUser=" + auditUser +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
