package com.sdzy.redis_shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sdzy.shiro.MyShiroRealm;
import com.sdzy.shiro.PhoneRealm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@Configuration
public class ShiroConfigurations {/*
	@Value("${spring.redis.host}")
	private String redisHost;
	 
	@Value("${spring.redis.port}")
	private int redisPort;
	 
	@Value("${spring.redis.password}")
	private String redisPassword;
	 
	@Value("${shiro.session.expire}")
	private int expire;
 
	
    //将自己的验证方式加入容器
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
    
    //将phone的验证方式加入容器
    @Bean
    public PhoneRealm phoneRealm(){
    	PhoneRealm phoneRealm = new PhoneRealm();
        return phoneRealm;
    }

    //权限管理，配置主要的Reamlm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //多realm
        List<Realm> realms = new ArrayList<>();
        realms.add(myShiroRealm());//多realm 认证时在上面的先认证，认证不通过 再到下一个realm认证.
        realms.add(phoneRealm());
        securityManager.setRealms(realms);
        //securityManager.setRealm(myShiroRealm()); 单个realm 配置
        
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    //Filter工厂,设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //拦截器
        Map<String, String> map = new LinkedHashMap<>();
        //匹配不会被拦截的链接 顺序判断
        map.put("/static/**","anon");
        map.put("/logins", "anon");
        map.put("/plogin", "anon");
        map.put("/getCode", "anon");
        
        map.put("/base/loginByPhone.action","anon");
        map.put("/base/loginByPassword.action","anon");

        map.put("/views/logoin.jsp", "anon");
        //配置退出过滤器，其中的具体的退出代码shiro已经帮我们实现了
        map.put("/logout","logout");
        
        //过滤链定义，从上向下自习，一般将/**放在最下面
        //authc所有url都必须通过认证才可以访问；anon所有url可以访问
        map.put("/**","authc");
        //如果不设置默认会自动寻找web工程根目录下的“/login.jsp”页面
       /// shiroFilterFactoryBean.setLoginUrl("/views/logoin.jsp");report/report/sale/listReport.action?appid=wx6061d5a96520f166&secrect=5c5ee5e5b9165db90960a124573baa93&grant_type=authorization_code&dateType=w&storeId=
        shiroFilterFactoryBean.setLoginUrl("/views/logoin.jsp");
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

 

    *//**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     *//*
 
    *//**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     *//*
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    *//**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     *//*
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost");
        redisManager.setPort(6379);
        redisManager.setExpire(1800);// 配置缓存过期时间
         // redisManager.setPassword(password);
        return redisManager;
    }

    *//**
     * Session Manager
     * 使用的是shiro-redis开源插件
     *//*
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    *//**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     *//*
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    *//**
     * 限制同一账号登录同时登录人数控制
     *
     * @return
     *//*
    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter() {
        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
        kickoutSessionControlFilter.setCacheManager(cacheManager());
        kickoutSessionControlFilter.setSessionManager(sessionManager());
        kickoutSessionControlFilter.setKickoutAfter(false);
        kickoutSessionControlFilter.setMaxSession(1);
        kickoutSessionControlFilter.setKickoutUrl("/auth/kickout");
        return kickoutSessionControlFilter;
    }


    *//***
     * 授权所用配置
     *
     * @return
     *//*
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    *//***
     * 使授权注解起作用不如不想配置可以在pom文件中加入
     * <dependency>
     *<groupId>org.springframework.boot</groupId>
     *<artifactId>spring-boot-starter-aop</artifactId>
     *</dependency>
     * @param securityManager
     * @return
     *//*
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    *//**
     * Shiro生命周期处理器
     *
     *//*
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

 
 
   
*/}
