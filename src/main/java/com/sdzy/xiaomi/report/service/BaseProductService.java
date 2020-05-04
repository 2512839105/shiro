package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.BaseProduct;
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
public interface BaseProductService extends IService<BaseProduct> {

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
	BaseProduct insertOrUpdateModel(BaseProduct baseProduct);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @param secrect 
	 * @param appid 
	 * @param js_code 
	 * @param callback 
	 * @param storeId 
	 * @param secrect2 
	 * @return
	 */
	Page<BaseProduct> selectModelsByPage(QueryParams queryParams, String keyword,String price,String storeId, String js_code, String appid, String secrect);
	
	
	
	
	/**
	 * 查近期新品
	 * @param storeId
	 * @param userId
	 * @param beginDate
	 * @param endDate
	 */
    List<Map<String,Object>> listNewProduct( String storeId,String userId,String beginDate,String endDate);


	String updateProduct(String data,String js_code, String appid, String secrect);


	 List<Map<String,String>> selectProductByCodeOrName(String storeId, String keyword, String js_code, String appid, String secrect);
}
