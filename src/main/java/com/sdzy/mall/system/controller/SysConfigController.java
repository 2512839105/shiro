package com.sdzy.mall.system.controller;

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
import com.sdzy.mall.system.model.SysConfig;
import com.sdzy.mall.system.service.SysConfigService;


@Controller
@RequestMapping(value = "/system/config")
public class SysConfigController extends BaseController {
    @Resource
    private SysConfigService sysConfigService;

    private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

    /**
     * 新增或编辑页
     */
    @RequestMapping("/edit.action")
    public void edit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
			 data=sysConfigService.findById(modelId);
			 request.setAttribute("model", data);
		 }else{
			 SysConfig model = new SysConfig();
			 // TODO: 请补全代码块
			 request.setAttribute("model", model);
		}
    }

    /**
     * 更新
     */
    @RequestMapping("/update.action")
    public String update(SysConfig model) {
         data=sysConfigService.update(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(SysConfig model) {
         data=sysConfigService.insert(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=sysConfigService.findById(modelId); 
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public @ResponseBody
    DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return sysConfigService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        sysConfigService.deleteById(modelId); 
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
		sysConfigService.deleteByParam(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据ids删除数据
     */
    @RequestMapping("/deleteByIds.action")
    public String deleteByIds(String modelIds) {
        sysConfigService.deleteByIds(modelIds); 
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
		sysConfigService.updateById(map); 
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
		sysConfigService.updateByParam(map); 
		return this.sendSuccJson();
    }
}