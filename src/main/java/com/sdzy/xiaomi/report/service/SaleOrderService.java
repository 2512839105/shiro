package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.SaleOrder;
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
public interface SaleOrderService extends IService<SaleOrder> {

	/**
	 * 按客流量查询
	 * @param storeId
	 * @param userId
	 * @param dateType
	 * @return
	 */
	List<Map<String,Object>> listFlowNum(String storeId,String userId,String dateType);
		
 	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<SaleOrder> selectModelsByPage(QueryParams queryParams);
	
 
   /**
    * 按照年月日
    * @param storeId
    * @param userId
    * @param dateType
    * @return
    */
    List<Map<String,Object>> listReport(String js_code,String appid,String secrect,String storeId,String userId,String dateType);
    
    List<Map<String,Object>> saleOrderNo(String storeId,String dateType);


	SaleOrder saveSaleOrderAndDetails(SaleOrder saleOrder, String user);


	SaleOrder submitSaleOrders(SaleOrder saleOrder, String user);


	SaleOrder savePayOrders(SaleOrder saleOrder, Integer saveOrder,String storeCode,String storeId);


	SaleOrder findById(String modelId);

    
}
