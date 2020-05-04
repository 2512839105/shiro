package com.sdzy.mall.stock.service.impl;

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
import com.sdzy.mall.stock.mapper.StockBatchHistoryDAO;
import com.sdzy.mall.stock.model.StockBatchHistory;
import com.sdzy.mall.stock.service.StockBatchHistoryService;


@Service
public class StockBatchHistoryServiceImpl implements StockBatchHistoryService {

    @Resource
    private StockBatchHistoryDAO stockBatchHistoryDAO;

    private static final Logger logger = LoggerFactory.getLogger(StockBatchHistoryServiceImpl.class);

    @Override
    public StockBatchHistory insert(StockBatchHistory model) {
        stockBatchHistoryDAO.insert(model); 
	 return model;
    }

    @Override
    public StockBatchHistory insert(StockBatchHistory model, LocalUser currentUser) {
        Date now = DateUtil.getCurrDateTime();
		//model.setId(StringUtil.getUUID());
		//model.setCreateUserId(currentUser.getUserId());
		//model.setCreateUserName(currentUser.getUserName());
		//model.setStoreId(currentUser.getStoreId());
		//model.setStoreName(currentUser.getStoreName());
		//model.setCreateDate(now);
		//model.setModifyDate(now);
		//model.setDeleteFlag(0);
		//stockBatchHistoryDAO.insert(model); 
		return model;
    }

    @Override
    public StockBatchHistory findById(String modelId) {
        return stockBatchHistoryDAO.findById(modelId);
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
		List list = stockBatchHistoryDAO.listByPage(map);
		PageInfo pageInfo = new PageInfo(list);
		return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List<StockBatchHistory> listByParam(Map<String, Object> paramMap) {
        return stockBatchHistoryDAO.listByParam(paramMap);
    }

    @Override
    public StockBatchHistory findByParam(Map<String, Object> paramMap) {
        return stockBatchHistoryDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return stockBatchHistoryDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return stockBatchHistoryDAO.deleteByParam(paramMap);
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
    public Integer audit(String[] modelIds) {
        if(modelIds == null || modelIds.length == 0) throw new CustomerException("审核失败!");
		List<Condition> updateList = new ArrayList<Condition>();
		List<Condition> whereList = new ArrayList<Condition>();
		//whereList.add(Condition.create("supplierId", modelIds, Condition.OpType.IN));
		//updateList.add(Condition.create("auditState", "1" , Condition.OpType.EQ));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("updateList", updateList);
		map.put("whereList", whereList);
		return stockBatchHistoryDAO.updateByParam(map);
    }

    @Override
    public Integer updateDeleteStatus(String modelId, int deleteFlag) {
        StockBatchHistory model = stockBatchHistoryDAO.findById(modelId);
		model.setDeleteFlag(deleteFlag);
		return stockBatchHistoryDAO.updateByPrimaryKey(model);
    }

    @Override
    public StockBatchHistory update(StockBatchHistory model, LocalUser user) {
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
        return stockBatchHistoryDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByPrimaryKeySelective(StockBatchHistory model, LocalUser user) {
        Date now = DateUtil.getCurrDateTime();
		model.setModifyDate(now);
		//model.setModifyUserId(user.getUserId());
		//model.setModifyUserName(user.getUserName());
		return  stockBatchHistoryDAO.updateByPrimaryKeySelective(model);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return stockBatchHistoryDAO.updateByParam(paramMap);
    }
}