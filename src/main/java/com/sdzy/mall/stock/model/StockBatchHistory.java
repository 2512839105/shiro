package com.sdzy.mall.stock.model;

import java.io.Serializable;
import java.util.Date;

/***
 * 库存历史操作表
 * @author  charlin
 */
public class StockBatchHistory implements Serializable {
    /**id*/
    private String historyId;
    /**0:表示验收, 1:表示销售, 2:表示退货, 3:表示盘点, 4:验收, 5:不合格品报损, 6:拆零*/
    private Integer operateType;
    /**批次id*/
    private String inventoryId;
    /**门店id*/
    private String storeId;
    /**供应商id*/
    private String supplierId;
    /**供应商名称*/
    private String supplierName;
    /**产品id*/
    private String productId;
    /**产品编号*/
    private String productCode;
    /**产品名称*/
    private String productName;
    /**通用名*/
    private String genericName;
    /**规格*/
    private String standard;
    /**单位*/
    private String unit;
    /**产地*/
    private String producingArea;
    /**生产单位*/
    private String produceFactory;
    /**批准文号*/
    private String approvalNumber;
    /**剂型*/
    private String dosageForm;
    /**生产日期*/
    private String produceDate;
    /**有效期至*/
    private String expiryDate;
    /**批号*/
    private String batchNo;
    /**批次单号*/
    private String lotNo;
    /**变化数量*/
    private Double count;
    /**采购单价*/
    private Double purchasePrice;
    /**采购金额*/
    private Double purchaseFee;
    /**创建用户名称*/
    private String createUserName;
    /**创建用户id*/
    private String createUserId;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;
    /**备注*/
    private String remark;
    /**删除标记 -1表示删除*/
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId == null ? null : historyId.trim();
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName == null ? null : genericName.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea == null ? null : producingArea.trim();
    }

    public String getProduceFactory() {
        return produceFactory;
    }

    public void setProduceFactory(String produceFactory) {
        this.produceFactory = produceFactory == null ? null : produceFactory.trim();
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber == null ? null : approvalNumber.trim();
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm == null ? null : dosageForm.trim();
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate == null ? null : produceDate.trim();
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo == null ? null : lotNo.trim();
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getPurchaseFee() {
        return purchaseFee;
    }

    public void setPurchaseFee(Double purchaseFee) {
        this.purchaseFee = purchaseFee;
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", historyId=").append(historyId);
        sb.append(", operateType=").append(operateType);
        sb.append(", inventoryId=").append(inventoryId);
        sb.append(", storeId=").append(storeId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", productId=").append(productId);
        sb.append(", productCode=").append(productCode);
        sb.append(", productName=").append(productName);
        sb.append(", genericName=").append(genericName);
        sb.append(", standard=").append(standard);
        sb.append(", unit=").append(unit);
        sb.append(", producingArea=").append(producingArea);
        sb.append(", produceFactory=").append(produceFactory);
        sb.append(", approvalNumber=").append(approvalNumber);
        sb.append(", dosageForm=").append(dosageForm);
        sb.append(", produceDate=").append(produceDate);
        sb.append(", expiryDate=").append(expiryDate);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", lotNo=").append(lotNo);
        sb.append(", count=").append(count);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", purchaseFee=").append(purchaseFee);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", remark=").append(remark);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append("]");
        return sb.toString();
    }
}