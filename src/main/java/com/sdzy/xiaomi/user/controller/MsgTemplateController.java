package com.sdzy.xiaomi.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.model.MsgTemplate;
import com.sdzy.xiaomi.user.service.MsgTemplateService;



import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;

/**
 * <p>
 * 短信模板 前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@Controller
@RequestMapping("/user/msgTemplate")
public class MsgTemplateController extends BaseController {
															
	@Autowired
	MsgTemplateService msgTemplateService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	msgTemplateService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(MsgTemplate model) {
    	data = msgTemplateService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
       
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = msgTemplateService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
        
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = msgTemplateService.selectById(modelId); 
    	return new ModelAndView("/user/msgTemplate","data",data);
    }
    
    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<MsgTemplate> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return msgTemplateService.selectModelsByPage(queryParams);
    }


}

