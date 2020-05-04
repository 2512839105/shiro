package com.sdzy.xiaomi.report.model;

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
 * @author charlin
 * @since 2018-06-28
 */
@TableName("gspEquipmentMaintainRecord")
public class GspEquipmentMaintainRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("maintainRecordId")
    private String maintainRecordId;
    @TableField("storeId")
    private String storeId;
    @TableField("equipmentName")
    private String equipmentName;
    @TableField("sitePlace")
    private String sitePlace;
    @TableField("equipmentNo")
    private String equipmentNo;
    @TableField("equipmentModel")
    private String equipmentModel;
    @TableField("maintainDate")
    private String maintainDate;
    @TableField("maintainReason")
    private String maintainReason;
    @TableField("maintainContent")
    private String maintainContent;
    @TableField("maintainResult")
    private String maintainResult;
    @TableField("maintainPerson")
    private String maintainPerson;
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


    public String getMaintainRecordId() {
        return maintainRecordId;
    }

    public void setMaintainRecordId(String maintainRecordId) {
        this.maintainRecordId = maintainRecordId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getSitePlace() {
        return sitePlace;
    }

    public void setSitePlace(String sitePlace) {
        this.sitePlace = sitePlace;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(String maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getMaintainReason() {
        return maintainReason;
    }

    public void setMaintainReason(String maintainReason) {
        this.maintainReason = maintainReason;
    }

    public String getMaintainContent() {
        return maintainContent;
    }

    public void setMaintainContent(String maintainContent) {
        this.maintainContent = maintainContent;
    }

    public String getMaintainResult() {
        return maintainResult;
    }

    public void setMaintainResult(String maintainResult) {
        this.maintainResult = maintainResult;
    }

    public String getMaintainPerson() {
        return maintainPerson;
    }

    public void setMaintainPerson(String maintainPerson) {
        this.maintainPerson = maintainPerson;
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
        return "GspEquipmentMaintainRecord{" +
        ", maintainRecordId=" + maintainRecordId +
        ", storeId=" + storeId +
        ", equipmentName=" + equipmentName +
        ", sitePlace=" + sitePlace +
        ", equipmentNo=" + equipmentNo +
        ", equipmentModel=" + equipmentModel +
        ", maintainDate=" + maintainDate +
        ", maintainReason=" + maintainReason +
        ", maintainContent=" + maintainContent +
        ", maintainResult=" + maintainResult +
        ", maintainPerson=" + maintainPerson +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
