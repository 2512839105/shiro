package com.sdzy.mall.promotion.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.promotion.model.PromotionProduct;

public interface PromotionProductService {
    /**
     * 新增
     */
    PromotionProduct insert(PromotionProduct model);

    /**
     * 新增
     */
    PromotionProduct insert(PromotionProduct model, LocalUser currentUser);

    
    /**
     * 按ID号查询
     */
    PromotionProduct findById(String modelId);

    /**
     * 根据参数分页查询
     */
    DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String... params);

    /**
     * 根据参数查询所有数据
     */
    List<PromotionProduct> listByParam(Map<String, Object> paramMap);

    /**
     * 根据参数查询一条数据
     */
    PromotionProduct findByParam(Map<String, Object> paramMap);

    /**
     * 根据id删除数据
     */
    Integer deleteById(String modelId);

    /**
     * 根据参数，任意删除
     */
    Integer deleteByParam(Map<String, Object> paramMap);

    /**
     * 根据ids删除数据
     */
    Integer deleteByIds(String modelIds);

    /**
     * 更新删除状态
     */
    Integer updateDeleteStatus(String modelId, int deleteFlag);

    /**
     * 更新
     */
    PromotionProduct update(PromotionProduct model, LocalUser currentUser);

    /**
     * 根据ID修改数据
     */
    Integer updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    Integer updateByParam(Map<String, Object> paramMap);
    
    /**
     * 查询促销和另赠品
     */
    List<PromotionProduct> getPromotionProductsAndGiveProducts(String modelId, String storeId);

    /**
     * 查询所有促销产品信息
     * @return
     */
    List listPromotionProduct();
}