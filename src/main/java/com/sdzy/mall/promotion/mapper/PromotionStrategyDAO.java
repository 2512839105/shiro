package com.sdzy.mall.promotion.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.promotion.model.PromotionStrategy;


@Mapper
public interface PromotionStrategyDAO {
    
    int deleteByPrimaryKey(String promotionStrategyId);

    int insert(PromotionStrategy record);

    PromotionStrategy selectByPrimaryKey(String promotionStrategyId);

    List<PromotionStrategy> selectAll();

    int updateByPrimaryKey(PromotionStrategy record);

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
    PromotionStrategy findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    PromotionStrategy findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<PromotionStrategy> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<PromotionStrategy> listByParam(Map<String, Object> paramMap);

    List listPromotionByParam(Map<String, Object> map);
}