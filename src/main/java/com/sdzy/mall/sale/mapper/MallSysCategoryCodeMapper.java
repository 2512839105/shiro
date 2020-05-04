package com.sdzy.mall.sale.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sdzy.mall.sale.model.MallSysCategoryCode;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-10
 */
public interface MallSysCategoryCodeMapper extends BaseMapper<MallSysCategoryCode> {
    
  List<Map<String,Object>> selectOnlineSaleDrug(Map<String, Object> map);
}
