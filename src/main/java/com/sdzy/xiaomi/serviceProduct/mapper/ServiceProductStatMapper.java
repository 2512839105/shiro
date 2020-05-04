package com.sdzy.xiaomi.serviceProduct.mapper;

import com.sdzy.xiaomi.serviceProduct.model.ServiceProductStat;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户服务产品汇总 Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-30
 */
public interface ServiceProductStatMapper extends BaseMapper<ServiceProductStat> {

	Map<String, String> selectBybuyerId(Object buyerId);
	
}
