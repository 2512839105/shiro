package com.sdzy.xiaomi.report.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import com.asdzy.common.utils.DateJsonDeserializer;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;
import com.sdzy.mall.promotion.model.PromotionProduct;
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
@TableName("saleOrderDetail")
public class SaleOrderDetail implements Serializable {

	 private String saleOrderDetailId;
	    /**门店号*/
	    private String storeId;
	    /**订单号*/
	    private String saleOrderNo;
	    /**货号Id*/
	    private String productId;
	    /**货号*/
	    private String productCode;
	    /**商品名*/
	    private String productName;
	    /**通用名*/
	    private String genericName;
	    /**产地*/
	    private String producingArea;
	    /**规格*/
	    private String standard;
	    /**单位*/
	    private String unit;
	    /**批准文号*/
	    private String approvalNumber;
	    /**生产单位*/
	    private String produceFactory;
	    /**剂型*/
	    private String dosageForm;
	    /**有效期至*/
	    private String expiryDate;
	    /**生产日期*/
	    private String produceDate;
	    /**批号*/
	    private String batchNo;
	    /**批次单号*/
	    private String lotNo;
	    /**是否处方药*/
	    private Integer isRxDrug;
	    /**含麻黄碱标志0否1是*/
	    private Integer isEphedrine;
	    /**含特药品种*/
	    private Integer isGMP;
	    /**可拆零药品，根据药品的拆零系数来判断*/
	    private Integer isSplitDrug;
	    /**是否医保品种*/
	    private Integer isYiBao;
	    /**数量*/
	    private BigDecimal saleCount;
	    /**库存*/
	    private BigDecimal stockCount;
	    /**成本价, 已换成tradePrice*/
	    private BigDecimal costPrice;
	    /**成本金额 , 已换成tradeAmount*/
	    private BigDecimal costAmount;
	    /**出厂指导单价*/
	    private BigDecimal retailPrice;
	    /**出厂指导金额*/
	    private BigDecimal retailAmount;
	    /**会员单价*/
	    private BigDecimal memberPrice;
	    /**会员金额*/
	    private BigDecimal memberAmount;

	    //---新增价格---开始----------------------------------
	    /**商品成本价，批次库存中的采购价*/
	    private BigDecimal tradePrice;
	    /**商品成本额*/
	    private BigDecimal tradeAmount;
	    /**原价 ：本地零售价为0取官方零售价，本地零售价不为0取本地零售价    有会员取会员价；*/
	    private BigDecimal originalPrice;
	    /**原价金额*/
	    private BigDecimal originalAmount;
	    /**售价, 折后价*/
	    private BigDecimal sellPrice;
	    /**售价金额 折后价*/
	    private BigDecimal sellAmount;

	    //---新增价格---结束----------------------------------

	    /**折扣*/
	    private BigDecimal discount;
	    /**折扣金额==相当于销售金额，现在基本不用*/
	    private BigDecimal discountFee;
	    /**创建日期*/
	    @JsonDeserialize(using=DateJsonDeserializer.class)
	    private Date createDate;
	    /**修改日期*/
	    @JsonDeserialize(using=DateJsonDeserializer.class)
	    private Date modifyDate;
	    /**备注*/
	    private String remark;
	    /**入库单号, 等于取批次号*/
	    private String inspectionOrderNo;
	    /**删除标记, -1表示删除*/
	    private int deleteFlag;
	    /**本地单价，就是调价后的价钱*/
	    private BigDecimal localRetailPrice;
	    /**销售订单id*/
	    private String saleOrderId;
	    //行号
	    private Integer lineNum;
	    //报表所用字段
	    /**营业员*/
	    private String seller;

	    //--不在数据库的字段---------------------------------------------------------------
	    /**首拆日期*/
	    @JsonDeserialize(using=DateJsonDeserializer.class)
	    private Date firstSplitDate;
	    /**会员编号*/
	    private String memberNo;
	    /**会员名称*/
	    private String memberName;
	    /**订单类型*/
	    private Integer saleOrderType;
	    /**订单日期*/
	    private Date saleDate;
	    /**操作员*/
	    private String operater;
	    /**订单类型 0:销售订单, 1:退货订单*/
	    private int detailType;
	    /**拆分人*/
	    private String splitUser;
	    private String supplierName;
	    
