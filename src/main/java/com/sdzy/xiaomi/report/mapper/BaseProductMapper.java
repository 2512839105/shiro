package com.sdzy.xiaomi.report.mapper;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.model.BaseProduct;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface BaseProductMapper extends BaseMapper<BaseProduct> {
		
//	查看近期新品
	List<Map<String,Object>> selectBaseProductByMonth(String storeId);
	List<Map<String,Object>> selectBaseProductByWeek(String storeId);
	List<Map<String,Object>> selectBaseProductByDay(String storeId);
	
	//查看价格变动
	List<Map<String,Object>> baseProduct(Page page, Map<String, Object> map);
	int updateProduct(@Param("storeId")String storeId, @Param("productId")String productId,@Param("localRetailPrice") BigDecimal localRetailPrice, @Param("memberPrice")BigDecimal memberPrice);
	List<Map<String, String>> selectProductByCodeOrName(@Param("storeId")String storeId,@Param("keyword")String keyword);
	
	List<BaseProduct> findProductByBarCode(Map<String, Object> map);
	
	List<BaseProduct> findProductByProductCode(Map<String, Object> map);
	List<BaseProduct> listProductsAndStocks(Map<String, Object> paramMap);
	
	List<BaseProduct> listByParam(Map productMap);
	void updateByPrimaryKeySelective(BaseProduct baseProduct);
}
