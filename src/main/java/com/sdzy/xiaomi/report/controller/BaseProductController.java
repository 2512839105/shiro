package com.sdzy.xiaomi.report.controller;


import com.sdzy.xiaomi.report.model.BaseProduct;
import com.sdzy.xiaomi.report.service.BaseProductService;

import net.sf.jsqlparser.statement.select.First.Keyword;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/baseProduct")
public class BaseProductController extends BaseController {

	@Autowired
    BaseProductService baseProductService;
 	
    /**
     * 查询商品价格变动
     * price ： 1降价，2升价
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<BaseProduct> selectModelsByPage(QueryParams queryParams,String price,String keyword,String storeId,String js_code,String appid,String secrect) {
        return baseProductService.selectModelsByPage(queryParams,keyword,price,storeId,js_code,appid,secrect);
    }
    /**
     *修改零售价，会员价
     */
    @RequestMapping("/updateProduct.action")
    public String updateProduct(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect) {
         baseProductService.updateProduct(data,js_code,appid,secrect);
         return this.sendSuccJson("修改成功");
    }
    /**
     * keyword storeId查询参数
     * 按货号，或商品名查询
     */
    @RequestMapping("/selectProductByCodeOrName.action")
    public String selectProductByCodeOrName(String storeId,String keyword,String js_code,String appid,String secrect){
    	data=baseProductService.selectProductByCodeOrName(storeId,keyword,js_code,appid,secrect);
    	return this.sendSuccJson(data);   	
    }
}

