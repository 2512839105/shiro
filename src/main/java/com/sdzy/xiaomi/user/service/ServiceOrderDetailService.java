package com.sdzy.xiaomi.user.service;

import com.sdzy.xiaomi.user.model.ServiceOrderDetail;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 服务订单明细表 服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
public interface ServiceOrderDetailService extends IService<ServiceOrderDetail> {

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
	ServiceOrderDetail insertOrUpdateModel(ServiceOrderDetail serviceOrderDetail);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<ServiceOrderDetail> selectModelsByPage(QueryParams queryParams);
}
