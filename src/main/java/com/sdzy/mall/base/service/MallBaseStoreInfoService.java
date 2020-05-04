package com.sdzy.mall.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.mall.base.model.MallBaseStoreInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-11
 */
public interface MallBaseStoreInfoService extends IService<MallBaseStoreInfo> {

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
	MallBaseStoreInfo insertOrUpdateModel(MallBaseStoreInfo baseStoreInfo);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<MallBaseStoreInfo> selectModelsByPage(QueryParams queryParams);
	
	
	Page<MallBaseStoreInfo> selectStoreOrderSale(Integer offset, Integer current, Integer limit);
	
	 Page selectProductAndStore(Integer offset, Integer current, Integer limit, String orderType,
	            Map<String, Object> map);
}
