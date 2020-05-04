package com.sdzy.xiaomi.report.service.impl;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.mapper.GspMeasuringDeviceInfoMapper;
import com.sdzy.xiaomi.report.model.GspEquipmentUseRecord;
import com.sdzy.xiaomi.report.model.GspMeasuringDeviceInfo;
import com.sdzy.xiaomi.report.service.GspMeasuringDeviceInfoService;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

 
 
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-06-28
 */
@Service
public class GspMeasuringDeviceInfoServiceImpl extends BaseServiceImpl<GspMeasuringDeviceInfoMapper, GspMeasuringDeviceInfo> implements GspMeasuringDeviceInfoService {

 
	
	@Override
	public  Page<GspMeasuringDeviceInfo>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<GspMeasuringDeviceInfo> page = new Page<GspMeasuringDeviceInfo>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<GspMeasuringDeviceInfo> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}

	@Override
	public Page selectBystoreId(QueryParams queryParams, String storeId) {
		Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Condition> whereList = queryParams.filtersToDBConditionals();		 
	  	whereList.add(new Condition("storeId",storeId,Condition.OpType.EQ));	 
		map.put("whereList", whereList);
	    page.setRecords(baseMapper.selectBystoreId(page, map));
		return page;
	}
	
	
	@Override
	public boolean delectByrecordId(Serializable measureDeviceId) {
		boolean returnValue=false;
		//TODO:加入删除前的判断		
		returnValue = this.deleteById(measureDeviceId);
		return returnValue;

	}

	@Override
	public GspMeasuringDeviceInfo updateByrecordId(GspMeasuringDeviceInfo model) {
		GspMeasuringDeviceInfo temp = this.selectById(model.getMeasureDeviceId());
		//TODO:设置需要修改的字段
		this.updateById(model);
		model=temp;
		return model;
	}



}
