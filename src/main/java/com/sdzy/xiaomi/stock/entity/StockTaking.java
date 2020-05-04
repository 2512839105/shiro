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
@TableName("stockTaking")
public class StockTaking implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("stockTakingId")
    private String stockTakingId;
    @TableField("storeId")
    private String storeId;
    @TableField("stockTakingDate")
    private Date stockTakingDate;
    @TableField("productId")
    private String productId;
    @TableField("productCode")
    private String productCode;
    @TableField("productName")
    private String productName;
    @TableField("batchNo")
    private String batchNo;
    private String standard;
    private String unit;
    @TableField("produceFactory")
    private String produceFactory;
    private BigDecimal price;
    @TableField("produceDate")
    private String produceDate;
    @TableField("expiryDate")
    private String expiryDate;
    @TableField("genericName")
    private String genericName;
    @TableField("producingArea")
    private String producingArea;
    @TableField("approvalNumber")
    private String approvalNumber;
    @TableField("dosageForm")
    private String dosageForm;
    @TableField("lotNo")
    private String lotNo;
    @TableField("bookCount")
    private BigDecimal bookCount;
    @TableField("bookAmount")
    private BigDecimal bookAmount;
    @TableField("checkCount")
    private BigDecimal checkCount;
    @TableField("checkAmount")
    private BigDecimal checkAmount;
    @TableField("profitAndLossCount")
    private BigDecimal profitAndLossCount;
    @TableField("profitAndLossAmount")
    private BigDecimal profitAndLossAmount;
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
    @TableField("hasGspAdded")
    private Integer hasGspAdded;
    /**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


    public String getStockTakingId() {
        return stockTakingId;
    }

    public void setStockTakingId(String stockTakingId) {
        this.stockTakingId = stockTakingId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Date getStockTakingDate() {
        return stockTakingDate;
    }

    public void setStockTakingDate(Date stockTakingDate) {
        this.stockTakingDate = stockTakingDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProduceFactory() {
        return produceFactory;
    }

    public void setProduceFactory(String produceFactory) {
        this.produceFactory = produceFactory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getBookCount() {
        return bookCount;
    }

    public void setBookCount(BigDecimal bookCount) {
        this.bookCount = bookCount;
    }

    public BigDecimal getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(BigDecimal bookAmount) {
        this.bookAmount = bookAmount;
    }

    public BigDecimal getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(BigDecimal checkCount) {
        this.checkCount = checkCount;
    }

    public BigDecimal getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(BigDecimal checkAmount) {
        this.checkAmount = checkAmount;
    }

    public BigDecimal getProfitAndLossCount() {
        return profitAndLossCount;
    }

    public void setProfitAndLossCount(BigDecimal profitAndLossCount) {
        this.profitAndLossCount = profitAndLossCount;
    }

    public BigDecimal getProfitAndLossAmount() {
        return profitAndLossAmount;
    }

    public void setProfitAndLossAmount(BigDecimal profitAndLossAmount) {
        this.profitAndLossAmount = profitAndLossAmount;
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

    public Integer getHasGspAdded() {
        return hasGspAdded;
    }

    public void setHasGspAdded(Integer hasGspAdded) {
        this.hasGspAdded = hasGspAdded;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "StockTaking{" +
        ", stockTakingId=" + stockTakingId +
        ", storeId=" + storeId +
        ", stockTakingDate=" + stockTakingDate +
        ", productId=" + productId +
        ", productCode=" + productCode +
        ", productName=" + productName +
        ", batchNo=" + batchNo +
        ", standard=" + standard +
        ", unit=" + unit +
        ", produceFactory=" + produceFactory +
        ", price=" + price +
        ", produceDate=" + produceDate +
        ", expiryDate=" + expiryDate +
        ", genericName=" + genericName +
        ", producingArea=" + producingArea +
        ", approvalNumber=" + approvalNumber +
        ", dosageForm=" + dosageForm +
        ", lotNo=" + lotNo +
        ", bookCount=" + bookCount +
        ", bookAmount=" + bookAmount +
        ", checkCount=" + checkCount +
        ", checkAmount=" + checkAmount +
        ", profitAndLossCount=" + profitAndLossCount +
        ", profitAndLossAmount=" + profitAndLossAmount +
        ", auditState=" + auditState +
        ", auditUserId=" + auditUserId +
        ", auditUser=" + auditUser +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", hasGspAdded=" + hasGspAdded +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
