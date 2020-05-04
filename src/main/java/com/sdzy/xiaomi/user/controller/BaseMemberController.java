package com.sdzy.xiaomi.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.user.model.BaseMember;
import com.sdzy.xiaomi.user.service.BaseMemberService;

import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.SuccessCallback;

import com.asdzy.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-03
 */
@Controller
@RequestMapping("/user")
public class BaseMemberController extends BaseController {

	@Autowired
	BaseMemberService  baseMemberService;                    
    /**
     * 根据门店id 查询会员
     */
    @RequestMapping("/selectMemberByStoreId.action")
    @ResponseBody
    public String selectMemberByStoreId(String storeId,String js_code,String appid,String secrect) {
        return  baseMemberService.selectMemberByStoreId(storeId,js_code,appid,secrect);

    }
    
    
    
}

