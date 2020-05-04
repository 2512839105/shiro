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
@TableName("gspMeasuringDeviceInfo")
public class GspMeasuringDeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("measureDeviceId")
    private String measureDeviceId;
    @TableField("storeId")
    private String storeId;
    @TableField("measureDeviceNo")
    private String measureDeviceNo;
    @TableField("measureDeviceName")
    private String measureDeviceName;
    @TableField("measureDeviceModel")
    private String measureDeviceModel;
    private String manufacturer;
    @TableField("measureRange")
    private String measureRange;
    @TableField("divisionValue")
    private String divisionValue;
    @TableField("checkCyle")
    private String checkCyle;
    @TableField("measureUrl")
    private String measureUrl;
    @TableField("measureInfo")
    private String measureInfo;
    private Integer state;
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


    public String getMeasureDeviceId() {
        return measureDeviceId;
    }

    public void setMeasureDeviceId(String measureDeviceId) {
        this.measureDeviceId = measureDeviceId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getMeasureDeviceNo() {
        return measureDeviceNo;
    }

    public void setMeasureDeviceNo(String measureDeviceNo) {
        this.measureDeviceNo = measureDeviceNo;
    }

    public String getMeasureDeviceName() {
        return measureDeviceName;
    }

    public void setMeasureDeviceName(String measureDeviceName) {
        this.measureDeviceName = measureDeviceName;
    }

    public String getMeasureDeviceModel() {
        return measureDeviceModel;
    }

    public void setMeasureDeviceModel(String measureDeviceModel) {
        this.measureDeviceModel = measureDeviceModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMeasureRange() {
        return measureRange;
    }

    public void setMeasureRange(String measureRange) {
        this.measureRange = measureRange;
    }

    public String getDivisionValue() {
        return divisionValue;
    }

    public void setDivisionValue(String divisionValue) {
        this.divisionValue = divisionValue;
    }

    public String getCheckCyle() {
        return checkCyle;
    }

    public void setCheckCyle(String checkCyle) {
        this.checkCyle = checkCyle;
    }

    public String getMeasureUrl() {
        return measureUrl;
    }

    public void setMeasureUrl(String measureUrl) {
        this.measureUrl = measureUrl;
    }

    public String getMeasureInfo() {
        return measureInfo;
    }

    public void setMeasureInfo(String measureInfo) {
        this.measureInfo = measureInfo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "GspMeasuringDeviceInfo{" +
        ", measureDeviceId=" + measureDeviceId +
        ", storeId=" + storeId +
        ", measureDeviceNo=" + measureDeviceNo +
        ", measureDeviceName=" + measureDeviceName +
        ", measureDeviceModel=" + measureDeviceModel +
        ", manufacturer=" + manufacturer +
        ", measureRange=" + measureRange +
        ", divisionValue=" + divisionValue +
        ", checkCyle=" + checkCyle +
        ", measureUrl=" + measureUrl +
        ", measureInfo=" + measureInfo +
        ", state=" + state +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
