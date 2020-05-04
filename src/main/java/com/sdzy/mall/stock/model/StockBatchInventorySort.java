package com.sdzy.mall.stock.model;

import java.util.Comparator;
import java.util.Date;

import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;

/**
 * Created by zwr on 2017/7/28.
 * desc:
 */
public class StockBatchInventorySort implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        MallStockBatchInventory model1 = (MallStockBatchInventory)o1;
        MallStockBatchInventory model2 = (MallStockBatchInventory)o2;

        //要判断日期是否为空，否则报异常
        String dateStr1 = model1.getProduceDate();
        String dateStr2 = model2.getProduceDate();
        
        boolean date1Empty = StringUtil.isEmpty(dateStr1);
        boolean date2Empty = StringUtil.isEmpty(dateStr2);
        
        if(date1Empty&&date2Empty)
            return 0;
        else if(date1Empty)
            return -1;
        else if(date2Empty)
            return 1;
        
        Date date1 = DateUtil.parseDateByDefaultFormat(formatDate(dateStr1));
        Date date2 = DateUtil.parseDateByDefaultFormat(formatDate(dateStr2));
        int flag = date1.compareTo(date2);
        return flag;
    }
    private String formatDate(String dataStr){
    	if(!dataStr.contains("-")&&dataStr.length()==8) {
    		String year  = dataStr.substring(0, 4);
        	String month  = dataStr.substring(4, 6);
        	String day  = dataStr.substring(6, 8);
        	return dataStr = year+"-"+month+"-"+day;
    	}
    	
    	return dataStr;
    }
}
