package com.sdzy.xiaomi.report.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.report.model.SaleOrderDetail;
import com.sdzy.xiaomi.report.mapper.SaleOrderDetailMapper;
import com.sdzy.xiaomi.report.service.SaleOrderDetailService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@Service
public class SaleOrderDetailServiceImpl extends BaseServiceImpl<SaleOrderDetailMapper, SaleOrderDetail> implements SaleOrderDetailService {

	
	
	@Override
	public  Page<SaleOrderDetail>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<SaleOrderDetail> page = new Page<SaleOrderDetail>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Wrapper<SaleOrderDetail> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		
/*		page.setRecords(baseMapper.listBestSaleProduct(page));*/
		return this.selectPage(page, wrapper);
	}

	/**
	 * 通过dateType 的值判断调用的SQL
	 * r--即使查询 两天内
	 * y--三年内
	 * m--三月内
	 * w--三周内
	 * d--7天内	
	 */
	@Override
	public List<Map<String,Object>> listSaleAmount( String storeId,
		String userId, String dateType){
		if(dateType==null){
			dateType="r";
		}			
			if(dateType.equals("y")){				
			 	  return baseMapper.selectSaleOrderDetailByYear(storeId);
			}else if(dateType.equals("m")){				
				return baseMapper.selectSaleOrderDetailByMoth(storeId);
			}else if(dateType.equals("w")){				
				return baseMapper.selectSaleOrderDetailByWeek(storeId);
			}else if(dateType.equals("d")){				
				return baseMapper.selectSaleOrderDetailByDay(storeId);
			}else if(dateType.equals("r")){				
				List<Map<String, Object>> day = baseMapper.selectSaleOrderDetailByDay(storeId);
				List<Map<String, Object>> month = baseMapper.selectSaleOrderDetailBySexMoth(storeId);						
				List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();				             				
				list.addAll(day);
				list.addAll(month);									
				return list;				 
			}else{
				
				return baseMapper.seleSaleOrderDetailByDate(storeId,dateType);
			}
		 
		 
		
		
		/*Map<String, String> map=new HashMap<String, String>();
		map.put("storeId", storeId);*/
		
		

/*		return  baseMapper.selectSaleOrderDetail(appid,secret,storeId,userId,dateType);
*/	}

	/**
	 * 通过dateType 的值判断调用的SQL
	 * r--即使查询 两天内
	 * y--三年内
	 * m--三月内
	 * w--三周内
	 * d--7天内	
	 */
	@Override
	public List<Map<String, Object>> listGrossProfit(String storeId, String userId, String dateType) {
		
		if(dateType==null){
			dateType="r";
		}
		if(dateType.equals("y")){
		 	  return baseMapper.selectlistGrossProfitByYear(storeId);  
		}else if(dateType.equals("m")){
			
			return baseMapper.selectlistGrossProfitByMoth(storeId);
		}else if(dateType.equals("w")){
			
			return baseMapper.selectlistGrossProfitByWeek(storeId);
		}else if(dateType.equals("d")){
			
			return baseMapper.selectlistGrossProfitByDay(storeId);
		}else if(dateType.equals("r")){
		    return  baseMapper.selectlistGrossProfitByRealTime(storeId);  
		}else{
			
			return baseMapper.selectlistByDate(storeId, dateType);  
		}
			 	
	}

	/**
	 * 统计会员销量
	 */
	@Override
	public List<Map<String, Object>> listMember(String storeId, String userId, String dateType) {
		 List<Map<String, Object>> a = baseMapper.listMeber(storeId);		 						 	 													
		 return a;
	}
	@Override
	public List<Map<String, Object>> ranking(String storeId, String userId, String dateType) {
		 
		return baseMapper.rankings(dateType);
	}


	@Override
	public List<Map<String, Object>> rankingsByStoreId(String storeId, String dateType) {
		 
		return baseMapper.rankingsByStoreId(storeId);
	}

	@Override
	public List<Map<String, Object>> employeePerformance(String dateType,String storeId,String seller) {
				if(dateType==null){
					dateType="d";
				}			  
		       if (dateType.equals("m")) {
					List<Map<String, Object>> data = baseMapper.employeePerformanceThisMonth(storeId,seller);	
					for(Map da:data){
						BigDecimal sell =  (BigDecimal) da.get("sellAmount");				 
						//long flow = (long) da.get("flow");
						BigDecimal flow =  (BigDecimal) da.get("flow");	
						//BigDecimal flows=new BigDecimal(flow);
						 BigDecimal utitPrice =  sell.divide(flow, 2, RoundingMode.HALF_UP);	
						da.put("utitPrice",utitPrice);
					}
					return data;
		       } 
				if(dateType.equals("d")){					
					List<Map<String, Object>> data = baseMapper.employeePerformanceYesterday(storeId,seller);		
					for(Map da:data){
						BigDecimal sell =  (BigDecimal) da.get("sellAmount");				 
						 long flow = (long) da.get("flow");
 						 BigDecimal flows=new BigDecimal(flow);
						 BigDecimal utitPrice =  sell.divide(flows, 2, RoundingMode.HALF_UP);	
						da.put("utitPrice",utitPrice);
					}
					return data;
				}
				return null;		  				  
	}

	@Override
	public String getStoreName(String storeId) {
		 
		return baseMapper.getStoreId(storeId);
	}
	@Override
	public List<Map<String, Object>> personalSales(String storeId,String userId,String dateType) {
				if(dateType==null){
					dateType="d";
				}
			if(dateType.equals("m")){
				return baseMapper.personalSalesMonth(storeId,userId);
			}else if(dateType.equals("d")){
				return baseMapper.personalSalesDay(storeId,userId);
			}
			return null;
	}
	@Override
	public List<Map<String, Object>> personalRankings(String storeId,String userId) {
		
		return baseMapper.personalRankings(storeId,userId);
		 
	}

	
	
	@Override
	public List<Map<String, Object>> selectAllStare() {
		// TODO Auto-generated method stub
		return baseMapper.selectAllStare();
	}
	
	@Override
	public List<Map<String, Object>> selectStareByNameOrCode(String storeNameOrCode) {
		 
		return baseMapper.selectStareByNameOrCode(storeNameOrCode);
	}
	
		
	/**
	 * 通过dateType的值判调用的SQL 
	 * y---昨天的
	 * s--查询7天内的
	 * t--查询30天内的
	 */
	@Override
	public Page listBestSaleProduct(QueryParams queryParams,String dateType,String sor,String storeId) {
	  
		Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Condition> whereList = queryParams.filtersToDBConditionals();	
		map.put("whereList", whereList);
			       
		if(dateType.equals("y")){
			return page.setRecords(baseMapper.listBestSaleProductYesterday(map,sor,storeId));						  
		}else if(dateType.equals("s")){
		   return page.setRecords(baseMapper.listBestSaleProductBySeven(map,sor,storeId));
		}else if(dateType.equals("t")){
			return page.setRecords(baseMapper.listBestSaleProductByThirty(map,sor,storeId));
		}				
		 return null;
	}

	@Override
	public List<Map<String, Object>> selectProductdetailsById(String productId, String storeId) {
		 
		return baseMapper.selectProductdetailsById(productId);
	}

	
	/**
	 *dateType y,m,d,w分别对应 年月日周
	 */
	
	@Override
	public List<Map<String, Object>> listDetailedMonitor(String storeId, String userId, String dateType,String createDate) {
		 
		if(dateType.equals("y")){
		 return baseMapper.listDetailedMonitorByYear(storeId,createDate);
		}else if(dateType.equals("m")){
			
		return baseMapper.listDetailedMonitorByMonth(storeId,createDate);
		}else if(dateType.equals("w")){
		
		return baseMapper.listDetailedMonitorByWeek(storeId,createDate);	
		}else if(dateType.equals("d")){
		 return baseMapper.listDetailedMonitorByDay(storeId,createDate);
		}
		return  null;
	}

	

}
