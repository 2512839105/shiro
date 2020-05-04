package com.sdzy.mall.base.controller;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.mall.base.model.MallBaseProduct;
import com.sdzy.mall.base.service.MallBaseProductService;
import com.sdzy.mall.base.service.MallBaseStoreInfoService;
import com.sdzy.mall.util.BaseUtil;
import com.sdzy.xiaomi.user.model.BaseStoreInfo;

 
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
@Controller
@RequestMapping("/base/baseProduct")
public class MallBaseProductController extends BaseController {

	@Autowired
	MallBaseProductService  baseProductService;
	@Autowired
    MallBaseStoreInfoService  ballBaseStoreInfoService;

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
    	baseProductService.deleteById(modelId); 
		return this.sendSuccJson();
    }
    
    
    /**
     * 新增或者更新
     */
    @RequestMapping("/insertOrUpdateModel.action")
    public String insertOrUpdateModel(MallBaseProduct model) {
    	data = baseProductService.insertOrUpdateModel(model); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 按主键查询
     */
    @RequestMapping("/findModelById.action")
    public String findModelById(String modelId) {
    	data = baseProductService.selectById(modelId); 
    	return this.sendSuccJson(data);
    }
    
    
    /**
     * 查询实体并转到修改页面
     */
    @RequestMapping("/findModelByUpdate.action")
    public ModelAndView findModelByUpdate(String modelId) {
    	data = baseProductService.selectById(modelId); 
    	return new ModelAndView("/base/baseProduct","data",data);
    }
    

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page<MallBaseProduct> selectModelsByPage(@RequestBody QueryParams queryParams) {
        return baseProductService.selectModelsByPage(queryParams);
    }

    
    /**
     *  根据商品类别获取商品列表 
     */
    @RequestMapping("/selectProductByCategory.action")
    public @ResponseBody Page selectProductByCategory(String vloginId,String vpwd,Integer offset,Integer current,Integer limit,String storeId,String propertyId) {
        if(!BaseUtil.validate(vloginId, vpwd)) {
            return BaseUtil.unValidate();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("propertyId", propertyId);
        map.put("storeId", storeId);
        return baseProductService.selectProductByCategory(offset,current,limit,map);
    }
    
    /**
     *  根据商品实体
     */
    @RequestMapping("/selectProductById.action")
    public String selectProductById(String vloginId,String vpwd,String storeId,String productId) {
        if(!BaseUtil.validate(vloginId, vpwd)) {
            return this.sendFailJson(BaseUtil.unValidate(), "接口验证失败");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productId", productId);
        map.put("storeId", storeId);
        return this.sendSuccJson(baseProductService.selectProductById(map));
    }
      
    
    /**
     *  根据商品名，商店名获得实体
     *  @param type 0 综合排序   1 距离排序  2价格排序   3销量
     */
    @RequestMapping("/selectProductAndStore.action")
    public String selectProductAndStore(String vloginId,String vpwd,Integer offset,Integer current,Integer limit,
            String latitude,String longitude,String keyValue,Integer type,boolean isAsc) {
        if(!BaseUtil.validate(vloginId, vpwd)) {
            return this.sendFailJson(BaseUtil.unValidate(), "接口验证失败");
        }
        String orderType = "";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("keyValue", keyValue);
        if(type==2) {
            orderType = "bp.retailPrice";    
        }
        if(type==3) {
            orderType = "saleCount";
        }

        Page productPage = baseProductService.selectProductAndStore(offset,current,limit,isAsc,orderType,map);
        Page storePage = ballBaseStoreInfoService.selectProductAndStore(offset, current, limit, orderType, map);
        List productList = productPage.getRecords();
        List storeList = storePage.getRecords();
        if(type==0||type==1) {
            productList = orderList(productList,latitude,longitude);
            storeList = orderList(storeList,latitude,longitude);
            productPage.setRecords(productList);
            storePage.setRecords(storeList);
        }
        map.clear();
        map.put("productTotal", productPage);
        map.put("productList", productList);
        map.put("storeTotal", storePage);
        map.put("storeList", storeList);
        return this.sendSuccJson(map);
        
     }
    
    
   
@SuppressWarnings("unchecked")
private List orderList(List comList,String latitude,String longitude) {
        
        Collections.sort(comList, new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                String latitude1 = "";
                String longitude1 =""; 
                String latitude2 ="";
                String longitude2 = "";
                double distance1 = 0.0;
                double distance2 = 0.0;
                if(o1 instanceof BaseStoreInfo) {
                    BaseStoreInfo so1 = (BaseStoreInfo)o1;  
                    BaseStoreInfo so2 = (BaseStoreInfo)o2;  
                     latitude1 = (so1.getLatitude()==null?"1.0":so1.getLatitude());
                     longitude1 = (so1.getLongitude()==null?"1.0":so1.getLongitude());
                     latitude2 = (so2.getLatitude()==null?"1.0":so2.getLatitude());
                     longitude2 = (so2.getLongitude()==null?"1.0":so2.getLongitude());
                     distance1 = BaseUtil.OrderWithDit(latitude1, latitude, longitude1, longitude);
                     distance2 = BaseUtil.OrderWithDit(latitude2, latitude, longitude2, longitude);
                     so1.setInstance(distance1);
                     so2.setInstance(distance2);  
                }else if(o1 instanceof HashMap) {
                    Map so1 = (Map)o1;
                    Map so2 = (Map)o2;
                    latitude1 = (so1.get("latitude")==null?"1.0":(String) so1.get("latitude"));
                    longitude1 = (so1.get("longitude")==null?"1.0":(String) so1.get("longitude"));
                    latitude2 = (so2.get("latitude")==null?"1.0":(String) so2.get("latitude"));
                    longitude2 = (so2.get("longitude")==null?"1.0":(String) so2.get("longitude"));     
                    distance1 = BaseUtil.OrderWithDit(latitude1, latitude, longitude1, longitude);
                    distance2 = BaseUtil.OrderWithDit(latitude2, latitude, longitude2, longitude);
                    so1.put("distance", distance1);
                    so2.put("distance", distance1);
                }
                return (int) (distance1 - distance2);  //升序
            }
        });
        return comList;
    }
    
}

