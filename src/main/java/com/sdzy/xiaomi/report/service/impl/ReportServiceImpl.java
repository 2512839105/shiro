package com.sdzy.xiaomi.report.service.impl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdzy.xiaomi.report.service.BaseProductService;
import com.sdzy.xiaomi.report.service.ReportService;
import com.sdzy.xiaomi.report.service.SaleOrderDetailService;
import com.sdzy.xiaomi.report.service.SaleOrderService;
import com.sdzy.xiaomi.report.service.SalePayOrderService;
import com.sdzy.xiaomi.report.service.StockBatchInventoryService;
import com.sdzy.xiaomi.util.BaseUtil;

@Service
public class ReportServiceImpl  implements ReportService{
	@Autowired
    BaseProductService baseProductService;
	@Autowired
    SaleOrderDetailService saleOrderDetailService;
	@Autowired
    SalePayOrderService salePayOrderService;
	@Autowired
	StockBatchInventoryService  stockBatchInventoryService;
	@Autowired
	SaleOrderService  saleOrderService;
	@Override
	public String listReport(String callback, String js_code, String appid, String secrect, String storeId,
			String userId, String dateType) {
		try { 
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				StringBuffer st=new StringBuffer();
				// data = saleOrderService.listReport(js_code,appid,secrect,storeId,userId,dateType);
				//毛利
				List<Map<String, Object>> data1 = saleOrderDetailService.listGrossProfit(storeId,userId,dateType); 
				 //st.append("'maoli':"+data+",");
				//销售额
				 List<Map<String, Object>> data2=saleOrderDetailService.listSaleAmount(storeId,userId,dateType); 
				 //st.append("'xiaoshoue':"+data+",");
				//按客流量
				 List<Map<String, Object>> data3 = saleOrderService.listFlowNum(storeId,userId,dateType); 
			 	//st.append("'keliuliang':"+data+"");
			    //String result="({"+st.toString()+"})";
				 ObjectMapper objectMapper = new ObjectMapper();				  
				 try {
					 String string1 = objectMapper.writeValueAsString(data1);
					 String string2 = objectMapper.writeValueAsString(data2);
					 String string3 = objectMapper.writeValueAsString(data3);
					 String result="({'status':200,'data':{'maoli':"+string1+",'xiaoshoue':"+string2+",'keliuliang':"+string3+"}})";				 					 
					 return callback+result;
				 } catch (JsonProcessingException e) {
					 return callback+"({'status':400,'result':null})";
				 }
			}
		} catch (IOException e) {		
			throw new CustomerException(e);	
		}
	return "({'status':400,'result':null})";
		
	}
 	
	@Override
	public String shopChief(String callback, String js_code, String appid, String secrect, String storeId, String userId,
			String dateType) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				  	   	 
				     Date now = new Date();
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");				    
			    	//毛利
			    	 List<Map<String, Object>> data1 = saleOrderDetailService.listGrossProfit(storeId,userId,dateType);   
			    	//销售额
			    	 List<Map<String, Object>> data2 = saleOrderDetailService.listSaleAmount(storeId,userId,dateType); 
			    	//按客流量
			     	 List<Map<String, Object>> data3 = saleOrderService.listFlowNum(storeId,userId,dateType); 
			         	 			  			     			     	 
			     	 ObjectMapper objectMapper = new ObjectMapper();					  					 
			     	 String string4="";
			     	 try {
						 if(dateType.equals("r")){
							//会员销售	 
					     	 List<Map<String, Object>> data4=saleOrderDetailService.listMember(storeId, userId, dateType);					     	 
							 if(data4.size()>0){ 
								 string4 = objectMapper.writeValueAsString(data4);							 
							 }				     	  
						 }
						 String string1 = "";
						 String string2 = "";
						 String string3 ="";
						 if(data1.size()>0){ string1 =objectMapper.writeValueAsString(data1);}
						 if(data2.size()>0){string2 =objectMapper.writeValueAsString(data2);}						 
						 if(data3.size()>0)
						 {	
							 string3= objectMapper.writeValueAsString(data3); }
						 	 					 
						 String create="createDate";
						
						 if(string1.equals("")){ 
							 string1="[{"+'"'+create+'"'+":"+'"'+sdf.format(now)+'"'+"}]";
						 }
						 if(string2.equals("")){
							 string2="[{"+'"'+create+'"'+":"+'"'+sdf.format(now)+'"'+"}]"; 
						 }
						 if(string3.equals("")){ 
							string3="[{"+'"'+create+'"'+":"+'"'+sdf.format(now)+'"'+"}]";
						 }
						 if(string4.equals("")){ 
							 string4="[{"+'"'+create+'"'+":"+'"'+sdf.format(now)+'"'+"}]";
						 }				 
					  String result="({'status':200,'data':{'maoli':"+string1+",'xiaoshoue':"+string2+",'keliuliang':"+string3+",'huiyuan':"+string4+"}})";	 					 														    		  
					  return callback+result;
											 
						 } catch (JsonProcessingException e) {
						 return callback+"({'status':400,'result':null})";
					 }
			}
		} catch (IOException e) {
			 
			throw new CustomerException(e);
		} 	 		
		return callback+"({'status':400,'result':null})";

	}
	@Override
	public String listDetailed(String callback, String js_code, String appid, String secrect, String storeId,
			String userId, String dateType) {		 
		if(dateType==null){    				
			dateType="d";
		}
							  
	try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			
			 StringBuffer st=new StringBuffer();		 
			 List<Map<String, Object>> data1 = saleOrderDetailService.listGrossProfit(storeId,userId,dateType); 			 
			 List<Map<String, Object>> data2=saleOrderDetailService.listSaleAmount(storeId,userId,dateType); 		 
			 List<Map<String, Object>> data3 = saleOrderService.listFlowNum(storeId,userId,dateType); 		  
			 ObjectMapper objectMapper = new ObjectMapper();				  
			 try {
				 String string1 = objectMapper.writeValueAsString(data1);
				 String string2 = objectMapper.writeValueAsString(data2);
				 String string3 = objectMapper.writeValueAsString(data3);		  				
				 String result=  "({'status':200,'data':{'maoli':"+string1+",'xiaoshoue':"+string2+",'keliuliang':"+string3+"}})";	 

				 return callback+result;
			 } catch (JsonProcessingException e) {
				 return callback+"({'status':400,'result':null})";
			 }
		}
		} catch (IOException e) {
			throw new CustomerException(e);
		} 
		return "({'status':400,'result':null})";				 
	}
	
	/**
	 * 员工业绩
	 */
	@Override
	public String employeePerformance(String callback, String js_code, String appid, String secrect, String storeId,
			String seller, String dateType) {	
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			//客流 
			List<Map<String, Object>> data = saleOrderDetailService.employeePerformance(dateType,storeId,seller);
	
			  ObjectMapper objectMapper = new ObjectMapper();				  				 
					 try {
						String string = objectMapper.writeValueAsString(data);
						return string;
					} catch (JsonProcessingException e) {
						return null;
					} 						 
			}
		} catch (IOException e) {
			throw new CustomerException(e);
		}
	 return null;	 
	}
	
	@Override
	public String personalSales(String callback, String js_code, String appid, String secrect, String storeId,
			String userId, String dateType) {	
		
		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){					
				List<Map<String, Object>> data = saleOrderDetailService.personalSales(storeId,userId,dateType);
				ObjectMapper objectMapper = new ObjectMapper();				  				 
				 try {
					String string = objectMapper.writeValueAsString(data);
					return string;
				} catch (JsonProcessingException e) {
					throw new CustomerException(e);
				} 
			   } 
			}catch (IOException e) {
					throw new CustomerException(e);
			}
			 return null;		 
		
	}
	@Override
	public String personalRankings(String callback, String js_code, String appid, String secrect, String storeId,
			String userId) {
		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			
			      List<Map<String, Object>> data = saleOrderDetailService.personalRankings(storeId,userId);
					ObjectMapper objectMapper = new ObjectMapper();				  				 
					 try {
						String string = objectMapper.writeValueAsString(data);
						return string;
					} catch (JsonProcessingException e) {
						throw new CustomerException(e);
					}
				}
			}catch (IOException e) {
				throw new CustomerException(e);
		}
				
		return null;
	}

	
	
	
	
	
	/**
	 * 药店排名
	 */
	@Override
	public String ranking(String callback, String js_code, String appid, String secrect, String storeId, String userId,
			String dateType) {
		try {

			if(BaseUtil.getSessionAndOpenJson(js_code, appid,secrect)){
				  List<Map<String, Object>> data = saleOrderDetailService.ranking(storeId, userId, dateType);  
				  ObjectMapper objectMapper = new ObjectMapper();				  			 		  
				try {
					String string1 = objectMapper.writeValueAsString(data); 
					 return string1;

				} catch (JsonProcessingException e) {			 
					throw new CustomerException(e);
				} 
			}
		} catch (IOException e) {
			throw new CustomerException(e);
		}
		return null;		
	}
	@Override
	public String rankingsByStoreId(String callback, String storeId, String dateType,String js_code,String appid,String secrect) {			
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
			     List<Map<String, Object>> data = saleOrderDetailService.rankingsByStoreId(storeId, dateType);
				 ObjectMapper objectMapper = new ObjectMapper();
				 String string;
				try {
					string = objectMapper.writeValueAsString(data);
					return  string;
				} catch (JsonProcessingException e) {				
					throw new CustomerException(e);
				}
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return null;
		}

	@Override
	public String selectAllStare(String callback,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	 
				List<Map<String, Object>> data = saleOrderDetailService.selectAllStare();
				 ObjectMapper objectMapper = new ObjectMapper();
				 String string;
				try {
					string = objectMapper.writeValueAsString(data);			
					return  callback+"({'status':200,'data':"+string+"})";
				} catch (JsonProcessingException e) {				
					 return callback+"({'status':400,'result':null})";
				}
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return null;

	}

	@Override
	public String selectStareByNameOrCode(String storeNameOrCode,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			   List<Map<String, Object>> data = saleOrderDetailService.selectStareByNameOrCode(storeNameOrCode);
			   ObjectMapper objectMapper = new ObjectMapper();
				 String string;
				try {
					string = objectMapper.writeValueAsString(data);
					return  string;
				} catch (JsonProcessingException e) {				
					throw new CustomerException(e);
				}
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return null;
	}

	@Override
	public String commodityInquiryByproductName(String productName,String js_code,String appid,String secrect,String storeId) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			     List<Map<String, Object>> data = stockBatchInventoryService.commodityInquiryByproductName(productName,storeId);		
				 ObjectMapper objectMapper = new ObjectMapper();
				 String string;
				try {
					string = objectMapper.writeValueAsString(data);
					return  string;
				} catch (JsonProcessingException e) {				
					throw new CustomerException(e);
				}	
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return null;
	}

	@Override
	public String listBestSaleProduct(QueryParams queryParams, String dateType,String sor,String js_code,String appid,String secrect,String storeId) {
		
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				Page data = saleOrderDetailService.listBestSaleProduct(queryParams, dateType,sor,storeId);
				 ObjectMapper objectMapper = new ObjectMapper();
				 String string;
				try {
					string = objectMapper.writeValueAsString(data);
					return  string;
				} catch (JsonProcessingException e) {				
					throw new CustomerException(e);
				}	
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
		return null;
	}

	@Override
	public String listStockCount(QueryParams queryParams,String sor,String codeOrName,String js_code,String appid,String secrect,String storeId) {
	 try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			Page data = stockBatchInventoryService.listStockCount(queryParams,sor,codeOrName,storeId);
			 ObjectMapper objectMapper = new ObjectMapper();
			 String string;
			try {
				string = objectMapper.writeValueAsString(data);
				return  string;
			} catch (JsonProcessingException e) {				
				throw new CustomerException(e);
			}	
		 }
	} catch (IOException e) {
		throw new CustomerException(e+"参数校验异常");
	}
	 return BaseUtil.productJson(500, null,"错误");
	}

	@Override
	public String listExpiriedProduct(QueryParams queryParams,String dateType, String sor,String js_code,String appid,String secrect,String storeId) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				String data = stockBatchInventoryService.listExpiriedProduct( queryParams,dateType,sor,storeId);
				
				return data;
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
			
		}
		return null;
	}

	@Override
	public String listLessStock(QueryParams queryParams,String sor,String js_code,String appid,String secrect,String storeId) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				Page data = stockBatchInventoryService.listLessStock(queryParams,sor,storeId); 
				ObjectMapper objectMapper = new ObjectMapper();				  
				 try {
					 String string1 = objectMapper.writeValueAsString(data); 
					 return string1;
				 } catch (JsonProcessingException e) {
					 return  "({'status':400,'result':null})";
				 } 
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
		return null;
	}
	
	@Override
	public String selectProductdetailsById(String productId, String storeId,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			   List<Map<String, Object>> data = saleOrderDetailService.selectProductdetailsById(productId,storeId);
				ObjectMapper objectMapper = new ObjectMapper();				  
				 try {
					 String string1 = objectMapper.writeValueAsString(data); 
					 return string1;
				 } catch (JsonProcessingException e) {
					 return  "({'status':400,'result':null})";
				 } 
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
		return null;
	}
	
	//详细报表监控端
	@Override
	public String listDetailedMonitor(String callback, String js_code, String appid, String secrect, String storeId,
			String userId, String dateType,String createDate) {
  
			if(dateType==null){    				
				dateType="d";
			}
			try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				 List<Map<String, Object>> data = saleOrderDetailService.listDetailedMonitor(storeId,userId,dateType,createDate);
					ObjectMapper objectMapper = new ObjectMapper();				  
					 try {
						 String string1 = objectMapper.writeValueAsString(data); 						
						 String result= "({'status':200,'data':"+string1+"})";	 
						 return callback+result;
					 } catch (JsonProcessingException e) {
						 return  "({'status':400,'result':null})";
					 } 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}




}
