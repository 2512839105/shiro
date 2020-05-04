package com.sdzy.xiaomi.report.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.mapper.GspEquipmentUseRecordMapper;
import com.sdzy.xiaomi.report.model.GspEquipmentUseRecord;
import com.sdzy.xiaomi.report.model.GspRoomTemperatureRecord;
import com.sdzy.xiaomi.report.service.GspEquipmentUseRecordService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.alibaba.fastjson.JSON;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

 
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-06-28
 */
@Service
public class GspEquipmentUseRecordServiceImpl extends BaseServiceImpl<GspEquipmentUseRecordMapper, GspEquipmentUseRecord> implements GspEquipmentUseRecordService {

 
	
	
	@Override
	public  Page<GspEquipmentUseRecord>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<GspEquipmentUseRecord> page = new Page<GspEquipmentUseRecord>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<GspEquipmentUseRecord> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}

	@Override
	public Page selectBystoreId(QueryParams queryParams, String storeId,String js_code,String appid,String secrect) {
	    try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){		
			    Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<Condition> whereList = queryParams.filtersToDBConditionals();		 
			  	whereList.add(new Condition("storeId",storeId,Condition.OpType.EQ));	 
				map.put("whereList", whereList);
			    page.setRecords(baseMapper.selectBystoreId(page, map));
				return page;
			}
		} catch (IOException e) {
		   throw new CustomerException(e+"参数验证失败");
		}
	    return null;
			
	}

	@Override
	public boolean delectByrecordId(Serializable userRecordId,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				boolean returnValue=false;
				//TODO:加入删除前的判断		
				returnValue = this.deleteById(userRecordId);
				return returnValue;
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return false;
	}

	@Override
	public GspEquipmentUseRecord updateByrecordId( String data,String js_code,String appid,String secrect) {
		try {
			
			 if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			
			GspEquipmentUseRecord model=JSON.parseObject(data,GspEquipmentUseRecord.class);
			//TODO:设置需要修改的字段
			this.updateById(model);
			return model;
			 }
				
		} catch (IOException e) {
			throw new CustomerException();
		}
	  return null;
	}


}
