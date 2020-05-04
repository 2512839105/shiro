package com.sdzy.mall.base.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.mall.base.model.MallBaseStoreInfo;
import com.sdzy.mall.base.service.MallBaseStoreInfoService;
import com.sdzy.mall.util.BaseUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-11
 */
@Controller
@RequestMapping("/base/baseStoreInfo")
public class MallBaseStoreInfoController extends BaseController {

	@Autowired
	MallBaseStoreInfoService  baseStoreInfoService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	baseStoreInfoService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(MallBaseStoreInfo model) {
    	data = baseStoreInfoService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = baseStoreInfoService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = baseStoreInfoService.selectById(modelId); 
    	return new ModelAndView("/base/baseStoreInfo","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<MallBaseStoreInfo> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return baseStoreInfoService.selectModelsByPage(queryParams);
    }
    
    
    /**
     *  根据商品类别获取商品列表
     */
    @RequestMapping("/selectStoreOrderSale.action")
    public @ResponseBody Page selectStoreOrderSale(String vloginId,String vpwd,Integer offset,Integer current,Integer limit) {
        if(!BaseUtil.validate(vloginId, vpwd)) {
            return BaseUtil.unValidate();
        }
        return baseStoreInfoService.selectStoreOrderSale(offset,current,limit);
    }
    
}

