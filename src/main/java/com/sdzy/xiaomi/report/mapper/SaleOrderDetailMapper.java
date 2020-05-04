package com.sdzy.xiaomi.report.mapper;

import com.sdzy.xiaomi.report.model.SaleOrderDetail;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asdzy.common.model.Query;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface SaleOrderDetailMapper extends BaseMapper<SaleOrderDetail> {
//	按销售额  年月周日
	//实时查询
	List<Map<String, Object>> selectSaleOrderDetailByRealTime(@Param("storeId")String storeId);
	//日
	List<Map<String,Object>> selectSaleOrderDetailByDay(@Param("storeId")String storeId);
	//周
	List<Map<String,Object>> selectSaleOrderDetailByWeek(@Param("storeId")String storeId);
	//3个月
	List<Map<String,Object>> selectSaleOrderDetailByMoth(@Param("storeId")String storeId);
	//六个月
	List<Map<String,Object>> selectSaleOrderDetailBySexMoth(@Param("storeId")String storeId);
	//年
	List<Map<String,Object>> selectSaleOrderDetailByYear(@Param("storeId")String storeId);
	//日期
	 List<Map<String,Object>> seleSaleOrderDetailByDate(@Param("storeId")String storeId,@Param("dateType")String dateType);
	
//	按毛利年月周日
	//日
	List<Map<String,Object>> selectlistGrossProfitByDay(@Param("storeId")String storeId);
	//周
	List<Map<String,Object>> selectlistGrossProfitByWeek(@Param("storeId") String storeId);
	//月
	List<Map<String,Object>> selectlistGrossProfitByMoth(@Param("storeId")String storeId);
	//年
	List<Map<String,Object>> selectlistGrossProfitByYear(@Param("storeId")String storeId);
	//及时查询今天和昨天
	List<Map<String,Object>> selectlistGrossProfitByRealTime(@Param("storeId")String storeId);
	//按照日期查
	List<Map<String,Object>> selectlistByDate(@Param("storeId")String storeId,@Param("dateType")String dateType);
	
	
	//即时查询
	List<Map<String,Object>> selectJSCX();	
	//按天
	List<Map<String,Object>> listMeber(String storeId);
	//按月
	List<Map<String,Object>> listMeberByMonth();

		
	//排名 按销售额
	List<Map<String,Object>> rankings(@Param("dateType")String dateType);
	List<Map<String,Object>> rankingsByStoreId(@Param("storeId")String storeId);
		
	//员工业绩
	List<Map<String,Object>> employeePerformanceThisMonth(@Param("storeId")String storeId,@Param("seller")String seller);
	List<Map<String,Object>> employeePerformanceYesterday(@Param("storeId")String storeId,@Param("seller")String seller);
	//个人销售额
	List<Map<String,Object>> personalSalesDay(@Param("storeId")String storeId,@Param("userId")String userId);
	List<Map<String,Object>> personalSalesMonth(@Param("storeId")String storeId,@Param("userId")String userId);	
	List<Map<String, Object>> personalRankings(@Param("storeId")String storeId,@Param("userId")String userId) ;
	
	//查询所有门店信息
	List<Map<String,Object>> selectAllStare();
	
	//获取门店名
	String getStoreId(String storeId);
	
	//根据门店名称或编码查询数据	
	List<Map<String,Object>> selectStareByNameOrCode(String storeNameOrCode);
	
	//分页查询 畅销商品
	/*List<SaleOrderDetail> listBestSaleProduct(Pagination page);*/
	List<Map<String,Object>> listBestSaleProductYesterday(Map<String,Object> map,@Param("sor")String sor,@Param("storeId")String storeId);
	//七天
	List<Map<String,Object>> listBestSaleProductBySeven(Map<String,Object> mapm,@Param("sor")String sor,@Param("storeId")String storeId);
	//三十天
	List<Map<String,Object>> listBestSaleProductByThirty(Map<String,Object> map,@Param("sor")String sor,@Param("storeId")String storeId);
	
	//按商品id查详情	
	List<Map<String, Object>> selectProductdetailsById(String productId);
	
	
	
	//详细报表监控端
	List<Map<String, Object>> listDetailedMonitorByYear(@Param("storeId")String storeId,@Param("createDate")String createDate);
	List<Map<String, Object>> listDetailedMonitorByMonth(@Param("storeId")String storeId,@Param("createDate")String createDate);
	List<Map<String, Object>> listDetailedMonitorByWeek(@Param("storeId")String storeId,@Param("createDate")String createDate);
	List<Map<String, Object>> listDetailedMonitorByDay(@Param("storeId")String storeId,@Param("createDate")String createDate);
	
	List<SaleOrderDetail> listByOrderNo(Map<String, Object> paramMap);
	int insertDetail(SaleOrderDetail detail);
	
	
	
	
}
