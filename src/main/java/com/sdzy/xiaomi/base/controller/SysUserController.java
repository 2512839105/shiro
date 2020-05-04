package com.sdzy.xiaomi.base.controller;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
import com.sdzy.xiaomi.base.service.SysUserService;
import com.sdzy.xiaomi.util.BaseUtil;

 

@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController extends BaseController{
    @Autowired
    private SysUserService sysUserService;

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
     
 
    /**
     * 根据参数分页查询  系统用户
     */
    @RequestMapping("/selectSysUserByStoreId.action")
    public String selectSysUserByStoreId(String storeId,String js_code,String appid,String secrect) {
    	try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				data=sysUserService.selectSysUserByStoreId(storeId);
				return this.sendSuccJson(data);
			}
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证失败");
		}
    	return null;
    }



    /**
     * 收银员查询
     */
    @RequestMapping("/listSeller.action")
    public String listSeller(String storeId,String js_code,String appid,String secrect) {      
		 try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){	
					 list =sysUserService.listSeller(storeId);
					 return this.sendJsonGrid(list);
				  }
			} catch (IOException e) {
				throw new CustomerException(e+"");
			}
		      return null ;
    }
 
}