package com.sdzy.xiaomi.user.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpUtils;

import com.sdzy.xiaomi.user.model.ServiceOrderBase;
import com.sdzy.xiaomi.serviceProduct.mapper.ServiceProductStatMapper;
import com.sdzy.xiaomi.serviceProduct.model.ServiceProductStat;
import com.sdzy.xiaomi.user.mapper.ServiceOrderBaseMapper;
import com.sdzy.xiaomi.user.service.ServiceOrderBaseService;
import com.sdzy.xiaomi.util.BaseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.HttpClientUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonBackReference;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务订单主表 服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
@Service
public class ServiceOrderBaseServiceImpl extends BaseServiceImpl<ServiceOrderBaseMapper, ServiceOrderBase>
        implements ServiceOrderBaseService {
    @Autowired
    ServiceProductStatMapper serviceProductStatMapper;
    
    private static final Logger log = LoggerFactory.getLogger(ServiceOrderBaseServiceImpl.class);

    
    @Override
    public boolean deleteModelById(Serializable id) {
        boolean returnValue = false;
        // TODO:加入删除前的判断

        returnValue = this.deleteById(id);
        return returnValue;
    }

    @Override
    public String insertOrder(Map<String, Object> map) {
        String data = (String) map.get("data"); // 取出 data 中的值
        JSONObject json = JSONObject.parseObject(data); // 转为json对象
        JSONObject detailMap = json.getJSONObject("detail"); // 取出json对象中 名为 detail 的值
        JSONObject orderMap = json.getJSONObject("order");// 取出json对象中 名为 order 的值

        String orderBaseId = StringUtil.getUUID();
        Object buyerType = orderMap.get("buyerType");
        Object buyerId = orderMap.get("buyerId");

        Object buyerName = orderMap.get("buyerName");

        Object payType = orderMap.get("payType");
        Object isPayed = orderMap.get("isPayed");
        Object state = orderMap.get("state");
        Object totalFee = orderMap.get("totalFee");

        // Detail
        String orderDetailId = StringUtil.getUUID();
        Object productName = detailMap.get("productName");

        Object unit = detailMap.get("unit");
        Object price = detailMap.get("price");
        Object buyCount = detailMap.get("buyCount");
        Object payment = detailMap.get("payment");
        Object companyId = detailMap.get("companyId");
        Date createTime = new Date();

        String orderNo = BaseUtil.getOrderNo();
        baseMapper.insertOrderBase(orderBaseId, orderNo, totalFee, payment, buyerId, buyerName, payType, isPayed, state,
                createTime);
        baseMapper.insertOrderDetail(orderDetailId, companyId, orderNo, productName, unit, price, buyCount, totalFee,
                payment, state, createTime);

        return orderNo;
    }

    @Override
    public Page<ServiceOrderBase> selectModelsByPage(QueryParams queryParams) {
        // 查询条件构造器
        // MyBatisPlusUtil.createEQWrapper(obj, "appkey","state")
        // where appkey=${obj.appkey} and state=${obj.state}
        // MyBatisPlusUtil.createEQWrapper(new Object[]{"value1","value2"},
        // "appkey","state")
        // where appkey=value1 And state=value2
        // MyBatisPlusUtil.filtersToWrapper(new Filter("appkey",OpType.EQ,"value1"),new
        // Filter("state",OpType.GE,"value2"))
        // where appkey=value1 And state>=value2

        Page<ServiceOrderBase> page = new Page<ServiceOrderBase>(queryParams.getCurrent(), queryParams.getLimit(),
                queryParams.getSort(), queryParams.isAsc());

        Wrapper<ServiceOrderBase> wrapper = MyBatisPlusUtil.filtersToWrapper(queryParams.getFilters());

        return this.selectPage(page, wrapper);
    }

    @Override
    public String updateOrder(Map<String, Object> data) {
        String orderNo = (String) data.get("outTradeNo");
       /* String payOrderNo = (String) data.get("tradeNo");
        String state = "TRADE_FINISHED";*/
     
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("vloginId", PropFileConfig.getProperty("vloginId"));
        paramMap.put("vpwd", PropFileConfig.getProperty("vpwd"));
        paramMap.put("payOrderNo",orderNo);
        log.info("单号为:"+orderNo+"---正在进行充值操作");
        String msg = HttpClientUtil.postJson("http://woxiaomi.asdzy.com/service/serviceProductStat/insertOrUpdateByPost.action", JSON.toJSONString(paramMap));
        return BaseUtil.productJson(null, "", msg);
    }
    
     public void test() {
        String orderNo = "XY311534924815524";
       /* String payOrderNo = (String) data.get("tradeNo");
        String state = "TRADE_FINISHED";*/
     
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("vloginId", PropFileConfig.getProperty("vloginId"));
        paramMap.put("vpwd", PropFileConfig.getProperty("vpwd"));
        paramMap.put("payOrderNo",orderNo);

        String msg = HttpClientUtil.postJson("http://localhost:8082/service/serviceProductStat/insertOrUpdateByPost.action", JSON.toJSONString(paramMap));
        System.out.println(msg);
    }

    @Override
    public List<Map<String, String>> selectBaseBybuyerId(String buyerId) {
        return baseMapper.selectBaseBybuyerId(buyerId);
    }

    @Override
    public List<Map<String, String>> selectDetail(String orderNo) {

        return baseMapper.selectDetail(orderNo);
    }

}
