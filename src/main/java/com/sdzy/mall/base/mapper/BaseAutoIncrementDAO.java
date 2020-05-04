package com.sdzy.mall.base.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseAutoIncrementDAO {

    void createAutoNo(Map<String, Object> map);
    String selectNowNo();

}