	    //---促销相关----------------------------------------------------------------
	    /**满足了促销 0:没有， 1达到， 如果达到则 把促销id与赠品名称添加到数据库*/
	    private int hasPromotion;
	    /**促销产品id*/
	    private String promotionProductId;
	    /**促销名称*/
	    private String promotionName;
	    /**促销赠品名称，使用*/
	    private String promotionGiveProductNames;
	    /**促销赠品ids, 使用":"间隔*/
	    private String promotionGiveProductIds;
	    /**促销减少金额*/
	    private BigDecimal promotionReduceAmount;
	    /**促销赠送产品数*/
	    private BigDecimal promotionGiveCount;
	    /**促销赠品总金额*/
	    private BigDecimal promotionGiveAmount;
	    /**促销产品*/
	    private PromotionProduct promotionProduct;
	    /**赠品产品*/
	    private List<PromotionGiveProduct> promotionGiveProductList;

	    /**1：是赠品， 0或null 正常销售*/
	    private Integer isGiveProduct;
	    /**赠品对应的原品产品号*/
	    private String giveProdcutParentCode;

	    /**商品助记名*/
	    private String   mnemonicName;
	    /**商品条码*/
	    private String   barCode;  
	    /**商品类别id*/
	    private String categoryId;
	    /**0:线下支付， 1：线上支付*/
	    private Integer payMethod;

	    private String standardCode;

	    /**是否提成*/
	    private Integer isCommission;
	    /**提成比例*/
	    private BigDecimal commissionRadio;
	    /**提成金额*/
	    private BigDecimal commissionAmount;
	    
	    
	    
	    public String getStandardCode() {
	        return standardCode;
	    }

	    public void setStandardCode(String standardCode) {
	        this.standardCode = standardCode;
	    }

	    public BigDecimal getCommissionAmount() {
	        return commissionAmount;
	    }

