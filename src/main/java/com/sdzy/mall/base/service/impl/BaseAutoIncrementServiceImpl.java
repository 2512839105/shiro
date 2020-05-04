package com.sdzy.mall.base.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdzy.mall.base.mapper.BaseAutoIncrementDAO;
import com.sdzy.mall.base.service.BaseAutoIncrementService;



/**
 * @author dingjifeng
 * @create 2017-07-14 9:13
 **/
@Service
public class BaseAutoIncrementServiceImpl implements BaseAutoIncrementService {

    @Resource
    BaseAutoIncrementDAO baseAutoIncrementDAO;

    @Override
    public String createAutoNo(String prefix, String storeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("prefix", prefix);
        map.put("storeId", storeId);
        baseAutoIncrementDAO.createAutoNo(map);
        return map.get("returnVal").toString();
    }

	@Override
	public String selectNowNo() {
		return baseAutoIncrementDAO.selectNowNo();
	}
    
    
}
