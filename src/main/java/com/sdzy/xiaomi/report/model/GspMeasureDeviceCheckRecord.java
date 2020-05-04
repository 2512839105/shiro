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
 * @since 2018-07-02
 */
@TableName("gspMeasureDeviceCheckRecord")
public class GspMeasureDeviceCheckRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("measureCheckId")
    private String measureCheckId;
    @TableField("storeId")
    private String storeId;
    @TableField("measureDeviceNo")
    private String measureDeviceNo;
    @TableField("checkDate")
    private Date checkDate;
    @TableField("checkDescription")
    private String checkDescription;
    @TableField("checkResult")
    private String checkResult;
    private String checker;
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


    public String getMeasureCheckId() {
        return measureCheckId;
    }

    public void setMeasureCheckId(String measureCheckId) {
        this.measureCheckId = measureCheckId;
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

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
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
        return "GspMeasureDeviceCheckRecord{" +
        ", measureCheckId=" + measureCheckId +
        ", storeId=" + storeId +
        ", measureDeviceNo=" + measureDeviceNo +
        ", checkDate=" + checkDate +
        ", checkDescription=" + checkDescription +
        ", checkResult=" + checkResult +
        ", checker=" + checker +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
