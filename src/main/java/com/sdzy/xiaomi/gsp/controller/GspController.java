package com.sdzy.xiaomi.gsp.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.xiaomi.util.BaseUtil;
import com.sdzy.xiaomi.util.JDBCUtil;



@Controller
@RequestMapping(value = "/gsp")
public class GspController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GspController.class);

    /**
     * 室内温湿度登记
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
			  order:排序类别 0降序，1升序
			  sort:排序对象，根据什么字段排序
     * @return Json
     */
    @RequestMapping("/saveRoomTemperature.action")
    @ResponseBody
    public String saveRoomTemperature(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "storeId",required = false) String storeId,@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){
    		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
					logger.info("用户"+userId+" 正在进行室内温湿度登记");
					Map<String, Object> sqlMap = dealJsonToSql(data);
					Object columnName = sqlMap.get("columnName");
					Object columnValue = sqlMap.get("columnValue");
					String sql = "insert into gspRoomTemperatureRecord (recordId, "+columnName+")values ('"+StringUtil.getUUID()+"' , "+columnValue+")";
					try {
						BaseUtil.executeByJdbc(sql);
						return BaseUtil.productJson(1, "","登记成功!");
					} catch (IllegalArgumentException| SecurityException | SQLException e) {
						//异常回滚
						e.printStackTrace();
						throw new CustomerException("登记失败!");					
					}
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
    		return null;

        
    }
    
    /**
     * 冰箱温度登记接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
     * @return Json
     */
    @RequestMapping("/saveFridgeTemperature.action")
    @ResponseBody
    public String saveFridgeTemperature(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){
    		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
					logger.info("用户"+userId+" 正在进行冰箱温度登记接口");
					Map<String, Object> sqlMap = dealJsonToSql(data);
					Object columnName = sqlMap.get("columnName");
					Object columnValue = sqlMap.get("columnValue"); 
					String sql = "insert into gspFridgeTemperatureRecord (recordId, "+columnName+") values ('"+StringUtil.getUUID()+"' , "+columnValue+")";
					try {
						BaseUtil.executeByJdbc(sql);
						return BaseUtil.productJson(1, "","登记成功!");
					} catch (IllegalArgumentException| SecurityException | SQLException e) {
						//异常回滚
						e.printStackTrace();
						throw new CustomerException("登记失败!");
					}    
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
    		return null;
    }
 
    
    /**
     * 设备使用记录接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
     * @return Json
     */
    @RequestMapping("/saveDeviceUseRecord.action")
    @ResponseBody
    public String saveDeviceUseRecord(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "storeId",required = false) String storeId,@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){
    		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
						logger.info("用户"+userId+" 正在调用设备使用记录接口");
						Map<String, Object> sqlMap = dealJsonToSql(data);
						Object columnName = sqlMap.get("columnName");
						Object columnValue = sqlMap.get("columnValue");
						String sql = "insert into gspEquipmentUseRecord (userRecordId, "+columnName+") values ('"+StringUtil.getUUID()+"' , "+columnValue+")";
						try {
							BaseUtil.executeByJdbc(sql);
							return BaseUtil.productJson(1, "","登记成功!");
						} catch (IllegalArgumentException| SecurityException | SQLException e) {
							//异常回滚
							e.printStackTrace();
							throw new CustomerException("登记失败!");
						} 
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
    		return null;
    }
    /**
     * 设备维护记录接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
     * @return Json
     */
    @RequestMapping("/saveDeviceMaintainRecord.action")
    @ResponseBody
    public String saveDeviceMaintainRecord(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "storeId",required = false) String storeId,@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){
    		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
						logger.info("用户"+userId+" 正在调用设备维护记录接口");
						Map<String, Object> sqlMap = dealJsonToSql(data);
						Object columnName = sqlMap.get("columnName");
						Object columnValue = sqlMap.get("columnValue");
						String sql = "insert into gspEquipmentMaintainRecord (maintainRecordId, "+columnName+") values ('"+StringUtil.getUUID()+"' , "+columnValue+")";
						try {
							BaseUtil.executeByJdbc(sql);
							return BaseUtil.productJson(1, "","登记成功!");
						} catch (IllegalArgumentException| SecurityException | SQLException e) {
							//异常回滚
							e.printStackTrace();
							throw new CustomerException("登记失败!");
						}
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
    		return null;
    }
    /**
     * 计量器具检定记录接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
     * @return Json
     */
    @RequestMapping("/saveMeasureDeviceRecord.action")
    @ResponseBody
    public String saveMeasureDeviceRecord(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "storeId",required = false) String storeId,@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){
    		
    		try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
						logger.info("用户"+userId+" 正在调用计量器具检定记录接口");
						Map<String, Object> sqlMap = dealJsonToSql(data);
						Object columnName = sqlMap.get("columnName");
						Object columnValue = sqlMap.get("columnValue");
						String sql = "insert into gspMeasureDeviceCheckRecord (measureCheckId, "+columnName+") values ('"+StringUtil.getUUID()+"' , "+columnValue+")";
						try {
							BaseUtil.executeByJdbc(sql);
							return BaseUtil.productJson(1, "","登记成功!");
						} catch (IllegalArgumentException| SecurityException | SQLException e) {
							//异常回滚
							e.printStackTrace();
							throw new CustomerException("登记失败!");
						} 
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
    		return null;
    }

    
    
    /**
     * 获取厂商培训列表接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  data:表单数据，需拼装
     * @return Json
     */
    @RequestMapping("/listManufacturerTrain.action")
    @ResponseBody
    public String listManufacturerTrain(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		@RequestParam(value = "storeId",required = false) String storeId,@RequestParam(value = "userId",required = false) String userId,
    		@RequestParam(value = "pageIndex",required = false) Integer pageIndex,@RequestParam(value = "pageIndex",required = false)  Integer pageSize,String js_code,String appid,String secrect){
		     try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
						logger.info("用户"+userId+" 正在调用获取厂商培训列表接口");
						if(StringUtil.isEmpty(pageSize)){
							pageSize = 10;
						}
						if(StringUtil.isEmpty(pageIndex)){
							pageIndex = 1;
						}
						String sql = "select * from listManufacturerTrain  where storeId = "+storeId +" limit "+pageIndex+","+pageSize;
						try {
							data = BaseUtil.executeQueryByJdbc(sql,null,null);//暂无数据库表
							return BaseUtil.productJson(null, data,"获取成功!");
						} catch (IllegalArgumentException| SecurityException | SQLException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							//异常回滚
							e.printStackTrace();
							throw new CustomerException("获取失败!");
						}
				 }
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
		     return null;
    }
    
    
    
    /**
     * 执行sql语句，返回结果集，用于查询类sql
     * 
     * @param sql:传入的查询sql
     * @return List<T>
     * @throws SQLException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * 
     * *//*
    private <T> List<T> executeQueryByJdbc(String sql) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		return (List<T>) convertList(rs);
    }
    
    private List<Object> convertList(ResultSet rs) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Object> list = new ArrayList<Object>();
		List<String> nameList = new ArrayList<String>();
		ResultSetMetaData md = rs.getMetaData();// 获取键名
		int columnCount = md.getColumnCount();// 获取列的数量
		while (rs.next()) {
			Object[] datas = new Object[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				Object value = rs.getObject(i);
				//把所有值装进去
				if(value instanceof Timestamp){
					Timestamp t =  (Timestamp)value;
					value = DateUtil.formatDateTime(new Date(t.getTime()));
				}
				datas[i-1] =  value;						
			}
			list.add(datas);
		}
		for (int i = 1; i <= columnCount; i++) {
			nameList.add(md.getColumnName(i));			
		}
		list.add(nameList);
		return list;
	}
    *//**
     * 生成返回的JSON格式
     * 
     * @param sql:传入的查询sql
     * @return boolean
     * @throws SQLException 
     * 
     * *//*
	private String productJson(Integer flag, Object data) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (flag != null) {
			jsonMap.put("state", 200);
			jsonMap.put("data", "");
			jsonMap.put("msg", "上传成功");
			return JSON.toJSONString(jsonMap);
		} else {
			jsonMap.put("state", 500);
			jsonMap.put("data", data);
			jsonMap.put("msg", "上传到服务端失败");
			return JSON.toJSONString(jsonMap);
		}
	}
	
    *//**
     * 执行sql语句，返回成功失败，用于增删改类sql
     * 
     * @param sql:传入的查询sql
     * @return boolean
     * @throws SQLException 
     * 
     * *//*
    private boolean executeByJdbc(String sql) throws SQLException{
    	Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps.execute();
    }*/
    
    private Map<String,Object> dealJsonToSql(String data){
    	JSONObject jObj = JSON.parseObject(data);
		Iterator<String> iterator = jObj.keySet().iterator();
		StringBuffer columnName = new StringBuffer();
		StringBuffer columnValue = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();
		while(iterator.hasNext()){
			String key = iterator.next();
			columnName = columnName.append(key+",");
			columnValue = columnValue.append("'"+jObj.get(key)+"',");
		}
		columnName = columnName.deleteCharAt(columnName.length()-1);
		columnValue = columnValue.deleteCharAt(columnValue.length()-1);
		map.put("columnName", columnName);
		map.put("columnValue", columnValue);
		return map;
    }
    
}