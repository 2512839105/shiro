package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.SaleOrderDetail;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface SaleOrderDetailService extends IService<SaleOrderDetail> {

	/**
	 * 按销售额查询
	 * @param js_code
	 * @param appid
	 * @param secret
	 * @param storeId
	 * @param userId
	 * @param dateType
	 * @return
	 */
	List<Map<String,Object>> listSaleAmount(String storeId,String userId,String dateType);

	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<SaleOrderDetail> selectModelsByPage(QueryParams queryParams);
	
	/**
	 * 按照毛利查询
	 * @param storeId
	 * @param userId
	 * @param dateType
	 * @return
	 */
	List<Map<String,Object>> listGrossProfit(String storeId,String userId,String dateType);
	
	List<Map<String,Object>> listMember( String storeId,String userId,String dateType);
	/**
	 * 药店排名
	 */
	
	 List<Map<String, Object>> ranking(String storeId,String userId,String dateType);
	 List<Map<String, Object>> rankingsByStoreId(String storeId,String dateType);
	 
	/**
	 * 员工业绩
	 */
	 List<Map<String, Object>> employeePerformance(String dateType,String storeId,String seller);
	 List<Map<String, Object>> personalSales(String storeId,String userId,String dateType);
	 List<Map<String, Object>> personalRankings(String storeId,String userId);
	 
	 String getStoreName(String storeId);
	 
	 /**
	  * 查询所有门店
	  */
	List<Map<String,Object>> selectAllStare();
	
	
	/**
	 * 按照id 查询 门店
	 */
	List<Map<String,Object>> selectStareByNameOrCode(String storeNameOrCode);
	
	/**
	 * 查询畅销产品
	 */
	Page listBestSaleProduct(QueryParams queryParams,String dateType,String sor,String storeId);
	
	/**
	 * 根据商品id查询详情
	 * @param productId
	 * @param storeId
	 */
	List<Map<String, Object>> selectProductdetailsById(String productId, String storeId);
	
	/**
	 * 详细报表监控段
	 */
	
	List<Map<String, Object>> listDetailedMonitor(String storeId,String userId,String dateType,String createDate);

	

	
 }
