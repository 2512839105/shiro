package com.sdzy.mall.promotion.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;

public interface PromotionGiveProductService {
    /**
     * 新增
     */
    PromotionGiveProduct insert(PromotionGiveProduct model);

    /**
     * 新增
     */
    PromotionGiveProduct insert(PromotionGiveProduct model, LocalUser currentUser);

    
    /**
     * 按ID号查询
     */
    PromotionGiveProduct findById(String modelId);

    /**
     * 根据参数分页查询
     */
    DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String... params);

    /**
     * 根据参数查询所有数据
     */
    List<PromotionGiveProduct> listByParam(Map<String, Object> paramMap);

    /**
     * 根据参数查询一条数据
     */
    PromotionGiveProduct findByParam(Map<String, Object> paramMap);

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
    PromotionGiveProduct update(PromotionGiveProduct model, LocalUser currentUser);

    /**
     * 根据ID修改数据
     */
    Integer updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    Integer updateByParam(Map<String, Object> paramMap);
}