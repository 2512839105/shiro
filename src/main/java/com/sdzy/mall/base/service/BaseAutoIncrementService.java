package com.sdzy.mall.base.service;

/**
 * @author dingjifeng
 * @create 2017-07-14 9:12
 **/
public interface BaseAutoIncrementService {
    String createAutoNo(String prefix, String storeId);
    
    String selectNowNo();
}
