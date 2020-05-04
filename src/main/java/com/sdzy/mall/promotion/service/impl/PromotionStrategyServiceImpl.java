package com.sdzy.mall.promotion.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.mall.promotion.mapper.PromotionGiveProductDAO;
import com.sdzy.mall.promotion.mapper.PromotionProductDAO;
import com.sdzy.mall.promotion.mapper.PromotionStrategyDAO;
import com.sdzy.mall.promotion.model.PromotionGiveProduct;
import com.sdzy.mall.promotion.model.PromotionProduct;
import com.sdzy.mall.promotion.model.PromotionStrategy;
import com.sdzy.mall.promotion.service.PromotionStrategyService;
import com.sdzy.mall.promotion.service.PromotionType;


@Service
public class PromotionStrategyServiceImpl implements PromotionStrategyService {
    @Resource
    private PromotionStrategyDAO promotionStrategyDAO;
    @Resource
    private PromotionProductDAO promotionProductDAO;
    @Resource
    private PromotionGiveProductDAO promotionGiveProductDAO;

    private static final Logger logger = LoggerFactory.getLogger(PromotionStrategyServiceImpl.class);
    
    private final Integer deleteStatus = -1;
    private final Integer normalStatus = 1;

    
    @Override
    public PromotionStrategy insert(PromotionStrategy model) {
        promotionStrategyDAO.insert(model); 
	 return model;
    }

    @Override
    public PromotionStrategy insert(PromotionStrategy model, LocalUser currentUser) {
        //状态
        Integer normal = 1;
        
        Date now = DateUtil.getCurrDateTime();
        String storeId = currentUser.getStoreId();
        String promotionStrategyId = StringUtil.generate16ShortUUID();
        model.setStoreId(storeId);
        model.setPromotionStrategyId(promotionStrategyId);
        model.setPromotionState(normal);
        model.setCreateDate(now);
        model.setModifyDate(now);

        if(model.getReachedCAToDiscount()!=null) {
            model.setReachedCAToDiscount(model.getReachedCAToDiscount().divide(new BigDecimal(10)));
        }
        
        //添加促销产品、促销赠品、或另赠品
        addDetails(model);
        
        promotionStrategyDAO.insert(model);
        
		return model;
    }

