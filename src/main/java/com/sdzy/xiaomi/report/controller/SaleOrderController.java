package com.sdzy.xiaomi.report.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.SessionUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.model.SaleOrder;
import com.sdzy.xiaomi.report.model.SalePayOrder;
import com.sdzy.xiaomi.report.service.SaleOrderService;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;
import com.sdzy.xiaomi.util.PayUtil;
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
@RequestMapping("/report/saleOrder")
public class SaleOrderController extends BaseController {
	
	@Autowired
	SaleOrderService  saleOrderService;
	
	@Autowired
	BaseStoreInfoService baseStoreInfoService;
    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(SaleOrder saleOrder, SalePayOrder salePayOrder) {
    	
    	saleOrder = saleOrderService.selectById(saleOrder.getSaleOrderId());		  	
    	BaseStoreInfo store = baseStoreInfoService.selectById(saleOrder.getStoreId());
		salePayOrder.setPayDate(new Date());
		String returnValue = PayUtil.tradePay(PayUtil.WEIXINPAY, "8nOdEKkG2d6AB7UE", store.getStoreName(), "药品销售单", salePayOrder.getAuthCode(), saleOrder.getSaleOrderNo(), salePayOrder.getPayMoney(), SessionUtil.getLocalUser().getUserId(), store.getStoreId(), "pos1", "");
		
		return this.sendSuccJson();
    }
   
}

