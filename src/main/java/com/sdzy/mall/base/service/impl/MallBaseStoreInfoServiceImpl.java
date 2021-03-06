package com.sdzy.mall.base.service.impl;


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
import com.sdzy.mall.base.mapper.MallBaseStoreInfoMapper;
import com.sdzy.mall.base.model.MallBaseStoreInfo;
import com.sdzy.mall.base.service.MallBaseStoreInfoService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-11
 */
@Service
public class MallBaseStoreInfoServiceImpl extends BaseServiceImpl<MallBaseStoreInfoMapper, MallBaseStoreInfo> implements MallBaseStoreInfoService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public MallBaseStoreInfo insertOrUpdateModel(MallBaseStoreInfo model) {
		if(StringUtil.isEmpty(model.getStoreId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			MallBaseStoreInfo temp = this.selectById(model.getStoreId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<MallBaseStoreInfo>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<MallBaseStoreInfo> page = new Page<MallBaseStoreInfo>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<MallBaseStoreInfo> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


    @Override
    public Page selectStoreOrderSale(Integer offset,Integer current,Integer limit) {
        // TODO Auto-generated method stub
        
        Page page = new Page(current, limit,"", false);
        
       List<Map<String, Object>> storeList = baseMapper.selectStoreOrderSale(page);
        
        page.setRecords(storeList);
        
        return page;
    }


    @Override
    public Page selectProductAndStore(Integer offset, Integer current, Integer limit,
            String orderType, Map<String, Object> map) {
        // TODO Auto-generated method stub
        Page page = new Page(current, limit,orderType, true);
        List<MallBaseStoreInfo> selectProductAndStore = baseMapper.selectProductAndStore(page, map);
        page.setRecords(selectProductAndStore);
        return page;
    }


}
