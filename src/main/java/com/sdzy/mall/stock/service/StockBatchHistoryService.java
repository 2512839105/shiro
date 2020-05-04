package com.sdzy.mall.stock.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.stock.model.StockBatchHistory;

public interface StockBatchHistoryService {
    /**
     * 新增
     */
    StockBatchHistory insert(StockBatchHistory model);

    /**
     * 新增
     */
    StockBatchHistory insert(StockBatchHistory model, LocalUser currentUser);

    /**
     * 按ID号查询
     */
    StockBatchHistory findById(String modelId);

    /**
     * 根据参数分页查询
     */
    DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String... params);

    /**
     * 根据参数查询所有数据
     */
    List<StockBatchHistory> listByParam(Map<String, Object> paramMap);

    /**
     * 根据参数查询一条数据
     */
    StockBatchHistory findByParam(Map<String, Object> paramMap);

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
     * 根据ids审核数据
     */
    Integer audit(String[] modelIds);

    /**
     * 更新删除状态
     */
    Integer updateDeleteStatus(String modelId, int deleteFlag);

    /**
     * 更新
     */
    StockBatchHistory update(StockBatchHistory model, LocalUser currentUser);

    /**
     * 根据ID修改数据
     */
    Integer updateById(Map<String, Object> paramMap);

    /**
     * 根据primaryKey修改数据
     */
    Integer updateByPrimaryKeySelective(StockBatchHistory model, LocalUser user);

    /**
     * 根据参数，任意更新
     */
    Integer updateByParam(Map<String, Object> paramMap);
}