package com.sdzy.xiaomi.report.service.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.report.model.SalePayOrder;
import com.sdzy.xiaomi.report.mapper.SalePayOrderMapper;
import com.sdzy.xiaomi.report.service.SalePayOrderService;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@Service
public class SalePayOrderServiceImpl extends BaseServiceImpl<SalePayOrderMapper, SalePayOrder> implements SalePayOrderService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public SalePayOrder insertOrUpdateModel(SalePayOrder model) {
		if(StringUtil.isEmpty(model.getPayOrderId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			SalePayOrder temp = this.selectById(model.getPayOrderId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<SalePayOrder>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<SalePayOrder> page = new Page<SalePayOrder>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<SalePayOrder> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


	@Override
	public List<Map<String, Object>> listGrossProfit(String storeId, String userId, String dateType) {
	 
		return null;
	}


}
