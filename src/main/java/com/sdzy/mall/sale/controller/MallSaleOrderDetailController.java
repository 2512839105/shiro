package com.sdzy.mall.sale.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.SessionUtil;
import com.sdzy.mall.sale.model.MallSaleOrderDetail;
import com.sdzy.mall.sale.service.MallSaleOrderDetailService;
import com.sdzy.mall.stock.service.MallStockBatchInventoryService;
import com.sdzy.xiaomi.report.service.BaseProductService;

@Controller
@RequestMapping(value = "/sale/orderdetail") 
public class MallSaleOrderDetailController extends BaseController {
    @Resource
    private MallSaleOrderDetailService saleOrderDetailService;
    @Resource
    private MallStockBatchInventoryService stockBatchInventoryService;
    @Resource
    private BaseProductService baseProductService;

    private static final Logger logger = LoggerFactory.getLogger(MallSaleOrderDetailController.class);

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(MallSaleOrderDetail model) {
         data=saleOrderDetailService.insert(model);
		 return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=saleOrderDetailService.findById(modelId);
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public String listByPage(@RequestParam Map<String, Object> paramMap) {
        List<Condition> whereList = new ArrayList<Condition>();
        whereList.add(Condition.createEq("storeId", SessionUtil.getLocalUser().getStoreId()));
        whereList.add(Condition.createEq("saleOrderId",paramMap.get("saleOrderId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		list=saleOrderDetailService.listByPage(map);

		return this.sendJsonGrid(list);
    }

    /**
     * 收银页面查询  按照条码、编号、助记码、商品名查询批次库存表
     * @param keyword
     * @return
     */
    @RequestMapping("/findStockByKeyword.action")
    @ResponseBody
    public DataGrid findStockByKeyword(QueryParams queryParams, @RequestParam(name="keyword") String keyword) {
        return saleOrderDetailService.findStockByKeyword(queryParams, keyword);
    }


    /**
     * 按照条码查询销售明细表
     * @param keyword
     * @return
     */
    @RequestMapping("/findSaleDetaisByBarCode.action")
    @ResponseBody
    public DataGrid findSaleDetaisByBarCode(QueryParams queryParams, @RequestParam(name="barCode") String keyword) {
        return saleOrderDetailService.findSaleDetaisByBarCode(queryParams, keyword, getCurrentUser());
    }


    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        saleOrderDetailService.deleteById(modelId); 
		return this.sendSuccJson();
    }



    /**
     * 通过编号、助记码、商品名查询
     * @param keyword
     * @param queryParams
     * @return
     */
    private DataGrid findByProperties(String keyword, QueryParams queryParams) {
        return saleOrderDetailService.findStockByProperties(keyword, queryParams);
    }
    
    /**
     * 通过条码进行查询汇总库存明细
     * @param barCode
     * @return
     */
    private DataGrid findByBarCode(String barCode) {
        return saleOrderDetailService.findStockByBarCode(barCode);
    }

}