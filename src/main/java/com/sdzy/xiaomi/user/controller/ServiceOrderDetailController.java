package com.sdzy.xiaomi.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.model.ServiceOrderDetail;
import com.sdzy.xiaomi.user.service.ServiceOrderDetailService;



import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;

/**
 * <p>
 * 服务订单明细表 前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
@Controller
@RequestMapping("/user/serviceOrderDetail")
public class ServiceOrderDetailController extends BaseController {

	@Autowired
	ServiceOrderDetailService  serviceOrderDetailService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	serviceOrderDetailService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(ServiceOrderDetail model) {
    	data = serviceOrderDetailService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = serviceOrderDetailService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = serviceOrderDetailService.selectById(modelId); 
    	return new ModelAndView("/user/serviceOrderDetail","data",data);
    }
    
    
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<ServiceOrderDetail> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return serviceOrderDetailService.selectModelsByPage(queryParams);
    }


}

