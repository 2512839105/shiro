package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.Sysoperatelog;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-06-07
 */
public interface SysoperatelogService extends IService<Sysoperatelog> {

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
	Sysoperatelog insertOrUpdateModel(Sysoperatelog sysoperatelog);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<Sysoperatelog> selectModelsByPage(QueryParams queryParams);
}
