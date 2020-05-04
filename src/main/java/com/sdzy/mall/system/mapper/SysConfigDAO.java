package com.sdzy.mall.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sdzy.mall.system.model.SysConfig;
import com.sdzy.mall.system.model.example.SysConfigExample;



@Repository
public interface SysConfigDAO {
    long countByExample(SysConfigExample example);

    int deleteByExample(SysConfigExample example);

    int deleteByPrimaryKey(Integer configId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(SysConfigExample example);

    SysConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    /**
     * 根据ID修改数据
     */
    int updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    int updateByParam(Map<String, Object> paramMap);

    /**
     * 根据id删除数据
     */
    int deleteById(String modelId);

    /**
     * 根据参数，任意删除
     */
    int deleteByParam(Map<String, Object> paramMap);

    /**
     * 根据id查询
     */
    SysConfig findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    SysConfig findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<SysConfig> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<SysConfig> listByParam(Map<String, Object> paramMap);

    SysConfig findByStoreId(String currStoreId);
}