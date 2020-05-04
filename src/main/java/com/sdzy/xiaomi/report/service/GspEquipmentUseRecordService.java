package com.sdzy.xiaomi.report.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.report.model.GspEquipmentUseRecord;
import com.sdzy.xiaomi.report.model.GspRoomTemperatureRecord;
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
 * @since 2018-06-28
 */
public interface GspEquipmentUseRecordService extends IService<GspEquipmentUseRecord> {

   
	

	boolean delectByrecordId(Serializable userRecordId, String js_code, String appid, String secrect);
	
	GspEquipmentUseRecord updateByrecordId(String data,String js_code,String appid,String secrect);
	
	
	Page selectBystoreId(QueryParams queryParams,String storeId, String js_code, String appid, String secrect);
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<GspEquipmentUseRecord> selectModelsByPage(QueryParams queryParams);
}
