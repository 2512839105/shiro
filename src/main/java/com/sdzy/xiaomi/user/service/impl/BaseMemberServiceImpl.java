package com.sdzy.xiaomi.user.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdzy.xiaomi.user.mapper.BaseMemberMapper;
import com.sdzy.xiaomi.user.model.BaseMember;
import com.sdzy.xiaomi.user.service.BaseMemberService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-03
 */
@Service
public class BaseMemberServiceImpl extends BaseServiceImpl<BaseMemberMapper, BaseMember> implements BaseMemberService {
   		
	@Override
	public String selectMemberByStoreId(String storeId,String js_code,String appid,String secrect) {
		try {
 			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
 				List<Map<String, String>> data = baseMapper.selectByStoreId(storeId);
			    ObjectMapper mapper=new ObjectMapper();
			    String string = mapper.writeValueAsString(data);
			 return string ;
			 } 
		} catch (IOException e) {
			 
			 throw new CustomerException(e+"参数验证异常");
		}
		return  BaseUtil.productJson(500,"" ,"失败");		 
	}

	@Override
	public BaseMember findById(String modelId) {
		 	return baseMapper.findById(modelId);

		 
	}

	@Override
	public BaseMember findByMemberNo(String memberNo, String storeId) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberNo" , memberNo);
		map.put("storeId" , storeId);
		List<BaseMember> baseMembers = baseMapper.findByParams(map);
		if (baseMembers == null || baseMembers.size() == 0) {
			throw new CustomerException("会员不存在!");
		}
		BaseMember baseM = baseMembers.get(0);
		return baseMembers.get(0);
	}

}
