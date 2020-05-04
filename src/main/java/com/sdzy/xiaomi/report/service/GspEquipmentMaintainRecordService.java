package com.sdzy.xiaomi.report.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.report.model.GspEquipmentMaintainRecord;
import com.sdzy.xiaomi.report.model.GspEquipmentUseRecord;
import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-06-28
 */
public interface GspEquipmentMaintainRecordService extends IService<GspEquipmentMaintainRecord> {

  
	boolean delectByrecordId(Serializable maintainRecordId, String js_code, String appid, String secrect);
	
	GspEquipmentMaintainRecord updateByrecordId(String data,String js_code,String appid,String secrect);
	
	
	Page selectBystoreId(QueryParams queryParams,String storeId, String js_code, String appid, String secrect);
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<GspEquipmentMaintainRecord> selectModelsByPage(QueryParams queryParams);
}
