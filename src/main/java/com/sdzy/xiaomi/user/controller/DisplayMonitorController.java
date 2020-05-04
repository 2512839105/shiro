package com.sdzy.xiaomi.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;
import com.sdzy.xiaomi.util.BaseUtil;

import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.model.JsonInfo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-04
 */
@Controller
@RequestMapping("/displayMonitor/")
public class DisplayMonitorController extends BaseController {

	@Autowired
	BaseStoreInfoService  baseStoreInfoService;   
    /**
     *
     * dateType 值 1,2,3,4,5 
     * 分别表示 统计  今天，昨天，本周，本月，今年  */    
	
	/**
	 * 根据地区对药店排名
	 * @param dateType
	 * @param address
	 */	
    @RequestMapping("/selectStoreRankRegion.action")
    @ResponseBody
    public String selectStoreRankRegion( String dateType,String address,String callback) {    	 
						 
			 return baseStoreInfoService.selectStoreRankRegion(dateType,address,callback);
    }    
    /**
     * 查询门店的详细信息 主要是图片
     * 视频 摄像头地址给监控端调用
     */
    @RequestMapping("/selectStoreDetail.action")
    @ResponseBody
    public String selectStoreDetail(String storeId,String callback) {    	 				 
		 return  baseStoreInfoService.selectStoreDetail(storeId,callback);	
    }
    /**
     * 根据企业名称搜索
     * @param companyName
     * @param callback
     * @return
     */
    @RequestMapping("/selectStoreByCompany.action")
    @ResponseBody
    public String selectStoreByCompany(String companyName,String callback) {    	 				 
		 	
		 return baseStoreInfoService.selectStoreByCompany(companyName,callback);
    }
    /**
     * 根据门店名称 和企业名 搜索 门店
     */
    @RequestMapping("/selectStoreByName.action")
    @ResponseBody
    public String selectStoreByName(String storeName,String callback,String companyId) {    	 				 
		 	
		 return baseStoreInfoService.selectStoreByName(storeName,callback,companyId);
    }
    /**
     * 获取门店监控录像地址 
     */
    @RequestMapping("/selectMonitorVideo.action")
    @ResponseBody
    public String selectMonitorVideo(String storeId) {    	 				 
		 	
		 return baseStoreInfoService.selectMonitorVideo(storeId);
    }
    
    
    
	/**
	 * 有bug
	 */
    @RequestMapping("/selectSaleDetail.action")
    @ResponseBody
    public String selectSaleDetail(String js_code,String appid,String secrect,String dateType,String storeId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */
			 data=baseStoreInfoService.selectSaleDetail(dateType,storeId);			 
			 return BaseUtil.productJson(1, data, "成功");
	/*	 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
    }
}

