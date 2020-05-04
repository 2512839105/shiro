package com.sdzy.xiaomi.report.controller;


 
import com.sdzy.xiaomi.report.service.BaseProductService;
import com.sdzy.xiaomi.report.service.ReportService;
import com.sdzy.xiaomi.report.service.SaleOrderDetailService;
import com.sdzy.xiaomi.report.service.SaleOrderService;
import com.sdzy.xiaomi.report.service.SalePayOrderService;
import com.sdzy.xiaomi.report.service.StockBatchInventoryService;
 
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.asdzy.common.query.QueryParams;
 
import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
 
/**
 * <p>
 *  前端控制器
 * </p>
 * @author charlin
 * @since 2018-05-28
 */
@Controller
@RequestMapping("/report/report/")
public class ReportController extends BaseController {
	@Autowired
    BaseProductService baseProductService;
	@Autowired
    SaleOrderDetailService saleOrderDetailService;
	@Autowired
    SalePayOrderService salePayOrderService;
	@Autowired
	StockBatchInventoryService  stockBatchInventoryService;
	@Autowired
	SaleOrderService  saleOrderService;
	@Autowired
	ReportService reportService;
	
  /*  *//**
     * 效期品种， 查询库存表
     *  
     * @param storeId
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @param dateType
     * @return
     *//*
    @RequestMapping("/stock/listExpiredProduct.action")
    public String listExpiredProduct(String js_code,String appid,String secret,String vloginId,String vpwd,String storeId,String userId,String pageIndex,String pageSize,String dateType) {
    	data = stockBatchInventoryService.listExpiredProduct(js_code,appid,secret,storeId,userId,pageIndex,pageSize,dateType); 
    	return this.sendSuccJson(data);
    }
	
   *//**success
    * 按销售额查询
    * @param js_code
    * @param appid
    * @param secret
    * @param storeId
    * @param userId
    * @param dateType
    * @return
    *//*
    @RequestMapping("/sale/listSaleAmount.action")
    public String listSaleAmount(String js_code,String appid,String secrect,String storeId,String userId,String dateType) {
    	 data=saleOrderDetailService.listSaleAmount(storeId,userId,dateType); 
		return this.sendSuccJson(data);
    }
    *//**
     * success
     * 按客流量查询
     * @param storeId
     * @param userId
     * @param dateType
     * @return
     *//*
    @RequestMapping("/sale/listFlowNum.action")
    public String listFlowNum(String js_code,String appid,String secrect,String storeId,String userId,String dateType) {
    	data = saleOrderService.listFlowNum(storeId,userId,dateType); 
    	return this.sendSuccJson(data);
    }    
   *//**
    * 按照毛利
    * @param storeId
    * @param userId
    * @param dateType
    * @return
    *//*
    @RequestMapping("/sale/listGrossProfit.action")
    public String listGrossProfit(String js_code,String appid,String secret,String storeId,String userId,String dateType) {
    	data = saleOrderDetailService.listGrossProfit(storeId,userId,dateType); 
    	return this.sendSuccJson(data);
    }
    
*/   /**
    * 销售报表按年月日
    * 按年月日  
    * @param js_code
    * @param appid
    * @param secrect		
    * @param storeId
    * @param userId
    * @param dateType 参数值为 y,m,w,d,r 分别是按年、月、周、天、即时查询
    * @return
    */
    @RequestMapping("/sale/listReport.action")
    @ResponseBody
    public String listReport(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType) {   		
    	return reportService.listReport(callback, js_code, appid, secrect, storeId, userId, dateType); 	 
    }
    /**
     * 店长速报
     * @param js_code
     * @param appid
     * @param secrect
     * @param storeId
     * @param userId
     * @param dateType 参数值为 y,m,w,d,r 分别是按年、月、周、天、即时查询
     * @return
     */
    @RequestMapping("/sale/shopChief.action")
    @ResponseBody
    public String  shopChief(String callback ,String js_code,String appid,String secrect,String storeId,String userId,String dateType) {   			
     	 return reportService.shopChief(callback, js_code, appid, secrect, storeId, userId, dateType);
    }
    /**
     * 详细报表
     * @param callback
     * @param js_code
     * @param appid
     * @param secrect
     * @param storeId
     * @param userId
     * @param dateType 参数值为 y,m,w,d,r 分别是按年、月、周、天、即时查询
     * @return
     */
    @RequestMapping("/sale/listDetailed.action")
    @ResponseBody
    public String listDetailed(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType) {   	   	
	      return reportService.listDetailed(callback, js_code, appid, secrect, storeId, userId, dateType);	 
    } 
    
    /**详细报表 
     * 监控端
     * */
    @RequestMapping("/sale/listDetailedMonitor.action")
    @ResponseBody
    public String listDetailedMonitor(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType,String createDate) {   	   	
	      return reportService.listDetailedMonitor(callback, js_code, appid, secrect, storeId, userId, dateType,createDate);	 
    }
    
 
    
    /**
     * 商品速查
     * 查询畅销品种排行
     */
    @RequestMapping("/sale/listBestSaleProduct.action")
    @ResponseBody
    public String listBestSaleProduct(QueryParams queryParams ,String dateType,String sor,String js_code,String appid,String secrect,String storeId ) {   	   	    	 
    	
    	return reportService.listBestSaleProduct(queryParams,dateType,sor,js_code, appid, secrect,storeId);
    }
    
