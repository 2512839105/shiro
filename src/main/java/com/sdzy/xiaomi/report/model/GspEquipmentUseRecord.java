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
@TableName("gspEquipmentUseRecord")
public class GspEquipmentUseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userRecordId")
    private String userRecordId;
    @TableField("storeId")
    private String storeId;
    @TableField("equipmentNo")
    private String equipmentNo;
    @TableField("equipmentName")
    private String equipmentName;
    @TableField("equipmentModel")
    private String equipmentModel;
    @TableField("sitePlace")
    private String sitePlace;
    @TableField("useDate")
    private String useDate;
    @TableField("useReason")
    private String useReason;
    @TableField("startDate")
    private Date startDate;
    @TableField("stopDate")
    private Date stopDate;
    @TableField("useState")
    private String useState;
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


    public String getUserRecordId() {
        return userRecordId;
    }

    public void setUserRecordId(String userRecordId) {
        this.userRecordId = userRecordId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getSitePlace() {
        return sitePlace;
    }

    public void setSitePlace(String sitePlace) {
        this.sitePlace = sitePlace;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getUseReason() {
        return useReason;
    }

    public void setUseReason(String useReason) {
        this.useReason = useReason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
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
        return "GspEquipmentUseRecord{" +
        ", userRecordId=" + userRecordId +
        ", storeId=" + storeId +
        ", equipmentNo=" + equipmentNo +
        ", equipmentName=" + equipmentName +
        ", equipmentModel=" + equipmentModel +
        ", sitePlace=" + sitePlace +
        ", useDate=" + useDate +
        ", useReason=" + useReason +
        ", startDate=" + startDate +
        ", stopDate=" + stopDate +
        ", useState=" + useState +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
