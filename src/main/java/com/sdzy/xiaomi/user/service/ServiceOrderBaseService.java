package com.sdzy.xiaomi.user.service;

import com.sdzy.xiaomi.user.model.ServiceOrderBase;
 
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
 
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 服务订单主表 服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
public interface ServiceOrderBaseService extends IService<ServiceOrderBase> {

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
	String insertOrder(Map<String,Object> data);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<ServiceOrderBase> selectModelsByPage(QueryParams queryParams);


	String updateOrder(Map<String, Object> data);


	List<Map<String,String>> selectBaseBybuyerId(String buyerId);


	List<Map<String,String>> selectDetail(String orderNo);
}
