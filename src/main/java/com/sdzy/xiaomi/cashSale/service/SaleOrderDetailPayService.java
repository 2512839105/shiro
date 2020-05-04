package com.sdzy.xiaomi.cashSale.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.purpleredgourd.sale.model.SaleOrderDetail;

public interface SaleOrderDetailPayService {
   

    DataGrid findSaleDetaisByBarCode(QueryParams queryParams, String keyword, LocalUser currentUser);

    DataGrid findStockByKeyword(QueryParams queryParams, String keyword, String storeId);

    DataGrid findStockByBarCode(String barCode, Integer type,String storeId);

    DataGrid findStockByProperties(String keyword, QueryParams queryParams,String storeId);

	String findUserByUserCode(String memberNo, String storeId);


     
}