    /**
     * 商品速查
     * 查询效率期品种
     * dateType 查询的时间 
     * sor 升序降序 
     */
    @RequestMapping("/sale/listExpiriedProduct.action")
    @ResponseBody
    public String listExpiriedProduct(QueryParams queryParams,String dateType ,String sor,String js_code,String appid,String secrect,String storeId) {   	   	    	 
    	return reportService.listExpiriedProduct(queryParams,dateType,sor,js_code, appid, secrect,storeId);
    }
    
    
    /**
     * 商品速查
     * 查询即时库存
     *  pageIndex 当前页,number 单页的数量
     *  codeOrName //根据货号或者商品名
     */
    @RequestMapping("/sale/listStockCount.action")
    @ResponseBody
    public String listStockCount(QueryParams queryParams,String sor,String codeOrName,String js_code,String appid,String secrect,String storeId) {   	   	    	 
    	return reportService.listStockCount(queryParams,sor,codeOrName,js_code,appid,secrect,storeId);   
   
    }
    
    /**
     * 商品速查
     * 缺货预警
     * 		
     */
    
    @RequestMapping("/sale/listLessStock.action")
    @ResponseBody
    public String listLessStock(QueryParams queryParams,String sor,String js_code,String appid,String secrect,String storeId) {   	   	    	    	
    	return reportService.listLessStock(queryParams,sor,js_code,appid,secrect,storeId);  
    }
    /**
     * 根据商品 id 查出详情
     */
    @RequestMapping("/sale/selectProductdetailsById.action")
    @ResponseBody
    public String selectProductdetailsById(String productId,String storeId,String js_code,String appid,String secrect) {      	
    	return reportService.selectProductdetailsById(productId,storeId,js_code,appid,secrect);
    }
   
    /** 
     * 商品速查
     * 根据 商品名查出详情
     */
    @RequestMapping("/sale/commodityInquiryByproductName.action")
    @ResponseBody
    public String commodityInquiryByproductName(String productName,String js_code,String appid,String secrect,String storeId) {   	   	    	 
    	return reportService.commodityInquiryByproductName(productName,js_code,appid,secrect,storeId);
    }

    /**null
     * 区域速报
     */
    @RequestMapping("/sale/regional.action")
    @ResponseBody
    public String regional(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType){
    	   	
    	return reportService.listReport(callback, js_code, appid, secrect, storeId, userId, dateType);
    }
    
    /**
     * 区域速报详情
     */
    @RequestMapping("/sale/regionaldetails.action")
    @ResponseBody
    public String regionaldetails(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType) {   	   	    	 
    	return reportService.listReport(callback, js_code, appid, secrect, storeId, userId, dateType);
    }
         
    /**
     * 查询所有店铺 按照sellAmount 降序排列
     * @return
     */   
    @RequestMapping("/sale/selectAllStare.action")
    @ResponseBody
    public String selectAllStare(String callback,String js_code,String appid,String secrect){    		
    	return reportService.selectAllStare(callback,js_code,appid,secrect);
    }
       
    /**
     * 根据门店名称或编码 查询门店 模糊查询
     */ 
    @RequestMapping("/sale/selectStareByNameOrCode.action")
    @ResponseBody
    public String selectStareByNameOrCode(String storeNameOrCode,String js_code,String appid,String secrect){    	
    	return reportService.selectStareByNameOrCode(storeNameOrCode,js_code,appid,secrect);
    } 
       
    /**
     * 店铺排名
     *  
     * @param queryParams
     * @return
     */    
    @RequestMapping("/sale/Rankings.action")
    @ResponseBody
     public String rankings(String callback,String js_code,String appid,String secrect,String storeId,String userId,String dateType) {
    	return reportService.ranking(callback, js_code, appid, secrect, storeId, userId, dateType);
    }          
    /**
     *店铺排名
     *根据storeId
     *查询店铺的详情
     */   
    @RequestMapping("/sale/RankingsByStoreId.action")
    @ResponseBody
    public String rankingsByStoreId(String callback,String storeId,String dateType,String js_code,String appid,String secrect) {
    	   	
    	return reportService.rankingsByStoreId(callback,storeId, dateType,js_code,appid,secrect);
   
    }  
   
    /**
     * 员工业绩
     * 个人销售总汇
     * 查询出客流 客单价 毛利 销售额
     * dateType :m 当月 和上月 ,d 昨天 
     * @return
     */   
    @RequestMapping("/sale/employeePerformance.action")
    @ResponseBody
    public String employeePerformance(String callback,String js_code,String appid,String secrect,String storeId,
    		String seller,String dateType) {       		    
    	return reportService.employeePerformance(callback, js_code, appid, secrect, storeId, seller, dateType);     
    }
    
    /**
     *员工业绩
     *个人销售 曲线  
     *dateType : d查出 7天   m 6个月的
     *个人销售额
     * @return
     */ 
    @RequestMapping("/sale/personalSales.action")
    @ResponseBody    
    public String personalSales(String callback,String js_code,String appid,String secrect,String 
    		storeId,String userId,String dateType) {       		      
    	return reportService.personalSales(callback, js_code, appid, secrect, storeId, userId, dateType);     
    }
      
    /**
     *员工业绩 排行
     *userId不传 默认 查出 业绩排行
     *按照上月 销售额降序
     * @return
     */ 
    @RequestMapping("/sale/personalRankings.action")
    @ResponseBody    
    public String personalRankings(String callback,String js_code,String appid,String secrect,String 
    		storeId,String userId) {       		      
    	return reportService.personalRankings(callback, js_code, appid, secrect, storeId, userId);     
    }
    
  
}

