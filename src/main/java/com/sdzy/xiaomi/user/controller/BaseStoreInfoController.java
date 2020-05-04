package com.sdzy.xiaomi.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
@RequestMapping("/baseStoreInfo")
public class BaseStoreInfoController extends BaseController {

	@Autowired
	BaseStoreInfoService  baseStoreInfoService;

    
    /**
     * 修改门店信息
     */
    @RequestMapping("/updateStoreById.action")
    public String updateStoreById(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect) {
    	 baseStoreInfoService.updateModel(data,js_code,appid,secrect); 
    	return this.sendSuccJson();
    }
  
    /**
     * 修改门店logo
     * @param logo
     * @param storeId
     * @return
     */      
    @RequestMapping("/updateStoreLogo.action")
    public String updateStoreLogo(MultipartFile logo,String storeId,String js_code,String appid,String secrect) {
	   	try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			 String logoname = logo.getOriginalFilename();               	       
			 String  logoPath= "/"+PropFileConfig.getProperty("uploadPath") +"/"+ DateUtil.formatCurrDateToS("yyyy/MM/dd")+"/"+ StringUtil.generate16ShortUUID()+logoname.substring(logoname.lastIndexOf("."));
			 String path=request.getServletContext().getRealPath("/")+logoPath;
			 File newFile=new File(path);
			 try {
			     if(!newFile.getParentFile().exists()){
			         newFile.getParentFile().mkdirs();
			     }
			     logo.transferTo(newFile);
			 } catch (IOException e) {
			     
			    throw new CustomerException("logo上传失败");
			 }   	 
			 data=baseStoreInfoService.updateStoreLogo(logoPath,storeId);	     
			 if(data.equals("1")){	    	 	    	  
				  return   this.sendSuccJson();
			 }
			 return this.sendFailJson("失败");
			}
		}  catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
       return null;
   }
    
    /**
     * 按主键查询
     */
    @RequestMapping("/selectStoreById.action")
    public String selectStoreById(String storeId,String js_code,String appid,String secrect) {
     try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
			data = baseStoreInfoService.selectById(storeId); 
			return this.sendSuccJson(data);
		 }
	} catch (IOException e) {
		throw new CustomerException(e+"参数验证失败");
	}
     return null;
    }
           
    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<BaseStoreInfo> selectModelsByPage(@RequestBody QueryParams queryParams,String js_code,String appid,String secrect) {
       try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			return baseStoreInfoService.selectModelsByPage(queryParams);
		   }
	} catch (IOException e) {
		throw new CustomerException(e+"参数验证异常");
	}
       return null;
       }
    
    /**
     * 查询所有门店 返回 storeId和storeName
     */  
    @RequestMapping("/selectStore.action")
    @ResponseBody 
    public String selectStore(String js_code,String appid,String secrect) {
       try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){ 
			return baseStoreInfoService.selectStore();
	    }
	} catch (IOException e) {
		throw new CustomerException(e+"参数验证异常");
	}
      return BaseUtil.productJson(null, appid, "参数验证失败"); 
    }

}

