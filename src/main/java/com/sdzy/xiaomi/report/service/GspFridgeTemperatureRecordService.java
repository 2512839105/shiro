package com.sdzy.xiaomi.report.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.report.model.GspFridgeTemperatureRecord;
import com.asdzy.common.model.Query;
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
public interface GspFridgeTemperatureRecordService extends IService<GspFridgeTemperatureRecord> {

 
	
    Page selectBystoreId(QueryParams queryParams,String storeId, String js_code, String appid, String secrect);
    
    boolean deleteByrecordId(Serializable recordId, String js_code, String appid, String secrect);
	
    GspFridgeTemperatureRecord updateByrecordId (String data,String js_code,String appid,String secrect);
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<GspFridgeTemperatureRecord> selectModelsByPage(QueryParams queryParams);
}
