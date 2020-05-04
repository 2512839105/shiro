package com.sdzy.xiaomi.report.mapper;

import com.sdzy.xiaomi.report.model.GspMeasureDeviceCheckRecord;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-02
 */
public interface GspMeasureDeviceCheckRecordMapper extends BaseMapper<GspMeasureDeviceCheckRecord> {

	List selectBystoreId(Page page, Map<String, Object> map);

}
