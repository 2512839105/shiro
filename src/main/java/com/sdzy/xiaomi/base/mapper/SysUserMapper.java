package com.sdzy.xiaomi.base.mapper;

 
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenxin
 * @since 2018-05-25
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	
		Map<String,String> selectStoreId(String storeAccount);
		String selectUserAccount(@Param("storeId")String storeId,@Param("userAccount")String userAccount);
		SysUser selectUserPassword(@Param("storeId")String storeId,@Param("userAccount")String userAccount,@Param("password")String password);
		SysUser selectByphoneNumber(String phoneNumber);
		
		List<Map<String,String>> selectByStoreId(String storeId);
		
		SysUser findById(String modelId);
		Map<String,String> selectStore(String storeId);
	 
		void insert(@Param("wxAccount")String wxAccount, @Param("wxName")String wxName, @Param("isAllowWxLogin")int isAllowWxLogin,@Param("userId")String userId);
		Map<String,Object> selectByAccount(@Param("storeId")String storeId,@Param("userAccount")String userAccount);
		List<SysUser> listByParam(Map<String, Object> paramMap);
	
		SysUser findByUserAccount(Map<String,Object> map);
		
		SysUser findByPhone(String mobile);
		

}
