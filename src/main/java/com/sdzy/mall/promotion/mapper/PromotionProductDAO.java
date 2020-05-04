package com.sdzy.mall.promotion.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.promotion.model.PromotionProduct;


@Mapper
public interface PromotionProductDAO {
    
    int deleteByPrimaryKey(String promotionProductId);

    int insert(PromotionProduct record);

    PromotionProduct selectByPrimaryKey(String promotionProductId);

    List<PromotionProduct> selectAll();

    int updateByPrimaryKey(PromotionProduct record);

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
    PromotionProduct findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    PromotionProduct findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<PromotionProduct> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<PromotionProduct> listByParam(Map<String, Object> paramMap);

    /**
     * 根据促销策略查询
     * @param modelId
     * @param storeId
     * @return
     */
    List<PromotionProduct> getPromotionProductsAndGiveProducts(@Param("modelId") String modelId, @Param("storeId") String storeId);

    /**
     * 查询所有的促销产品
     * @param paramMap
     * @return
     */
    List<PromotionProduct> listPromotionProductsAndGiveProducts(Map<String, Object> paramMap);
}