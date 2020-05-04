package com.sdzy.mall.sale.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.sdzy.mall.sale.model.MallSalePayOrder;

public interface MallSalePayOrderService {
    /**
     * 新增
     */
    MallSalePayOrder insert(MallSalePayOrder model);

    /**
     * 按ID号查询
     */
    MallSalePayOrder findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallSalePayOrder> listByPage(Map<String, Object> paramMap);

    /**
     * 根据id删除数据
     */
    Integer deleteById(String modelId);

    /**
     * 根据参数，任意删除
     */
    Integer deleteByParam(Map<String, Object> paramMap);

    /**
     * 根据ID修改数据
     */
    Integer updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    Integer updateByParam(Map<String, Object> paramMap);

    DataGrid listByPage(QueryParams queryParams);
}