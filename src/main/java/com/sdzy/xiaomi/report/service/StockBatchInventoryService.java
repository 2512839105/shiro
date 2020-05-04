package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.StockBatchInventory;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface StockBatchInventoryService extends IService<StockBatchInventory> {

    /**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteModelById(Serializable id);


	/**
	 *  查询库存表
	 * @param storeId
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @param dateType
	 * @return
	 */
	 
	List<Map<String,Object>> listExpiredProduct(String js_code,String appid,String secret,String storeId,String userId,String pageIndex,String pageSize,String dateType);

	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<StockBatchInventory> selectModelsByPage(QueryParams queryParams);
	
	/**
	 * 查询库存数量
	 * @param codeOrName 
	 * @param storeId 
	 * @param storeId
	 * @param userId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	
    Page listStockCount(QueryParams queryParams,String sor, String codeOrName, String storeId);
  
    /**
     * 查效期品种，指在三个月内的，或过期的
     * @param storeId 
     */
    String listExpiriedProduct(QueryParams queryParams,String dateType,String sor, String storeId);
    
    /**
     * 缺货预警 
     * @param storeId 
     * @param storeId
     * @param userId
     * @return
     */
    
   Page listLessStock(QueryParams queryParams,String sor, String storeId);
    
    
    List<Map<String,Object >> commodityInquiryByproductName(String productName, String storeId);


	List<Map<String,String>> findInventorys(String keyword, String storeId,String sort);

 
}
