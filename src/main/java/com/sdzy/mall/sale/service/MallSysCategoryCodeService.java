package com.sdzy.mall.sale.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.mall.sale.model.MallSysCategoryCode;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
public interface MallSysCategoryCodeService extends IService<MallSysCategoryCode> {

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
	MallSysCategoryCode insertOrUpdateModel(MallSysCategoryCode sysCategoryCode);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<MallSysCategoryCode> selectModelsByPage(QueryParams queryParams);
	
	/**
     *  获取门店线上销售商品类别
     * @param queryParams
     * @return
     */
	List<Map<String,Object>> selectOnlineSaleDrug(Map<String, Object> map);

}
