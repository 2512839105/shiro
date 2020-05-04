package com.sdzy.xiaomi.cashSale.controller;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.sdzy.xiaomi.user.service.BaseMemberService;
import com.sdzy.xiaomi.cashSale.service.SaleOrderDetailPayService;
import com.sdzy.xiaomi.report.model.SaleOrder;
import com.sdzy.xiaomi.report.service.SaleOrderService;
import com.sdzy.xiaomi.util.BaseUtil;
 

@Controller
@RequestMapping(value = "/cashSale/orderdetails") 
public class SaleOrderDetailPayController extends BaseController {
    @Autowired
    private SaleOrderDetailPayService saleOrderDetailService;
    @Autowired
    private BaseMemberService baseMemberService;
    @Autowired
    private SaleOrderService saleOrderService;

    private static final Logger logger = LoggerFactory.getLogger(SaleOrderDetailPayController.class);

 

    /**
     * 收银页面查询  按照条码、编号、助记码、商品名查询批次库存表
     * @param keyword
     * @return
     */
    @RequestMapping("/findStockByKeyword.action")
    @ResponseBody
    public DataGrid findStockByKeyword(QueryParams queryParams, @RequestParam(name="keyword") String keyword,String storeId,String js_code,String appid,String secrect) {
        try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
		        return saleOrderDetailService.findStockByKeyword(queryParams, keyword,storeId);
			  }
		} catch (IOException e) {
			throw new CustomerException(e+"");
		}
	      return null;
    }
    
    /**
     * 收银页面查询  会员编号查询会员
     * @param memberNo storeId
     * @return
     */
    @RequestMapping("/findMemberByMemberNo.action")
    public String findMemberByMemberNo(String memberNo,String storeId,String js_code,String appid,String secrect) {
        try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
		        data= baseMemberService.findByMemberNo(memberNo,storeId);
		        return this.sendSuccJson(data);
			  }
		} catch (IOException e) {
			throw new CustomerException(e+"");
		}
	      return null ;
    }
    
    

    /**
     * 如果支付宝微信组合支付
     * 支付宝先支付
     * 只保存销售订单与明细
     * @param data  订单信息     user  门店id code ,用户name 用户id
     * 
     * @return
     */				  
    @RequestMapping("/submitSaleOrders.action")
    public String submitSaleOrders(String data,String user,String js_code,String appid,String secrect) {
    	        
        try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
				SaleOrder saleOrder=JSON.parseObject(data,SaleOrder.class);
		        //1保存销售主单与明细
		        saleOrder = saleOrderService.saveSaleOrderAndDetails(saleOrder,user);
		        //2保存支付与更新库存
		        saleOrder = saleOrderService.submitSaleOrders(saleOrder,user);
		        return this.sendSuccJson(saleOrder);
		      
			  }
		} catch (IOException e) {
			throw new CustomerException(e+"");
		}
	      return this.sendFailJson("小程序参数验证失败");
    }
    
    


}