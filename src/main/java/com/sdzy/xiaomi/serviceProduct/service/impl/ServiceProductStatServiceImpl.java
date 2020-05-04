package com.sdzy.xiaomi.serviceProduct.service.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.serviceProduct.model.ServiceProductStat;
import com.sdzy.xiaomi.serviceProduct.mapper.ServiceProductStatMapper;
import com.sdzy.xiaomi.serviceProduct.service.ServiceProductStatService;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户服务产品汇总 服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-30
 */
@Service
public class ServiceProductStatServiceImpl extends BaseServiceImpl<ServiceProductStatMapper, ServiceProductStat> implements ServiceProductStatService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public ServiceProductStat insertOrUpdateModel(ServiceProductStat model) {
		if(StringUtil.isEmpty(model.getStatId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			ServiceProductStat temp = this.selectById(model.getStatId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<ServiceProductStat>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<ServiceProductStat> page = new Page<ServiceProductStat>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<ServiceProductStat> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


	@Override
	public Map<String, String> selectBybuyerId(String buyerId) {
		
		return baseMapper.selectBybuyerId(buyerId);
	}


}
