package com.sdzy.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
 import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.sdzy.redis_shiro.RedisSessionDAO;
import com.sdzy.redis_shiro.ShiroSessionListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
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
        map.put("/statics/**","anon");
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
         shiroFilterFactoryBean.setLoginUrl("/views/logoin.jsp");//report/report/sale/listReport.action?appid=wx6061d5a96520f166&secrect=5c5ee5e5b9165db90960a124573baa93&grant_type=authorization_code&dateType=w&storeId=
        // shiroFilterFactoryBean.setSuccessUrl("/views/videoList.jsp");
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    
 
 
     
    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     */
    public RedisCacheManager cacheManager() {
      RedisCacheManager redisCacheManager = new RedisCacheManager();
      redisCacheManager.setRedisManager(redisManager());
       //redisCacheManager.setExpire(expire);//缓存过期时间：秒
      return redisCacheManager;
    }
        
     /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     */
    public RedisManager redisManager() {
      RedisManager redisManager = new RedisManager();
      redisManager.setHost(redisHost);
      redisManager.setPort(redisPort);
      redisManager.setExpire(expire);
/*      redisManager.setTimeout(30000);//连接redis超时
      if(!StringUtils._isEmpty_(redisPassword))
    	redisManager.setPassword(redisPassword);*/
      return redisManager;
    }
     
     /**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */
     @Bean
     public DefaultWebSessionManager sessionManager() {
       DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
       //删除过期的session
       sessionManager.setDeleteInvalidSessions(true);
       sessionManager.setSessionIdUrlRewritingEnabled(false);
       //使用redis存储session
       sessionManager.setSessionDAO(redisSessionDAO());
       Collection<SessionListener> list=new ArrayList<>();
       list.add(new ShiroSessionListener());
       sessionManager.setSessionListeners(list);
        return sessionManager;
     }
     
     /**
      * 配置session监听
      * @return
      */
     @Bean
     public ShiroSessionListener sessionListener(){
         ShiroSessionListener sessionListener = new ShiroSessionListener();
         return sessionListener;
     }
     /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
     @Bean
     public RedisSessionDAO redisSessionDAO() {
       RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
/*       redisSessionDAO.setExpire(expire);//session会话过期时间，默认就是1800秒*/
     //  redisSessionDAO.setRedisManager(redisManager());
       return redisSessionDAO;
     }
     
    /**
    * 凭证匹配器
    */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
      HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
      hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
      hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
      return hashedCredentialsMatcher;
    }
    

  @Bean(name = "redisTemplate")
  public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
      RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
      redisTemplate.setConnectionFactory(redisConnectionFactory);

      redisTemplate.setKeySerializer(keySerializer());
      redisTemplate.setHashKeySerializer(keySerializer());
      redisTemplate.setValueSerializer(valueSerializer());
      redisTemplate.setHashValueSerializer(valueSerializer());

 
      return redisTemplate;
  }

  private RedisSerializer<String> keySerializer() {
      return new StringRedisSerializer();
  }

  private RedisSerializer<Object> valueSerializer() {
      return new GenericJackson2JsonRedisSerializer();
  }
   
}
