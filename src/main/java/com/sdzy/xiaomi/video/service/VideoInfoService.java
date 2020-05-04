package com.sdzy.xiaomi.video.service;

import com.sdzy.xiaomi.video.model.VideoInfo;
import com.baomidou.mybatisplus.service.IService;

import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-17
 */
public interface VideoInfoService extends IService<VideoInfo> {

    /**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteModelById(Serializable videoId);


	/**
	 * 新增
	 * @param secrect 
	 * @param category 
	 * @param storeType 
	 * @param secrect2 
	 * @param file 
	 * @param api
	 * @return
	 */
	String insertModel( String filePath,String title,String introduc,String category,String srot, String storeType,String js_code, String appid, String secrect);

	VideoInfo updateVideo(VideoInfo video);
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<VideoInfo> selectModelsByPage(QueryParams queryParams);


	String  deleteVideoById(String[] videoId);


    String getToken();


    String getVedioAddress(String accessToken);
}
