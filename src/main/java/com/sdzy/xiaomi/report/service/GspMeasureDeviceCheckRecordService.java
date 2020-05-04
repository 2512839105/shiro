package com.sdzy.xiaomi.report.service;

import com.sdzy.xiaomi.report.model.GspMeasureDeviceCheckRecord;
import com.sdzy.xiaomi.report.model.GspMeasuringDeviceInfo;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-02
 */
public interface GspMeasureDeviceCheckRecordService extends IService<GspMeasureDeviceCheckRecord> {

    /**
	 * 根据ID删除
     * @param secrect 
     * @param appid 
     * @param js_code 
	 * @param id
	 * @return
	 */
 

	
	
	boolean delectByrecordId(Serializable measureCheckId, String js_code, String appid, String secrect);
	
	GspMeasureDeviceCheckRecord updateByrecordId(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect);
	
 
    Page selectBystoreId(QueryParams queryParams,String storeId, String js_code, String appid, String secrect);
    
	
	 
}
