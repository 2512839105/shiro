package com.sdzy.xiaomi.report.service.impl;


import java.io.Serializable;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.report.model.Sysoperatelog;
import com.sdzy.xiaomi.report.mapper.SysoperatelogMapper;
import com.sdzy.xiaomi.report.service.SysoperatelogService;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-06-07
 */
@Service
public class SysoperatelogServiceImpl extends BaseServiceImpl<SysoperatelogMapper, Sysoperatelog> implements SysoperatelogService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public Sysoperatelog insertOrUpdateModel(Sysoperatelog model) {
		if(StringUtil.isEmpty(model.getLogId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			Sysoperatelog temp = this.selectById(model.getLogId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<Sysoperatelog>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<Sysoperatelog> page = new Page<Sysoperatelog>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<Sysoperatelog> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


}
