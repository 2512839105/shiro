package com.sdzy.xiaomi.serviceProduct.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.sdzy.dataSource.DataSource;
import com.sdzy.xiaomi.serviceProduct.model.ServiceProductStat;
import com.sdzy.xiaomi.serviceProduct.service.ServiceProductStatService;
import com.sdzy.xiaomi.util.BaseUtil;

import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;

/**
 * <p>
 * 用户服务产品汇总 前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/serviceProductStat")
public class ServiceProductStatController extends BaseController {

	@Autowired
	ServiceProductStatService  serviceProductStatService;

	   //查询短信剩于数量
	    @RequestMapping("/selectBybuyerId.action")
	    @ResponseBody
	    @DataSource(name="three")
	    public String selectBybuyerId(String buyerId,String appid,String secrect,String js_code) {
	    	try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				    data=serviceProductStatService.selectBybuyerId(buyerId); 
				   return  BaseUtil.productJson(1, data, "成功");
				}
			} catch (IOException e) {
				throw new CustomerException("参数验证异常");
			}
	      return BaseUtil.productJson(null, "", "参数验证失败");
	    }
	    
	
    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	serviceProductStatService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(ServiceProductStat model) {
    	data = serviceProductStatService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = serviceProductStatService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = serviceProductStatService.selectById(modelId); 
    	return new ModelAndView("/user/serviceProductStat","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<ServiceProductStat> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return serviceProductStatService.selectModelsByPage(queryParams);
    }


}

