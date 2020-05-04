package com.sdzy.xiaomi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

 
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.ResponseBody;
 
 
 
import com.sdzy.xiaomi.user.service.MsgSendRecordService;
import com.sdzy.xiaomi.util.SendTemplateSMS;

import org.springframework.stereotype.Controller;

import com.sdzy.dataSource.DataSource;

import com.asdzy.common.controller.BaseController;
 

/**
 * <p>
 * 短信发送记录 前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
@Controller
@RequestMapping("/member")

public class MsgSendRecordController extends BaseController {
    
    private static final String successCode = "000000";
	@Autowired
	MsgSendRecordService  msgSendRecordService;

 
	/**
	 * 添加信息
	 */
	@DataSource(name="three")
	@RequestMapping("/addMessage.action")
	public String addMessage(@RequestParam(value = "data",required = false) String data,String js_code,String appid,String secrect ){							
	     msgSendRecordService.addMessage( data,js_code, appid, secrect);
	   return sendSuccJson(data);
	}
	
	/**
	 * 通过sendUserId 查询
	 */
	@DataSource(name="three")
	@RequestMapping("/selectBySendUserId.action")
	@ResponseBody
	public String selectBySendUserId(String sendUserId,String js_code,String appid,String secrect ){							
	      
	   return msgSendRecordService.selectBySendUserId(sendUserId,js_code, appid, secrect);
	}
   
}

