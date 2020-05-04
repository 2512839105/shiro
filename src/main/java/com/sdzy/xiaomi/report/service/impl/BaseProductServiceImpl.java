package com.sdzy.xiaomi.report.service.impl;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.security.auth.message.callback.PrivateKeyCallback.IssuerSerialNumRequest;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.Condition.OpType;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.alibaba.fastjson.JSON;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.report.model.BaseProduct;
import com.sdzy.xiaomi.report.mapper.BaseProductMapper;
import com.sdzy.xiaomi.report.service.BaseProductService;
import com.sdzy.xiaomi.user.model.MsgSendRecord;
import com.sdzy.xiaomi.util.BaseUtil;
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
public class BaseProductServiceImpl extends BaseServiceImpl<BaseProductMapper, BaseProduct> implements BaseProductService {

    @Override
	public boolean deleteModelById(Serializable id) {
		boolean returnValue=false;
		//TODO:加入删除前的判断
		
		returnValue = this.deleteById(id);
		return returnValue;
	}
	
 
	@Override
	public BaseProduct insertOrUpdateModel(BaseProduct model) {
		if(StringUtil.isEmpty(model.getProductId())){
			//TODO:新增前做相应处理
			this.insert(model);
		}else{
			BaseProduct temp = this.selectById(model.getProductId());
			//TODO:设置需要修改的字段
			this.updateById(temp);
			model=temp;
		}
		return model;
	}
	
	@Override
	public  Page<BaseProduct>  selectModelsByPage(QueryParams queryParams,String keyword,String price, String storeId, String js_code, String appid, String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			
			Page  page = new Page(queryParams.getCurrent(),queryParams.getLimit(),queryParams.getSort(), queryParams.isAsc());
			Map<String, Object> map = new HashMap<String, Object>();		
			List<Condition> whereList = queryParams.filtersToDBConditionals();
			if(storeId!=null&&!storeId.equals("")){
			  	whereList.add(new Condition("storeId",storeId,Condition.OpType.EQ));			  			  	
				}
			    if(keyword!=null&&!keyword.equals("")){
				    if(BaseUtil.isInteger(keyword)){
					  whereList.add(new Condition("productCode", keyword,OpType.LK));	
				    }else{		    	
						 whereList.add(new Condition("productName", keyword,OpType.LK));	
				    }
			    }
				if(price.equals("1")) {  //1 降价 2 是升价    
					  whereList.add(new Condition("tradeOldPrice","tradePrice",OpType.LT));
				 }else if(price.equals("2")){
					 whereList.add(new Condition("tradeOldPrice","tradePrice",OpType.GT));
				 }
			map.put("whereList", whereList);
			return page.setRecords(baseMapper.baseProduct(page,map));
			}
		} catch (IOException e) {
			 throw new CustomerException(e+"微信参数验证异常");
		}
		 return null;
	}
	 
	@Override
	public List<Map<String, Object>> listNewProduct(String storeId, String userId, String beginDate, String endDate) {
		 
		if(storeId==null)
		{
			throw new CustomerException("门店编号不能为空！");
		}
		return baseMapper.selectBaseProductByMonth(storeId);
	}


	@Override
	public String updateProduct(String data, String js_code, String appid, String secrect) {
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				BaseProduct model=JSON.parseObject(data,BaseProduct.class);													
				
				int result=baseMapper.updateProduct(model.getStoreId(),model.getProductId(),model.getLocalRetailPrice(),model.getMemberPrice());
							
				return result+"";
				
			}
		} catch (IOException e) {
			 
			throw new CustomerException(e+"微信参数验证异常");
			
		}
		return BaseUtil.productJson(500,"","微信参数验证失败");
	}


	@Override
	public List<Map<String, String>> selectProductByCodeOrName(String storeId, String keyword, String js_code,
			String appid, String secrect) {
		 
		try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){			 
				return baseMapper.selectProductByCodeOrName(storeId,keyword);				
			}
		} catch (IOException e) {			 
			throw new CustomerException(e+"微信参数验证异常");
			
		}
		return null;
	}

	 
}
