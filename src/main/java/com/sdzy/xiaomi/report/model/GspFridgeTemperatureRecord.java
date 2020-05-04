package com.sdzy.xiaomi.report.model;
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
 * @author charlin
 * @since 2018-06-28
 */
@TableName("gspFridgeTemperatureRecord")
public class GspFridgeTemperatureRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId("recordId")
    private String recordId;
    @TableField("storeId")
    private String storeId;
    @TableField("recordDate")
    private String recordDate;
    @TableField("temperatureAm")
    private BigDecimal temperatureAm;
    @TableField("humidityAm")
    private BigDecimal humidityAm;
    @TableField("takeStepAm")
    private String takeStepAm;
    @TableField("afterTakeStepTemperatureAm")
    private BigDecimal afterTakeStepTemperatureAm;
    @TableField("afterTakeStepHumidityAm")
    private BigDecimal afterTakeStepHumidityAm;
    @TableField("recorderAm")
    private String recorderAm;
    @TableField("temperaturePm")
    private BigDecimal temperaturePm;
    @TableField("humidityPm")
    private BigDecimal humidityPm;
    @TableField("takeStepPm")
    private String takeStepPm;
    @TableField("afterTakeStepTemperaturePm")
    private BigDecimal afterTakeStepTemperaturePm;
    @TableField("afterTakeStepHumidityPm")
    private BigDecimal afterTakeStepHumidityPm;
    @TableField("recorderPm")
    private String recorderPm;
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
    
    
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public BigDecimal getTemperatureAm() {
        return temperatureAm;
    }

    public void setTemperatureAm(BigDecimal temperatureAm) {
        this.temperatureAm = temperatureAm;
    }

    public BigDecimal getHumidityAm() {
        return humidityAm;
    }

    public void setHumidityAm(BigDecimal humidityAm) {
        this.humidityAm = humidityAm;
    }

    public String getTakeStepAm() {
        return takeStepAm;
    }

    public void setTakeStepAm(String takeStepAm) {
        this.takeStepAm = takeStepAm;
    }

    public BigDecimal getAfterTakeStepTemperatureAm() {
        return afterTakeStepTemperatureAm;
    }

    public void setAfterTakeStepTemperatureAm(BigDecimal afterTakeStepTemperatureAm) {
        this.afterTakeStepTemperatureAm = afterTakeStepTemperatureAm;
    }

    public BigDecimal getAfterTakeStepHumidityAm() {
        return afterTakeStepHumidityAm;
    }

    public void setAfterTakeStepHumidityAm(BigDecimal afterTakeStepHumidityAm) {
        this.afterTakeStepHumidityAm = afterTakeStepHumidityAm;
    }

    public String getRecorderAm() {
        return recorderAm;
    }

    public void setRecorderAm(String recorderAm) {
        this.recorderAm = recorderAm;
    }

    public BigDecimal getTemperaturePm() {
        return temperaturePm;
    }

    public void setTemperaturePm(BigDecimal temperaturePm) {
        this.temperaturePm = temperaturePm;
    }

    public BigDecimal getHumidityPm() {
        return humidityPm;
    }

    public void setHumidityPm(BigDecimal humidityPm) {
        this.humidityPm = humidityPm;
    }

    public String getTakeStepPm() {
        return takeStepPm;
    }

    public void setTakeStepPm(String takeStepPm) {
        this.takeStepPm = takeStepPm;
    }

    public BigDecimal getAfterTakeStepTemperaturePm() {
        return afterTakeStepTemperaturePm;
    }

    public void setAfterTakeStepTemperaturePm(BigDecimal afterTakeStepTemperaturePm) {
        this.afterTakeStepTemperaturePm = afterTakeStepTemperaturePm;
    }

    public BigDecimal getAfterTakeStepHumidityPm() {
        return afterTakeStepHumidityPm;
    }

    public void setAfterTakeStepHumidityPm(BigDecimal afterTakeStepHumidityPm) {
        this.afterTakeStepHumidityPm = afterTakeStepHumidityPm;
    }

    public String getRecorderPm() {
        return recorderPm;
    }

    public void setRecorderPm(String recorderPm) {
        this.recorderPm = recorderPm;
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
        return "GspFridgeTemperatureRecord{" +
        ", recordId=" + recordId +
        ", storeId=" + storeId +
        ", recordDate=" + recordDate +
        ", temperatureAm=" + temperatureAm +
        ", humidityAm=" + humidityAm +
        ", takeStepAm=" + takeStepAm +
        ", afterTakeStepTemperatureAm=" + afterTakeStepTemperatureAm +
        ", afterTakeStepHumidityAm=" + afterTakeStepHumidityAm +
        ", recorderAm=" + recorderAm +
        ", temperaturePm=" + temperaturePm +
        ", humidityPm=" + humidityPm +
        ", takeStepPm=" + takeStepPm +
        ", afterTakeStepTemperaturePm=" + afterTakeStepTemperaturePm +
        ", afterTakeStepHumidityPm=" + afterTakeStepHumidityPm +
        ", recorderPm=" + recorderPm +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
