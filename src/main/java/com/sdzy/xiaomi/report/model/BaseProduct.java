package com.sdzy.xiaomi.report.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@TableName("baseProduct")
public class BaseProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("productId")
    private String productId;
    @TableField("storeId")
    private String storeId;
    @TableField("dataSource")
    private String dataSource;
    @TableField("categoryId")
    private String categoryId;
    /**
     * 类别名称
     */
    @TableField("categoryName")
    private String categoryName;
    @TableField("productCode")
    private String productCode;
    @TableField("productName")
    private String productName;
    @TableField("genericName")
    private String genericName;
    @TableField("producingArea")
    private String producingArea;
    @TableField("supplierId")
    private String supplierId;
    @TableField("supplierName")
    private String supplierName;
    private String standard;
    private String unit;
    @TableField("mnemonicName")
    private String mnemonicName;
    @TableField("totalStorage")
    private BigDecimal totalStorage;
    private BigDecimal tradeOldPrice;
    private Integer  auditState0;
    private Integer isWebSale;
    private String auditUserId0;
    private String auditUserName0;
    private Date auditDate0;
    private String auditRemark0;
    private Integer auditState1;
    private Integer auditState2;
    private Integer isCommission;
    private BigDecimal commissionRadio;
    private BigDecimal profit;
    private BigDecimal profitRate;
    private BigDecimal commissionAmount;
    
    public Integer getAuditState0() {
		return auditState0;
	}

	public void setAuditState0(Integer auditState0) {
		this.auditState0 = auditState0;
	}

	public Integer getIsWebSale() {
		return isWebSale;
	}

	public void setIsWebSale(Integer isWebSale) {
		this.isWebSale = isWebSale;
	}

	public String getAuditUserId0() {
		return auditUserId0;
	}

	public void setAuditUserId0(String auditUserId0) {
		this.auditUserId0 = auditUserId0;
	}

	public String getAuditUserName0() {
		return auditUserName0;
	}

	public void setAuditUserName0(String auditUserName0) {
		this.auditUserName0 = auditUserName0;
	}

	public Date getAuditDate0() {
		return auditDate0;
	}

	public void setAuditDate0(Date auditDate0) {
		this.auditDate0 = auditDate0;
	}

	public String getAuditRemark0() {
		return auditRemark0;
	}

	public void setAuditRemark0(String auditRemark0) {
		this.auditRemark0 = auditRemark0;
	}

	public Integer getAuditState1() {
		return auditState1;
	}

	public void setAuditState1(Integer auditState1) {
		this.auditState1 = auditState1;
	}

	public Integer getAuditState2() {
		return auditState2;
	}

	public void setAuditState2(Integer auditState2) {
		this.auditState2 = auditState2;
	}

	public Integer getIsCommission() {
		return isCommission;
	}

	public void setIsCommission(Integer isCommission) {
		this.isCommission = isCommission;
	}

	public BigDecimal getCommissionRadio() {
		return commissionRadio;
	}

	public void setCommissionRadio(BigDecimal commissionRadio) {
		this.commissionRadio = commissionRadio;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(BigDecimal profitRate) {
		this.profitRate = profitRate;
	}

	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public BigDecimal getTradeOldPrice() {
		return tradeOldPrice;
	}

	public void setTradeOldPrice(BigDecimal tradeOldPrice) {
		this.tradeOldPrice = tradeOldPrice;
	}

	/**
     * 批发价
     */
    @TableField("tradePrice")
    private BigDecimal tradePrice;
    /**
     * 平均成本价
     */
    @TableField("averagePrice")
    private BigDecimal averagePrice;
    /**
     * 指导零售价
     */
    @TableField("retailPrice")
    private BigDecimal retailPrice;
    /**
     * 本地零售价
     */
    @TableField("localRetailPrice")
    private BigDecimal localRetailPrice;
    /**
     * 会员价
     */
    @TableField("memberPrice")
    private BigDecimal memberPrice;
    @TableField("sellingPrice1")
    private BigDecimal sellingPrice1;
    @TableField("sellingPrice2")
    private BigDecimal sellingPrice2;
    @TableField("sellingPrice3")
    private BigDecimal sellingPrice3;
    @TableField("barCode")
    private String barCode;
    @TableField("localBarCode")
    private String localBarCode;
    @TableField("propertyId")
    private String propertyId;
    /**
     * 属性名称
     */
    @TableField("propertyName")
    private String propertyName;
    @TableField("isRxDrug")
    private Integer isRxDrug;
    @TableField("approvalNumber")
    private String approvalNumber;
    @TableField("produceFactory")
    private String produceFactory;
    @TableField("dosageForm")
    private String dosageForm;
    @TableField("acceptanceLevel")
    private String acceptanceLevel;
    @TableField("storageCondition")
    private String storageCondition;
    @TableField("standardCode")
    private String standardCode;
    @TableField("proviceStandard")
    private String proviceStandard;
    @TableField("expiryDate")
    private BigDecimal expiryDate;
    @TableField("isYiBao")
    private Integer isYiBao;
    @TableField("isGMP")
    private Integer isGMP;
    private String effect;
    @TableField("characterInfo")
    private String characterInfo;
    @TableField("brandId")
    private String brandId;
    @TableField("isDrug")
    private Integer isDrug;
    @TableField("drugCategoryId")
    private String drugCategoryId;
    @TableField("priceFloat")
    private BigDecimal priceFloat;
    @TableField("goodsAllocation")
    private String goodsAllocation;
    @TableField("afterScatteredUnit")
    private String afterScatteredUnit;
    @TableField("scatteredCoefficient")
    private String scatteredCoefficient;
    @TableField(value = "createDate", fill = FieldFill.INSERT_UPDATE)
    private Date createDate;
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;
    /**
     * 0:禁止，1启用
     */
    private Integer status;
    @TableField("isAudit")
    private Integer isAudit;
    @TableField("isCancel")
    private Integer isCancel;
    @TableField("createUserId")
    private String createUserId;
    @TableField("createUserName")
    private String createUserName;
    @TableField("gspTypeId")
    private String gspTypeId;
    @TableField("storageUpper")
    private BigDecimal storageUpper;
    @TableField("storageFloor")
    private BigDecimal storageFloor;
    @TableField("mainClassId")
    private String mainClassId;
    @TableField("retailMiddleClass")
    private String retailMiddleClass;
    @TableField("retailSmallClass")
    private String retailSmallClass;
    @TableField("productCluster")
    private String productCluster;
    @TableField("conserveReason")
    private String conserveReason;
    @TableField("isMainConserve")
    private Integer isMainConserve;
    @TableField("conserveMeasure")
    private String conserveMeasure;
    @TableField("isImportedDrug")
    private Integer isImportedDrug;
    @TableField("isDrugPiece")
    private Integer isDrugPiece;
    @TableField("instrumnetTypeId")
    private String instrumnetTypeId;
    @TableField("isEggPreparation")
    private Integer isEggPreparation;
    @TableField("isTwoClassmentalDrug")
    private Integer isTwoClassmentalDrug;
    @TableField("isEphedrine")
    private Integer isEphedrine;
    @TableField("isThormone")
    private Integer isThormone;
    @TableField("isMindDrug")
    private Integer isMindDrug;
    @TableField("isDangerChemistry")
    private Integer isDangerChemistry;
    @TableField("isAnesthetic")
    private Integer isAnesthetic;
    @TableField("isMedicalToxicity")
    private Integer isMedicalToxicity;
    @TableField("isVaccine")
    private Integer isVaccine;
    @TableField("isDiagnosticReagent")
    private Integer isDiagnosticReagent;
    @TableField("isStimulant")
    private Integer isStimulant;
    @TableField("isEan1")
    private Integer isEan1;
    @TableField("isEan2")
    private Integer isEan2;
    @TableField("isHealthFood")
    private Integer isHealthFood;
    @TableField("isFood")
    private Integer isFood;
    @TableField("storeRequireClass")
    private String storeRequireClass;
    @TableField("otcClass")
    private String otcClass;
    @TableField("isTermination")
    private Integer isTermination;
    @TableField("seasonClass")
    private String seasonClass;
    @TableField("coreItemClass")
    private String coreItemClass;
    @TableField("deliveryRequireClass")
    private String deliveryRequireClass;
    @TableField("arearangeName")
    private String arearangeName;
    @TableField("lowTemperature")
    private Integer lowTemperature;
    @TableField("abcClass")
    private String abcClass;
    private String remark;
    @TableField("auditUserId1")
    private String auditUserId1;
    @TableField("auditUserName1")
    private String auditUserName1;
    @TableField("auditDate1")
    private Date auditDate1;
    @TableField("auditRemark1")
    private String auditRemark1;
    @TableField("auditUserId2")
    private String auditUserId2;
    @TableField("auditUserName2")
    private String auditUserName2;
    @TableField("auditDate2")
    private Date auditDate2;
    @TableField("auditRemark2")
    private String auditRemark2;
    private List<StockBatchInventory> stockBatchInventories;

    public List<StockBatchInventory> getStockBatchInventories() {
		return stockBatchInventories;
	}

	public void setStockBatchInventories(List<StockBatchInventory> stockBatchInventories) {
		this.stockBatchInventories = stockBatchInventories;
	}

	/**
     * -1表示删除,0或null表示正常
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;
    /**
     * 陈列区
     */
    @TableField("exhibitionArea")
    private String exhibitionArea;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getMnemonicName() {
        return mnemonicName;
    }

    public void setMnemonicName(String mnemonicName) {
        this.mnemonicName = mnemonicName;
    }

    public BigDecimal getTotalStorage() {
        return totalStorage;
    }

    public void setTotalStorage(BigDecimal totalStorage) {
        this.totalStorage = totalStorage;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
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

    public BigDecimal getLocalRetailPrice() {
        return localRetailPrice;
    }

    public void setLocalRetailPrice(BigDecimal localRetailPrice) {
        this.localRetailPrice = localRetailPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public BigDecimal getSellingPrice1() {
        return sellingPrice1;
    }

    public void setSellingPrice1(BigDecimal sellingPrice1) {
        this.sellingPrice1 = sellingPrice1;
    }

    public BigDecimal getSellingPrice2() {
        return sellingPrice2;
    }

    public void setSellingPrice2(BigDecimal sellingPrice2) {
        this.sellingPrice2 = sellingPrice2;
    }

    public BigDecimal getSellingPrice3() {
        return sellingPrice3;
    }

    public void setSellingPrice3(BigDecimal sellingPrice3) {
        this.sellingPrice3 = sellingPrice3;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getLocalBarCode() {
        return localBarCode;
    }

    public void setLocalBarCode(String localBarCode) {
        this.localBarCode = localBarCode;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getIsRxDrug() {
        return isRxDrug;
    }

    public void setIsRxDrug(Integer isRxDrug) {
        this.isRxDrug = isRxDrug;
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

    public String getAcceptanceLevel() {
        return acceptanceLevel;
    }

    public void setAcceptanceLevel(String acceptanceLevel) {
        this.acceptanceLevel = acceptanceLevel;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getProviceStandard() {
        return proviceStandard;
    }

    public void setProviceStandard(String proviceStandard) {
        this.proviceStandard = proviceStandard;
    }

    public BigDecimal getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(BigDecimal expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getIsYiBao() {
        return isYiBao;
    }

    public void setIsYiBao(Integer isYiBao) {
        this.isYiBao = isYiBao;
    }

    public Integer getIsGMP() {
        return isGMP;
    }

    public void setIsGMP(Integer isGMP) {
        this.isGMP = isGMP;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCharacterInfo() {
        return characterInfo;
    }

    public void setCharacterInfo(String characterInfo) {
        this.characterInfo = characterInfo;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Integer getIsDrug() {
        return isDrug;
    }

    public void setIsDrug(Integer isDrug) {
        this.isDrug = isDrug;
    }

    public String getDrugCategoryId() {
        return drugCategoryId;
    }

    public void setDrugCategoryId(String drugCategoryId) {
        this.drugCategoryId = drugCategoryId;
    }

    public BigDecimal getPriceFloat() {
        return priceFloat;
    }

    public void setPriceFloat(BigDecimal priceFloat) {
        this.priceFloat = priceFloat;
    }

    public String getGoodsAllocation() {
        return goodsAllocation;
    }

    public void setGoodsAllocation(String goodsAllocation) {
        this.goodsAllocation = goodsAllocation;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
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

    public String getGspTypeId() {
        return gspTypeId;
    }

    public void setGspTypeId(String gspTypeId) {
        this.gspTypeId = gspTypeId;
    }

    public BigDecimal getStorageUpper() {
        return storageUpper;
    }

    public void setStorageUpper(BigDecimal storageUpper) {
        this.storageUpper = storageUpper;
    }

    public BigDecimal getStorageFloor() {
        return storageFloor;
    }

    public void setStorageFloor(BigDecimal storageFloor) {
        this.storageFloor = storageFloor;
    }

    public String getMainClassId() {
        return mainClassId;
    }

    public void setMainClassId(String mainClassId) {
        this.mainClassId = mainClassId;
    }

    public String getRetailMiddleClass() {
        return retailMiddleClass;
    }

    public void setRetailMiddleClass(String retailMiddleClass) {
        this.retailMiddleClass = retailMiddleClass;
    }

    public String getRetailSmallClass() {
        return retailSmallClass;
    }

    public void setRetailSmallClass(String retailSmallClass) {
        this.retailSmallClass = retailSmallClass;
    }

    public String getProductCluster() {
        return productCluster;
    }

    public void setProductCluster(String productCluster) {
        this.productCluster = productCluster;
    }

    public String getConserveReason() {
        return conserveReason;
    }

    public void setConserveReason(String conserveReason) {
        this.conserveReason = conserveReason;
    }

    public Integer getIsMainConserve() {
        return isMainConserve;
    }

    public void setIsMainConserve(Integer isMainConserve) {
        this.isMainConserve = isMainConserve;
    }

    public String getConserveMeasure() {
        return conserveMeasure;
    }

    public void setConserveMeasure(String conserveMeasure) {
        this.conserveMeasure = conserveMeasure;
    }

    public Integer getIsImportedDrug() {
        return isImportedDrug;
    }

    public void setIsImportedDrug(Integer isImportedDrug) {
        this.isImportedDrug = isImportedDrug;
    }

    public Integer getIsDrugPiece() {
        return isDrugPiece;
    }

    public void setIsDrugPiece(Integer isDrugPiece) {
        this.isDrugPiece = isDrugPiece;
    }

    public String getInstrumnetTypeId() {
        return instrumnetTypeId;
    }

    public void setInstrumnetTypeId(String instrumnetTypeId) {
        this.instrumnetTypeId = instrumnetTypeId;
    }

    public Integer getIsEggPreparation() {
        return isEggPreparation;
    }

    public void setIsEggPreparation(Integer isEggPreparation) {
        this.isEggPreparation = isEggPreparation;
    }

    public Integer getIsTwoClassmentalDrug() {
        return isTwoClassmentalDrug;
    }

    public void setIsTwoClassmentalDrug(Integer isTwoClassmentalDrug) {
        this.isTwoClassmentalDrug = isTwoClassmentalDrug;
    }

    public Integer getIsEphedrine() {
        return isEphedrine;
    }

    public void setIsEphedrine(Integer isEphedrine) {
        this.isEphedrine = isEphedrine;
    }

    public Integer getIsThormone() {
        return isThormone;
    }

    public void setIsThormone(Integer isThormone) {
        this.isThormone = isThormone;
    }

    public Integer getIsMindDrug() {
        return isMindDrug;
    }

    public void setIsMindDrug(Integer isMindDrug) {
        this.isMindDrug = isMindDrug;
    }

    public Integer getIsDangerChemistry() {
        return isDangerChemistry;
    }

    public void setIsDangerChemistry(Integer isDangerChemistry) {
        this.isDangerChemistry = isDangerChemistry;
    }

    public Integer getIsAnesthetic() {
        return isAnesthetic;
    }

    public void setIsAnesthetic(Integer isAnesthetic) {
        this.isAnesthetic = isAnesthetic;
    }

    public Integer getIsMedicalToxicity() {
        return isMedicalToxicity;
    }

    public void setIsMedicalToxicity(Integer isMedicalToxicity) {
        this.isMedicalToxicity = isMedicalToxicity;
    }

    public Integer getIsVaccine() {
        return isVaccine;
    }

    public void setIsVaccine(Integer isVaccine) {
        this.isVaccine = isVaccine;
    }

    public Integer getIsDiagnosticReagent() {
        return isDiagnosticReagent;
    }

    public void setIsDiagnosticReagent(Integer isDiagnosticReagent) {
        this.isDiagnosticReagent = isDiagnosticReagent;
    }

    public Integer getIsStimulant() {
        return isStimulant;
    }

    public void setIsStimulant(Integer isStimulant) {
        this.isStimulant = isStimulant;
    }

    public Integer getIsEan1() {
        return isEan1;
    }

    public void setIsEan1(Integer isEan1) {
        this.isEan1 = isEan1;
    }

    public Integer getIsEan2() {
        return isEan2;
    }

    public void setIsEan2(Integer isEan2) {
        this.isEan2 = isEan2;
    }

    public Integer getIsHealthFood() {
        return isHealthFood;
    }

    public void setIsHealthFood(Integer isHealthFood) {
        this.isHealthFood = isHealthFood;
    }

    public Integer getIsFood() {
        return isFood;
    }

    public void setIsFood(Integer isFood) {
        this.isFood = isFood;
    }

    public String getStoreRequireClass() {
        return storeRequireClass;
    }

    public void setStoreRequireClass(String storeRequireClass) {
        this.storeRequireClass = storeRequireClass;
    }

    public String getOtcClass() {
        return otcClass;
    }

    public void setOtcClass(String otcClass) {
        this.otcClass = otcClass;
    }

    public Integer getIsTermination() {
        return isTermination;
    }

    public void setIsTermination(Integer isTermination) {
        this.isTermination = isTermination;
    }

    public String getSeasonClass() {
        return seasonClass;
    }

    public void setSeasonClass(String seasonClass) {
        this.seasonClass = seasonClass;
    }

    public String getCoreItemClass() {
        return coreItemClass;
    }

    public void setCoreItemClass(String coreItemClass) {
        this.coreItemClass = coreItemClass;
    }

    public String getDeliveryRequireClass() {
        return deliveryRequireClass;
    }

    public void setDeliveryRequireClass(String deliveryRequireClass) {
        this.deliveryRequireClass = deliveryRequireClass;
    }

    public String getArearangeName() {
        return arearangeName;
    }

    public void setArearangeName(String arearangeName) {
        this.arearangeName = arearangeName;
    }

    public Integer getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(Integer lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public String getAbcClass() {
        return abcClass;
    }

    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditUserId1() {
        return auditUserId1;
    }

    public void setAuditUserId1(String auditUserId1) {
        this.auditUserId1 = auditUserId1;
    }

    public String getAuditUserName1() {
        return auditUserName1;
    }

    public void setAuditUserName1(String auditUserName1) {
        this.auditUserName1 = auditUserName1;
    }

    public Date getAuditDate1() {
        return auditDate1;
    }

    public void setAuditDate1(Date auditDate1) {
        this.auditDate1 = auditDate1;
    }

    public String getAuditRemark1() {
        return auditRemark1;
    }

    public void setAuditRemark1(String auditRemark1) {
        this.auditRemark1 = auditRemark1;
    }

    public String getAuditUserId2() {
        return auditUserId2;
    }

    public void setAuditUserId2(String auditUserId2) {
        this.auditUserId2 = auditUserId2;
    }

    public String getAuditUserName2() {
        return auditUserName2;
    }

    public void setAuditUserName2(String auditUserName2) {
        this.auditUserName2 = auditUserName2;
    }

    public Date getAuditDate2() {
        return auditDate2;
    }

    public void setAuditDate2(Date auditDate2) {
        this.auditDate2 = auditDate2;
    }

    public String getAuditRemark2() {
        return auditRemark2;
    }

    public void setAuditRemark2(String auditRemark2) {
        this.auditRemark2 = auditRemark2;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getExhibitionArea() {
        return exhibitionArea;
    }

    public void setExhibitionArea(String exhibitionArea) {
        this.exhibitionArea = exhibitionArea;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
        ", productId=" + productId +
        ", storeId=" + storeId +
        ", dataSource=" + dataSource +
        ", categoryId=" + categoryId +
        ", categoryName=" + categoryName +
        ", productCode=" + productCode +
        ", productName=" + productName +
        ", genericName=" + genericName +
        ", producingArea=" + producingArea +
        ", supplierId=" + supplierId +
        ", supplierName=" + supplierName +
        ", standard=" + standard +
        ", unit=" + unit +
        ", mnemonicName=" + mnemonicName +
        ", totalStorage=" + totalStorage +
        ", tradePrice=" + tradePrice +
        ", averagePrice=" + averagePrice +
        ", retailPrice=" + retailPrice +
        ", localRetailPrice=" + localRetailPrice +
        ", memberPrice=" + memberPrice +
        ", sellingPrice1=" + sellingPrice1 +
        ", sellingPrice2=" + sellingPrice2 +
        ", sellingPrice3=" + sellingPrice3 +
        ", barCode=" + barCode +
        ", localBarCode=" + localBarCode +
        ", propertyId=" + propertyId +
        ", propertyName=" + propertyName +
        ", isRxDrug=" + isRxDrug +
        ", approvalNumber=" + approvalNumber +
        ", produceFactory=" + produceFactory +
        ", dosageForm=" + dosageForm +
        ", acceptanceLevel=" + acceptanceLevel +
        ", storageCondition=" + storageCondition +
        ", standardCode=" + standardCode +
        ", proviceStandard=" + proviceStandard +
        ", expiryDate=" + expiryDate +
        ", isYiBao=" + isYiBao +
        ", isGMP=" + isGMP +
        ", effect=" + effect +
        ", characterInfo=" + characterInfo +
        ", brandId=" + brandId +
        ", isDrug=" + isDrug +
        ", drugCategoryId=" + drugCategoryId +
        ", priceFloat=" + priceFloat +
        ", goodsAllocation=" + goodsAllocation +
        ", afterScatteredUnit=" + afterScatteredUnit +
        ", scatteredCoefficient=" + scatteredCoefficient +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", status=" + status +
        ", isAudit=" + isAudit +
        ", isCancel=" + isCancel +
        ", createUserId=" + createUserId +
        ", createUserName=" + createUserName +
        ", gspTypeId=" + gspTypeId +
        ", storageUpper=" + storageUpper +
        ", storageFloor=" + storageFloor +
        ", mainClassId=" + mainClassId +
        ", retailMiddleClass=" + retailMiddleClass +
        ", retailSmallClass=" + retailSmallClass +
        ", productCluster=" + productCluster +
        ", conserveReason=" + conserveReason +
        ", isMainConserve=" + isMainConserve +
        ", conserveMeasure=" + conserveMeasure +
        ", isImportedDrug=" + isImportedDrug +
        ", isDrugPiece=" + isDrugPiece +
        ", instrumnetTypeId=" + instrumnetTypeId +
        ", isEggPreparation=" + isEggPreparation +
        ", isTwoClassmentalDrug=" + isTwoClassmentalDrug +
        ", isEphedrine=" + isEphedrine +
        ", isThormone=" + isThormone +
        ", isMindDrug=" + isMindDrug +
        ", isDangerChemistry=" + isDangerChemistry +
        ", isAnesthetic=" + isAnesthetic +
        ", isMedicalToxicity=" + isMedicalToxicity +
        ", isVaccine=" + isVaccine +
        ", isDiagnosticReagent=" + isDiagnosticReagent +
        ", isStimulant=" + isStimulant +
        ", isEan1=" + isEan1 +
        ", isEan2=" + isEan2 +
        ", isHealthFood=" + isHealthFood +
        ", isFood=" + isFood +
        ", storeRequireClass=" + storeRequireClass +
        ", otcClass=" + otcClass +
        ", isTermination=" + isTermination +
        ", seasonClass=" + seasonClass +
        ", coreItemClass=" + coreItemClass +
        ", deliveryRequireClass=" + deliveryRequireClass +
        ", arearangeName=" + arearangeName +
        ", lowTemperature=" + lowTemperature +
        ", abcClass=" + abcClass +
        ", remark=" + remark +
        ", auditUserId1=" + auditUserId1 +
        ", auditUserName1=" + auditUserName1 +
        ", auditDate1=" + auditDate1 +
        ", auditRemark1=" + auditRemark1 +
        ", auditUserId2=" + auditUserId2 +
        ", auditUserName2=" + auditUserName2 +
        ", auditDate2=" + auditDate2 +
        ", auditRemark2=" + auditRemark2 +
        ", deleteFlag=" + deleteFlag +
        ", exhibitionArea=" + exhibitionArea +
        "}";
    }
}
