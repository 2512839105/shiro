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
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.promotion.model.PromotionProduct;
import com.sdzy.mall.promotion.service.PromotionProductService;


@Controller
@RequestMapping(value = "/promtion/product")
public class PromotionProductController extends BaseController {
    @Resource
    private PromotionProductService promotionProductService;

    private static final Logger logger = LoggerFactory.getLogger(PromotionProductController.class);

    /**
     * 新增或编辑页
     */
    @RequestMapping("/edit.action")
    public void edit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
			 data=promotionProductService.findById(modelId);
			 request.setAttribute("model", data);
		 }else{
			 PromotionProduct model = new PromotionProduct();
			 // TODO: 请补全代码块
			 request.setAttribute("model", model);
		}
    }

    /**
     * 主要用于收银页面进行促销产品初始化
     * @return
     */
    @RequestMapping("/listPromotionProduct.action")
    @ResponseBody
    public JsonInfo listPromotionProduct() {
        list = promotionProductService.listPromotionProduct();
        return JsonInfo.succ(list);
    }

    /**
     * 更新
     */
    @RequestMapping("/update.action")
    public String update(PromotionProduct model) {
         data=promotionProductService.update(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(PromotionProduct model) {
         data=promotionProductService.insert(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=promotionProductService.findById(modelId); 
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public @ResponseBody  DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return promotionProductService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        promotionProductService.deleteById(modelId); 
		return this.sendSuccJson();
    }


    /**
     * 根据ids删除数据
     */
    @RequestMapping("/deleteByIds.action")
    public String deleteByIds(String modelIds) {
        promotionProductService.deleteByIds(modelIds); 
		return this.sendSuccJson();
    }


    /**
     * 根据促销策略Id获取促销产品
     * @param modelId
     * @return
     */
    @RequestMapping(value = "/getPromotionProducts.action")
    @ResponseBody
    public DataGrid getPromotionProducts(String modelId){
        if(StringUtil.isEmpty(modelId))
            throw new CustomerException("主键不能为空！");
        
        Map<String, Object> map = new HashMap<>();
        
        List<Condition> whereList = new ArrayList<>();
		whereList.add(Condition.createEq("storeId",getCurrentUser().getStoreId()));
		whereList.add(Condition.createEq("promotionStrategyId", modelId));

        map.put("whereList", whereList);
        map.put("sort", "productCode");
        map.put("order", "asc");
        
        List<PromotionProduct> list = promotionProductService.listByParam(map);
        
        return new DataGrid(list.size(), list);
    }

    /**
     * 根据促销策略Id获取促销产品--针对单品促销--关联查询另赠品
     * @param modelId
     * @return
     */
    @RequestMapping(value = "/getPromotionProductsAndGiveProducts.action")
    @ResponseBody
    public DataGrid getPromotionProductsAndGiveProducts(String modelId){
        if(StringUtil.isEmpty(modelId))
            throw new CustomerException("主键不能为空！");
        List<PromotionProduct> list = promotionProductService.getPromotionProductsAndGiveProducts(modelId, getCurrentUser().getStoreId());
        return new DataGrid(list.size(), list);
    }
    
}