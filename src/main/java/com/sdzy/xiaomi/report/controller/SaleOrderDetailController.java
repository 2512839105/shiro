package com.sdzy.xiaomi.report.controller;


import com.sdzy.xiaomi.report.model.SaleOrderDetail;
import com.sdzy.xiaomi.report.service.SaleOrderDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;


import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@Controller
@RequestMapping("/report/saleOrderDetail")
public class SaleOrderDetailController extends BaseController {

	@Autowired
    SaleOrderDetailService saleOrderDetailService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	saleOrderDetailService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
 
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = saleOrderDetailService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = saleOrderDetailService.selectById(modelId); 
    	return new ModelAndView("/report/saleOrderDetail","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<SaleOrderDetail> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return saleOrderDetailService.selectModelsByPage(queryParams);
    }


}

