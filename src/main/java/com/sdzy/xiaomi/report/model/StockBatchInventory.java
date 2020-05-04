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
 * @since 2018-05-28
 */
@TableName("stockBatchInventory")
public class StockBatchInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("inventoryId")
    private String inventoryId;
    @TableField("storeId")
    private String storeId;
    @TableField("supplierId")
    private String supplierId;
    @TableField("supplierName")
    private String supplierName;
    @TableField("productId")
    private String productId;
    @TableField("productCode")
    private String productCode;
    @TableField("productName")
    private String productName;
    @TableField("genericName")
    private String genericName;
    private String standard;
    private String unit;
    @TableField("producingArea")
    private String producingArea;
    @TableField("produceFactory")
    private String produceFactory;
    @TableField("approvalNumber")
    private String approvalNumber;
    @TableField("dosageForm")
    private String dosageForm;
    @TableField("produceDate")
    private String produceDate;
    @TableField("expiryDate")
    private String expiryDate;
    @TableField("batchNo")
    private String batchNo;
    @TableField("lotNo")
    private String lotNo;
    /**
     * 库存数量
     */
    @TableField("stockCount")
    private BigDecimal stockCount;
    @TableField("purchaseCount")
    private BigDecimal purchaseCount;
    @TableField("purchasePrice")
    private BigDecimal purchasePrice;
    @TableField("purchaseFee")
    private BigDecimal purchaseFee;
    @TableField("operatorId")
    private String operatorId;
    private String operator;
    @TableField("inspectionOrderNo")
    private String inspectionOrderNo;
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    private String remark;
    private String mnemonicName;
    private String barCode; 
    private Integer isYiBao;
    public String getMnemonicName() {
		return mnemonicName;
	}

	public void setMnemonicName(String mnemonicName) {
		this.mnemonicName = mnemonicName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Integer getIsYiBao() {
		return isYiBao;
	}

	public void setIsYiBao(Integer isYiBao) {
		this.isYiBao = isYiBao;
	}

	/**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getProduceFactory() {
        return produceFactory;
    }

    public void setProduceFactory(String produceFactory) {
        this.produceFactory = produceFactory;
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

    public BigDecimal getStockCount() {
        return stockCount;
    }

    public void setStockCount(BigDecimal stockCount) {
        this.stockCount = stockCount;
    }

    public BigDecimal getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(BigDecimal purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseFee() {
        return purchaseFee;
    }

    public void setPurchaseFee(BigDecimal purchaseFee) {
        this.purchaseFee = purchaseFee;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInspectionOrderNo() {
        return inspectionOrderNo;
    }

    public void setInspectionOrderNo(String inspectionOrderNo) {
        this.inspectionOrderNo = inspectionOrderNo;
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
        return "StockBatchInventory{" +
        ", inventoryId=" + inventoryId +
        ", storeId=" + storeId +
        ", supplierId=" + supplierId +
        ", supplierName=" + supplierName +
        ", productId=" + productId +
        ", productCode=" + productCode +
        ", productName=" + productName +
        ", genericName=" + genericName +
        ", standard=" + standard +
        ", unit=" + unit +
        ", producingArea=" + producingArea +
        ", produceFactory=" + produceFactory +
        ", approvalNumber=" + approvalNumber +
        ", dosageForm=" + dosageForm +
        ", produceDate=" + produceDate +
        ", expiryDate=" + expiryDate +
        ", batchNo=" + batchNo +
        ", lotNo=" + lotNo +
        ", stockCount=" + stockCount +
        ", purchaseCount=" + purchaseCount +
        ", purchasePrice=" + purchasePrice +
        ", purchaseFee=" + purchaseFee +
        ", operatorId=" + operatorId +
        ", operator=" + operator +
        ", inspectionOrderNo=" + inspectionOrderNo +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", remark=" + remark +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
