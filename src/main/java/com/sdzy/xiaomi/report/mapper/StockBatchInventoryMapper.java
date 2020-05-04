package com.sdzy.xiaomi.report.mapper;

import com.sdzy.xiaomi.report.model.StockBatchInventory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asdzy.common.model.Query;
import com.asdzy.common.query.QueryParams;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface StockBatchInventoryMapper extends BaseMapper<StockBatchInventory> {
	
	//查询效期品种 库存 表
	List<Map<String,Object>> stockBatchInventory(String storeId);
	
     //查看库存数量
	List<Map<String,Object>> listStockCount(Page page,Map<String, Object> map,@Param("sor")String sor,@Param("storeId")String storeId); 
	//通过货号或货品名查询
	List<Map<String,Object>> listStockCountByCodeOrName(Page page,@Param("codeOrName")String codeOrName,@Param("sor")String sor,@Param("storeId")String storeId); 

	//查看效期产品 有效期三个月内或过期的
	List<Map<String,Object>> listExpiriedProductByMonth( Page page, @Param("sor")String sort,@Param("storeId")String storeId);
	List<Map<String,Object>> listExpiriedProductByWeek(Page page,@Param("sor")String sort,@Param("storeId")String storeId);
	List<Map<String,Object>> listExpiriedProductByDay(Page page,@Param("sor")String sort,@Param("storeId")String storeId);
	List<Map<String,Object>> listExpiriedProductByBeoverdue(Page page,@Param("sor")String sort,@Param("storeId")String storeId);

	//缺货预警
	List<Map<String,Object>> listLessStock(Page page, Map<String, Object> map,@Param("sor")String sor, @Param("storeId")String storeId);
	
	//根据商品名查询详细
	List<Map<String, Object>> commodityInquiryByproductName(@Param("productName")String productName,@Param("storeId")String storeId);
	//盘点
	List<Map<String, String>> findInventorys(@Param("keyword")String keyword,@Param("storeId")String storeId);

	List<StockBatchInventory> listByParam(Map<String, Object> paramMap);

	List<StockBatchInventory> findByParam(Map<String, Object> map);

	void updateByPrimaryKeySelective(StockBatchInventory currentInventory);
}
