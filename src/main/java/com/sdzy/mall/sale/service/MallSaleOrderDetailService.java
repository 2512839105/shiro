package com.sdzy.mall.sale.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.sale.model.MallSaleOrderDetail;

public interface MallSaleOrderDetailService {
    /**
     * 新增
     */
    MallSaleOrderDetail insert(MallSaleOrderDetail model);

    /**
     * 按ID号查询
     */
    MallSaleOrderDetail findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallSaleOrderDetail> listByPage(Map<String, Object> paramMap);

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

    List listByParam(Map<String, Object> map);

    /**
     * 销售订单报表
     * @param map
     * @return
     */
    List listReportListByPage(Map<String, Object> map);

    /**
     * 查询销售订单明细报表
     * @param queryParams
     * @param currentUser
     * @param params
     * @return
     */
    DataGrid listReportListByPage(QueryParams queryParams, LocalUser currentUser, String...params);

	List<MallSaleOrderDetail> listByLastestDate(Map<String, Object> map);

	Date getMaxDate(String storeId);

    DataGrid findSaleDetaisByBarCode(QueryParams queryParams, String keyword, LocalUser currentUser);

    DataGrid findStockByKeyword(QueryParams queryParams, String keyword);

    DataGrid findStockByBarCode(String barCode);

    DataGrid findStockByProperties(String keyword, QueryParams queryParams);

    DataGrid listAllStock(QueryParams queryParams);
    
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
}