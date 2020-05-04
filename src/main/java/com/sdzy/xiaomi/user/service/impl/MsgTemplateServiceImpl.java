package com.sdzy.xiaomi.user.service.impl;


import java.io.Serializable;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.mapper.MsgTemplateMapper;
import com.sdzy.xiaomi.user.model.MsgTemplate;
import com.sdzy.xiaomi.user.service.MsgTemplateService;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;


import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信模板 服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@Service
public class MsgTemplateServiceImpl extends BaseServiceImpl<MsgTemplateMapper, MsgTemplate> implements MsgTemplateService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public MsgTemplate insertOrUpdateModel(MsgTemplate model) {
		if(StringUtil.isEmpty(model.getTemplateId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			MsgTemplate temp = this.selectById(model.getTemplateId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<MsgTemplate>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<MsgTemplate> page = new Page<MsgTemplate>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<MsgTemplate> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


}
