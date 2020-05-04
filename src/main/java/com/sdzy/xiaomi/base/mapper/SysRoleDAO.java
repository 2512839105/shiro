package com.sdzy.xiaomi.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.asdzy.common.model.Query;
import com.sdzy.xiaomi.base.entity.SysRole;
import com.sdzy.xiaomi.base.entity.vo.SysRoleExample;


@Repository
public interface SysRoleDAO {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

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
    SysRole findById(String modelId);

    /**
     * 根据参数查询单个实体
     */
    SysRole findByParam(Map<String, Object> paramMap);

    /**
     * 根据参数分页查询
     */
    List<SysRole> listByPage(Map<String, Object> paramMap);

    /**
     * 根据参数查询List
     */
    List<SysRole> listByParam(Map<String, Object> paramMap);

    /**
     * 根据用户id查询所有角色
     * @param userId
     * @return
     */
    List<String> listUserRoles(String userId);
    
    /**
     * 根据用户id查询所有角色
     * @param userId
     * @return
     */
    List<SysRole> listUserRoleNames(String userId);

    /**
     * 根据关键字查询
     * @param map
     * @return
     */
    List listRolesByKeyword(Map<String, Object> map);

    List<SysRole> listIdAndName(Query query);
    
    
    List<String> getRoleNames(String userId);
    
    
}