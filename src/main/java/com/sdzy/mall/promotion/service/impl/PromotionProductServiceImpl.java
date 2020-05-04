package com.sdzy.mall.promotion.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asdzy.common.enums.Status;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.sdzy.mall.promotion.mapper.PromotionProductDAO;
import com.sdzy.mall.promotion.model.PromotionProduct;
import com.sdzy.mall.promotion.service.PromotionProductService;


@Service
public class PromotionProductServiceImpl implements PromotionProductService {
    @Resource
    private PromotionProductDAO promotionProductDAO;

    private static final Logger logger = LoggerFactory.getLogger(PromotionProductServiceImpl.class);

    @Override
    public PromotionProduct insert(PromotionProduct model) {
        promotionProductDAO.insert(model); 
	 return model;
    }
    

    @Override
    public PromotionProduct insert(PromotionProduct model, LocalUser currentUser) {
        Date now = DateUtil.getCurrDateTime();
		//model.setId(StringUtil.getUUID());
		//model.setCreateUserId(currentUser.getUserId());
		//model.setCreateUserName(currentUser.getUserName());
		//model.setCreateDate(now);
		//model.setModifyDate(now);
		//model.setDeleteFlag(0);
		//promotionProductDAO.insert(model); 
		return model;
    }

    @Override
    public PromotionProduct findById(String modelId) {
        return promotionProductDAO.findById(modelId);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String ... params) {
    	/*List<Condition> whereList = queryParams.filtersToDBConditionals();		
    	whereList.add(Condition.createEq("storeId",currentUser.getStoreId()));
    	PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
		if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
			PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
		}	
		//whereList.add(Condition.createEq("deleteFlag",0));
		//whereList.add(Condition.create("IFNULL(deleteFlag,'')", -1 , Condition.OpType.NE));
		//whereList.add(Condition.createEq("typeFlag",params[0]));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		List list = promotionProductDAO.listByPage(map);
		PageInfo pageInfo = new PageInfo(list);*/
		return new DataGrid();
    }

    @Override
    public List<PromotionProduct> listByParam(Map<String, Object> paramMap) {
        return promotionProductDAO.listByParam(paramMap);
    }

    @Override
    public PromotionProduct findByParam(Map<String, Object> paramMap) {
        return promotionProductDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return promotionProductDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return promotionProductDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer deleteByIds(String modelIds) {
        if (StringUtil.isEmpty(modelIds)){throw new CustomerException("删除失败！");}
		Integer data = 0;
		if (modelIds.contains(",")){
			String[] recordIdArr = modelIds.split(",");
			for (String modelId: recordIdArr) {
				//Integer count = this.deleteById(modelId);
				Integer count = this.updateDeleteStatus(modelId, -1 );
				data += count;
			}
		}else{
			data = this.updateDeleteStatus(modelIds, -1);
		}
		return data;
    }

    @Override
    public Integer updateDeleteStatus(String modelId, int deleteFlag) {
        PromotionProduct model = promotionProductDAO.findById(modelId);
		//model.setDeleteFlag(deleteFlag);
		return promotionProductDAO.updateByPrimaryKey(model);
    }

    @Override
    public PromotionProduct update(PromotionProduct model, LocalUser user) {
        Date now = DateUtil.getCurrDateTime();
		List<Condition> whereList = new ArrayList<Condition>();
		List<Condition> updateList = new ArrayList<Condition>();
		// whereList.add(Condition.createEq("id", model.getId()));
		updateList.add(Condition.createEq("modifyDate",now));
		// TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		map.put("updateList", updateList);
		this.updateByParam(map);
		return model;
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return promotionProductDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return promotionProductDAO.updateByParam(paramMap);
    }

    @Override
    public List<PromotionProduct> getPromotionProductsAndGiveProducts(String modelId, String storeId) {
        return promotionProductDAO.getPromotionProductsAndGiveProducts(modelId, storeId);
    }

    /**
     * 查询所有的促销产品信息
     * 1、如果赠品在库存里不存在的，不查询
     * @return
     */
    @Override
    public List listPromotionProduct() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", SessionUtil.getLocalUser().getStoreId());
        map.put("status", Status.NORMAL.getValue());
        List<PromotionProduct> promotionProductList = promotionProductDAO.listPromotionProductsAndGiveProducts(map);
        return  promotionProductList;
    }
}