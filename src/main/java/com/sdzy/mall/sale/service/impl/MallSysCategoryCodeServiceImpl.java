package com.sdzy.mall.sale.service.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.asdzy.common.mybatisplus.MyBatisPlusUtil;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.mall.sale.mapper.MallSysCategoryCodeMapper;
import com.sdzy.mall.sale.model.MallSysCategoryCode;
import com.sdzy.mall.sale.service.MallSysCategoryCodeService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
@Service
public class MallSysCategoryCodeServiceImpl extends BaseServiceImpl<MallSysCategoryCodeMapper, MallSysCategoryCode> implements MallSysCategoryCodeService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public MallSysCategoryCode insertOrUpdateModel(MallSysCategoryCode model) {
		if(StringUtil.isEmpty(model.getCodeId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			MallSysCategoryCode temp = this.selectById(model.getCodeId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<MallSysCategoryCode>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<MallSysCategoryCode> page = new Page<MallSysCategoryCode>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<MallSysCategoryCode> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


    @Override
    public List<Map<String, Object>> selectOnlineSaleDrug(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return baseMapper.selectOnlineSaleDrug(map);
    }


}
