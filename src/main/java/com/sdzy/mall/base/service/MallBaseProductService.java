package com.sdzy.mall.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.mall.base.model.MallBaseProduct;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
public interface MallBaseProductService extends IService<MallBaseProduct> {

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
	MallBaseProduct insertOrUpdateModel(MallBaseProduct baseProduct);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<MallBaseProduct> selectModelsByPage(QueryParams queryParams);
	
	/**
     * 根据门店展示的商品类别获取商品列表分页
     * @param map
     * @return
     */
    Page selectProductByCategory(Integer offset, Integer current, Integer limit, Map<String, Object> map);
    



    Page selectProductAndStore(Integer offset, Integer current, Integer limit, boolean isAsc, String orderType,
            Map<String, Object> map);


    Map<String, Object> selectProductById(Map<String, Object> map);


}
