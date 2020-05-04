package com.sdzy.xiaomi.report.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.model.StockBatchInventory;
import com.sdzy.xiaomi.report.service.StockBatchInventoryService;



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
@RequestMapping("/report/stockBatchInventory")
public class StockBatchInventoryController extends BaseController {

	@Autowired
	StockBatchInventoryService  stockBatchInventoryService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	stockBatchInventoryService.deleteById(modelId); 
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
    	data = stockBatchInventoryService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = stockBatchInventoryService.selectById(modelId); 
    	return new ModelAndView("/report/stockBatchInventory","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<StockBatchInventory> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return stockBatchInventoryService.selectModelsByPage(queryParams);
    }


}

