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
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;
import com.sdzy.mall.promotion.service.PromotionGiveProductService;


@Controller
@RequestMapping(value = "/promtion/giveproduct")
public class PromotionGiveProductController extends BaseController {
    @Resource
    private PromotionGiveProductService promotionGiveProductService;

    private static final Logger logger = LoggerFactory.getLogger(PromotionGiveProductController.class);

    
    /**
     * 新增或编辑页
     */
    @RequestMapping("/edit.action")
    public void edit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
			 data=promotionGiveProductService.findById(modelId);
			 request.setAttribute("model", data);
		 }else{
			 PromotionGiveProduct model = new PromotionGiveProduct();
			 // TODO: 请补全代码块
			 request.setAttribute("model", model);
		}
    }

    /**
     * 更新
     */
    @RequestMapping("/update.action")
    public String update(PromotionGiveProduct model) {
         data=promotionGiveProductService.update(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(PromotionGiveProduct model) {
         data=promotionGiveProductService.insert(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=promotionGiveProductService.findById(modelId); 
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public @ResponseBody
    DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return promotionGiveProductService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        promotionGiveProductService.deleteById(modelId); 
		return this.sendSuccJson();
    }


    /**
     * 根据ids删除数据
     */
    @RequestMapping("/deleteByIds.action")
    public String deleteByIds(String modelIds) {
        promotionGiveProductService.deleteByIds(modelIds); 
		return this.sendSuccJson();
    }


    
    /**
     * 根据促销策略Id获取促销产品
     * @param modelId
     * @return
     */
    @RequestMapping(value = "/getPromotionGiveProducts.action")
    @ResponseBody
    public DataGrid getPromotionGiveProducts(String modelId){
        if(StringUtil.isEmpty(modelId)) throw new CustomerException("主键不能为空！");
        Map<String, Object> map = new HashMap<>();
        List<Condition> whereList = new ArrayList<>();
		whereList.add(Condition.createEq("storeId", getCurrentUser().getStoreId()));
        whereList.add(Condition.createEq("strategyIdOrPid", modelId));
        map.put("whereList", whereList);
        List<PromotionGiveProduct> list = promotionGiveProductService.listByParam(map);
        return new DataGrid(list.size(), list);
    }
}