package com.sdzy.xiaomi.sale.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.xiaomi.stock.entity.SaleOrderDetail;
import com.sdzy.xiaomi.util.BaseUtil;
import com.sdzy.xiaomi.util.JDBCUtil;


@RestController
public class SaleController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);


    /**
     * 获取畅销品种接口
     * @param vloginId：接口验证登录名
     * 		  vpwd：接口验证密码 
     * 		  storeId：门店ID
			  userId：当前用户ID
			  pageIndex：页码，默认为1
			  pageSize：每页数量，默认为10
			  dateType: 搜索关键词，天数类型：昨天，近七天，近30天
     * @return Json
     */
    @GetMapping("/listBestSaleProduct.action")
    public String findInventory(@RequestParam(value = "vloginId",required = false) String vloginId, @RequestParam(value = "vpwd",required = false) String vpwd,
    		String userId,String storeId,Integer pageIndex,Integer pageSize,Integer dateType,String sort,Integer order){
		logger.info("用户"+userId+" 正在调用获取畅销品种接口");
			if(StringUtil.isEmpty(pageSize)){
				pageSize = 10;
			}	
			if(StringUtil.isEmpty(pageIndex)||pageIndex==1){
				pageIndex = 0;
			}else {
				pageIndex = (pageIndex-1)*pageSize;
			}
			String orderBy = "";
			if(order!=null&&order==0){
	    		orderBy = " order by "+sort+" desc";
	    	}else if(order!=null&&order==1){
	    		orderBy = " order by "+sort+"";
	    	}
			String time ="";
			//0为昨天，1为近七天，2为近三十天
			switch(dateType){
				case 0: time = " = date_sub(current_date(),interval 1 day)"; break;
				case 1: time =" >= date_sub(current_date(),interval 7 day)"; break;
				case 2: time =" >= date_sub(current_date(),interval 30 day)"; break;
			}
    		String sql = "select * from saleOrderDetail where storeId = "+storeId +" and createDate "+time+orderBy+" limit "+pageIndex+","+pageSize;
			try {
				data = BaseUtil.executeQueryByJdbc(sql,new SaleOrderDetail(),null);
				return BaseUtil.productJson(1, data,"获取成功!");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | SQLException e) {
				//异常回滚
				e.printStackTrace();
				throw new CustomerException("获取失败!");
			}

        
    }
    
}