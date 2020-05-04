package com.sdzy.xiaomi.base.controller;

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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSON;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.IPUtil;
import com.asdzy.common.utils.MD5Util;
import com.baomidou.mybatisplus.annotations.DataSource;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.base.service.SysUserService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.sdzy.xiaomi.util.JDBCUtil;
import com.sdzy.xiaomi.util.ReadTxtFile;
import com.sdzy.xiaomi.util.SendTemplateSMS;


@Controller
@RequestMapping(value = "/base")
public class LoginController extends BaseController {
	
	@Autowired
	SysUserService sysUserService;
	
	//用map 集合存放 验证码和手机号
	private final static Map<String,String> testCodeInforMap = new HashMap<String,String>();  
	
    //手机号
    public static final String SMSMobileAttrName= "smsMobile";
    //短信发送成功状态码
    private static final String successCode     = "000000";
    
    private static final String randomCodeStr   = "0123456789";
    
 
 
 /**
  *   js_code,  appid,  secrect :小程序参数验证
  * 
  * 
  * 账号密码登陆
  */
	@RequestMapping("/loginByPassword.action")
	@ResponseBody
	public String loginByPassword(String storeAccount, String userAccount, String password,String wxAccount,String wxName,String js_code,String appid,String secrect){  
	 
		return 	 sysUserService.loginByPassword(storeAccount, userAccount, password,wxAccount,wxName,js_code,appid,secrect);  	 
	}
  
	
		/**
		 * 验证码登陆
		 * @param phoneNumber
		 * @param authCode
		 * @return
		 */
		@RequestMapping("/login.action")
		@ResponseBody
		public String login(String phoneNumber, String authCode,String js_code,String appid,String secrect){
			 try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){    	
				    String phone=testCodeInforMap.get(authCode); 
				    String  code=testCodeInforMap.get(phoneNumber);
				 	 SysUser user=sysUserService.getUserByphoneNumber(phoneNumber);
				 	  
				 	 if(phone==null){
				 		return BaseUtil.productJson(null, "","验证码错误"); 
				 	 }
				     if(phone!=null&&phone.equals(phoneNumber)){
				    	 if(authCode!=null&&authCode.equals(code)){  
				    		 testCodeInforMap.remove(phoneNumber);
				    		 testCodeInforMap.remove(authCode);
				   		return BaseUtil.productJson(1,user.getStoreName(), user.getStoreId());
				    	 }
				    	 return BaseUtil.productJson(null, "","验证码错误");   			 
				     }
				    return BaseUtil.productJson(null, "","请先发送验证码");
				 }
			} catch (IOException e) {
				throw new CustomerException(e+"参数验证失败");
			}
			 return null;
		 }


/**
 * 获取验证码
 * @param phoneNumber
 * @return
 */
@RequestMapping("/loginGetCode.action")
@ResponseBody
public JsonInfo loginGetCode(String phoneNumber,String js_code,String appid,String secrect){
	try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect))	{	
			SysUser storeName=sysUserService.getUserByphoneNumber(phoneNumber);
			
			if(storeName==null){
				
			  return new JsonInfo(500, "手机号输入有误", "fail");			
					
			} 	
			String randomCode = getRandomCode(6);
		    HashMap resultMap = SendTemplateSMS.sendSMS(phoneNumber, randomCode);    
		      
		    if(successCode.equals(resultMap.get("statusCode"))) {
		    	System.out.println("发送验证码"+randomCode);
		    	 
		    	testCodeInforMap.put(phoneNumber,randomCode);
		    	testCodeInforMap.put(randomCode,phoneNumber);           
		        return new JsonInfo(200, null, "短信发送成功");
		    }
		   
		    return new JsonInfo(500, "短信发送失败", "fail");
		}
	} catch (IOException e) {
		throw new CustomerException(e+"参数验证失败");
	}
	return null;
}

		private static String getRandomCode(int length) {
		    String randomCode = "";
		    
		    int maxIndex = randomCodeStr.length();
		    
		    Random random = new Random();
		    
		    for(int i=0;i<length;i++) {
		        randomCode += random.nextInt(maxIndex);
		    }
		    
		    return randomCode;
		}
 

   

}