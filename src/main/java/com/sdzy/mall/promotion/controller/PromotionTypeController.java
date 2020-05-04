package com.sdzy.mall.promotion.controller;

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
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.promotion.model.PromotionType;
import com.sdzy.mall.promotion.service.PromotionTypeService;


@Controller
@RequestMapping(value = "/promtion/type")
public class PromotionTypeController extends BaseController {
    @Resource
    private PromotionTypeService promotionTypeService;

    private static final Logger logger = LoggerFactory.getLogger(PromotionTypeController.class);

    
    /**
     * 新增或编辑页
     */
    @RequestMapping("/edit.action")
    public void edit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
			 data=promotionTypeService.findById(modelId);
			 request.setAttribute("model", data);
		 }else{
			 PromotionType model = new PromotionType();
			 // TODO: 请补全代码块
			 request.setAttribute("model", model);
		}
    }

    /**
     * 更新
     */
    @RequestMapping("/update.action")
    public String update(PromotionType model) {
         data=promotionTypeService.update(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(PromotionType model) {
         data=promotionTypeService.insert(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=promotionTypeService.findById(modelId); 
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public @ResponseBody
    DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return promotionTypeService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        promotionTypeService.deleteById(modelId); 
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
		promotionTypeService.deleteByParam(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据ids删除数据
     */
    @RequestMapping("/deleteByIds.action")
    public String deleteByIds(String modelIds) {
        promotionTypeService.deleteByIds(modelIds); 
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
		promotionTypeService.updateById(map); 
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
		promotionTypeService.updateByParam(map); 
		return this.sendSuccJson();
    }
}