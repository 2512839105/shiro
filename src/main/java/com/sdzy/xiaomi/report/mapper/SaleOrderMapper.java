package com.sdzy.xiaomi.report.mapper;

import com.sdzy.xiaomi.report.model.SaleOrder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface SaleOrderMapper extends BaseMapper<SaleOrder> {

//	按客流量 日周月年
	//实时查询
	List<Map<String,Object>> listFlowNumByRealTime(@Param("storeId")String storeId);
	//日
	List<Map<String,Object>> listFlowNumByDay(@Param("storeId")String storeId);
	//周
	List<Map<String,Object>> listFlowNumByWeek(@Param("storeId")String storeId);	
	//月
	List<Map<String,Object>> listFlowNumByMoth(@Param("storeId")String storeId);	
	//年
	List<Map<String,Object>> listFlowNumByYear(@Param("storeId")String storeId);	
	//日期
	List<Map<String,Object>> listFlowNumByDate(@Param("storeId")String storeId,@Param("dateType")String dateType);
	
	
	
	//销售报表按年月日
	//按年
	List<Map<String,Object>> listReportByYear(String storeId);
	//按月
	List<Map<String,Object>> listReportByMoth(String storeId);
	//按周
	List<Map<String,Object>> listReportByWeek(String storeId);
	List<Map<String,Object>> listReportByDay(String storeId);
	
	
	//统计客单 日周年
	 
	//日
	List<Map<String,Object>> listSaleOrderByDay(String storeId);
	//周
	List<Map<String,Object>> listSaleOrderByWeek(String storeId);	
	//月
	List<Map<String,Object>> listSaleOrderByMoth(String storeId);	
	//年
	List<Map<String,Object>> listSaleOrderByYear(String storeId);	
	

	//药店排名
	List<SaleOrder> selectModelsByPage(Pagination page,Map<String, Object> map);
	
	List<SaleOrder> listByOrderNo(Map<String, Object> paramMap);
	
	SaleOrder findById(String modelId);
	
	Integer updateByPrimaryKeySelective(SaleOrder so);
	int insertSaleOrder(SaleOrder saleOrder);
	

	

	
	
	
	
	
	
}
