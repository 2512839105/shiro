package com.sdzy.xiaomi.report.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.report.model.GspEquipmentMaintainRecord;
import com.sdzy.xiaomi.report.model.GspEquipmentUseRecord;
import com.sdzy.xiaomi.report.model.GspMeasuringDeviceInfo;
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
public interface GspMeasuringDeviceInfoService extends IService<GspMeasuringDeviceInfo> {

	boolean delectByrecordId(Serializable measureDeviceId);
	
	GspMeasuringDeviceInfo updateByrecordId(GspMeasuringDeviceInfo model);
	
 
    Page selectBystoreId(QueryParams queryParams,String storeId);
	Page<GspMeasuringDeviceInfo> selectModelsByPage(QueryParams queryParams);
}
