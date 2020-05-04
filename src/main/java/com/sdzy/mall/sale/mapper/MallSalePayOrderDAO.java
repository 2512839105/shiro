package com.sdzy.mall.sale.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.sale.model.MallSalePayOrder;
import com.sdzy.mall.sale.model.sample.MallSalePayOrderExample;



@Repository
public interface MallSalePayOrderDAO {
    long countByExample(MallSalePayOrderExample example);

    int deleteByExample(MallSalePayOrderExample example);

    int deleteByPrimaryKey(String payOrderId);

    int insert(MallSalePayOrder record);

    int insertSelective(MallSalePayOrder record);

    List<MallSalePayOrder> selectByExample(MallSalePayOrderExample example);

    MallSalePayOrder selectByPrimaryKey(String payOrderId);

    int updateByExampleSelective(@Param("record") MallSalePayOrder record, @Param("example") MallSalePayOrderExample example);

    int updateByExample(@Param("record") MallSalePayOrder record, @Param("example") MallSalePayOrderExample example);

    int updateByPrimaryKeySelective(MallSalePayOrder record);

    int updateByPrimaryKey(MallSalePayOrder record);

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
    MallSalePayOrder findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    MallSalePayOrder findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<MallSalePayOrder> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<MallSalePayOrder> listByParam(Map<String, Object> paramMap);

    /**
     * 查询支付订单
     * @param saleOrderNo
     * @return
     */
    MallSalePayOrder findSalePayOrder(@Param("saleOrderNo") String saleOrderNo);
}