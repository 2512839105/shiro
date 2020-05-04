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
import com.sdzy.mall.promotion.mapper.PromotionGiveProductDAO;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;
import com.sdzy.mall.promotion.service.PromotionGiveProductService;
import com.sdzy.mall.util.BaseUtil;


@Service
public class PromotionGiveProductServiceImpl implements PromotionGiveProductService {
    @Resource
    private PromotionGiveProductDAO promotionGiveProductDAO;

    private static final Logger logger = LoggerFactory.getLogger(PromotionGiveProductServiceImpl.class);

    @Override
    public PromotionGiveProduct insert(PromotionGiveProduct model) {
        promotionGiveProductDAO.insert(model); 
	 return model;
    }
    

    @Override
    public PromotionGiveProduct insert(PromotionGiveProduct model, LocalUser currentUser) {
        Date now = DateUtil.getCurrDateTime();
		//model.setId(StringUtil.getUUID());
		//model.setCreateUserId(currentUser.getUserId());
		//model.setCreateUserName(currentUser.getUserName());
		//model.setCreateDate(now);
		//model.setModifyDate(now);
		//model.setDeleteFlag(0);
		//promotionGiveProductDAO.insert(model); 
		return model;
    }

    @Override
    public PromotionGiveProduct findById(String modelId) {
        return promotionGiveProductDAO.findById(modelId);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String ... params) {

		/*Map<String, Object> map = BaseUtil.getPageMap(queryParams, currentUser, false);
		List list = promotionGiveProductDAO.listByPage(map);
		PageInfo pageInfo = new PageInfo(list);
		return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List<PromotionGiveProduct> listByParam(Map<String, Object> paramMap) {
        return promotionGiveProductDAO.listByParam(paramMap);
    }

    @Override
    public PromotionGiveProduct findByParam(Map<String, Object> paramMap) {
        return promotionGiveProductDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return promotionGiveProductDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return promotionGiveProductDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer deleteByIds(String modelIds) {
        if (StringUtil.isEmpty(modelIds)){throw new CustomerException("删除失败！");}
		Integer data = 0;
		if (modelIds.contains(",")){
			String[] recordIdArr = modelIds.split(",");
			for (String modelId: recordIdArr) {
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
        PromotionGiveProduct model = promotionGiveProductDAO.findById(modelId);
		//model.setDeleteFlag(deleteFlag);
		return promotionGiveProductDAO.updateByPrimaryKey(model);
    }

    @Override
    public PromotionGiveProduct update(PromotionGiveProduct model, LocalUser user) {
        Date now = DateUtil.getCurrDateTime();
		List<Condition> whereList = new ArrayList<Condition>();
		List<Condition> updateList = new ArrayList<Condition>();
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
        return promotionGiveProductDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return promotionGiveProductDAO.updateByParam(paramMap);
    }
}