	    public void setCommissionAmount(BigDecimal commissionAmount) {
	        this.commissionAmount = commissionAmount;
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

	    public String getSupplierName() {
	        return supplierName;
	    }

	    public void setSupplierName(String supplierName) {
	        this.supplierName = supplierName;
	    }

	    public Integer getPayMethod() {
	        return payMethod;
	    }

	    public void setPayMethod(Integer payMethod) {
	        this.payMethod = payMethod;
	    }

	    public Integer getIsGiveProduct() {
	        return isGiveProduct;
	    }

	    public void setIsGiveProduct(Integer isGiveProduct) {
	        this.isGiveProduct = isGiveProduct;
	    }

	    public String getGiveProdcutParentCode() {
	        return giveProdcutParentCode;
	    }

	    public void setGiveProdcutParentCode(String giveProdcutParentCode) {
	        this.giveProdcutParentCode = giveProdcutParentCode;
	    }

	    public Date getFirstSplitDate() {
	        return firstSplitDate;
	    }

	    public void setFirstSplitDate(Date firstSplitDate) {
	        this.firstSplitDate = firstSplitDate;
	    }

	    public Integer getIsYiBao() {
	        return isYiBao;
	    }

	    public void setIsYiBao(Integer isYiBao) {
	        this.isYiBao = isYiBao;
	    }

	    public BigDecimal getPromotionGiveAmount() {
	        return promotionGiveAmount;
	    }

	    public void setPromotionGiveAmount(BigDecimal promotionGiveAmount) {
	        this.promotionGiveAmount = promotionGiveAmount;
	    }

	    public BigDecimal getOriginalPrice() {
	        return originalPrice;
	    }

	    public void setOriginalPrice(BigDecimal originalPrice) {
	        this.originalPrice = originalPrice;
	    }

	    public BigDecimal getOriginalAmount() {
	        return originalAmount;
	    }

	    public void setOriginalAmount(BigDecimal originalAmount) {
	        this.originalAmount = originalAmount;
	    }

	    public BigDecimal getSellPrice() {
	        return sellPrice;
	    }

	    public void setSellPrice(BigDecimal sellPrice) {
	        this.sellPrice = sellPrice;
	    }

	    public BigDecimal getSellAmount() {
	        return sellAmount;
	    }

	    public void setSellAmount(BigDecimal sellAmount) {
	        this.sellAmount = sellAmount;
	    }

	    public BigDecimal getTradePrice() {
			return tradePrice;
		}

		public void setTradePrice(BigDecimal tradePrice) {
			this.tradePrice = tradePrice;
		}

		public BigDecimal getTradeAmount() {
			return tradeAmount;
		}

		public void setTradeAmount(BigDecimal tradeAmount) {
			this.tradeAmount = tradeAmount;
		}

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

	    public BigDecimal getStockCount() {
	        return stockCount;
	    }

	    public void setStockCount(BigDecimal stockCount) {
	        this.stockCount = stockCount;
	    }

	    public BigDecimal getLocalRetailPrice() {
	        return localRetailPrice;
	    }

	    public void setLocalRetailPrice(BigDecimal localRetailPrice) {
	        this.localRetailPrice = localRetailPrice;
	    }

	    public int getDeleteFlag() {
	        return deleteFlag;
	    }

	    public void setDeleteFlag(int deleteFlag) {
	        this.deleteFlag = deleteFlag;
	    }

		public BigDecimal getPromotionGiveCount() {
	        return promotionGiveCount;
	    }

	    public void setPromotionGiveCount(BigDecimal promotionGiveCount) {
	        this.promotionGiveCount = promotionGiveCount;
	    }

	    public BigDecimal getPromotionReduceAmount() {
	        return promotionReduceAmount;
	    }

	    public void setPromotionReduceAmount(BigDecimal promotionReduceAmount) {
	        this.promotionReduceAmount = promotionReduceAmount;
	    }

	    public String getPromotionName() {
	        return promotionName;
	    }

	    public void setPromotionName(String promotionName) {
	        this.promotionName = promotionName;
	    }

	    public int getHasPromotion() {
	        return hasPromotion;
	    }

	    public void setHasPromotion(int hasPromotion) {
	        this.hasPromotion = hasPromotion;
	    }

	    public String getPromotionProductId() {
	        return promotionProductId;
	    }

	    public void setPromotionProductId(String promotionProductId) {
	        this.promotionProductId = promotionProductId;
	    }

	    public String getPromotionGiveProductNames() {
	        return promotionGiveProductNames;
	    }

	    public void setPromotionGiveProductNames(String promotionGiveProductNames) {
	        this.promotionGiveProductNames = promotionGiveProductNames;
	    }

	    public PromotionProduct getPromotionProduct() {
	        return promotionProduct;
	    }

	    public void setPromotionProduct(PromotionProduct promotionProduct) {
	        this.promotionProduct = promotionProduct;
	    }

	    public List<PromotionGiveProduct> getPromotionGiveProductList() {
	        return promotionGiveProductList;
	    }

	    public void setPromotionGiveProductList(List<PromotionGiveProduct> promotionGiveProductList) {
	        this.promotionGiveProductList = promotionGiveProductList;
	    }

	    public String getSplitUser() {
			return splitUser;
		}

		public void setSplitUser(String splitUser) {
			this.splitUser = splitUser;
		}

	    public String getInspectionOrderNo() {
			return inspectionOrderNo;
		}

		public void setInspectionOrderNo(String inspectionOrderNo) {
			this.inspectionOrderNo = inspectionOrderNo;
		}

		public int getDetailType() {
	        return detailType;
	    }

	    public void setDetailType(int detailType) {
	        this.detailType = detailType;
	    }

	    public String getOperater() {
	        return operater;
	    }

	    public void setOperater(String operater) {
	        this.operater = operater;
	    }

	    public String getMemberName() {
	        return memberName;
	    }

	    public void setMemberName(String memberName) {
	        this.memberName = memberName;
	    }

	    public String getSeller() {
	        return seller;
	    }

	    public void setSeller(String seller) {
	        this.seller = seller;
	    }

	    public String getMemberNo() {
	        return memberNo;
	    }

	    public void setMemberNo(String memberNo) {
	        this.memberNo = memberNo;
	    }

	    public Integer getSaleOrderType() {
	        return saleOrderType;
	    }

	    public void setSaleOrderType(Integer saleOrderType) {
	        this.saleOrderType = saleOrderType;
	    }

	    public String getSaleOrderDetailId() {
	        return saleOrderDetailId;
	    }

	    public void setSaleOrderDetailId(String saleOrderDetailId) {
	        this.saleOrderDetailId = saleOrderDetailId;
	    }

	    public String getStoreId() {
	        return storeId;
	    }

	    public void setStoreId(String storeId) {
	        this.storeId = storeId;
	    }

	    public String getSaleOrderNo() {
	        return saleOrderNo;
	    }

	    public void setSaleOrderNo(String saleOrderNo) {
	        this.saleOrderNo = saleOrderNo;
	    }

	    public Date getSaleDate() {
	        return saleDate;
	    }

	    public void setSaleDate(Date saleDate) {
	        this.saleDate = saleDate;
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

	    public Integer getIsRxDrug() {
	        return isRxDrug;
	    }

	    public void setIsRxDrug(Integer isRxDrug) {
	        this.isRxDrug = isRxDrug;
	    }

	    public Integer getIsEphedrine() {
	        return isEphedrine;
	    }

	    public void setIsEphedrine(Integer isEphedrine) {
	        this.isEphedrine = isEphedrine;
	    }

	    public Integer getIsGMP() {
	        return isGMP;
	    }

	    public void setIsGMP(Integer isGMP) {
	        this.isGMP = isGMP;
	    }

	    public Integer getIsSplitDrug() {
	        return isSplitDrug;
	    }

	    public void setIsSplitDrug(Integer isSplitDrug) {
	        this.isSplitDrug = isSplitDrug;
	    }

	    public BigDecimal getSaleCount() {
	        return saleCount;
	    }

	    public void setSaleCount(BigDecimal saleCount) {
	        this.saleCount = saleCount;
	    }

	    public BigDecimal getCostPrice() {
	        return costPrice;
	    }

	    public void setCostPrice(BigDecimal costPrice) {
	        this.costPrice = costPrice;
	    }

	    public BigDecimal getCostAmount() {
	        return costAmount;
	    }

	    public void setCostAmount(BigDecimal costAmount) {
	        this.costAmount = costAmount;
	    }

	    public BigDecimal getRetailPrice() {
	        return retailPrice;
	    }

	    public void setRetailPrice(BigDecimal retailPrice) {
	        this.retailPrice = retailPrice;
	    }

	    public BigDecimal getRetailAmount() {
	        return retailAmount;
	    }

	    public void setRetailAmount(BigDecimal retailAmount) {
	        this.retailAmount = retailAmount;
	    }

	    public BigDecimal getMemberPrice() {
	        return memberPrice;
	    }

	    public void setMemberPrice(BigDecimal memberPrice) {
	        this.memberPrice = memberPrice;
	    }

	    public BigDecimal getMemberAmount() {
	        return memberAmount;
	    }

	    public void setMemberAmount(BigDecimal memberAmount) {
	        this.memberAmount = memberAmount;
	    }

	    public BigDecimal getDiscount() {
	        return discount;
	    }

	    public void setDiscount(BigDecimal discount) {
	        this.discount = discount;
	    }

	    public BigDecimal getDiscountFee() {
	        return discountFee;
	    }

	    public void setDiscountFee(BigDecimal discountFee) {
	        this.discountFee = discountFee;
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

	    public String getSaleOrderId() {
	        return saleOrderId;
	    }

	    public void setSaleOrderId(String saleOrderId) {
	        this.saleOrderId = saleOrderId;
	    }

	    public Integer getLineNum() {
	        return lineNum;
	    }

	    public void setLineNum(Integer lineNum) {
	        this.lineNum = lineNum;
	    }

	    public String getPromotionGiveProductIds() {
	        return promotionGiveProductIds;
	    }

	    public void setPromotionGiveProductIds(String promotionGiveProductIds) {
	        this.promotionGiveProductIds = promotionGiveProductIds;
	    }

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

}
