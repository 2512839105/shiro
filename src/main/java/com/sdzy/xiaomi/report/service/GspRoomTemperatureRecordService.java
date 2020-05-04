package com.sdzy.xiaomi.report.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.report.model.GspRoomTemperatureRecord;
import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-06-28
 */
public interface GspRoomTemperatureRecordService extends IService<GspRoomTemperatureRecord> {

  	Page<GspRoomTemperatureRecord> selectModelsByPage(QueryParams queryParams);

	Page selectBystoreId(QueryParams queryParams, String storeId, String js_code, String appid, String secrect);
	
	boolean delectByrecordId(Serializable recordId, String js_code, String appid, String secrect);
	
	GspRoomTemperatureRecord updateByrecordId(String data,String js_code,String appid,String secrect);
	
}
