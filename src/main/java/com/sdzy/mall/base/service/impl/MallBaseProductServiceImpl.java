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
import com.sdzy.mall.base.mapper.MallBaseProductMapper;
import com.sdzy.mall.base.model.MallBaseProduct;
import com.sdzy.mall.base.service.MallBaseProductService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
@Service
public class MallBaseProductServiceImpl extends BaseServiceImpl<MallBaseProductMapper, MallBaseProduct> implements MallBaseProductService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public MallBaseProduct insertOrUpdateModel(MallBaseProduct model) {
		if(StringUtil.isEmpty(model.getProductId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			MallBaseProduct temp = this.selectById(model.getProductId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	
	
	@Override
	public  Page<MallBaseProduct>  selectModelsByPage(QueryParams queryParams) {
		//查询条件构造器
		//MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
		//where appkey=${obj.appkey} and state=${obj.state}
		//MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"}, "appkey","state")
		//where appkey=value1 And state=value2
		//MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new Filter("state",OpType.GE,"value2"))
		//where appkey=value1 And state>=value2
		
		Page<MallBaseProduct> page = new Page<MallBaseProduct>(queryParams.getCurrent(), queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
		 
		Wrapper<MallBaseProduct> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());
		 
		return this.selectPage(page, wrapper);
	}


    @Override
    public Page selectProductByCategory(Integer offset,Integer current,Integer limit,Map<String, Object> map) {
        // TODO Auto-generated method stub
        
        String order = "createDate";
       
        Page page = new Page(current, limit,order, true);
        List<Map<String,Object>> selectProductByCategory = baseMapper.selectProductByCategory(page,map);
        
        page.setRecords(selectProductByCategory);
        
        return page;
    }


    @Override
    public Page selectProductAndStore(Integer offset, Integer current, Integer limit,boolean isAsc,String orderType ,Map<String, Object> map) {
       
        Page page = new Page(current, limit,orderType,isAsc);
        
        page.setRecords(baseMapper.selectProductAndStore(page,map));
        
        return page;
    }


    @Override
    public Map<String, Object> selectProductById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return baseMapper.selectProductById(map);
    }


}
