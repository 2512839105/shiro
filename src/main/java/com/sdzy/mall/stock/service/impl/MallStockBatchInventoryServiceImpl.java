package com.sdzy.mall.stock.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.sdzy.mall.stock.mapper.MallStockBatchInventoryDAO;
import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.stock.service.MallStockBatchInventoryService;
import com.sdzy.mall.util.BaseUtil;


@Service
public class MallStockBatchInventoryServiceImpl implements MallStockBatchInventoryService {
    @Resource
    private MallStockBatchInventoryDAO stockBatchInventoryDAO;

    private static final Logger logger = LoggerFactory.getLogger(MallStockBatchInventoryServiceImpl.class);
 
    @Override
    public MallStockBatchInventory insert(MallStockBatchInventory model) {
        stockBatchInventoryDAO.insert(model); 
		 return model;
    }

    @Override
    public MallStockBatchInventory findById(String modelId) {
        return stockBatchInventoryDAO.findById(modelId);
    }

    @Override
    public List<MallStockBatchInventory> listByPage(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.listByPage(paramMap);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser) {
        /*Map<String, Object> map = BaseUtil.getPageMap(queryParams, currentUser, true);
        List list = stockBatchInventoryDAO.listByPage(map);
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public DataGrid findStockBatchByPage(QueryParams queryParams, LocalUser currentUser) {
       /* Map<String, Object> map = BaseUtil.getPageMap(queryParams, currentUser, true);
        List list = stockBatchInventoryDAO.findStockBatchByPage(map);
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public Integer deleteById(String modelId) {
        return stockBatchInventoryDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.updateByParam(paramMap);
    }

    @Override
    public List<MallStockBatchInventory> listByParam(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.listByParam(paramMap);
    }

    @Override
    public List<MallStockBatchInventory> introduceByPage(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.introduceByPage(paramMap);
    }

    @Override
    public List<MallStockBatchInventory> introduceByParam(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.introduceByParam(paramMap);
    }

    /**
     * 根据Id更新数量
     * @param inventoryId
     * @return
     */
    @Override
    public Integer updateStockCountById(String inventoryId, BigDecimal count, String storeId) {
        List<Condition> whereList = new ArrayList<Condition>();
        List<Condition> updateList = new ArrayList<Condition>();
        Map<String, Object> map = new HashMap<String, Object>();
        whereList.add(Condition.createEq("inventoryId", inventoryId));
        whereList.add(Condition.createEq("storeId", storeId));
        updateList.add(Condition.createEq("stockCount",count));
        updateList.add(Condition.createEq("modifyDate", DateUtil.getCurrDateTime()));
        map.put("whereList", whereList);
        map.put("updateList", updateList);
        return stockBatchInventoryDAO.updateByParam(map);
    }

    @Override
    public List listReportListByPage(Map<String, Object> map) {
        return stockBatchInventoryDAO.listReportListByPage(map);
    }

    @Override
    public List<MallStockBatchInventory> findByParam(Map<String, Object> map){
        return stockBatchInventoryDAO.findByParam(map);
    }

    @Override
    public List<MallStockBatchInventory> getList(Map<String, Object> paramMap) {
        return stockBatchInventoryDAO.getList(paramMap);
    }

    @Override
    public DataGrid findNotMaintainProductList(QueryParams queryParams, Map<String, Object> paramMap) {
       /* PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        if(StringUtil.isNotEmpty(queryParams.getSort())&&StringUtil.isNotEmpty(queryParams.getOrder())) {
            PageHelper.orderBy(queryParams.getSort()+" "+queryParams.getOrder());
        }
        
        PageInfo<StockBatchInventory> pageInfo = new PageInfo<>(stockBatchInventoryDAO.findNotMaintainProductList(paramMap));
        
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();

    }

	@Override
	public String selectStorage(String productCode, Date first, Date finall) {
		return stockBatchInventoryDAO.selectStorage(productCode, first, finall);
	}

	@Override
	public BigDecimal selectStorageFee(String productCode, Date first, Date finall) {
		return stockBatchInventoryDAO.selectStorageFee(productCode, first, finall);
	}

    @Override
    public DataGrid getDetachableList(QueryParams queryParams, LocalUser currentUser, String keyword) {
       /* Map<String, Object> map = new HashMap<>();
        map.put("keyword", keyword);
        map.put("storeId", currentUser.getStoreId());
        PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        if(StringUtil.isNotEmpty(queryParams.getSort())&&StringUtil.isNotEmpty(queryParams.getOrder())) {
            PageHelper.orderBy(queryParams.getSort()+" "+queryParams.getOrder());
        }
        
        List<StockBatchInventory> stockBatchInventories = stockBatchInventoryDAO.getDetachableList(map);
        PageInfo<StockBatchInventory> pageInfo = new PageInfo<>(stockBatchInventories);
        
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }


    @Override
    public Integer getCountByStoreId(String storeId) {
        return stockBatchInventoryDAO.getCountByStoreId(storeId);
    }


}