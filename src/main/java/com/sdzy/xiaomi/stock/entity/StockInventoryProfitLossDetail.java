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
@TableName("stockInventoryProfitLossDetail")
public class StockInventoryProfitLossDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("inventoryProfitLossDetailId")
    private String inventoryProfitLossDetailId;
    @TableField("storeId")
    private String storeId;
    @TableField("inventoryProfitLossNo")
    private String inventoryProfitLossNo;
    @TableField("productId")
    private String productId;
    @TableField("productCode")
    private String productCode;
    @TableField("productName")
    private String productName;
    @TableField("genericName")
    private String genericName;
    @TableField("producingArea")
    private String producingArea;
    private String standard;
    private String unit;
    @TableField("approvalNumber")
    private String approvalNumber;
    @TableField("produceFactory")
    private String produceFactory;
    @TableField("dosageForm")
    private String dosageForm;
    @TableField("expiryDate")
    private String expiryDate;
    @TableField("produceDate")
    private String produceDate;
    @TableField("batchNo")
    private String batchNo;
    @TableField("lotNo")
    private String lotNo;
    private BigDecimal price;
    private BigDecimal amount;
    @TableField("amountOfMoney")
    private BigDecimal amountOfMoney;
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


    public String getInventoryProfitLossDetailId() {
        return inventoryProfitLossDetailId;
    }

    public void setInventoryProfitLossDetailId(String inventoryProfitLossDetailId) {
        this.inventoryProfitLossDetailId = inventoryProfitLossDetailId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getInventoryProfitLossNo() {
        return inventoryProfitLossNo;
    }

    public void setInventoryProfitLossNo(String inventoryProfitLossNo) {
        this.inventoryProfitLossNo = inventoryProfitLossNo;
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

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getProduceFactory() {
        return produceFactory;
    }

    public void setProduceFactory(String produceFactory) {
        this.produceFactory = produceFactory;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
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
        return "StockInventoryProfitLossDetail{" +
        ", inventoryProfitLossDetailId=" + inventoryProfitLossDetailId +
        ", storeId=" + storeId +
        ", inventoryProfitLossNo=" + inventoryProfitLossNo +
        ", productId=" + productId +
        ", productCode=" + productCode +
        ", productName=" + productName +
        ", genericName=" + genericName +
        ", producingArea=" + producingArea +
        ", standard=" + standard +
        ", unit=" + unit +
        ", approvalNumber=" + approvalNumber +
        ", produceFactory=" + produceFactory +
        ", dosageForm=" + dosageForm +
        ", expiryDate=" + expiryDate +
        ", produceDate=" + produceDate +
        ", batchNo=" + batchNo +
        ", lotNo=" + lotNo +
        ", price=" + price +
        ", amount=" + amount +
        ", amountOfMoney=" + amountOfMoney +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
