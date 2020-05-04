package com.sdzy.xiaomi.base.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.asdzy.common.enums.Status;
import com.asdzy.common.exception.CustomerException;

import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import com.asdzy.common.query.Condition;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.utils.MD5Util;
import com.sdzy.xiaomi.base.entity.SysRole;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.base.mapper.SysRoleDAO;
import com.sdzy.xiaomi.base.mapper.SysUserMapper;
import com.sdzy.xiaomi.base.service.SysUserService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.sdzy.xiaomi.util.ReadTxtFile;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	@Autowired
	private SysRoleDAO sysRoleDAO;

	

	@Override
	public String selectOne(LocalUser localUser) {
	 
		return null;
	}

	@Override
	public List<Map<String,String>> selectSysUserByStoreId(String storeId) {
				
		 return baseMapper.selectByStoreId(storeId);
	}
	
	
	
	@Override
	public String loginByPassword(String storeAccount, String userAccount, String password,String wxAccount,String wxName,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				

		 
				Map<String,String> map=baseMapper.selectStoreId(storeAccount);				 
				 String storeId = map.get("storeId");

 
				 	Map<String, Object> users = baseMapper.selectByAccount(storeId,userAccount);
				 	if(users==null)
						 return BaseUtil.productJson(null,"","账号不存在");

				 	String userId=(String) users.get("userId");
				 	String wxAccounts=(String) users.get("wxAccount");
				 	Integer isAllowWxLogin= (Integer) users.get("isAllowWxLogin");

				//if(wxAccounts!=null&&isAllowWxLogin==1){
				
			  //  baseMapper.selectByWxAccount(wxAccount,wxName);

					if(storeId!=null){
						String	account=baseMapper.selectUserAccount(storeId,userAccount);
						if(account!=null){
							password=MD5Util.encrypt(password,"yaodian@sdzy!@#$%"); 	
						    SysUser  user=baseMapper.selectUserPassword(storeId,userAccount,password);
							 if(user==null){					 
								 return BaseUtil.productJson(null, "","登录失败，用户密码输入错误！");					 					 					 
							 }else{									 
								 	 Map<String, String> storeMap= baseMapper.selectStore(storeId);	
									 String store= JSON.toJSONString(storeMap);							  					 					 					 
								    String jsonString = JSON.toJSONString(user);							  					 					 					 
								    String result="{\"status\":200,\"user\":"+jsonString+",\"store\":"+store+"}" ;  

						           
							       return result;
					 }
						}else{				
							return BaseUtil.productJson(null, "","登录失败，用户账号输入错误！");
						}			 		
					}else{						
						return BaseUtil.productJson(null, "","登录失败，门店号输入错误！");			
					}
				 
		/*	}else{
				
				baseMapper.insert(wxAccount,wxName,0,userId);
				return BaseUtil.productJson(null, "","账号未授权");

			}*/
		}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
 
		return BaseUtil.productJson(null, "","小程序参数验证失败");
 
	}

	@Override
	public String loginByPhoneNumber(String phoneNumber, String randomCode) {
		Map<String,Integer> map;

		SysUser user=baseMapper.selectByphoneNumber(phoneNumber);		
		if(user==null){
			return BaseUtil.productJson(null, "","手机号号输入错误！");			
		}
	
	   if(randomCode==null){
			Integer randomcode=(int)((Math.random()*9+1)*100000); 		
			 map=new HashMap<String,Integer>();			    
		      map.put(phoneNumber, randomcode);	
		      map.get(phoneNumber);
		   /* SendTemplateSMS.sendSMS(phoneNumber, randomcode.toString());*/
		}
	   
	   if(randomCode.equals(""))
				
		return "aer";
	   
	   
	return user.getUserName();
	}

	@Override
	public SysUser getUserByphoneNumber(String phoneNumber) {
				
		SysUser user=baseMapper.selectByphoneNumber(phoneNumber);
		return user;
	}

	@Override
	public SysUser findSysUserById(String modelId) {
		SysUser user=baseMapper.findById(modelId);
		return user;
	}

	@Override
	public List<SysUser> listSeller(String storeId) {
 	        Map<String, Object> paramMap = new HashMap<>();
	        List<Condition> whereList = new ArrayList<>();
	        whereList.add(Condition.createEq("status", Status.NORMAL.getValue()));
	        whereList.add(Condition.create("IFNULL(deleteFlag,'')", -1 , Condition.OpType.NE));
	        whereList.add(Condition.createEq("storeId", storeId));
	        paramMap.put("whereList", whereList);
	        List<SysUser> list =  baseMapper.listByParam(paramMap);
	        for(SysUser sysUser : list) {
	            List<SysRole> roleList = sysRoleDAO.listUserRoleNames(sysUser.getUserId());
	            sysUser.setRoleList(roleList);
	        }
	        return list;
	}

	@Override
	public SysUser findByUserAccount(String username, String password) {
		Map<String,Object> map=new HashMap<>();
        map.put("userAccount", username);
        map.put("password", password);
		return baseMapper.findByUserAccount(map);
	}

}
