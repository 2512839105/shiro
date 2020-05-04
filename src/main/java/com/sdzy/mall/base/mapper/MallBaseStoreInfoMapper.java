package com.sdzy.mall.base.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.mall.base.model.MallBaseStoreInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-11
 */
public interface MallBaseStoreInfoMapper extends BaseMapper<MallBaseStoreInfo> {
    List<Map<String,Object>> selectStoreOrderSale(Page<MallBaseStoreInfo> page);
    
    List<MallBaseStoreInfo> selectProductAndStore(Page page, Map<String, Object> map);
    
    List<MallBaseStoreInfo> selectById(String storeId);

    
}
