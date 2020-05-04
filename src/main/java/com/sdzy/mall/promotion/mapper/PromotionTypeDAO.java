package com.sdzy.mall.promotion.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sdzy.mall.promotion.model.PromotionType;

@Mapper
public interface PromotionTypeDAO {
    
    int deleteByPrimaryKey(Integer promotionTypeID);

    int insert(PromotionType record);

    PromotionType selectByPrimaryKey(Integer promotionTypeID);

    List<PromotionType> selectAll();

    int updateByPrimaryKey(PromotionType record);

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
    PromotionType findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    PromotionType findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<PromotionType> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<PromotionType> listByParam(Map<String, Object> paramMap);
}