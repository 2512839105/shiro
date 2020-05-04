package com.sdzy.mall.promotion.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asdzy.common.controller.BaseController;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;
import com.sdzy.mall.promotion.model.PromotionProduct;
import com.sdzy.mall.promotion.model.PromotionStrategy;
import com.sdzy.mall.promotion.service.PromotionGiveProductService;
import com.sdzy.mall.promotion.service.PromotionProductService;
import com.sdzy.mall.promotion.service.PromotionStrategyService;
import com.sdzy.mall.promotion.service.PromotionType;


@Controller
@RequestMapping(value = "/promotion")
public class PromotionStrategyController extends BaseController {
    @Resource
    private PromotionStrategyService promotionStrategyService;
    @Resource
    private PromotionProductService promotionProductService;
    @Resource
    private PromotionGiveProductService promotionGiveProductService;

    private static final Logger logger = LoggerFactory.getLogger(PromotionStrategyController.class);

    /**
     * 新增或编辑页
     */
    @RequestMapping(value = "/tjEdit.action",method = RequestMethod.GET)
    public void tjEdit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
			 data=promotionStrategyService.findById(modelId);
			 request.setAttribute("model", data);
		 }else{
			 PromotionStrategy model = new PromotionStrategy();
			 // TODO: 请补全代码块
			 request.setAttribute("model", model);
		}
    }

    /**
     * 新增或编辑单品页
     */
    @RequestMapping(value = "/spEdit.action",method = RequestMethod.GET)
    public void singleProductEdit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
             data=promotionStrategyService.findById(modelId);
             request.setAttribute("model", data);
         }else{
             PromotionStrategy model = new PromotionStrategy();
             // TODO: 请补全代码块
             request.setAttribute("model", model);
        }
    }

    /**
     * 新增或编辑多品页
     */
    @RequestMapping(value = "/mpEdit.action",method = RequestMethod.GET)
    public void multiProductEdit(@RequestParam(value = "modelId",required = false) String modelId) {
         if(!StringUtil.isEmpty(modelId)) {
             data=promotionStrategyService.findById(modelId);
             request.setAttribute("model", data);
         }else{
             PromotionStrategy model = new PromotionStrategy();
             // TODO: 请补全代码块
             request.setAttribute("model", model);
        }
    }

    /**
     * 更新
     */
    @RequestMapping("/update.action")
    public String update(PromotionStrategy model) {
         data=promotionStrategyService.update(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }

    /**
     * 新增
     */
    @RequestMapping("/insert.action")
    public String insert(PromotionStrategy model, @RequestParam(required=true) Integer type) {
        
        if(type==0)
            model.setPromotionType(PromotionType.SPECIAL_OFFER.getDbValue());
        else if(type==1)
            model.setPromotionType(PromotionType.SINGLE_PRODUCT.getDbValue());
        
         data=promotionStrategyService.insert(model, this.getCurrentUser()); 
		 return this.sendSuccJson(data);
    }
    
    /**
     * 启用
     * @param modelIds
     * @return
     */
    @RequestMapping("/enableByIds.action")
    public String enableByIds(String modelIds) {
        promotionStrategyService.updateStateByIds(modelIds, 1);
        
        return this.sendSuccJson();
    }
    
    /**
     * 暂停
     * @param modelIds
     * @return
     */
    @RequestMapping("/pauseByIds.action")
    public String pauseByIds(String modelIds) {
        promotionStrategyService.updateStateByIds(modelIds, 3);
        
        return this.sendSuccJson();
    }

    /**
     * 按ID号查询
     */
    @RequestMapping("/findById.action")
    public String findById(String modelId) {
         data=promotionStrategyService.findById(modelId); 
		 return this.sendSuccJson(data);
    }

    /**
     * 根据参数分页查询
     */
    @RequestMapping("/listByPage.action")
    public @ResponseBody
    DataGrid listByPage(@RequestBody QueryParams queryParams) {
        return promotionStrategyService.listByPage(queryParams, getCurrentUser());
    }

    /**
     * 根据id删除数据
     */
    @RequestMapping("/deleteById.action")
    public String deleteById(String modelId) {
        promotionStrategyService.deleteById(modelId); 
		return this.sendSuccJson();
    }

    /**
     * 根据参数，任意删除
     */
    @RequestMapping("/deleteByParam.action")
    public String deleteByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		promotionStrategyService.deleteByParam(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据ids删除数据
     */
    @RequestMapping("/deleteByIds.action")
    public String deleteByIds(String modelIds) {
        promotionStrategyService.deleteByIds(modelIds); 
		return this.sendSuccJson();
    }

    
    /**
     * 根据ID修改数据
     */
    @RequestMapping("/updateById.action")
    public String updateById(@RequestParam Map<String, Object> paramMap) {
        List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("modelId", paramMap.get("modelId"));
		map.put("updateList", updateList);
		promotionStrategyService.updateById(map); 
		return this.sendSuccJson();
    }

    /**
     * 根据参数，任意更新
     */
    @RequestMapping("/updateByParam.action")
    public String updateByParam(@RequestParam Map<String, Object> paramMap) {
         List<Condition> whereList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		List<Condition> updateList = new ArrayList<Condition>();
		 // TODO: 请补全代码块
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		map.put("updateList", updateList);
		promotionStrategyService.updateByParam(map); 
		return this.sendSuccJson();
    }
    
    @RequestMapping("/updateLocalPromotionData.action")
    @ResponseBody
    public String updateLocalPromotionData() {
        
        logger.info("-------更新js文件！-------");
        String storeId = getCurrentUser().getStoreId();
        try {
            updateLocalPromotionData(request.getServletContext().getRealPath("/")+"/statics/js/promotionData_"+storeId+".js");
        } catch (Exception e) {
            e.printStackTrace();
            
            return "fail";
        }
        
        return "success";
    }

    char blank = ' ';
    char singleQuotes = '\'';
    char equalStr = '=';
    char commaStr = ',';
    char leftSquareBracket = '[';
    char rightSquareBracket = ']';
    String prefix = "var";
    
    String promotionStrategyArray = "promotionStrategyArray";
    //促销策略需要输出的字段
    String[] promotionStrategyFields = {"promotionStrategyId","storeId","promotionType","promotionStartDate"};
    
    String promotionProductArray = "promotionProductArray";
    //促销产品需要输出的字段
    String[] promotionProductFields = {"promotionProductId","promotionStrategyId","storeId","spromotionType"};
    
    String promotionGiveProductArray = "promotionGiveProductArray";
    //促销赠品需要输出的字段
    String[] promotionGiveProductFields = {"strategyIdOrPid","storeId","giveProductType"};
    
    private boolean updateLocalPromotionData(String filePath) throws NoSuchMethodException, SecurityException, Exception {
        File file = new File(filePath);
        try {
            if(!file.exists())
                file.createNewFile();
            
            Map<String, Object> paramMap = new HashMap<>();
            
            List<Condition> updateList = new ArrayList<>();
            updateList.add(Condition.createEq("storeId", getCurrentUser().getStoreId()));
            
            paramMap.put("whereList", updateList);
            
            List<PromotionStrategy> promotionStrategies = promotionStrategyService.listByParam(paramMap);
            List<PromotionProduct> promotionProducts = promotionProductService.listByParam(paramMap);
            List<PromotionGiveProduct> promotionGiveProducts = promotionGiveProductService.listByParam(paramMap);
            PrintWriter writer = new PrintWriter(new FileOutputStream(file));
            
            StringBuffer sb = new StringBuffer();
            printPromotionStrategies(sb, promotionStrategies, writer);
            printPromotionProducts(sb, promotionProducts, writer);
            printPromotionGiveProducts(sb, promotionGiveProducts, writer);
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    /**
     * 输出销售策略
     */
    private void printPromotionStrategies(StringBuffer sb, List<PromotionStrategy> promotionStrategies, PrintWriter writer) throws NoSuchMethodException, SecurityException, Exception {
        sb.append(prefix).append(blank).append(promotionStrategyArray).append(equalStr).append(leftSquareBracket);
        
        writer.print(sb.toString());
        sb.setLength(0);
        String[] fields = promotionStrategyFields;
        for(int i=0,length=promotionStrategies.size();i<length;i++) {
            
            PromotionStrategy promotionStrategy = promotionStrategies.get(i);
            
            sb.append(leftSquareBracket);
            
            getValueByFields(sb, fields, PromotionStrategy.class, promotionStrategy);
            
            sb.append(rightSquareBracket);
            
            if(i!=length-1)
                sb.append(commaStr);
            
            writer.print(sb.toString());
            sb.setLength(0);
        }
        writer.print(rightSquareBracket);
        
        writer.println();
    }
    
    /**
     * 输出销售产品
     */
    private void printPromotionProducts(StringBuffer sb, List<PromotionProduct> promotionProducts, PrintWriter writer) throws NoSuchMethodException, SecurityException, Exception {
        sb.append(prefix).append(blank).append(promotionProductArray).append(equalStr).append(leftSquareBracket);
        
        writer.print(sb.toString());
        sb.setLength(0);
        String[] fields = promotionProductFields;
        for(int i=0,length=promotionProducts.size();i<length;i++) {
            
            PromotionProduct promotionProduct = promotionProducts.get(i);
            
            sb.append(leftSquareBracket);
            
            getValueByFields(sb, fields, PromotionProduct.class, promotionProduct);
            
            sb.append(rightSquareBracket);
            
            if(i!=length-1)
                sb.append(commaStr);
            
            writer.print(sb.toString());
            sb.setLength(0);
        }
        writer.print(rightSquareBracket);
        
        writer.println();
    }

    /**
     * 输出销售赠品
     */
    private void printPromotionGiveProducts(StringBuffer sb, List<PromotionGiveProduct> promotionGiveProducts, PrintWriter writer) throws NoSuchMethodException, SecurityException, Exception {
        sb.append(prefix).append(blank).append(promotionGiveProductArray).append(equalStr).append(leftSquareBracket);
        
        writer.print(sb.toString());
        sb.setLength(0);
        //配置需要输出的字段
        String[] fields = promotionGiveProductFields;
        for(int i=0,length=promotionGiveProducts.size();i<length;i++) {
            
            PromotionGiveProduct promotionGiveProduct = promotionGiveProducts.get(i);
            
            sb.append(leftSquareBracket);
            
            getValueByFields(sb, fields, PromotionGiveProduct.class, promotionGiveProduct);
            
            sb.append(rightSquareBracket);
            
            if(i!=length-1)
                sb.append(commaStr);
            
            writer.print(sb.toString());
            sb.setLength(0);
        }
        writer.print(rightSquareBracket);
        
        writer.println();
    }
    
    private void getValueByFields(StringBuffer sb, String[] fields, Class<?> cla, Object object) throws NoSuchMethodException, SecurityException, Exception {
        for(int i=0,length=fields.length;i<length;i++) {
            String fieldStr = fields[i];
            Field field = cla.getDeclaredField(fieldStr);
            Method method = cla.getMethod("get"+getMethodName(fieldStr));
            Object result = method.invoke(object);
            sb.append(singleQuotes);
            if(field.getType().equals(Date.class)) {
                sb.append(((Date)result).getTime());
            }else {
                sb.append(result);
            }
            sb.append(singleQuotes);

            if(i!=length-1)
                sb.append(commaStr);
        }
    }
    
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}