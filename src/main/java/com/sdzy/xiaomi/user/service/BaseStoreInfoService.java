package com.sdzy.xiaomi.user.service;

import com.sdzy.xiaomi.user.model.BaseStoreInfo;
import com.baomidou.mybatisplus.service.IService;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-04
 */
public interface BaseStoreInfoService extends IService<BaseStoreInfo> {
	
	
	
	
	String updateStoreLogo(String logoPath,String storeId);
	
	/**
	 * 新增或者更新实体，存在主键为更新，反正新增
	 * @param api
	 * @return
	 */
	BaseStoreInfo updateModel(String data,String js_code,String appid,String secrect);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<BaseStoreInfo> selectModelsByPage(QueryParams queryParams);

	String selectStore();

	String selectAllStore(String dateType, String companyId);

	String selectStoreNameRank(String codeId, String dateType,String companyId);

	String   selectStoreSaleRank(String dateType,String companyId);

	String selectPayRank(String dateType,String companyId);

	String selectRegionRank(String dateType,String companyId);

	String selectIsRxDrugRank(String dateType,String companyId);

	String selectMemberCount(String dateType, String companyId);

	List<Map<String, String>> selectSaleDetail(String dateType, String storeId);

	String selectCategoryRank(String dateType,String companyId);

	String selectStoreRankRegion(String dateType,String address,String callback);

	String selectStoreDetail(String storeId,String callback);

	String selectStoreByCompany(String companyName, String callback);

	String selectStoreByName(String storeName, String callback, String companyId);

	String selectAll(String companyId);

	String selectMonitorVideo(String storeId);

	String realTimeSales(String companyId);

	String sellAmountGoupByHour(String companyId);

 }
