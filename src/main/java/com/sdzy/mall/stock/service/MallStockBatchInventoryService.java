package com.sdzy.mall.stock.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.stock.model.MallStockBatchInventory;

public interface MallStockBatchInventoryService {
    /**
     * 新增
     */
    MallStockBatchInventory insert(MallStockBatchInventory model);

    /** 
     * 按ID号查询
     */
    MallStockBatchInventory findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallStockBatchInventory> listByPage(Map<String, Object> paramMap);

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

    /**
     * 根据参数查询
     */
    List<MallStockBatchInventory> listByParam(Map<String, Object> paramMap);

    /**
     * 引入分页查询
     */
    List<MallStockBatchInventory> introduceByPage(Map<String, Object> paramMap);

    /**
     * 引入列表
     */
    List<MallStockBatchInventory> introduceByParam(Map<String, Object> paramMap);

    /**
     * 根据Id更新数量
     * @param inventoryId
     * @return
     */
    Integer updateStockCountById(String inventoryId, BigDecimal count, String storeId);
    
    /**
     * 选择列表
     */
    List<MallStockBatchInventory> getList(Map<String, Object> paramMap);

    /**
     * 报表
     * @param map
     * @return
     */
    List listReportListByPage(Map<String, Object> map);
    
    /**
     * 获取未养护的库存商品
     * @return
     */
    DataGrid findNotMaintainProductList(QueryParams queryParams, Map<String, Object> paramMap);

    DataGrid listByPage(QueryParams queryParams, LocalUser currentUser);
    
    List<MallStockBatchInventory> findByParam(Map<String, Object> map);
    /**
     * 查询期初库存
     */
    String selectStorage(String productCode,Date first,Date finall);
    /**
     * 查询期初库存成本金额
     */
    BigDecimal selectStorageFee(String productCode,Date first,Date finall);
    
    DataGrid getDetachableList(QueryParams queryParams, LocalUser currentUser, String keyword);

    Integer getCountByStoreId(String storeId);

    DataGrid findStockBatchByPage(QueryParams queryParams, LocalUser currentUser);
}