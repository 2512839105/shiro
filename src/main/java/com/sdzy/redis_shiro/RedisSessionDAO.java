package com.sdzy.redis_shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;

 

/**
 * redis处理
 */
 
public class RedisSessionDAO extends AbstractSessionDAO{

	private static final Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

 /*
	@Autowired
	private RedisTemplate<String, Session> redisTemplate;

	private static final String KEY = "redisShareSessionMap";
	
	@Override
	public void update(Session session) throws UnknownSessionException {
		if(session ==null || session.getId() ==null){
			logger.error("update错误，session为空"+JSON.toJSONString(session));
		}else{
			redisTemplate.boundHashOps(KEY).put(session.getId().toString(), session);
		}
	}

 
	@Override
	public void delete(Session session) {
		if(session ==null || session.getId() ==null){
			logger.error("delete错误，session为空"+JSON.toJSONString(session));
		}else{
			redisTemplate.boundHashOps(KEY).delete(session.getId().toString());
		} 
	}

	@Override
	public Collection<Session> getActiveSessions() {
		List<Session> list = new ArrayList<>();
        List<Object> values = redisTemplate.boundHashOps(KEY).values();
        for (Object object : values) {
            list.add((Session) object);
        }
        return list;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        //添加进redis
        redisTemplate.boundHashOps(KEY).put(sessionId.toString(), session);
        return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if(sessionId ==null ){
			logger.error("doReadSession错误，缺少sessionId");
			return null;
		}
		return(Session) redisTemplate.boundHashOps(KEY).get(sessionId);
	}

 */
}
