package com.sdzy.xiaomi.user.service;

import com.sdzy.xiaomi.user.model.BaseMember;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-03
 */
public interface BaseMemberService extends IService<BaseMember> {

  
	String selectMemberByStoreId(String storeId, String js_code, String appid, String secrect);
    BaseMember findById(String modelId);
    /**
     * 根据会员编号查询数据
     */
    BaseMember findByMemberNo(String memberNo,String storeId);


}
