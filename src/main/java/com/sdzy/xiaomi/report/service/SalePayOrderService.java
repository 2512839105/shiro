package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.SalePayOrder;
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
public interface SalePayOrderService extends IService<SalePayOrder> {

    /**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteModelById(Serializable id);


	/**
	 * 新增或者更新实体，存在主键为更新，反正新增
	 * @param api
	 * @return
	 */
	SalePayOrder insertOrUpdateModel(SalePayOrder salePayOrder);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<SalePayOrder> selectModelsByPage(QueryParams queryParams);
	
	
	List<Map<String,Object>> listGrossProfit(String storeId,String userId,String dateType); 
}
