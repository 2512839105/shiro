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
import com.sdzy.xiaomi.report.mapper.GspMeasureDeviceCheckRecordMapper;
import com.sdzy.xiaomi.report.model.GspEquipmentMaintainRecord;
import com.sdzy.xiaomi.report.model.GspMeasureDeviceCheckRecord;
import com.sdzy.xiaomi.report.model.GspMeasuringDeviceInfo;
import com.sdzy.xiaomi.report.service.GspMeasureDeviceCheckRecordService;
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
 * @since 2018-07-02
 */
@Service
public class GspMeasureDeviceCheckRecordServiceImpl extends BaseServiceImpl<GspMeasureDeviceCheckRecordMapper, GspMeasureDeviceCheckRecord> implements GspMeasureDeviceCheckRecordService {

  
	@Override
	public boolean delectByrecordId(Serializable measureCheckId,String js_code,String appid,String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
				boolean returnValue=false;
				//TODO:加入删除前的判断		
				returnValue = this.deleteById(measureCheckId);
				return returnValue;
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		return false;
	}

	@Override
	public GspMeasureDeviceCheckRecord updateByrecordId(String data,String js_code,String appid,String secrect) {
		// TODO Auto-generated method stub		
		try {
			
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
					
				GspMeasureDeviceCheckRecord	model=JSON.parseObject(data,GspMeasureDeviceCheckRecord.class);
				//TODO:设置需要修改的字段
				this.updateById(model);
		 
				return model;				
			}
		} catch (IOException e) {
			throw new CustomerException();
		}
	  return null;
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
		throw new CustomerException(e+"参数验证异常");
	}
	  return null;
 
	}

 

}
