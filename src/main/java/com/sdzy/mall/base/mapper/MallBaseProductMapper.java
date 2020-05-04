package com.sdzy.mall.base.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.mall.base.model.MallBaseProduct;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
public interface MallBaseProductMapper extends BaseMapper<MallBaseProduct> {
    List<Map<String,Object>> selectProductByCategory(Page page, Map<String, Object> map);
    
    List<Map<String,Object>> selectProductAndStore(Page page, Map<String, Object> map);

    Map<String, Object> selectProductById(Map<String, Object> map);
    
    int updateByPrimaryKeySelective(MallBaseProduct record);
    
    List<MallBaseProduct> listByParam(Map productMap);

}
