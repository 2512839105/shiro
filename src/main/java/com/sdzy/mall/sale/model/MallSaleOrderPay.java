package com.sdzy.mall.sale.model;


/**
 * 云支付
 */
public class MallSaleOrderPay {

	private MallSaleOrder saleOrder;
	private MallSalePayOrder salePayOrder;
	private  String tradeOrderId;
	public String getTradeOrderId() {
		return tradeOrderId;
	}
	public void setTradeOrderId(String tradeOrderId) {
		this.tradeOrderId = tradeOrderId;
	}
	public MallSaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(MallSaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	public MallSalePayOrder getSalePayOrder() {
		return salePayOrder;
	}
	public void setSalePayOrder(MallSalePayOrder salePayOrder) {
		this.salePayOrder = salePayOrder;
	}
	
}
