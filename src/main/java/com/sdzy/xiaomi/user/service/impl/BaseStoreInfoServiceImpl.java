package com.sdzy.xiaomi.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.xmlrpc.base.Data;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;
 
import com.sdzy.xiaomi.user.mapper.BaseStoreInfoMapper;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;
import com.sdzy.xiaomi.util.BaseUtil;
 import com.asdzy.common.mybatisplus.support.BaseServiceImpl;

 
import org.springframework.stereotype.Service;
 

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-04
 */
@Service
public class BaseStoreInfoServiceImpl extends BaseServiceImpl<BaseStoreInfoMapper, BaseStoreInfo> implements BaseStoreInfoService {
 
 
	@Override
	public BaseStoreInfo updateModel(String data,String js_code,String appid,String secrect) {
	 
		try {			
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){		
				BaseStoreInfo model=JSON.parseObject(data,BaseStoreInfo.class);
			this.updateById(model);   				    		
			return model;
		}
		
		} catch (IOException e) {
			throw new CustomerException(e);	
		} 
		return null;
	}
	
	
	
	@Override
	public  Page<BaseStoreInfo>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<BaseStoreInfo> page = new Page<BaseStoreInfo>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<BaseStoreInfo> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}

	@Override
	public String updateStoreLogo(String logoPath,String storeId) {
		
		int result=baseMapper.updateLogo(logoPath, storeId);
		 
		return  result+"";
	}



	@Override
	public String selectStore(){
		List<Map<String, String>> data = baseMapper.selectStore();
		ObjectMapper  objectMapper=new ObjectMapper();
		String string;	 
			try {
				string = objectMapper.writeValueAsString(data);
			} catch (JsonProcessingException e) {
				throw new CustomerException(e+"数据转换异常");
			}	 
		return string;
	}



	@Override
	public String selectAllStore(String dateType,String companyId) {
		if(dateType==null){
			dateType="1";
		}
		 Map<String, Object>  data = baseMapper.selectAllStore(dateType,companyId);		 
			// System.out.println(a.get("saleOrderNo"));
		 if(data!=null){
		  BigDecimal b =  (BigDecimal) data.get("saleOrderNo");
			     
			 if(b==null){
				 data.put("sellAmount", 0);
				 data.put("online",0);
				 data.put("saleCount", 0);
				 data.put("online", 0);				 
			 }
			 if(data.get("online")==null){  //判断线上交易是否在
				 data.put("online", 0);
				
			 }else{
				 BigDecimal sellAmount = (BigDecimal) data.get("sellAmount");	
				 int sell = sellAmount.intValue();
				 int online=(int) data.get("online");				   		
				 data.put("online",online/sell);
			 }			 
		 List<Map<String,Object>>  list=new ArrayList();
		 list.add(data);
		 String jsData = JSON.toJSONString(list);
		 return  jsData;
		 }
		 return null;
	}


	@Override
	
	public String selectCategoryRank(String dateType,String companyId) {
		// TODO Auto-generated method stub
		List<Map<String, String>> data = baseMapper.selectCategoryRank(dateType,companyId);
		return JSON.toJSONString(data);
	}
 

	@Override
	public String selectStoreNameRank(String codeId, String dateType,String companyId) {
		if(dateType==null){
			dateType="1";
		}
		List<Map<String, String>> store = baseMapper.selectStoreNameRank(codeId,dateType,companyId);
		List<Map<String, String>> supplier = baseMapper.selectProductRank(codeId,dateType,companyId);
		String storeJS = JSON.toJSONString(store);
		String supplierJS=JSON.toJSONString(supplier);
		/*String storeJS2=storeJS.replaceAll("\\]", "");
		String supplierJS2=supplierJS.replaceAll("\\[", "");*/
		
		String json="{\"msg\":\"成功\",\"data\":"+storeJS+",\"list\":"+supplierJS+"}";
		return json;
	}



	@Override
	public String selectStoreSaleRank(String dateType,String companyId) {
		// TODO Auto-generated method stub
		List<Map<String, String>> rank = baseMapper.selectStoreSaleRank(dateType,companyId);
		String count = baseMapper.selectStoreCount(companyId);		
		 	
		String ranks = JSON.toJSONString(rank);
		String counts = JSON.toJSONString(count);
		String iString="{\"storeCount\":"+counts+",\"list\":"+ranks+"}";
		return iString;
	}
	
	public String selectAll(String companyId){     
		 String data = baseMapper.selectStoreAllCount(companyId);	 	
		 String al= "{\"storeAllCount\":"+data+"}";
	  	return al;

	}

	@Override
	public String selectPayRank(String dateType,String companyId) {
		List<Map<String, String>> data = baseMapper.selectPayRank(dateType,companyId);
		if(data.size()!=0&&data!=null){
			for(Map a:data){
				String type =  (String) a.get("payType");
				switch (type) {
				case "1":a.put("payType","现金"); break;
				case "2":a.put("payType","支付宝"); break;
				case "3":a.put("payType","微信"); break;
				case "4":a.put("payType","银联"); break;
				case "5":a.put("payType","医保"); break;
				}
					
			}
			return JSON.toJSONString(data);
			
		}
		return JSON.toJSONString(data);

		
	}


	@Override
	public String selectRegionRank(String dateType,String companyId) {		
		 List<Map<String, String>> data=baseMapper.selectRegionRank(dateType,companyId);
		 List<Map<String, String>> data2=baseMapper.selectRegionRankCity(dateType,companyId);
		 ObjectMapper objectMapper=new ObjectMapper();
 	 
 	try {
			String string=objectMapper.writeValueAsString(data);
			String string2=objectMapper.writeValueAsString(data2);
			//{"msg":"成功","data":"[{\"SUM(sellAmount)\":816.800,\"ran\":\"广东省\"}][{\"SUM(sellAmount)\":816.800,\"ran\":\"珠海市\"}]","state":200}
			String tmp1 = string2.replaceAll("\\[", "");
			String tmp2 = string.replaceAll("\\]", "");
			String json = null;
			String te=tmp1.replace("]","");
			String te2=tmp2.replace("[", "");
			if(te.isEmpty()||te2.isEmpty()){  //其中一个为空时不能留逗号
				  json="{\"msg\":\"成功\",\"data\":"+tmp2+tmp1+"}";
			}else if(!te.isEmpty()||!te2.isEmpty()){
			   json="{\"msg\":\"成功\",\"data\":"+tmp2+","+tmp1+"}";
			}
			return json;
		} catch (JsonProcessingException e) {
			throw new CustomerException(e+"转换异常");
		}

	}
	@Override
	public String selectIsRxDrugRank(String dateType,String companyId) {
		Map<String, String> data = baseMapper.selectIsRxDrugRank(dateType,companyId);
		
 		return JSON.toJSONString(data);
	}

	@Override
	public String selectMemberCount(String dateType,String companyId) {
		Map<String, String> data = baseMapper.selectMemberCount(companyId);
 		return JSON.toJSONString(data);
	}



	@Override
	public List<Map<String,String>> selectSaleDetail(String dateType, String storeId) {
		
		return baseMapper.selectSaleDetail(dateType,storeId);
	}


	//------------------展厅监控
	@Override
	public String selectStoreRankRegion(String dateType,String address,String callback) {
		 
		 List<BaseStoreInfo> 	data = baseMapper.selectStoreRankRegion(dateType,address);
		String jsString= JSON.toJSONString(data);
		String js="{\"msg\":\"成功\",\"data\":"+jsString+"}";		
		return js;

	}



	@Override
	public String selectStoreDetail(String storeId,String callback) {
		// TODO Auto-generated method stub
		BaseStoreInfo aa = baseMapper.selectStoreDetail(storeId);
		    ObjectMapper ob=new ObjectMapper();
		    String string;
			try {
				string = ob.writeValueAsString(aa);
				String js="{\"msg\":\"成功\",\"data\":"+string+"}";
				return  js;
			} catch (JsonProcessingException e) {
				return null;
			}
		 
		
	}



	@Override
	public String selectStoreByCompany(String companyName,String callback) {
		List<Map<String, String>> data = baseMapper.selectStoreByCompany(companyName);	
		String jString=JSON.toJSONString(data);
		 String js="{\"msg\":\"成功\",\"data\":"+jString+"}";
		return  js;
	}



	@Override
	public String selectStoreByName(String storeName, String callback,String companyId) {
		 List<Map<String, String>> data = baseMapper.selectStoreByName(storeName,companyId);
		 String jString=JSON.toJSONString(data);
		 String js="{\"msg\":\"成功\",\"data\":"+jString+"}";
		return  js;
	}



	@Override
	public String selectMonitorVideo(String storeId) {
		Map<String, String> data = baseMapper.selectMonitorVideo(storeId);
	/*	if (data==null||data.size()<1) {
			return " {\"msg\":\"成功\",\"data\":\"暂无数据信息\" }";
		}*/
	   String jsData=JSON.toJSONString(data);
		return "{\"msg\":\"成功\",\"data\":"+jsData+"}";
		
	}



	@Override
	public String realTimeSales(String companyId) {
	    List<Map<String, String>> data =baseMapper.realTimeSales(companyId); 
 		String jsData=JSON.toJSONString(data);
		return jsData; 
 		
	}



	@Override
	public String sellAmountGoupByHour(String companyId) {
		 List<Map<String, Object>> data =baseMapper.sellAmountGoupByHour(companyId); 
		 
 		 double ABC = 0;    
	 
  		 for(Map  a:data){					 
 	 				String aer=(String) a.get("hours");
	 				BigDecimal  abc=(BigDecimal) a.get("count");
	 				double sellAmount = abc.doubleValue();
	 				ABC=sellAmount+ABC;	//计算 某个时间段销售总额
	 				BigDecimal bd2 = new BigDecimal(ABC, new MathContext(8));
	 				int i=0;
	 				a.put("sellAmount",bd2);
	 				//list.add(a);
	    }
  		return JSON.toJSONString(data);
	}



 
}
