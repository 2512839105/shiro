package com.sdzy.mall.sale.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.sale.model.MallSaleOrderDetail;
import com.sdzy.mall.sale.model.sample.MallSaleOrderDetailExample;



@Repository
public interface MallSaleOrderDetailDAO {
    long countByExample(MallSaleOrderDetailExample example);

    int deleteByExample(MallSaleOrderDetailExample example);

    int deleteByPrimaryKey(String saleOrderDetailId);

    int insert(MallSaleOrderDetail record);

    int insertSelective(MallSaleOrderDetail record);

    List<MallSaleOrderDetail> selectByExample(MallSaleOrderDetailExample example);

    MallSaleOrderDetail selectByPrimaryKey(String saleOrderDetailId);

    int updateByExampleSelective(@Param("record") MallSaleOrderDetail record, @Param("example") MallSaleOrderDetailExample example);

    int updateByExample(@Param("record") MallSaleOrderDetail record, @Param("example") MallSaleOrderDetailExample example);

    int updateByPrimaryKeySelective(MallSaleOrderDetail record);

    int updateByPrimaryKey(MallSaleOrderDetail record);

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
    MallSaleOrderDetail findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    MallSaleOrderDetail findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<MallSaleOrderDetail> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<MallSaleOrderDetail> listByParam(Map<String, Object> paramMap);



    /**
     * 报表
     * @param map
     * @return
     */
    List listReportListByPage(Map<String, Object> map);

	List<MallSaleOrderDetail> listByLastestDate(Map<String, Object> map);

	Date getMaxDate(String storeId);

    List<MallSaleOrderDetail> findSaleDetaisByBarCode(Map<String, Object> paramMap);
    /**
     * 查询总销售
     * 
     */
    String selectCount(String productCode,Date first,Date finall);
    /**
     *查询总成本金额
     */
    BigDecimal selectFeeCount(String productCode,Date first,Date finall);
    /**
     * 本期出库零售金额
     */
    BigDecimal selectMember(String productCode,Date first,Date finall);

    /**
     * 查询处方单审核后的销售记录
     * @param map
     * @return
     */
    List<MallSaleOrderDetail> listIsRxDrugReportListByPage(Map<String, Object> map);
    
    /**
     * 销售接口上传引入
     * @param map
     * @return
     */
    List<MallSaleOrderDetail> listInterfaceData(Map<String, Object> map);

    List<MallSaleOrderDetail> listSplitReportListByPage(Map<String, Object> map);
}