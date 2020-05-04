package com.sdzy.xiaomi.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.stock.constant.StockConstant;
import com.sdzy.xiaomi.report.model.BaseProduct;
import com.sdzy.xiaomi.report.model.StockBatchInventory;

public class BaseUtils {

	public static Map<String, Object> setDatas(StockBatchInventory stockBatchInventory, BaseProduct product) {
		HashMap map = new HashMap();
		BigDecimal memberPrice = product.getMemberPrice();
		BigDecimal retailPrice = product.getRetailPrice();
		BigDecimal stockCount = stockBatchInventory.getStockCount();
		String unit = StringUtil.isEmpty(stockBatchInventory.getUnit())
				? product.getUnit()
				: stockBatchInventory.getUnit();
		BigDecimal initPrice = product.getLocalRetailPrice() != null
				&& product.getLocalRetailPrice().doubleValue() > 0.001D
						? product.getLocalRetailPrice()
						: product.getRetailPrice();
		BigDecimal purchasePrice = stockBatchInventory.getPurchasePrice();
		if (StockConstant.SPLIT_UNIT_KG.equalsIgnoreCase(unit)) {
			unit = StockConstant.SPLIT_UNIT_G;
			initPrice = initPrice.divide(new BigDecimal(1000));
			retailPrice = retailPrice.divide(new BigDecimal(1000));
			purchasePrice = purchasePrice.divide(new BigDecimal(1000));
			memberPrice = memberPrice.divide(new BigDecimal(1000));
			stockCount = stockCount.multiply(new BigDecimal(1000));
		}

		map.put("uniqueId",product.getProductId() + stockBatchInventory.getProductCode() + stockBatchInventory.getBatchNo());
		map.put("productId", product.getProductId());
		map.put("productCode", stockBatchInventory.getProductCode());
		map.put("productName", product.getProductName());
		map.put("produceFactory", product.getProduceFactory());
		map.put("produceDate", stockBatchInventory.getProduceDate());
		map.put("expiryDate", stockBatchInventory.getExpiryDate());
		map.put("standard", product.getStandard());
		map.put("batchNo", stockBatchInventory.getBatchNo());
		map.put("stockCount", stockCount);
		map.put("retailPrice", retailPrice);
		map.put("localRetailPrice", initPrice);
		map.put("originalPrice", initPrice);
		map.put("memberPrice", memberPrice);
		map.put("sellPrice", initPrice);
		map.put("saleCount", Integer.valueOf(1));
		map.put("discount", Integer.valueOf(100));
		map.put("sellAmount", initPrice);
		map.put("isEphedrine", product.getIsEphedrine());
		map.put("isRxDrug", product.getIsRxDrug());
		map.put("isGMP", product.getIsGMP());
		if (StringUtils.isNotEmpty(product.getAfterScatteredUnit())
				&& StringUtils.isNotEmpty(product.getScatteredCoefficient())) {
			map.put("isSplitDrug", Integer.valueOf(1));
		}

		map.put("remark", stockBatchInventory.getRemark());
		map.put("unit", unit);
		map.put("lotNo", stockBatchInventory.getLotNo());
		map.put("approvalNumber", product.getApprovalNumber());
		map.put("dosageForm", product.getDosageForm());
		map.put("genericName", product.getGenericName());
		map.put("inspectionOrderNo", stockBatchInventory.getInspectionOrderNo());
		map.put("inventoryId", stockBatchInventory.getInventoryId());
		map.put("categoryId", product.getCategoryId());
		map.put("tradePrice", purchasePrice);
		map.put("isYiBao", product.getIsYiBao());
		return map;
	}
}
