package com.sdzy.xiaomi.report.model;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2018-06-07
 */
@TableName("sysoperatelog")
public class Sysoperatelog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "logId", type = IdType.AUTO)
    private Integer logId;
    @TableField("logType")
    private Integer logType;
    @TableField("companyId")
    private String companyId;
    @TableField("companyName")
    private String companyName;
    @TableField("storeId")
    private String storeId;
    @TableField("storeName")
    private String storeName;
    @TableField("moduleName")
    private String moduleName;
    @TableField("actionName")
    private String actionName;
    /**
     * 参数
     */
    private String params;
    private String description;
    @TableField("operaterId")
    private String operaterId;
    private String operater;
    @TableField("clientIP")
    private String clientIP;
    private String time;
    @TableField("operateTime")
    private Date operateTime;
    @TableField("deleteFlag")
    private Integer deleteFlag;
    /**
     * 最后修改时间
     */
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Sysoperatelog{" +
        ", logId=" + logId +
        ", logType=" + logType +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", storeId=" + storeId +
        ", storeName=" + storeName +
        ", moduleName=" + moduleName +
        ", actionName=" + actionName +
        ", params=" + params +
        ", description=" + description +
        ", operaterId=" + operaterId +
        ", operater=" + operater +
        ", clientIP=" + clientIP +
        ", time=" + time +
        ", operateTime=" + operateTime +
        ", deleteFlag=" + deleteFlag +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