    @Override
    public PromotionStrategy findById(String modelId) {
        return promotionStrategyDAO.findById(modelId);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams, LocalUser currentUser, String ... params) {       
    	/*List<Condition> whereList = queryParams.filtersToDBConditionals();
		whereList.add(Condition.createEq("storeId",currentUser.getStoreId()));;
		PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
		if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
			PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
		}		
		//whereList.add(Condition.create("IFNULL(promotionState, '')", deleteStatus , Condition.OpType.NE));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereList", whereList);
		//List list = promotionStrategyDAO.listByPage(map);
		List list = promotionStrategyDAO.listPromotionByParam(map);
		PageInfo pageInfo = new PageInfo(list);
		return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List<PromotionStrategy> listByParam(Map<String, Object> paramMap) {
        return promotionStrategyDAO.listByParam(paramMap);
    }

    @Override
    public PromotionStrategy findByParam(Map<String, Object> paramMap) {
        return promotionStrategyDAO.findByParam(paramMap);
    }

    @Override
    public Integer deleteById(String modelId) {
        return promotionStrategyDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return promotionStrategyDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer deleteByIds(String modelIds) {
        if (StringUtil.isEmpty(modelIds)){throw new CustomerException("删除失败！");}
		Integer data = 0;
		if (modelIds.contains(",")){
			String[] recordIdArr = modelIds.split(",");
			for (String modelId: recordIdArr) {
				//Integer count = this.deleteById(modelId);
				Integer count = this.updateDeleteStatus(modelId, deleteStatus );
				data += count;
			}
		}else{
			data = this.updateDeleteStatus(modelIds, deleteStatus);
		}
		return data;
    }

    @Override
    public Integer updateDeleteStatus(String modelId, int deleteFlag) {
        PromotionStrategy model = promotionStrategyDAO.findById(modelId);
		model.setPromotionState(deleteFlag);
		
		//如果存在另赠品（多品促销时）
		if(model.getPromotiomGiveType()!=null&&model.getPromotiomGiveType()==2) {
		    updateGiveProductsDeleteStatus(model);
		}
		
		updatePromotionProductsDeleteStatus(model);
		
		return promotionStrategyDAO.updateByPrimaryKey(model);
    }

    @Override
    public PromotionStrategy update(PromotionStrategy model, LocalUser user) {
        
        String modelId = model.getPromotionStrategyId();
        String storeId = user.getStoreId();
        PromotionStrategy dbPromotionStrategy = this.findById(modelId);
        
        if(dbPromotionStrategy==null)
            throw new CustomerException("不存在相关销售策略！");
        
        Date now = DateUtil.getCurrDateTime();
        model.setModifyDate(now);
        model.setStoreId(storeId);
        
		List<Condition> whereList = new ArrayList<Condition>();
		List<Condition> updateList = new ArrayList<Condition>();
		
		whereList.add(Condition.createEq("promotionStrategyId", modelId));
		whereList.add(Condition.createEq("storeId", storeId));
		
		Integer dbPromotionType = dbPromotionStrategy.getPromotionType();
		
		//如果是多品促销
		if(dbPromotionType!=PromotionType.SINGLE_PRODUCT.getDbValue()&&dbPromotionType!=PromotionType.SPECIAL_OFFER.getDbValue()) {
		    
		    if(model.getReachedCAToDiscount()!=null) {
		        model.setReachedCAToDiscount(model.getReachedCAToDiscount().divide(new BigDecimal(10)));
            }
		    
		    updateList.add(Condition.createEq("promotionType", model.getPromotionType()));
		    updateList.add(Condition.createEq("reachedCountOrAmount", model.getReachedCountOrAmount()));
		    updateList.add(Condition.createEq("reachedCAToGiveCount", model.getReachedCAToGiveCount()));
		    updateList.add(Condition.createEq("reachedCAToReduceMoney", model.getReachedCAToReduceMoney()));
		    updateList.add(Condition.createEq("reachedCAToDiscount", model.getReachedCAToDiscount()));
		    updateList.add(Condition.createEq("reachedCAToAddMoney", model.getReachedCAToAddMoney()));
		    updateList.add(Condition.createEq("promotiomGiveType", model.getPromotiomGiveType()));
		}else{
		    model.setPromotionType(dbPromotionType);
		}
		
		updateList.add(Condition.createEq("modifyDate", now));
		updateList.add(Condition.createEq("promotionName", model.getPromotionName()));
		updateList.add(Condition.createEq("promotionRange", model.getPromotionRange()));
		updateList.add(Condition.createEq("customerRange", model.getCustomerRange()));
		updateList.add(Condition.createEq("promotionStartDate", model.getPromotionStartDate()));
		updateList.add(Condition.createEq("promotionEndDate", model.getPromotionEndDate()));
		
		//删除另赠品
		deleteGiveProducts(model);
		//删除促销产品、另赠品
		deletePromotionProducts(model);
        //添加促销产品、促销赠品、或另赠品
        addDetails(model);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("whereList", whereList);
		map.put("updateList", updateList);
		
		this.updateByParam(map);
		
		return model;
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return promotionStrategyDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return promotionStrategyDAO.updateByParam(paramMap);
    }

    @Override
    public Integer updateStateByIds(String modelIds, Integer state) {
        if (StringUtil.isEmpty(modelIds)){
            throw new CustomerException("主键不能为空！");
        }
        
        Integer data = 0;
        
        Map<String, Object> map = new HashMap<>();
        
        List<Condition> updateList = new ArrayList<>();
        
        updateList.add(Condition.createEq("promotionState", state));
        
        map.put("updateList", updateList);
        
        if (modelIds.contains(",")){
            String[] recordIdArr = modelIds.split(",");
            for (String modelId: recordIdArr) {
                map.put("modelId", modelId);
                
                Integer count = this.updateById(map);
                data+=count;
            }
        }else{
            map.put("modelId", modelIds);
            data = this.updateById(map);
        }
        
        return data;
    }
    
    /**
     * 添加促销产品、促销赠品、或另赠品
     * @param model
     */
    private void addDetails(PromotionStrategy model) {
        Date now = model.getModifyDate();
        String storeId = model.getStoreId();
        String promotionStrategyId = model.getPromotionStrategyId();
        
        if (model.getDetails()!=null&&model.getDetails().size()>0) {
            for(PromotionProduct product : model.getDetails()) {
                String promotionProductId = StringUtil.generate16ShortUUID();
                product.setPromotionProductId(promotionProductId);
                product.setCreateDate(now);
                product.setModifyDate(now);
                product.setPromotionStrategyId(promotionStrategyId);
                product.setStoreId(storeId);
                product.setStatus(normalStatus);
                
                if(product.getSreachedCAToDiscount()!=null) {
                    product.setSreachedCAToDiscount(product.getSreachedCAToDiscount().divide(new BigDecimal(10)));
                }
                
                //如果促销策略为单品促销，且为另赠品
                if(model.getPromotionType()==PromotionType.SINGLE_PRODUCT.getDbValue()
                        &&product.getSpromotiomGiveType()!=null&&product.getSpromotiomGiveType()==2) {
                    
                    for(PromotionGiveProduct giveProduct : product.getDetails()) {
                        giveProduct.setGiveProductId(StringUtil.generate16ShortUUID());
                        giveProduct.setStrategyIdOrPid(promotionProductId);
                        giveProduct.setCreateDate(now);
                        giveProduct.setModifyDate(now);
                        giveProduct.setStoreId(storeId);
                        giveProduct.setStatus(normalStatus);
                        //属于促销产品
                        giveProduct.setGiveProductType(1);
                        
                        promotionGiveProductDAO.insert(giveProduct);
                    }
                    
                }else if(model.getPromotionType()==PromotionType.SPECIAL_OFFER.getDbValue()) {
                    product.setSpromotionType(PromotionType.SPECIAL_OFFER.getDbValue());
                }
                
                promotionProductDAO.insert(product);
            }
        }
        
        //当赠品类别不为空，且为另赠品时
        if(model.getPromotiomGiveType()!=null&&model.getPromotiomGiveType()==2) {
            for(PromotionGiveProduct giveProduct : model.getGiveProducts()) {
                giveProduct.setGiveProductId(StringUtil.generate16ShortUUID());
                giveProduct.setStrategyIdOrPid(promotionStrategyId);
                giveProduct.setStoreId(storeId);
                giveProduct.setCreateDate(now);
                giveProduct.setModifyDate(now);
                giveProduct.setStatus(normalStatus);
                //属于促销策略
                giveProduct.setGiveProductType(0);
                
                promotionGiveProductDAO.insert(giveProduct);
            }
        }
    }
    
    /**
     * 根据销售策略-删除另赠品
     * @param model
     */
    private void deleteGiveProducts(PromotionStrategy model) {
        String modelId = model.getPromotionStrategyId();
        String storeId = model.getStoreId();
        Map<String, Object> map = new HashMap<>();
        
        List<Condition> whereList = new ArrayList<>();
        whereList.add(Condition.createEq("strategyIdOrPid", modelId));
        whereList.add(Condition.createEq("storeId", storeId));
        map.put("whereList", whereList);
        
        promotionGiveProductDAO.deleteByParam(map);
    }
    
    /**
     * 根据销售策略-删除促销产品、另赠品
     * @param model
     */
    private void deletePromotionProducts(PromotionStrategy model) {
        String modelId = model.getPromotionStrategyId();
        String storeId = model.getStoreId();
        List<PromotionProduct> promotionProducts = promotionProductDAO.getPromotionProductsAndGiveProducts(modelId, storeId);
        for(PromotionProduct dbPromotionProduct : promotionProducts) {
            
            List<PromotionGiveProduct> dbGiveProducts = dbPromotionProduct.getDetails();
            
            for(PromotionGiveProduct dbGiveProduct : dbGiveProducts) {
                promotionGiveProductDAO.deleteById(dbGiveProduct.getGiveProductId());
            }
            
            promotionProductDAO.deleteById(dbPromotionProduct.getPromotionProductId());
        }
    }
    
    /**
     * 根据销售策略-更新另赠品状态（删除状态）
     */
    private void updateGiveProductsDeleteStatus(PromotionStrategy model) {
        String modelId = model.getPromotionStrategyId();
        String storeId = model.getStoreId();
        Map<String, Object> map = new HashMap<>();
        
        List<Condition> whereList = new ArrayList<>();
        whereList.add(Condition.createEq("strategyIdOrPid", modelId));
        whereList.add(Condition.createEq("storeId", storeId));
        
        List<Condition> updateList = new ArrayList<>();
        updateList.add(Condition.createEq("status", deleteStatus));

        map.put("whereList", whereList);
        map.put("updateList", updateList);
        
        promotionGiveProductDAO.updateByParam(map);
    }
    
    /**
     * 根据促销策略-更新促销产品、另赠品状态（删除状态）
     */
    private void updatePromotionProductsDeleteStatus(PromotionStrategy model) {
        String modelId = model.getPromotionStrategyId();
        String storeId = model.getStoreId();
        List<PromotionProduct> promotionProducts = promotionProductDAO.getPromotionProductsAndGiveProducts(modelId, storeId);
        for(PromotionProduct dbPromotionProduct : promotionProducts) {
            
            List<PromotionGiveProduct> dbGiveProducts = dbPromotionProduct.getDetails();
            
            for(PromotionGiveProduct dbGiveProduct : dbGiveProducts) {
                dbGiveProduct.setStatus(deleteStatus);
                promotionGiveProductDAO.updateByPrimaryKey(dbGiveProduct);
            }
            
            dbPromotionProduct.setStatus(deleteStatus);
            promotionProductDAO.updateByPrimaryKey(dbPromotionProduct);
        }
    }
}