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

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.sdzy.mall.promotion.mapper.PromotionTypeDAO;
import com.sdzy.mall.promotion.model.PromotionType;
import com.sdzy.mall.promotion.service.PromotionTypeService;


@Service
public class PromotionTypeServiceImpl implements PromotionTypeService {
    @Resource
    private PromotionTypeDAO promotionTypeDAO;

    private static final Logger logger = LoggerFactory.getLogger(PromotionTypeServiceImpl.class);

    @Override
    public PromotionType insert(PromotionType model) {
        promotionTypeDAO.insert(model); 
	 return model;
    }

    
    @Override
    public PromotionType insert(PromotionType model, LocalUser currentUser) {
        Date now = DateUtil.getCurrDateTime();
		//model.setId(StringUtil.getUUID());
		//model.setCreateUserId(currentUser.getUserId());
		//model.setCreateUserName(currentUser.getUserName());
		//model.setCreateDate(now);
		//model.setModifyDate(now);
		//model.setDeleteFlag(0);
		//promotionTypeDAO.insert(model); 
		return model;
    }

    @Override
    public PromotionType findById(String modelId) {
        return promotionTypeDAO.findById(modelId);
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
		List list = promotionTypeDAO.listByPage(map);
		PageInfo pageInfo = new PageInfo(list);
		return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List<PromotionType> listByParam(Map<String, Object> paramMap) {
        return promotionTypeDAO.listByParam(paramMap);
    }

    @Override
    public PromotionType findByParam(Map<String, Object> paramMap) {
        return promotionTypeDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return promotionTypeDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return promotionTypeDAO.deleteByParam(paramMap);
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
        PromotionType model = promotionTypeDAO.findById(modelId);
		//model.setDeleteFlag(deleteFlag);
		return promotionTypeDAO.updateByPrimaryKey(model);
    }

    @Override
    public PromotionType update(PromotionType model, LocalUser user) {
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
        return promotionTypeDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return promotionTypeDAO.updateByParam(paramMap);
    }
}