package com.sdzy.xiaomi.report.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.Condition.OpType;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.ConditionValue.ConditionType;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.report.model.StockBatchInventory;
import com.sdzy.xiaomi.report.mapper.StockBatchInventoryMapper;
import com.sdzy.xiaomi.report.service.StockBatchInventoryService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;

import org.eclipse.jdt.internal.compiler.ast.NullAnnotationMatching;
import org.springframework.core.annotation.Order;
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
public class StockBatchInventoryServiceImpl extends BaseServiceImpl<StockBatchInventoryMapper, StockBatchInventory> implements StockBatchInventoryService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	
	@Override
	public  Page<StockBatchInventory>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<StockBatchInventory> page = new Page<StockBatchInventory>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<StockBatchInventory> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}

	/**查询效期品种
	 * 查询库存 表
	 */

	@Override
	public List<Map<String, Object>> listExpiredProduct(String js_code,String appid,String secret,String storeId, String userId, String pageIndex,
			String pageSize, String dateType) {
		
		/*try {
			BaseUtil.getSessionAndOpenJson(js_code);
			
		

		} catch (IOException e) {
			throw new CustomerException(e);
		}*/
		if(storeId==null)
		{
			throw new CustomerException("门店编号不能为空！");
		}
		
		return baseMapper.stockBatchInventory(storeId);
	}

	@Override
	public Page listStockCount(QueryParams queryParams,String sor,String codeOrName,String storeId) {
				
		Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Condition> whereList = queryParams.filtersToDBConditionals();
		if(codeOrName!=null&&codeOrName!=""){
			/*if(BaseUtil.isInteger(codeOrName)){
			 whereList.add(new Condition("productCode",codeOrName,OpType.LK));
			}else{				
			 whereList.add(new Condition("productName",codeOrName,OpType.LK));
			}*/
			map.put("whereList",whereList);
			return page.setRecords(baseMapper.listStockCountByCodeOrName(page,codeOrName,sor,storeId));			
		}
		map.put("whereList",whereList);	
			 		
	    page.setRecords(baseMapper.listStockCount(page,map,sor,storeId));
	 
	    return  page;
		 
	}


	/**通过dateType 的值判断调用哪条SQL
	 * y---一个月内的
	 * s---一至三个月内的
	 * l---三至六个月内的
	 * g--过期的
	 */
	 
	@Override
	public String listExpiriedProduct(QueryParams queryParams,String dateType,String sor,String storeId) {
		// TODO Auto-generated method stub
		
		Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Condition> whereList = queryParams.filtersToDBConditionals();	
		map.put("whereList", whereList);
			       		 
		if(dateType.equals("y")){	
			page.setRecords(baseMapper.listExpiriedProductByMonth(page,sor,storeId));
		}else if(dateType.equals("s")){
			
			page.setRecords(baseMapper.listExpiriedProductByWeek(page,sor,storeId));
		}else if(dateType.equals("l")){
			page.setRecords(baseMapper.listExpiriedProductByDay(page,sor,storeId));
		}else if(dateType.equals("g")){			
			page.setRecords(baseMapper.listExpiriedProductByBeoverdue(page,sor,storeId));
		}
		
				 ObjectMapper objectMapper = new ObjectMapper();				  
				 try {
					 String string1 = objectMapper.writeValueAsString(page);				
					 return string1;
				 } catch (JsonProcessingException e) {
					 return "({'status':400,'result':null})";
				 }
				 	 
	}



	@Override
	public Page listLessStock(QueryParams queryParams,String sor,String storeId) {
		// TODO Auto-generated method stub
		Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String, Object> map = new HashMap<String, Object>();		
		List<Condition> whereList = queryParams.filtersToDBConditionals();				  	
		map.put("whereList", whereList);		   
		return page.setRecords(baseMapper.listLessStock(page,map,sor,storeId));
	}



	@Override
	public List<Map<String, Object>> commodityInquiryByproductName(String productName,String storeId) {
		 
		return baseMapper.commodityInquiryByproductName(productName,storeId);
	}



	@Override
	public List<Map<String, String>> findInventorys(String keyword, String storeId, String sort) {
	 
		return baseMapper.findInventorys(keyword,storeId);
	}

}
