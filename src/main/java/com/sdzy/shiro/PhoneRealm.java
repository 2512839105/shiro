package com.sdzy.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.asdzy.common.exception.CustomerException;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.base.mapper.SysUserMapper;

public class PhoneRealm extends AuthorizingRealm  {

	@Autowired
	SysUserMapper sysUserMapper;
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		PhoneToken token = null;

			 
            token = (PhoneToken) principals;

        String phone = (String) token.getPrincipal();

        SysUser user = sysUserMapper.findByPhone(phone);
 
        return (AuthorizationInfo) new SimpleAuthenticationInfo(user, phone, this.getName());

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//Use phoneToken =(PhoneToken)token;
		// new String((char[]) token.getCredentials());
		  String phone=new String((char[]) token.getCredentials());
/*           if(true){
           	throw new CustomerException("werwrw");
           }*/
             
	        SysUser user = sysUserMapper.findByPhone(phone);
	        if(user == null) throw new UnknownAccountException("手机号不存在");
	        return new SimpleAuthenticationInfo(user, phone, this.getName());
	}
	

 
 

}
