package com.sdzy.xiaomi.serviceProduct.service;

import com.sdzy.xiaomi.serviceProduct.model.ServiceProductStat;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户服务产品汇总 服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-30
 */
public interface ServiceProductStatService extends IService<ServiceProductStat> {

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
	ServiceProductStat insertOrUpdateModel(ServiceProductStat serviceProductStat);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<ServiceProductStat> selectModelsByPage(QueryParams queryParams);


	Map<String,String> selectBybuyerId(String buyerId);
}
