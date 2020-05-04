package com.sdzy.redis_shiro;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
/**
 * 步骤3：发现用户推出后，Session没有从Redis中销毁，虽然当前重新new了一个，但会对统计带来干扰，通过SessionListener解决这个问题
 * @author charlin
 */
public class ShiroSessionListener implements SessionListener {

    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionListener.class);

    @Autowired
    private RedisSessionDAO redisSessionDAO;

    @Override
    public void onStart(Session session) {
        // 会话创建时触发
        logger.info("ShiroSessionListener session {} 被创建", session.getId());
    }

    @Override
    public void onStop(Session session) {
        redisSessionDAO.delete(session);
        //RedisUtil redisUtil=(RedisUtil) SpringContext.getBean("redisUtil");
        //redisUtil.remove(session.getId().toString());
    }

    @Override
    public void onExpiration(Session session) {
        redisSessionDAO.delete(session);
        //会话过期时触发
        logger.info("ShiroSessionListener session {} 过期", session.getId());
    }
}