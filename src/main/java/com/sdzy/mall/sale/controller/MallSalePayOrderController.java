package com.sdzy.mall.sale.controller;

import java.util.ArrayList;
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
import com.sdzy.mall.sale.model.MallSalePayOrder;
import com.sdzy.mall.sale.service.MallSalePayOrderService;


@Controller
@RequestMapping(value = "/sale/payorder")
public class MallSalePayOrderController extends BaseController {
    @Resource
    private MallSalePayOrderService salePayOrderService;

    private static final Logger logger = LoggerFactory.getLogger(MallSalePayOrderController.class);

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(MallSalePayOrder model) {
         data=salePayOrderService.insert(model);
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=salePayOrderService.findById(modelId);
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    @ResponseBody
    public DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return salePayOrderService.listByPage(queryParams);
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        salePayOrderService.deleteById(modelId); 
		return this.sendSuccJson();
    }

    /**
     * 根据参数，任意删除
     */
    @RequestMapping("/deleteByParam.action")
    public String deleteByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		salePayOrderService.deleteByParam(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据ID修改数据
     */
    @RequestMapping("/updateById.action")
    public String updateById(@RequestParam Map<String, Object> paramMap) {
        List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("modelId", paramMap.get("modelId"));
		map.put("updateList", updateList);
		salePayOrderService.updateById(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据参数，任意更新
     */
    @RequestMapping("/updateByParam.action")
    public String updateByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		map.put("updateList", updateList);
		salePayOrderService.updateByParam(map); 
		return this.sendSuccJson();
    }
}