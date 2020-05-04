package com.sdzy.xiaomi.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存表
 * @author  charlin
 */
public class StockBatchInventory implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3461744950789817020L;
	
	private BigDecimal stockCount;
 

	public BigDecimal getStockCount() {
		return stockCount;
	}

	public void setStockCount(BigDecimal stockCount) {
		this.stockCount = stockCount;
	}

	private String inventoryId;
    /**门店号*/
    private String storeId;
    /**供应商id*/
    private String supplierId;
    /**供应商名称*/
    private String supplierName;
    /**产品id*/
    private String productId;
    /**供应商编号*/
    private String productCode;
    /**供应商名称*/
    private String productName;
    /**通用名称*/
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
    /**数量*/
    private BigDecimal purchaseCount;
    /**采购单价*/
    private BigDecimal purchasePrice;
    /**采购金额*/
    private BigDecimal purchaseFee;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modifyDate;
    /**备注*/
    private String remark;
    /**删除标记-1表示删除*/
    private Integer deleteFlag;

    
    /**
     * 库存批次 平均成本价
     */
    private BigDecimal averagePrice;
    /**零售价*/
    private BigDecimal retailPrice;
    /**会员价*/
    private BigDecimal memberPrice;
    /**批发价*/
    private BigDecimal tradePrice;
    /**总库存*/
    private BigDecimal totalStorage;
    /**助记名*/
    private String mnemonicName;
    /**重点养护0否1是*/
    private int isMainConserve;
    /**中药饮片0否1是*/
    private int isDrugPiece;
    /**拆零系数*/
    private String scatteredCoefficient;
    /**拆零后单位*/
    private String afterScatteredUnit;
    
    private String inspectionOrderNo;
    private String operatorId;
    
    private String operator;
    
    /**用来查询*/
    private String barCode;
    
    private String storeCode;
    
    
    
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAfterScatteredUnit() {
		return afterScatteredUnit;
	}

	public void setAfterScatteredUnit(String afterScatteredUnit) {
		this.afterScatteredUnit = afterScatteredUnit;
	}

	public String getScatteredCoefficient() {
		return scatteredCoefficient;
	}

	public void setScatteredCoefficient(String scatteredCoefficient) {
		this.scatteredCoefficient = scatteredCoefficient;
	}

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

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getTotalStorage() {
        return totalStorage;
    }

    public void setTotalStorage(BigDecimal totalStorage) {
        this.totalStorage = totalStorage;
    }

    public String getMnemonicName() {
        return mnemonicName;
    }

    public void setMnemonicName(String mnemonicName) {
        this.mnemonicName = mnemonicName;
    }

    public int getIsMainConserve() {
        return isMainConserve;
    }

    public void setIsMainConserve(int isMainConserve) {
        this.isMainConserve = isMainConserve;
    }

    public int getIsDrugPiece() {
        return isDrugPiece;
    }

    public void setIsDrugPiece(int isDrugPiece) {
        this.isDrugPiece = isDrugPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockBatchInventory that = (StockBatchInventory) o;

        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        return batchNo != null ? batchNo.equals(that.batchNo) : that.batchNo == null;
    }

    @Override
    public int hashCode() {
        int result = productCode != null ? productCode.hashCode() : 0;
        result = 31 * result + (batchNo != null ? batchNo.hashCode() : 0);
        return result;
    }
}

