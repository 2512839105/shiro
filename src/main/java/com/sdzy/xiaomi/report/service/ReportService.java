package com.sdzy.xiaomi.report.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;

public interface ReportService {
	
	/**
	 * 销售报表
	 */
	String listReport(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType);   	
    /**
     * 店长速报
     */
	String  shopChief(String callback ,String js_code,String appid,String secrect,String storeId,String userId,String dateType);
	/**
	 * 详细报表
	 */
	String listDetailed(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType);
	/**
	 * 监控端
	 */
	String listDetailedMonitor(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType,String createDate);
	
	/**
	 * 商品速查
	 * @param secrect 
	 * @param appid 
	 * @param js_code 
	 * @param storeId 
	 */
	String listBestSaleProduct(QueryParams queryParams ,String dateType,String sor, String js_code, String appid, String secrect, String storeId);
	String listStockCount(QueryParams queryParams,String sor, String codeOrName, String js_code, String appid, String secrect, String storeId);
	String listExpiriedProduct(QueryParams queryParams ,String dateType ,String sor, String js_code, String appid, String secrect, String storeId);
	String listLessStock(QueryParams queryParams,String sor, String js_code, String appid, String secrect, String storeId);
	
	/**
	 * 通过商品ID查询
	 * @param secrect 
	 * @param appid 
	 * @param js_code 
	 */
	String selectProductdetailsById(String productId,String storeId, String js_code, String appid, String secrect);
	
	
 	String commodityInquiryByproductName(String productName, String js_code, String appid, String secrect, String storeId);
	
	
	
	/**
	 * 员工业绩
	 */
	String employeePerformance(String callback,String js_code,String appid,String secrect,String storeId,String seller,String dateType);
	String personalSales(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType);
	String personalRankings(String callback,String js_code,String appid,String secrect,String storeId,String userId);
    		
	
	
	
	/**
	 * 排名
	 */
	String ranking(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType);
	String rankingsByStoreId(String callback,String storeId,String dateType, String js_code, String appid, String secrect);
	
	/**
	 * 根据药店名称查询数据
	 */
	/*String selectByStoreName(String storeName);*/
	/**
	 * 查询所有门店
	 * @param secrect 
	 * @param appid 
	 * @param js_code 
	 * @return
	 */
	String selectAllStare(String callback, String js_code, String appid, String secrect);
	
	/**
	 * 根据门店Id 查询门店信息
	 * @param secrect 
	 * @param appid 
	 * @param js_code 
	 */
	String selectStareByNameOrCode(String storeNameOrCode, String js_code, String appid, String secrect);
	
}
