package com.sdzy.xiaomi.user.mapper;

import com.sdzy.xiaomi.user.model.MsgSendRecord;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 短信发送记录 Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
public interface MsgSendRecordMapper extends BaseMapper<MsgSendRecord> {

	List<Map<String,String>> select();

	int addMessage(@Param("recordId")String recordId, @Param("state")Integer state,@Param("userType")Integer userType,@Param("sendUserId") String sendUserId, @Param("templateId")String templateId,
			@Param("sendTitle")String sendTitle, @Param("sendContent")String sendContent, @Param("sendDate")String sendDate, @Param("receiveUsers")String receiveUsers, @Param("sendCount")Integer sendCount);

	List<MsgSendRecord> selectBySendUserId(@Param("sendUserId")String sendUserId);

}
