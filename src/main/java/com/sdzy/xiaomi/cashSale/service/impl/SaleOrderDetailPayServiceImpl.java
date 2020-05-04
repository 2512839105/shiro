package com.sdzy.xiaomi.cashSale.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.utils.StringUtil;
import com.asdzy.purpleredgourd.base.model.BaseMember;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdzy.mall.stock.constant.StockConstant;
import com.sdzy.xiaomi.cashSale.constant.SaleConstant;
import com.sdzy.xiaomi.cashSale.service.SaleOrderDetailPayService;
import com.sdzy.xiaomi.report.mapper.BaseProductMapper;
import com.sdzy.xiaomi.report.mapper.StockBatchInventoryMapper;
import com.sdzy.xiaomi.report.model.BaseProduct;
import com.sdzy.xiaomi.report.model.StockBatchInventory;
import com.sdzy.xiaomi.util.BaseUtils;

@Service
public class SaleOrderDetailPayServiceImpl implements SaleOrderDetailPayService {

 
    @Autowired
    private BaseProductMapper baseProductDAO;
    @Autowired
    private StockBatchInventoryMapper stockBatchInventoryDAO;

    private static final Logger logger = LoggerFactory.getLogger(SaleOrderDetailPayServiceImpl.class);

	@Override
	public DataGrid findSaleDetaisByBarCode(QueryParams queryParams, String keyword, LocalUser currentUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGrid findStockByKeyword(QueryParams queryParams, String keyword,String storeId) {
        //if(StringUtils.isEmpty(keyword)) throw new CustomerException("请输入条形码或货号!");
        //匹配条码
        boolean barCodepattern = Pattern.matches("^[0-9]{8,13}$", keyword) ;
        //如果完全满足货号则直接查询，不分页
        boolean productCodeMatch = Pattern.matches("^\\d{5,8}$", keyword);
        if (barCodepattern) {
            return this.findStockByBarCode(keyword, SaleConstant.QUERY_FLAG_BARCODE,storeId);
        }else if (productCodeMatch) {
            return this.findStockByBarCode(keyword, SaleConstant.QUERY_FLAG_PRODUCTCODE,storeId);
        }else {
            return this.findStockByProperties(keyword, queryParams, storeId);
        }
	}

	@Override
	public DataGrid findStockByBarCode(String barCode, Integer type,String storeId) {
		 // LocalUser localUser = SessionUtil.getLocalUser();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("storeId", storeId);
	        //查询中药信息
//	        if (StringUtils.isNotEmpty(barCode) && barCode.startsWith("0") && barCode.length() < 12) {
//	            map.put("unit", StockConstant.SPLIT_UNIT_KG);
//	        } else {
	        map.put("keyword", barCode);
//	        }
	        List<BaseProduct> list = null;
	        if (SaleConstant.QUERY_FLAG_BARCODE == type){
	            list = baseProductDAO.findProductByBarCode(map);
	        }else if (SaleConstant.QUERY_FLAG_PRODUCTCODE== type){
	            list = baseProductDAO.findProductByProductCode(map);
	        }
	        //数据集
	        List<Map<String, Object>> dataList = new ArrayList<>();
	        //库存map
	        Map<String, BigDecimal> stocksMap = new LinkedHashMap<>();
	        Map<String, Object> dataMap = new HashMap<>();
	        for (BaseProduct product : list) {
	            if (StringUtil.isEmpty(product.getProductCode()) || product.getTotalStorage() == null || product.getTotalStorage().doubleValue() <= 0)
	                continue;
	            Map<String, Object> paramMap = new HashMap<>();
	            List<Condition> whereList = new ArrayList<>();
	            whereList.add(Condition.create("productId", product.getProductId(), Condition.OpType.EQ));
	            whereList.add(Condition.create("productCode", product.getProductCode(), Condition.OpType.EQ));
	            whereList.add(Condition.create("IFNULL(stockCount,'')", 0, Condition.OpType.NE));
	            whereList.add(Condition.createEq("storeId", storeId));
	            paramMap.put("whereList", whereList);
	            //查询出此产品所有不为空的批次
	            List<StockBatchInventory> stockBatchInventories = stockBatchInventoryDAO.listByParam(paramMap);
	            if (stockBatchInventories == null) continue;
	            dataList = this.getSaleDatas(dataList, stocksMap, dataMap, product, stockBatchInventories);
	        }
	        return new DataGrid(dataList.size(), dataList);
	}

	@Override
	public DataGrid findStockByProperties(String keyword, QueryParams queryParams,String storeId) {
		 Map<String, Object> paramMap = new HashMap<>();
	       // LocalUser localUser = SessionUtil.getLocalUser();
	        paramMap.put("storeId", storeId);
	        String keyName = null;
	        //以零开头的数字
	        Boolean numberMatch = Pattern.matches("^0\\d{5,8}$", keyword);
	        //匹配货号
	        Boolean productCodeMatch = Pattern.matches("^(?!([a-zA-Z]+|\\d+)$)[a-zA-Z\\d]{5,8}$", keyword);
	        //匹配助记名
	        Boolean mnemonicNameMatch = Pattern.matches("^[a-zA-Z]{3,}$", keyword);
	        //中文
	        Boolean chineseMathc = Pattern.matches("^[\\u4e00-\\u9fa5]*$", keyword);

	        if (productCodeMatch) {
	            keyName = "productCode";
	        } else if (mnemonicNameMatch) {
	            keyName = "mnemonicName";
	        } else {
	            keyName = "productName";
	        }

	        if (StringUtils.isNotEmpty(keyword)) {
	            if (keyword.startsWith(StockConstant.ZERO) && !numberMatch) {
	                keyword = keyword.substring(1, keyword.length());
	                if (chineseMathc) { //中文查询中药
	                    paramMap.put("chineseDrug", keyword);
	                } else if (mnemonicNameMatch) { //助记码或条码查询中药
	                    paramMap.put("chinaMnemonicDrug", keyword);
	                } else if (productCodeMatch) { //助记码或条码查询中药
	                    paramMap.put("chinaCodeDrug", keyword);
	                } else {
	                    paramMap.put("chinaAllDrug", keyword);
	                }
	            } else {
	                paramMap.put(keyName, keyword);
	            }
	        }
	        //分页
	        if (StringUtil.isNotEmpty(queryParams.getLimit()) && StringUtil.isNotEmpty(queryParams.getOffset())) {
	            PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
	        } else {
	            PageHelper.offsetPage(0, 10);
	        }
	        //排序
	        if (StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())) {
	            PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder() + ", productCode ASC, expiryDate ASC");
	        } else {
	            PageHelper.orderBy("productCode ASC, expiryDate ASC");
	        }
	        paramMap.put("sort", "productCode");
	        paramMap.put("order", "asc");
	        List<BaseProduct> list = baseProductDAO.listProductsAndStocks(paramMap);
	        List<Map<String, Object>> dataList = this.getDataList(list);
	        PageInfo<BaseProduct> pageInfo = new PageInfo<>(list);
	        return new DataGrid(pageInfo.getTotal(), dataList);
	}
	
	  /**
     * 获取数据集
     *
     * @param list
     * @return
     */
    private List<Map<String, Object>> getDataList(List<BaseProduct> list) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, BigDecimal> stocksMap = new LinkedHashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (BaseProduct product : list) {
            	List<StockBatchInventory> stockBatchInventories = product.getStockBatchInventories();
                if (stockBatchInventories == null) continue;
                dataList = this.getSaleDatas(dataList, stocksMap, dataMap, product, stockBatchInventories);
            }
        }
        return dataList;
    }
	 private List<Map<String, Object>> getSaleDatas(List<Map<String, Object>> dataList, Map<String, BigDecimal> stocksMap, Map<String, Object> dataMap, BaseProduct product, List<StockBatchInventory> stockBatchInventories) {
	        for (StockBatchInventory stockBatchInventory : stockBatchInventories) {
	            String onlyCode = stockBatchInventory.getProductCode() + "," + stockBatchInventory.getBatchNo();
	            if (stocksMap.get(onlyCode) == null) {
	                //小于或等于0不能销售
	                //if(product.getRetailPrice().doubleValue()<=0) continue;
	                //设值到map
	                Map<String, Object> bean = BaseUtils.setDatas(stockBatchInventory, product);
	                dataList.add(bean);
	                stocksMap.put(onlyCode, stockBatchInventory.getStockCount());
	                //把
	                dataMap.put(onlyCode, bean);
	            } else {
	                BigDecimal stockCount = stocksMap.get(onlyCode).add(stockBatchInventory.getStockCount());
	                stocksMap.put(onlyCode, stockCount);
	                //如果有重复，取得重复的bean, 然后把库存相加
	                Map<String, Object> bean = (Map<String, Object>) dataMap.get(onlyCode);
	                dataList.remove(bean);
	                String unit = bean.get("unit").toString();
	                if (StockConstant.SPLIT_UNIT_G.equalsIgnoreCase(unit)) {
	                    stockCount = stockCount.multiply(new BigDecimal(1000));
	                }
	                bean.put("stockCount", stockCount);
	                dataList.add(bean);
	            }
	        }
	        return dataList;
	    }

	@Override
	public String findUserByUserCode(String memberNo, String storeId) {
	/*	Map<String, Object> map = new HashMap<>();
		map.put("memberNo" , memberNo);
		map.put("storeId" , SessionUtil.getLocalUser().getStoreId());
		//List<BaseMember> baseMembers = baseMemberDAO.findByParams(map);
		if (baseMembers == null || baseMembers.size() == 0) {
			throw new CustomerException("会员不存在!");
		}
		return baseMembers.get(0);
		*/
		return null;
	}

}