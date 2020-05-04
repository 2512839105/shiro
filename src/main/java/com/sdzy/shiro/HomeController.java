package com.sdzy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.session.ShiroUtil;
import com.asdzy.common.utils.MD5Util;
import com.asdzy.purpleredgourd.system.constant.SysConstant;
import com.asdzy.purpleredgourd.system.shiro.CustomerUsernamePasswordToken;
import com.sdzy.xiaomi.util.BaseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping(value = "/logins")
    public String login(String username,String password,String storeCode) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = null;
        System.out.println("exception=" + exception);
        String msg = "";
      
        String previousPassword=MD5Util.encrypt(password,"yaodian@sdzy!@#$%"); 
        
        CustomerUsernamePasswordToken token=new CustomerUsernamePasswordToken(username, password, previousPassword, storeCode);
        Subject subject = ShiroUtil.getSubject();
        subject.login(token);
        Map<String, Object> map = new HashMap<String, Object>();
        if (subject.isAuthenticated()) {
            LocalUser localUser = SessionUtil.getLocalUser();
            //查询处方平台ID到Cooike
  
            Session session = subject.getSession();
            session.setAttribute(SysConstant.CURRENT_USER, localUser);
        } else {
            msg = "没有登陆!";
        }
/*        Map<String,Object> map=new HashMap<String, Object>();
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }*/
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "videoList";
    }			
 // 使用手机号和短信验证码登录
    @RequestMapping("/plogin")
    @ResponseBody
    public JsonInfo pLogin(@RequestParam("phone") String phone, @RequestParam("code") String code, HttpSession session){

        // 根据phone从session中取出发送的短信验证码，并与用户输入的验证码比较
        String messageCode = (String) session.getAttribute(phone);

         if(code.equals(messageCode)){

            UserNamePasswordPhoneToken token = new UserNamePasswordPhoneToken(phone);

            Subject subject = ShiroUtil.getSubject();

            subject.login(token);
            LocalUser localUser = SessionUtil.getLocalUser();
            //查询处方平台ID到Cooike
            session.setAttribute(SysConstant.CURRENT_USER, localUser);
            return JsonInfo.succ(null);

        }else{
        	 return JsonInfo.error("登录失败", messageCode);
        }
    }
    
    @RequestMapping("/getCode")
    @ResponseBody
    public JsonInfo getCode(@RequestParam("phone") String phone){
    	
    	String order = BaseUtil.getOrderNo();
    	request.getSession().setAttribute(phone, order);
    	return JsonInfo.succ(order);
    }


    
    @RequestMapping("/logout.action")
    @ResponseBody
    public JsonInfo logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        System.out.println("退出登录");
        return JsonInfo.succ("退出登录");
    }
    
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}
