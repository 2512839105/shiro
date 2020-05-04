package com.sdzy.xiaomi.video.mapper;

import com.sdzy.xiaomi.video.model.VideoInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-17
 */
public interface VideoInfoMapper extends BaseMapper<VideoInfo> {
    
	List<VideoInfo> selectVideoInfo(Page<VideoInfo> page, Map<String, Object> map);

	void deleteVideoById(@Param("videoId")String[] videoId);

}
