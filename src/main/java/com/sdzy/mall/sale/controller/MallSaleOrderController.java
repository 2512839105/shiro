package com.sdzy.mall.sale.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.sale.model.MallSaleOrder;
import com.sdzy.mall.sale.model.MallSaleOrderPay;
import com.sdzy.mall.sale.service.MallSaleOrderService;
import com.sdzy.mall.util.BaseUtil;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;
import com.sdzy.xiaomi.user.service.BaseMemberService;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;


@Controller
@RequestMapping(value = "/sale/order")
public class MallSaleOrderController extends BaseController {
    @Resource
    private MallSaleOrderService saleOrderService;
    @Resource
    private BaseMemberService baseMemberService;
    @Resource
    private BaseStoreInfoService baseStoreInfoService;

    private static final Logger logger = LoggerFactory.getLogger(MallSaleOrderController.class);


//    public String generateTokenAjax() {
//        String token = BaseUtil.generateToken(request.getSession());
//        AjaxSupport.sendSuccessText(token);
//        return NONE;
//    }



    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(MallSaleOrder model) {
        data = saleOrderService.insert(model);
        return this.sendSuccJson(data);
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
        data = saleOrderService.findById(modelId);
        return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    @ResponseBody
    public DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return saleOrderService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        saleOrderService.deleteById(modelId);
        return this.sendSuccJson();
    }


    /**
     * 获取支付方式
     */
    @RequestMapping("/getPayMethod.action")
    public String getPayMethod(String storeId) {
        BaseStoreInfo baseStoreInfo = baseStoreInfoService.selectById(storeId);
        return this.sendSuccJson(baseStoreInfo.getPayMethod());
    }

/*    @RequestMapping("/findMemberByMemberNo.action")
    public String findUserByUserCode(String memberNo) {
        data = baseMemberService.findByMemberNo(memberNo);
        return this.sendSuccJson(data);
    }*/

    /**
     * 提交销售表单
     * 1)支付 , 更新支付状态
     * @param saleOrderDetail jsonArray,storeId,totalCount,totalMemberAmount
     */
    //@SameUrlData
    @RequestMapping("/submitSaleOrder.action")
    public String submitSaleOrder(MallSaleOrder saleOrder,String userId) {
        //如果为空，说明是新加入，否则代表是处方生成的订单，没有支付
        if (StringUtils.isEmpty(saleOrder.getSaleOrderNo())) {
            saleOrder = saleOrderService.submitSaleOrder(saleOrder);
        }
        saleOrderService.savePayOrder(saleOrder,userId);

        saleOrder.setStoreId(this.getCurrentUser().getStoreId());
        return this.sendSuccJson(saleOrder);
    }


    /**
     * 暂存销售表单
     */
    @RequestMapping("/pauseSaleOrder.action")
    public String pauseSaleOrder(@RequestBody MallSaleOrder saleOrder, @RequestParam(required = false) Integer isPending) {
        data = saleOrderService.pauseSaleOrder(saleOrder, isPending);
        return this.sendSuccJson(data);
    }


    /**
     * 提交退货表单
     */
    @RequestMapping("/submitReturnOrder.action")
    public String submitReturnOrder(@RequestBody MallSaleOrder saleOrder,String userId) {
        saleOrderService.submitReturnOrder(saleOrder,userId);
        return this.sendSuccJson();
    }


    /**
     * 提单
     *
     * @return
     */
    @RequestMapping("/findPending.action")
    @ResponseBody
    public JsonInfo findPending() {
        data = saleOrderService.findPending();
        return JsonInfo.succ(data);
    }

    /**
     * 根据销售订单id
     *
     * @param saleOrderId
     * @return
     */
    @RequestMapping("/findPendginsByOrderId.action")
    public String findPendginsByOrderId(String saleOrderId) {
        list = saleOrderService.findPendginsByOrderId(saleOrderId);
        return this.sendSuccJson(list);
    }

    /**
     * 根据单号查询订单
     *
     * @param saleOrderNo
     * @return
     */
    @RequestMapping("/findSaleOrderByNo.action")
    public String findSaleOrderByNo(String saleOrderNo) {
        data = saleOrderService.findSaleOrderByNo(saleOrderNo);
        return this.sendSuccJson(data);
    }


    /**
     * 查询云支付订单是否支付成功
     *
     * @return
     */
    @RequestMapping(value = "/findOrderPay.action")
    public String findOrderPay(@RequestBody MallSaleOrderPay saleOrderPay) {
        data = saleOrderService.findOrderPay(saleOrderPay);
        if (data != null) {
            return this.sendSuccJson();
        } else {
            return this.sendFailJson("支付失败");
        }
    }


    /**
     * 查询云支付订单是否支付成功
     *
     * @return
     */
    @RequestMapping(value = "/findOrderPaySuccess.action")
    public String findOrderPaySuccess(String tradeOrderId,String userId) {
        String resule = saleOrderService.findOrderPaySuccess(tradeOrderId,userId);
        if ("success".equals(resule)) {
            return this.sendSuccJson();
        } else {
            return this.sendFailJson("支付失败");
        }
    }

}

