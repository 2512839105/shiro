package com.sdzy.xiaomi.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.asdzy.common.utils.HttpClientUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.SignUtil;


public class PayUtil {
    public static String ALIPAY="aliPay";
    public static String UNIONPAY="unionPay";
    public static String WEIXINPAY="weixinPay";
    
    

 //   public static ResourceBundle propConfig = ResourceBundle.getBundle("conf/config");

    public static void main(String[] args) {
    	 String authCode="134650233381039385";
    	String returnValue = PayUtil.tradePay("83cb9a4bf7ce4c9bb470638b3ea845c5 ",PayUtil.WEIXINPAY,"金鼎店","药品销售单",authCode,"SL023099963",BigDecimal.valueOf(0.01),"userId001","store1","pos1","test");
      
        System.out.println(returnValue);
    }

    /**
     * 查询收款明细
     * @param tradeOrderId 支付编号
     * @return
     */
    public static  String findTrade(String tradeOrderId){

        Map map= new HashMap<String, Object>();
        map.put("tradeOrderId", tradeOrderId);
        
        //系统参数
        map=PayUtil.configSystemParam(map,"api.get.pay.findTradePay");
        return HttpClientUtil.postJson(PropFileConfig.getProperty("sdcloudpay.host")+"/api/gateway.action", JSON.toJSONString(map));
    }


    /**
     * 支付中查询，并更新支付结果
     * @param tradeOrderId
     * @return
     */
    public static  String findTradePaying(String accountNo,String tradeOrderId){ 	
    	Map map= new HashMap<String, Object>();
    	map.put("tradeOrderId", tradeOrderId);
    	map.put("accountNo", accountNo);
    	//系统参数
    	map=PayUtil.configSystemParam(map,"api.get.pay.findTradePaying");
    	return HttpClientUtil.postJson(PropFileConfig.getProperty("sdcloudpay.host")+"/api/gateway.action", JSON.toJSONString(map));
    }



//    /**
//     * 支付中查询
//     * @return
//     */
//    public static String findTradePaying(Map map) {
//        //系统参数
//        map=PayUtil.configSystemParam(map,"api.get.pay.findTradePay");
//        return HttpClientUtil.postJson(propConfig.getString("sdcloudpay.host") + "/store/pay/findTradePaying.action", JSON.toJSONString(map));
//    }

    /**
     * @param platformType 支付渠道
     * @param accountNo 收款账户
     * @param authCode  用户自己的支付宝付款码
     * @param outTradeNo 订单号
     * @param payMoney 订单总金额
     * @param discountableAmount  订单可打折金额
     * @param undiscountableAmount 订单不可打折金额
     * @param subject 订单描述
     * @param body 订单标题
     * @param operatorId 商户操作员编号
     * @param storeId 商户号
     * @param deviceInfo  商户机具终端编号
     * @param attach  附加信息，原样返回
     * @param storeId 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号),如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
     * @return
     */
    public static  String tradePay( String accountNo,String platformType, String subject, String body, String authCode, String outTradeNo, BigDecimal payMoney, String operatorId, String storeId, String deviceInfo, String attach){
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("platformType", platformType);
        map.put("accountNo", accountNo);
        map.put("subject",subject);
        map.put("body", body);
        map.put("authCode", authCode);
        map.put("outTradeNo", outTradeNo);
        map.put("totalAmount", payMoney);
        map.put("operatorId", operatorId);
        map.put("storeId", storeId);
        map.put("deviceInfo", deviceInfo);
        map.put("attach", attach);
        map=PayUtil.configSystemParam(map, "api.set.pay.tradePay");
        //系统参数
        return HttpClientUtil.postJson(PropFileConfig.getProperty("sdcloudpay.host")+"/api/gateway.action", JSON.toJSONString(map));
    }


    /**
     * 组建公共参数
     * @param map 员参数
     * @param method 本此调用的函数
     * @return 带签名后的参数
     */
    private static Map<String, Object> configSystemParam(Map<String, Object> map, String method) {
        map.put("apikey", PropFileConfig.getProperty("store.appkey"));
        map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("method", method);
        map.put("version", "1");       
        try {
			map.put("sign", SignUtil.generateSignature(map, PropFileConfig.getProperty("store.apisecret")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return map;
    }


    //--友德医相关---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 充值中查询，并更新支付结果
     * @return
     */
    public static String findTradeRecharging(Map map) {
        //系统参数 
        return HttpClientUtil.postJson( PropFileConfig.getProperty("admin.host") + "store/pay/findTradeRecharging.action", JSON.toJSONString(map));
    }

    /**
     * 扫码支付，此接口返回二维码
     *
     * @param platformType 支付渠道
     * @param subject      订单描述
     * @param body         订单标题
     * @param outTradeNo   订单号
     * @param payMoney     订单总金额
     * @param operatorId   商户操作员编号
     * @param storeId      商户号
     * @param deviceInfo   商户机具终端编号
     * @param attach       附加信息，原样返回
     * @return
     */
    public static  String recharge(String platformType, String subject, String body, String outTradeNo, BigDecimal payMoney, String operatorId, String storeId, String deviceInfo, String attach){
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("platformType", platformType);
        //map.put("accountNo", accountNo);
        map.put("subject",subject);
        map.put("body", body);
        map.put("outTradeNo", outTradeNo);
        map.put("totalAmount", payMoney);
        map.put("operatorId", operatorId);
        map.put("storeId", storeId);
        map.put("deviceInfo", deviceInfo);
        map.put("attach", attach);
        //系统参数
        return HttpClientUtil.postJson(PropFileConfig.getProperty("admin.host")+"store/pay/recharge.action", JSON.toJSONString(map));
    }

}
