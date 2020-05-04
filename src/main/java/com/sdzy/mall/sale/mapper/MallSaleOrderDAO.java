package com.sdzy.mall.sale.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.sale.model.MallSaleOrder;
import com.sdzy.mall.sale.model.sample.MallSaleOrderExample;



@Repository
public interface MallSaleOrderDAO {

    long countByExample(MallSaleOrderExample example);

    int deleteByExample(MallSaleOrderExample example);

    int deleteByPrimaryKey(String saleOrderId);

    int insert(MallSaleOrder record);

    int insertSelective(MallSaleOrder record);

    List<MallSaleOrder> selectByExample(MallSaleOrderExample example);

    MallSaleOrder selectByPrimaryKey(String saleOrderId);

    int updateByExampleSelective(@Param("record") MallSaleOrder record, @Param("example") MallSaleOrderExample example);

    int updateByExample(@Param("record") MallSaleOrder record, @Param("example") MallSaleOrderExample example);

    int updateByPrimaryKeySelective(MallSaleOrder record);

    int updateByPrimaryKey(MallSaleOrder record);

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
    MallSaleOrder findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallSaleOrder> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询
     */
    List<MallSaleOrder> listByParam(Map<String, Object> paramMap);
    
	List<MallSaleOrder> listByLastestDate(Map<String, Object> map);

    /**
     * 查询提单
     * @return
     */
    List findSaleOrderByPending();
}