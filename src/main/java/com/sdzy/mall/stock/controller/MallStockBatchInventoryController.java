package com.sdzy.mall.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.stock.service.MallStockBatchInventoryService;


@Controller
@RequestMapping(value = "/stock/batchInventory")
public class MallStockBatchInventoryController extends BaseController {
    @Resource
    private MallStockBatchInventoryService stockBatchInventoryService;

    private static final Logger logger = LoggerFactory.getLogger(MallStockBatchInventoryController.class);

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(MallStockBatchInventory model) {
         data= stockBatchInventoryService.insert(model);
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data= stockBatchInventoryService.findById(modelId);
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public String listByPage(@RequestBody QueryParams queryParams) {
        List<Condition> whereList = queryParams.filtersToDBConditionals();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		list= stockBatchInventoryService.listByPage(map);
		return this.sendJsonGrid(list);
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        stockBatchInventoryService.deleteById(modelId);
		return this.sendSuccJson();
    }

    /**
     * 产品选择页面
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/select.action")
    public void select(@RequestParam(value = "keyword",required = false) String keyword) {
        request.setAttribute("keyword", keyword);
    }

    /**
     * 盘盈、盘亏选择页面
     * @param keyword
     * @return
     */ 
    @RequestMapping(value = "/inventoryProfitLossSelect.action")
    public void inventoryProfitLossSelect(@RequestParam(value = "keyword",required = false) String keyword) {
        request.setAttribute("keyword", keyword);
    }

    /**
     * 关键字搜索列表
     * dingjifeng
     *
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getList.action")
    @ResponseBody
    public DataGrid getList(@RequestBody QueryParams queryParams, String keyword) {
    	/* String storeId = this.getCurrentUser().getStoreId();
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("keyword", keyword);

        map.put("storeId", storeId);
    	PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        if(StringUtil.isNotEmpty(queryParams.getOrder())&&StringUtil.isNotEmpty(queryParams.getSort())) {
            PageHelper.orderBy(queryParams.getSort()+" "+queryParams.getOrder());
        }
        
        if(!StringUtil.isEmpty(keyword))
        keyword= StringUtil.getDecodeString(keyword);       
        list = stockBatchInventoryService.getList(map);
        PageInfo<StockBatchInventory> pageInfo = new PageInfo<>(list);
        
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }
    
    /**
     * 获取可拆零列表
     * @param queryParams
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getDetachableList.action")
    @ResponseBody
    public DataGrid getDetachableList(@RequestBody QueryParams queryParams, String keyword) {
        
        return stockBatchInventoryService.getDetachableList(queryParams, getCurrentUser(), keyword);
    }
    
    @RequestMapping("/detachableSelect.action")
    public void detachableSelect(String keyword) {
        request.setAttribute("keyword", keyword);
    }
    
    /**
     * 产品选择页面
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/breakageProductSelect.action")
    public void breakageProductSelect(@RequestParam(value = "keyword",required = false) String keyword) {
        request.setAttribute("keyword", keyword);
    }

    /**
     * 根据参数，任意删除
     *//*
    @RequestMapping("/deleteByParam.action")
    public String deleteByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		stockBatchInventoryService.deleteByParam(map);
		return this.sendSuccJson();
    }

    *//**
     * 根据ID修改数据
     *//*
    @RequestMapping("/updateById.action")
    public String updateById(@RequestParam Map<String, Object> paramMap) {
        List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("modelId", paramMap.get("modelId"));
		map.put("updateList", updateList);
		stockBatchInventoryService.updateById(map);
		return this.sendSuccJson();
    }

    *//**
     * 根据参数，任意更新
     *//*
    @RequestMapping("/updateByParam.action")
    public String updateByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		map.put("updateList", updateList);
		stockBatchInventoryService.updateByParam(map);
		return this.sendSuccJson();
    }*/
}