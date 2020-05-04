package com.sdzy.xiaomi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.beans.factory.annotation.Autowired;
  
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdzy.dataSource.DataSource;
import com.sdzy.xiaomi.user.service.BaseStoreInfoService;
import com.sdzy.xiaomi.util.BaseUtil;
import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
 

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-04
 */
@Controller
@RequestMapping("/display")
public class DisplayController extends BaseController {

	@Autowired
	BaseStoreInfoService  baseStoreInfoService;

    @RequestMapping("/selectAllInterface.action")
    @ResponseBody
    public String selectAllInterface(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */
			String allSellMount = baseStoreInfoService.selectAllStore(dateType,companyId); //统计所有销售额
			String categoryRank=baseStoreInfoService.selectCategoryRank(dateType,companyId);	//根据药品销售类别排行	 
    	 	String storeRank = baseStoreInfoService.selectStoreSaleRank(dateType,companyId); 	//门店排行 根据销售额 排出前十名 以及统计门店数量 
     	 	String payRank = baseStoreInfoService.selectPayRank(dateType,companyId);//支付类型 排行  根据销售额 排倒叙出支付方式 
     	 	String regionRank = baseStoreInfoService.selectRegionRank(dateType,companyId);//根据区域排名
     	 	String rxDrugRank = baseStoreInfoService.selectIsRxDrugRank(dateType,companyId);// 查询处方药销售额
    	 	String memberCount=baseStoreInfoService.selectMemberCount(dateType,companyId);  //查询会员总数
    	 	String  data="{\"msg\":\"成功\",\"allSellMount\":"+allSellMount+",\"categoryRank\":"+categoryRank+",\"storeRank\":"+storeRank+",\"payRank\":"+payRank+",\"regionRank\":"+regionRank+",\"rxDrugRank\":"+rxDrugRank+",\"memberCount\":"+memberCount+"}";
    	 	return data;
	/*	 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
    }
    
	@DataSource(name="four") //切换到数据库YaoDianServiceCenter 统计所有门店的数量
	@RequestMapping("/selectAll.action")
    @ResponseBody
    public String  selectAll(String companyId){  	
    	return baseStoreInfoService.selectAll(companyId);
    }
	
	 /**
     * 根据药品类别销售额 对门店排行 对商品销售排行
     * 
     */
	   @RequestMapping("/selectStoreNameRank.action")
	    @ResponseBody
	    public String selectStoreNameRank(String js_code,String appid,String secrect,String dateType,String codeId,String companyId) {
	     	 /* try {
				if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */
		 	 
				 return baseStoreInfoService.selectStoreNameRank(codeId,dateType,companyId);
			/* 	  }
			} catch (IOException e) {
				throw new CustomerException(e+"参数验证异常");
			}
	    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
	  }
	   /**
	    * 滚动条
	    */
	   @RequestMapping("/realTimeSales.action")
	   @ResponseBody 
	   public String realTimeSales(String js_code,String appid,String secrect,String companyId ){
		   
		   return baseStoreInfoService.realTimeSales(companyId);
	   }
	   /**
	    * 地球仪
	    */
	   
	   @RequestMapping("/sellAmountGoupByHour.action")
	   @ResponseBody 
	   public String sellAmountGoupByHour(String js_code,String appid,String secrect,String companyId){
		   
		   return baseStoreInfoService.sellAmountGoupByHour(companyId);
	   }

    /**
     * 统计所有门店，销售交易额，订单数，成交商品数，线上交易占比
     * dateType 值 1,2,3,4,5 
     * 分别表示 统计 今天，昨天，本周，本月，今年 
     */
    @RequestMapping("/selectAllStore.action")
    @ResponseBody
    public String selectAllStore(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */
			  		 
			 return baseStoreInfoService.selectAllStore(dateType,companyId).toString();	
	/*	 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
    }
    
    /**
     * 根据药品销售类别排行
     */
    @RequestMapping("/selectCategoryRank.action")
    @ResponseBody
    public String selectCategoryRank(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */
			 data=baseStoreInfoService.selectCategoryRank(dateType,companyId);			 
			 return BaseUtil.productJson(1, data, "成功");
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
    }
   
 
    /**
     * 门店排行 根据销售额 排出前十名 以及统计门店数量
     */
    @RequestMapping("/selectStoreSaleRank.action")
    @ResponseBody
    public String selectStoreSaleRank(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */			  
    	 	 String st = baseStoreInfoService.selectStoreSaleRank(dateType,companyId); 	 
			 return st;
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败");  */
    }

       
    /**
     * 支付类型 排行  根据销售额 排倒叙出支付方式 
     */
    @RequestMapping("/selectPayRank.action")
    @ResponseBody
    public String selectPayRank(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */			  
    	 	data=baseStoreInfoService.selectPayRank(dateType,companyId);
			 return BaseUtil.productJson(1, data, "成功");
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败"); */
    }
    /*
     * 根据区域排名
     */
    @RequestMapping("/selectRegionRank.action")
    @ResponseBody
    public String selectRegionRank(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */			  
    	 	//data=
			 return baseStoreInfoService.selectRegionRank(dateType,companyId);
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败"); */
    }
    /*
     * 查询处方药销售额
     */
    @RequestMapping("/selectIsRxDrugRank.action")
    @ResponseBody
    public String selectIsRxDrugRank(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */			  
    	 	 data=baseStoreInfoService.selectIsRxDrugRank(dateType,companyId);
			 return BaseUtil.productJson(1, data,"成功");
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败"); */
    }
    
    /*
     * 查询会员总数
     */
    @RequestMapping("/selectMemberCount.action")
    @ResponseBody
    public String selectMemberCount(String js_code,String appid,String secrect,String dateType,String companyId) {
     	 /* try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){  */			  
    	 	 data=baseStoreInfoService.selectMemberCount(dateType,companyId);
 			 return BaseUtil.productJson(1, data,"成功");
		/* 	  }
		} catch (IOException e) {
			throw new CustomerException(e+"参数验证异常");
		}
    	return BaseUtil.productJson(null, appid, "参数验证失败"); */
    }
      
 
}

