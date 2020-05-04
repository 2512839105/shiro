package com.sdzy.xiaomi.report.mapper;

 
import java.util.List;
import java.util.Map;
 
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.report.model.GspMeasuringDeviceInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-06-28
 */
public interface GspMeasuringDeviceInfoMapper extends BaseMapper<GspMeasuringDeviceInfo> {

  List<Map<String,String>> selectBystoreId(Page page,Map<String,Object> map);
}
