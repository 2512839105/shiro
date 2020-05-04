package com.sdzy.shiro;

 
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.asdzy.purpleredgourd.system.shiro.CustomerUsernamePasswordToken;
import com.sdzy.shiro.noUser.User;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.base.mapper.SysUserMapper;
import com.sdzy.xiaomi.base.service.SysUserService;

import java.util.Map;
import java.util.stream.Collectors;

//实现AuthorizingRealm接口的用户认证
public class MyShiroRealm extends AuthorizingRealm {

  
	@Autowired
	SysUserMapper  sysUserMapper;
	@Autowired
	SysUserService sysUserService;
    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的账号
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        CustomerUsernamePasswordToken customerToken =null ;

        if(username!=null){
        	customerToken= (CustomerUsernamePasswordToken) token;
        }else{
        	 
        }

        String previousPassword=customerToken.getPreviousPassword();
        String storeCode=customerToken.getStoreCode();
        String storeId=customerToken.getStoreCode();
        String userName=customerToken.getUsername();
        //查询用户名称
        //通过username从数据库中查找user对像
        //实际项目中，这里可以根据实际清况做缓存，如果不做，shiro自己也是有时间间隔机制，2分钟不会执行该方法
 
       SysUser userInfo = sysUserService.findByUserAccount(username, password);
         
        //账号不存在
        if(userInfo == null) throw new UnknownAccountException("门店编号或账号或密码不正确");
        //密码错误
      //  if(!password.equals(userInfo.getPassword())) throw new IncorrectCredentialsException("门店编号或账号或密码不正确");
        //账号刪除
        if(userInfo.getDeleteFlag() == -1)throw new DisabledAccountException("账号已被删除");
        //mac地址不匹配
         //账号锁定
        if(userInfo.getStatus() == 0)throw new LockedAccountException("账号已被锁定,请联系管理员");
         if(userInfo == null){
            return  null;
        }else{
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userInfo,//用户名
                    password,//密码
                    getName()
            );
            return authenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User)principalCollection.getPrimaryPrincipal();
     
        return authorizationInfo;
    }
}
