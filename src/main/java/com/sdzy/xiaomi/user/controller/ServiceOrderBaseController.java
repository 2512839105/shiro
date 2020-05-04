package com.sdzy.xiaomi.user.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.dataSource.DataSource;
import com.sdzy.xiaomi.user.model.ServiceOrderBase;
import com.sdzy.xiaomi.user.service.ServiceOrderBaseService;
import com.sdzy.xiaomi.util.BaseUtil;
import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;
/**
 * <p>
 * 服务订单主表 前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
@Controller
@RequestMapping("/serviceOrderBase")
 
public class ServiceOrderBaseController extends BaseController {

	@Autowired
	ServiceOrderBaseService  serviceOrderBaseService;
    
    /**
     * 新增订单和订单明细
     */
	@DataSource(name="three")
    @RequestMapping("/insertOrder.action")
    public String insertOrder(@RequestParam Map<String,Object> data) {
     	try {
 			if(BaseUtil.getSessionAndOpenJson((String)data.get("js_Code"), (String)data.get("appid"),(String)data.get("secrect"))){
			   	return this.sendSuccJson(serviceOrderBaseService.insertOrder(data));
			}
		} catch (IOException e) {
			throw new CustomerException("参数验证异常");
		}
     	  return  this.sendFailJson("参数验证失败");
    }
    
    //修改订单状态
    @RequestMapping("/updateOrder.action")
    @ResponseBody
	@DataSource(name="three")
    public String updateOrder(@RequestParam Map<String,Object> data) {
    	try {
			if(BaseUtil.getSessionAndOpenJson((String)data.get("js_Code"), (String)data.get("appid"),(String)data.get("secrect"))){
				return  serviceOrderBaseService.updateOrder(data);
			}
		} catch (IOException e) {
			throw new CustomerException("参数验证异常");
		}
     return  BaseUtil.productJson(null,"","参数验证失败");
     }
    
    //根据买家Id 查询订单详情
    @RequestMapping("/selectBaseBybuyerId.action")
    @ResponseBody
	@DataSource(name="three")
    public String selectBaseBybuyerId(String buyerId,String appid,String secrect,String js_code){
    	try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
				data=serviceOrderBaseService.selectBaseBybuyerId(buyerId);
	    	return BaseUtil.productJson(1, data, "成功");
			}
		} catch (IOException e) {
			throw new CustomerException("参数验证异常");
		}
    	return BaseUtil.productJson(null, "", "参数验证失败");
    }
    //根据订单号查询订单详情
    @RequestMapping("/selectDetail.action")
    @ResponseBody
	@DataSource(name="three")
    public String selectDetail(String orderNo,String appid,String secrect,String js_code){
    	 try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  
				data=serviceOrderBaseService.selectDetail(orderNo);
			return BaseUtil.productJson(1, data, "成功");
			 	}
		} catch (IOException e) {
			throw new CustomerException("参数验证异常");
		}
    	return BaseUtil.productJson(null, "", "参数验证失败");    	
    } 
      
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<ServiceOrderBase> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return serviceOrderBaseService.selectModelsByPage(queryParams);
    }

}

