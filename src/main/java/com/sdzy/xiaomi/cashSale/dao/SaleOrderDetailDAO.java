package com.sdzy.xiaomi.cashSale.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asdzy.purpleredgourd.sale.model.sample.SaleOrderDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.asdzy.purpleredgourd.sale.model.SaleOrderDetail;

@Repository
public interface SaleOrderDetailDAO {
    long countByExample(SaleOrderDetailExample example);

    int deleteByExample(SaleOrderDetailExample example);

    int deleteByPrimaryKey(String saleOrderDetailId);

    int insert(SaleOrderDetail record);

    int insertSelective(SaleOrderDetail record);

    List<SaleOrderDetail> selectByExample(SaleOrderDetailExample example);

    SaleOrderDetail selectByPrimaryKey(String saleOrderDetailId);

    int updateByExampleSelective(@Param("record") SaleOrderDetail record, @Param("example") SaleOrderDetailExample example);

    int updateByExample(@Param("record") SaleOrderDetail record, @Param("example") SaleOrderDetailExample example);

    int updateByPrimaryKeySelective(SaleOrderDetail record);

    int updateByPrimaryKey(SaleOrderDetail record);

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
    SaleOrderDetail findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    SaleOrderDetail findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<SaleOrderDetail> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<SaleOrderDetail> listByParam(Map<String, Object> paramMap);



    /**
     * 报表
     * @param map
     * @return
     */
    List listReportListByPage(Map<String, Object> map);

	List<SaleOrderDetail> listByLastestDate(Map<String, Object> map);

	Date getMaxDate(String storeId);

    List<SaleOrderDetail> findSaleDetaisByBarCode(Map<String, Object> paramMap);
    /**
     * 查询总销售
     * 
     */
    String selectCount(String productCode,Date first,Date finall, String storeId);
    /**
     *查询总成本金额
     */
    BigDecimal selectFeeCount(String productCode, Date first, Date finall, String storeId);
    /**
     * 本期出库零售金额
     */
    BigDecimal selectMember(String productCode, Date first, Date finall, String storeId);

    /**
     * 查询处方单审核后的销售记录
     * @param map
     * @return
     */
    List<SaleOrderDetail> listIsRxDrugReportListByPage(Map<String, Object> map);
    
    /**
     * 销售接口上传引入
     * @param map
     * @return
     */
    List<SaleOrderDetail> listInterfaceData(Map<String, Object> map);

    List<SaleOrderDetail> listSplitReportListByPage(Map<String, Object> map);

    List<Map<String, Object>> selectSaleUploadData(String lastUploadDate);

    List<SaleOrderDetail> listByOrderNo(Map<String, Object> paramMap);
}