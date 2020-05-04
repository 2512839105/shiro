package com.sdzy.xiaomi.user.service;

import com.sdzy.xiaomi.user.model.MsgSendRecord;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 短信发送记录 服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
public interface MsgSendRecordService extends IService<MsgSendRecord> {

    /**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean selectPhoneNumber(Serializable id);


	/**
	 * 新增或者更新实体，存在主键为更新，反正新增
	 * @param api
	 * @return
	 */
	MsgSendRecord insertOrUpdateModel(MsgSendRecord msgSendRecord);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<MsgSendRecord> selectModelsByPage(QueryParams queryParams);


 

	String  addMessage(String data, String js_code, String appid, String secrect);


	String selectBySendUserId(String sendUserId, String js_code, String appid, String secrect);
}
