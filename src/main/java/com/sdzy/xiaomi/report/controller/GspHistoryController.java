package com.sdzy.xiaomi.report.controller;

import com.sdzy.xiaomi.report.service.GspEquipmentMaintainRecordService;
import com.sdzy.xiaomi.report.service.GspEquipmentUseRecordService;
import com.sdzy.xiaomi.report.service.GspFridgeTemperatureRecordService;
import com.sdzy.xiaomi.report.service.GspMeasureDeviceCheckRecordService;
import com.sdzy.xiaomi.report.service.GspMeasuringDeviceInfoService;
import com.sdzy.xiaomi.report.service.GspRoomTemperatureRecordService;
import com.sdzy.xiaomi.util.BaseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
@Controller
@RequestMapping("/hiostory")
public class GspHistoryController extends BaseController {

 
	@Autowired
	GspEquipmentMaintainRecordService gspEquipmentMaintainRecordService;
	@Autowired
	GspEquipmentUseRecordService gspEquipmentUseRecordService;
	@Autowired
	GspFridgeTemperatureRecordService gspFridgeTemperatureRecordService;
	@Autowired
	GspMeasuringDeviceInfoService gspMeasuringDeviceInfoService;
	@Autowired
	GspRoomTemperatureRecordService gspRoomTemperatureRecordService;
	@Autowired
	GspMeasureDeviceCheckRecordService gspMeasureDeviceCheckRecordService;
	
	
	/**
	 * 查询冰箱登记记录
	 * 
	 * @param storeId
	 * @return
	 */
	@RequestMapping("/gspFridgeTemperatureRecord.action")
    @ResponseBody
	public Page gspFridgeTemperatureRecord(QueryParams queryParams,String storeId,String js_code,String appid,String secrect){		
		return gspFridgeTemperatureRecordService.selectBystoreId(queryParams,storeId,js_code,appid,secrect);
	}
	/**
	 * 查询详情 冰箱登记记录
	 * @param modelId
	 * @return
	 */
	  @RequestMapping("/gspFridgeTemperatureRecordSelectById.action")
	 public String gspFridgeTemperatureRecordSelectById(String recordId,String js_code,String appid,String secrect) {  
	      try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
			    data = gspFridgeTemperatureRecordService.selectById(recordId); 
				return this.sendSuccJson(data);
			  }
		} catch (IOException e) {
			throw new CustomerException(e+"");
		}
	      return null;
	  }	    	
	/**
	 * 删除冰箱登记记录
	 * @param recordId
	 * @return
	 */	
	@RequestMapping("/gspFridgeTemperatureRecordDelete.action")
	public String gspFridgeTemperatureRecordDelete(String recordId,String js_code,String appid,String secrect){		    
			
		    gspFridgeTemperatureRecordService.deleteByrecordId(recordId,js_code,appid,secrect);		 
			return this.sendSuccJson();			
	}
	
	/**
	 * 修改冰箱登记记录
	 * @param 
	 * @return
	 */	
	@RequestMapping("/gspFridgeTemperatureRecordUpdate.action") 
	public String gspFridgeTemperatureRecordUpdate(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect ){	
		gspFridgeTemperatureRecordService.updateByrecordId(data,js_code,appid,secrect);		 	 
	 	return this.sendSuccJson();				
	}
	
		
	/**
	 *室温登记记录
	 */
	@RequestMapping("/gspRoomTemperatureRecord.action")
    @ResponseBody
	public Page gspRoomTemperatureRecord(QueryParams queryParams,String storeId,String js_code,String appid,String secrect){				
		return gspRoomTemperatureRecordService.selectBystoreId(queryParams,storeId,js_code,appid,secrect);		
	}	
	/**
	 * 查询详情 室温登记记录
	 * @param recordId
	 * @return
	 */
	  @RequestMapping("/gspRoomTemperatureRecordSelectById.action")
	 public String gspRoomTemperatureRecordSelectById(String recordId,String js_code,String appid,String secrect) {  
	    try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
			    data = gspRoomTemperatureRecordService.selectById(recordId); 
				return this.sendSuccJson(data);
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
	    return null;
	 }	
	
	/**
	 * 删除 室内温度登记记录
	 */
	@RequestMapping("/gspRoomTemperatureRecordDelete.action")
	public String gspRoomTemperatureRecordDelete(String recordId,String js_code,String appid,String secrect){				
			gspRoomTemperatureRecordService.delectByrecordId(recordId,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	
	/**
	 * 修改 室内温度登记记录
	 */
	@RequestMapping("/gspRoomTemperatureRecordUpdate.action")
	public String gspRoomTemperatureRecordUpdate(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){				
		gspRoomTemperatureRecordService.updateByrecordId(data,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}

	/**
	 * 设备使用记录接口 记录
	 * @param queryParams
	 * @param storeId
	 * @return
	 */
	@RequestMapping("/gspEquipmentUseRecord.action")
    @ResponseBody
	public Page gspEquipmentUseRecord(QueryParams queryParams,String storeId,String js_code,String appid,String secrect){
		
		return gspEquipmentUseRecordService.selectBystoreId(queryParams,storeId,js_code,appid,secrect) ;

	}
	/**
	 * 查询详情 设备使用记录
	 * @param userRecordId
	 * @return
	 */
	  @RequestMapping("/gspEquipmentUseRecordSelectById.action")
	 public String gspEquipmentUseRecordSelectById(String userRecordId,String js_code,String appid,String secrect) {  
	    try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			  		data = gspEquipmentUseRecordService.selectById(userRecordId); 
			  		return this.sendSuccJson(data);
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
	    return null;
	 }	
	
	/**
	 * 删除 设备使用记录
	 * userRecordId
	 */
	@RequestMapping("/gspEquipmentUseRecordDelete.action")
	public String gspEquipmentUseRecordDelete(String userRecordId,String js_code,String appid,String secrect){				
		  gspEquipmentUseRecordService.delectByrecordId(userRecordId,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	
	/**
	 * 修改 设备使用记录
	 */
	@RequestMapping("/gspEquipmentUseRecordUpdate.action")
	public String gspEquipmentUseRecordUpdate(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){				
		gspEquipmentUseRecordService.updateByrecordId(data,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	
	/**
	 * 设备维护记录接口
	 * @param queryParams
	 * @param storeId
	 * @return
	 */	
	@RequestMapping("/gspEquipmentMaintainRecord.action")
    @ResponseBody	 
	public Page gspEquipmentMaintainRecord(QueryParams queryParams,String storeId,String js_code,String appid,String secrect){
			
		return gspEquipmentMaintainRecordService.selectBystoreId(queryParams,storeId,js_code,appid,secrect);
	}
	/**
	 * 查询详情 设备维护记录
	 * @param modelId
	 * @return
	 */
	  @RequestMapping("/gspEquipmentMaintainRecordSelectById.action")
	 public String gspEquipmentMaintainRecordSelectById(String maintainRecordId,String js_code,String appid,String secrect) {  	    	
		  try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			    data = gspEquipmentMaintainRecordService.selectById(maintainRecordId); 
				return this.sendSuccJson(data);
			  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
		  return null;
	 }	
	
	/**
	 * 删除 设备维护记录
	 */
	@RequestMapping("/gspEquipmentMaintainRecordDelete.action")
	public String gspEquipmentMaintainRecordDelete(String maintainRecordId,String js_code,String appid,String secrect){				
		gspEquipmentMaintainRecordService.delectByrecordId(maintainRecordId,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	
	/**
	 * 修改 设备维护记录 
	 */
	@RequestMapping("/gspEquipmentMaintainRecordUpdate.action")
	public String gspEquipmentMaintainRecordUpdate(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){				
		gspEquipmentMaintainRecordService.updateByrecordId(data,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
		
	/**
	 * 查询详情计量器具检定
	 * @param storeId
	 * @return
	 */
	@RequestMapping("/gspMeasureDeviceCheckRecord.action")
    @ResponseBody
	public Page gspMeasureDeviceCheckRecord(QueryParams queryParams,String storeId,String js_code,String appid,String secrect){
		return gspMeasureDeviceCheckRecordService.selectBystoreId(queryParams,storeId,js_code,appid,secrect);
	}	
	/**
	 * 查询详情计量器具检定
	 * @param measureCheckId
	 * @return
	 */
	  @RequestMapping("/gspMeasureDeviceCheckRecordSelectById.action")
	 public String gspMeasureDeviceCheckRecordSelectById(String measureCheckId,String js_code,String appid,String secrect) {  
	    try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			    data = gspMeasureDeviceCheckRecordService.selectById(measureCheckId); 
				return this.sendSuccJson(data);
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
	    return null;
	 }	
	
	/**
	 * 删除 计量器具检定
	 * @param measureCheckId
	 */
	@RequestMapping("/gspMeasureDeviceCheckRecordDelete.action")
	public String gspMeasureDeviceCheckRecordDelete(String measureCheckId,String js_code,String appid,String secrect){				
		gspMeasureDeviceCheckRecordService.delectByrecordId(measureCheckId,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	/**
	 * 修改 计量器具检定  
	 * @param data
	 * @param js_code
	 * @param appid
	 * @param secrect
	 * @return
	 */
	@RequestMapping("/gspMeasureDeviceCheckRecordUpdate.action")
	public String gspMeasureDeviceCheckRecordUpdate(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect){				
		gspMeasureDeviceCheckRecordService.updateByrecordId(data,js_code,appid,secrect);
		 return this.sendSuccJson();		
	}
	
	
}

