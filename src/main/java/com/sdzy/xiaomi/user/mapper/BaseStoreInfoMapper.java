package com.sdzy.xiaomi.user.mapper;

import com.sdzy.xiaomi.user.model.BaseStoreInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-04
 */
public interface BaseStoreInfoMapper extends BaseMapper<BaseStoreInfo> {
	int updateLogo(@Param("logoPath")String logoPath,@Param("storeId")String storeId);
	List<Map<String,String>> selectStore();
	Map<String, Object> selectAllStore(@Param("dateType")String dateType,@Param("companyId")String companyId);
	List<Map<String, String>> selectCategoryRank(@Param("dateType")String dateType,@Param("companyId")String companyId);
	List<Map<String, String>> selectProductRank(@Param("codeId")String codeId,@Param("dateType")String dateType,@Param("companyId")String companyId);
	List<Map<String, String>> selectStoreNameRank(@Param("codeId")String codeId,@Param("dateType")String dateType,@Param("companyId") String companyId);
	List<Map<String, String>> selectStoreSaleRank(@Param("dateType")String dateType,@Param("companyId")String companyId);
	String selectStoreCount(@Param("companyId")String companyId);
	String selectStoreAllCount(@Param("companyId")String companyId);
	List<Map<String, String>> selectPayRank(@Param("dateType")String dateType,@Param("companyId")String companyId);
	List<Map<String, String>> selectRegionRank(@Param("dateType")String dateType,@Param("companyId")String companyId);
	List<Map<String, String>> selectRegionRankCity(@Param("dateType")String dateType,@Param("companyId")String companyId);
	Map<String,String> selectIsRxDrugRank(@Param("dateType")String dateType,@Param("companyId")String companyId);
	Map<String,String> selectMemberCount(@Param("companyId")String companyId);
	List<Map<String, String>> selectSaleDetail(@Param("dateType")String dateType,@Param("storeId")String storeId);
	List<BaseStoreInfo>  selectStoreRankRegion(@Param("dateType")String dateType,@Param("address")String address);
	
	BaseStoreInfo selectStoreDetail(@Param("storeId")String storeId);
	List<Map<String, String>> selectStoreByCompany(@Param("companyName")String companyName);
	List<Map<String,String>> selectStoreByName(@Param("storeName")String storeName,@Param("companyId")String companyId);
	Map<String,String> selectMonitorVideo(@Param("storeId")String storeId);
	
	List<Map<String, String>> realTimeSales(@Param("companyId")String companyId);
	List<Map<String, Object>> sellAmountGoupByHour(@Param("companyId")String companyId);
	
	BaseStoreInfo findByStoreCode(String storeCode);
 
	
}
