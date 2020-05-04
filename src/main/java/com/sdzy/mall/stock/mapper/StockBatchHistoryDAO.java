package com.sdzy.mall.stock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.stock.model.StockBatchHistory;
import com.sdzy.mall.stock.model.vo.StockBatchHistoryExample;



@Repository
public interface StockBatchHistoryDAO {
    long countByExample(StockBatchHistoryExample example);

    int deleteByExample(StockBatchHistoryExample example);

    int deleteByPrimaryKey(String historyId);

    int insert(StockBatchHistory record);

    int insertSelective(StockBatchHistory record);

    List<StockBatchHistory> selectByExample(StockBatchHistoryExample example);

    StockBatchHistory selectByPrimaryKey(String historyId);

    int updateByExampleSelective(@Param("record") StockBatchHistory record, @Param("example") StockBatchHistoryExample example);

    int updateByExample(@Param("record") StockBatchHistory record, @Param("example") StockBatchHistoryExample example);

    int updateByPrimaryKeySelective(StockBatchHistory record);

    int updateByPrimaryKey(StockBatchHistory record);

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
    StockBatchHistory findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    StockBatchHistory findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<StockBatchHistory> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<StockBatchHistory> listByParam(Map<String, Object> paramMap);
}