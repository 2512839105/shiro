package com.sdzy.xiaomi.user.mapper;

 
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.model.BaseMember;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-03
 */
public interface BaseMemberMapper extends BaseMapper<BaseMember> {

	List<Map<String,String>> selectByStoreId(String storeId);
    BaseMember findById(String modelId);
	List<BaseMember> findByParams(Map<String, Object> map);


}
