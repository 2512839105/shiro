package com.sdzy.mall.sale.service;

import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.sdzy.mall.sale.model.MallSaleOrder;
import com.sdzy.mall.sale.model.MallSaleOrderPay;
import com.sdzy.mall.sale.model.MallSalePayOrder;


public interface MallSaleOrderService {
    /**
     * 新增
     */
    MallSaleOrder insert(MallSaleOrder model);

    /**
     * 按ID号查询
     */
    MallSaleOrder findById(String modelId);

    /**
     * 根据参数分页查询
     */
    List<MallSaleOrder> listByPage(Map<String, Object> paramMap);

    /**
     * 根据id删除数据
     */
    Integer deleteById(String modelId);

    /**
     * 根据参数，任意删除
     */
    Integer deleteByParam(Map<String, Object> paramMap);

    /**
     * 根据ID修改数据
     */
    Integer updateById(Map<String, Object> paramMap);

    /**
     * 根据参数，任意更新
     */
    Integer updateByParam(Map<String, Object> paramMap);

    DataGrid findPending();

    MallSaleOrder findSaleOrderByNo(String saleOrderNo);

    MallSalePayOrder addSalePayOrder(MallSaleOrder saleOrder, MallSalePayOrder salePayOrder);

    MallSalePayOrder findSalePayOrder(String saleOrderNo);

    DataGrid listByPage(QueryParams queryParams, LocalUser currentUser);

   

    /**
     * 退货
     * 1）插入数据到销售明细中，设置detailType = 1, 只有saleCount小于0的才添加
     * 2）添加数据到支付订单中，orderType = 1 , payMoney为负数， 如果表单中有订单且saleCount为负数，说明已经退款过
     * 3) 查询在库存批次表是否存存，存在则加库存
     * 4）产品表总库存增加
     * 5）历史表添加退货数据
     * 其中3、4、5条可做成一个统一的接口供调用 存在baseServiceImpl
     * @param saleOrder
     * @return
     */
    void submitReturnOrder(MallSaleOrder saleOrder, String userId);


    /**
     * 根据一个时间，获取大于改时间的数据
     */
	List<MallSaleOrder> listByLastestDate(Map<String, Object> map);

    /**
     * 暂存销售表单，只生成表单，不生成明细与支付信息
     * @param saleOrder
     * @param isPending
     * @return
     */
    MallSaleOrder pauseSaleOrder(MallSaleOrder saleOrder, Integer isPending);
    
    
    /**
     * 查询云支付订单是否支付成功
     * @param saleOrderPay
     * @return
     */
    Integer findOrderPay(MallSaleOrderPay saleOrderPay);
    
    
    /**
     * 查询云支付订单是否支付成功
     * @return
     */
    String findOrderPaySuccess(String tradeOrderId, String storeCode);

    /**
     * 提交支付订单
     * @param saleOrder
     * @return
     */
    void savePayOrder(MallSaleOrder saleOrder, String userId);

    /**
     * 提交订单
     * @param saleOrder
     * @return
     */
    MallSaleOrder submitSaleOrder(MallSaleOrder saleOrder);

    /**
     * 查询挂单明细
     * @return
     */
    List findPendginsByOrderId(String saleOrderId);




}