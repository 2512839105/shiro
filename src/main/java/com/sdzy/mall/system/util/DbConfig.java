package com.sdzy.mall.system.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.query.Condition;
import com.sdzy.mall.system.model.SysConfig;
import com.sdzy.mall.system.service.SysConfigService;


@Controller
public class DbConfig extends BaseController{
	
	
	 private static SysConfigService sysConfigService;
	 
	 @Autowired
	 public  void setSysConfigService(SysConfigService sysConfigService){
		 DbConfig.sysConfigService = sysConfigService;
	 }
	 
	 public  SysConfig getSysConfigBeanByStoreId(){
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		 List<Condition> whereList = new ArrayList<Condition>();
		 whereList.add(Condition.createEq("storeId",getCurrentUser().getStoreId()));
		 paramMap.put("whereList", whereList);
		 return sysConfigService.findByParam(paramMap);
	 }
	 
	 
	 
	 public static Object getProperty(String key){
		 DbConfig db = new DbConfig();
		 SysConfig sysConfig = db.getSysConfigBeanByStoreId();
		 Method method = null;
		 Object invoke =null;
		try {
			method = sysConfig.getClass().getMethod("get"+db.upperKey(key));
			invoke = method.invoke(sysConfig);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			throw new CustomerException("执行方法错误，找不到传入的配置key",e);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			throw new CustomerException("获取属性异常",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return invoke;
	 }
	 
	 public static void setProperty(String key,Object value){
		 DbConfig db = new DbConfig();
		 SysConfig sysConfig = db.getSysConfigBeanByStoreId();
		 Method method = null;
         Class cls = null;
         if(value instanceof String) {
             cls = String.class;
         }else if(value instanceof Integer) {
             cls = Integer.class;
         }else if(value instanceof BigDecimal) {
             cls = BigDecimal.class;
         }else if(value instanceof Date) {
             cls = Date.class;
         }else if(value instanceof Double) {
             cls = Double.class;
         }else {
             cls = Object.class;
         }
		try {
			method = sysConfig.getClass().getMethod("set"+db.upperKey(key),cls);
			method.invoke(sysConfig,value);
			sysConfigService.updateByBean(sysConfig);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			throw new CustomerException("执行方法错误，找不到传入的配置key:"+value.getClass(),e);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			throw new CustomerException("获取属性异常",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public String upperKey(String key){
		 return key.substring(0,1).toUpperCase()+key.substring(1, key.length());
	 }
	 
	 /**
	  * 获得int类型结果
	  * @param key
	  * @return
	  */
	 public static Integer getIntProperty(String key){
		 return Integer.parseInt(getStringProperty(key));
	 }
	 
	 /**
	  * 获取String类型结果
	  * @param key
	  * @return
	  */
	 public static String getStringProperty(String key){
		 Object property = getProperty(key);
		 return property.toString();
	 }
}
