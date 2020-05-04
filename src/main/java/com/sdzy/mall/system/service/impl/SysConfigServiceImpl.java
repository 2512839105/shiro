package com.sdzy.mall.system.service.impl;

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
import com.sdzy.mall.system.mapper.SysConfigDAO;
import com.sdzy.mall.system.model.SysConfig;
import com.sdzy.mall.system.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigDAO sysConfigDAO;

    private static final Logger logger = LoggerFactory.getLogger(SysConfigServiceImpl.class);

    @Override
    public SysConfig insert(SysConfig model) {
        sysConfigDAO.insert(model); 
	 return model;
    }

    @Override
    public SysConfig insert(SysConfig model, LocalUser currentUser) {
        Date now = DateUtil.getCurrDateTime();
		//model.setId(StringUtil.getUUID());
		//model.setCreateUserId(currentUser.getUserId());
		//model.setCreateUserName(currentUser.getUserName());
		//model.setCreateDate(now);
		//model.setModifyDate(now);
		//model.setDeleteFlag(0);
		//sysConfigDAO.insert(model); 
		return model;
    }

    @Override
    public SysConfig findById(String modelId) {
        return sysConfigDAO.findById(modelId);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String ... params) {
       /* PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
		if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
			PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
		}
		List<Condition> whereList = queryParams.filtersToDBConditionals();
		whereList.add(Condition.createEq("storeId",currentUser.getStoreId()));;
		//whereList.add(Condition.createEq("deleteFlag",0));
		//whereList.add(Condition.create("IFNULL(deleteFlag,'')", -1 , Condition.OpType.NE));
		//whereList.add(Condition.createEq("typeFlag",params[0]));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		List list = sysConfigDAO.listByPage(map);
		PageInfo pageInfo = new PageInfo(list);
		return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List<SysConfig> listByParam(Map<String, Object> paramMap) {
        return sysConfigDAO.listByParam(paramMap);
    }

    @Override
    public SysConfig findByParam(Map<String, Object> paramMap) {
        return sysConfigDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return sysConfigDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return sysConfigDAO.deleteByParam(paramMap);
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
        SysConfig model = sysConfigDAO.findById(modelId);
		//model.setDeleteFlag(deleteFlag);
		return sysConfigDAO.updateByPrimaryKey(model);
    }

    @Override
    public SysConfig update(SysConfig model, LocalUser user) {
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
        return sysConfigDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return sysConfigDAO.updateByParam(paramMap);
    }

	@Override
	public Integer updateByBean(SysConfig sysConfig) {
		// TODO Auto-generated method stub
		return sysConfigDAO.updateByPrimaryKey(sysConfig);
	}
}