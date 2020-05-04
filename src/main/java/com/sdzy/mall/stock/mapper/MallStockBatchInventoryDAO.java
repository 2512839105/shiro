package com.sdzy.mall.stock.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.stock.model.vo.MallStockBatchInventoryExample;



@Repository
public interface MallStockBatchInventoryDAO {

    long countByExample(MallStockBatchInventoryExample example);

    int deleteByExample(MallStockBatchInventoryExample example);

    int insertSelective(MallStockBatchInventory record);

    List<MallStockBatchInventory> selectByExample(MallStockBatchInventoryExample example);

    int updateByExampleSelective(@Param("record") MallStockBatchInventory record, @Param("example") MallStockBatchInventoryExample example);

    int updateByExample(@Param("record") MallStockBatchInventory record, @Param("example") MallStockBatchInventoryExample example);

    int updateByPrimaryKeySelective(MallStockBatchInventory record);

    int deleteByPrimaryKey(String inventoryId);

    int insert(MallStockBatchInventory record);

    MallStockBatchInventory selectByPrimaryKey(String inventoryId);
 
    List<MallStockBatchInventory> selectAll();

    int updateByPrimaryKey(MallStockBatchInventory record);

    /**
     * 根据ID修改数据
     */
    int updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    int updateByParam(Map<String, Object> paramMap);

    /**
     * 根据id删除数据
     */
    int deleteById(String modelId);

    /**
     * 根据参数，任意删除
     */
    int deleteByParam(Map<String, Object> paramMap);

    /**
     * 根据id查询
     */
    MallStockBatchInventory findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallStockBatchInventory> listByPage(Map<String, Object> paramMap);

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
     * 选择列表
     * @param paramMap
     * @return
     */
    List<MallStockBatchInventory> getList(Map<String, Object> paramMap);

    /**
     * 报表
     * @param map
     * @return
     */
    List listReportListByPage(Map<String, Object> map);
    
    List<MallStockBatchInventory> findByParam(Map<String, Object> paramMap);

    List<MallStockBatchInventory> findByKeywords(Map<String, Object> paramMap);

    List<MallStockBatchInventory> findNotMaintainProductList(Map<String, Object> paramMap);
    /**
     * 查询期初库存
     */
    String selectStorage(String productCode,Date first,Date finall);
    /**
     * 查询期初库存成本金额
     */
    BigDecimal selectStorageFee(String productCode,Date first,Date finall);
    
    List<MallStockBatchInventory> getDetachableList(Map<String, Object> paramMap);

    Integer getCountByStoreId(String storeId);

    List findStockBatchByPage(Map<String, Object> map);
}