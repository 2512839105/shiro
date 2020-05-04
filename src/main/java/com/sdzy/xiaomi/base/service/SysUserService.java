package com.sdzy.xiaomi.base.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.base.entity.SysUser;

public interface SysUserService {
	
	String selectOne(LocalUser localUser);
	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	List<Map<String,String>>selectSysUserByStoreId (String storeId);
	
	String loginByPassword(String storeAccount, String userAccount, String password,String wxAccount,String wxName,String js_code,String appid,String secrect);
	
	String loginByPhoneNumber(String phoneNumber,String randomCode);
	
	SysUser getUserByphoneNumber(String phoneNumber);
	
    SysUser findSysUserById(String modelId);

	List<SysUser> listSeller(String storeId);

	SysUser findByUserAccount(String username, String password);

}
