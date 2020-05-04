package com.sdzy.xiaomi.user.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.alibaba.fastjson.JSON;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.user.model.MsgSendRecord;
import com.sdzy.xiaomi.user.mapper.MsgSendRecordMapper;
import com.sdzy.xiaomi.user.service.MsgSendRecordService;
import com.sdzy.xiaomi.util.BaseUtil;

import ch.qos.logback.classic.pattern.Util;

import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

/**
 * <p>
 * 短信发送记录 服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@Service
public class MsgSendRecordServiceImpl extends BaseServiceImpl<MsgSendRecordMapper, MsgSendRecord> implements MsgSendRecordService {

    @Override
	public boolean selectPhoneNumber(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public MsgSendRecord insertOrUpdateModel(MsgSendRecord model) {
		if(StringUtil.isEmpty(model.getRecordId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			MsgSendRecord temp = this.selectById(model.getRecordId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<MsgSendRecord>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<MsgSendRecord> page = new Page<MsgSendRecord>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<MsgSendRecord> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


 

	     
	@Override
	public String addMessage(String data, String js_code, String appid, String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){		
				MsgSendRecord model=JSON.parseObject(data,MsgSendRecord.class); 		          
				model.setTemplateId("");			
				String recordId=StringUtil.getUUID();
				Integer state= 1;
			    Integer userType = model.getSendUserType();
			    String sendUserId = model.getSendUserId();
			    String templateId = model.getTemplateId();
			    String sendTitle = model.getSendTitle();
			    String sendContent = model.getSendContent();
			    String sendDate = model.getSendDate();
			    String receiveUsers = model.getReceiveUsers();			    			    
			    Integer sendCount=model.getSendCount();			      
			    baseMapper.addMessage(recordId,state,userType,sendUserId,templateId,sendTitle,sendContent,sendDate,receiveUsers,sendCount);
			    return BaseUtil.productJson(200, "","添加成功");
			}
		} catch (IOException e) {			 
			throw new CustomerException(e+"参数校验失败");	 
		}  		    
		return BaseUtil.productJson(500, "","添加失败");
	}


	@Override
	public String selectBySendUserId(String sendUserId, String js_code, String appid, String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){					     			   
			     try {
			    	  List<MsgSendRecord> data = baseMapper.selectBySendUserId(sendUserId);			    	  
					    ObjectMapper mapper=new ObjectMapper();
					    String string = mapper.writeValueAsString(data);
					return string;
				} catch (JsonProcessingException e) {					
					e.printStackTrace();
				}
			 }
		} catch (IOException e) {			 
			throw new CustomerException(e+"参数校验失败");	 
		}  	   
		return BaseUtil.productJson(500, "","");
	
	}


}
