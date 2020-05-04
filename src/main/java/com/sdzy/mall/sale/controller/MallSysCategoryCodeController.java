package com.sdzy.mall.sale.controller;


import java.util.HashMap;
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
import com.sdzy.mall.sale.model.MallSysCategoryCode;
import com.sdzy.mall.sale.service.MallSysCategoryCodeService;
import com.sdzy.mall.util.BaseUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
@Controller
@RequestMapping("/sale/sysCategoryCode")
public class MallSysCategoryCodeController extends BaseController {
    
	@Autowired
	MallSysCategoryCodeService  sysCategoryCodeService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	sysCategoryCodeService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(MallSysCategoryCode model) {
    	data = sysCategoryCodeService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = sysCategoryCodeService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = sysCategoryCodeService.selectById(modelId); 
    	return new ModelAndView("/sale/sysCategoryCode","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<MallSysCategoryCode> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return sysCategoryCodeService.selectModelsByPage(queryParams);
    }

    /**
     * 获取门店线上销售商品类别
     */
    @RequestMapping("/selectOnlineSaleDrug.action")
    public String selectOnlineSaleDrug(String vloginId,String vpwd,String storeId) {
        if(!BaseUtil.validate(vloginId, vpwd)) {
            return this.sendFailJson(BaseUtil.unValidate(), "接口验证失败");
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("storeId", storeId);
        return this.sendSuccJson(sysCategoryCodeService.selectOnlineSaleDrug(map));
    }
    
}

