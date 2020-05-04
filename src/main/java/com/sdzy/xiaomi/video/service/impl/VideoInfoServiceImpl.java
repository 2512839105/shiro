package com.sdzy.xiaomi.video.service.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.query.Condition.OpType;
import com.asdzy.common.utils.HttpClientUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asdzy.common.mybatisplus.MyBatisPlusUtil;

import com.sdzy.xiaomi.video.model.VideoInfo;
import com.sdzy.xiaomi.video.mapper.VideoInfoMapper;
import com.sdzy.xiaomi.video.service.VideoInfoService;
import com.asdzy.common.mybatisplus.support.BaseServiceImpl;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlin
 * @since 2018-07-17
 */
@Service
public class VideoInfoServiceImpl extends BaseServiceImpl<VideoInfoMapper, VideoInfo> implements VideoInfoService {

    @Override
	public boolean deleteModelById(Serializable videoId) {
		boolean returnValue=false;		
		
		returnValue = this.deleteById(videoId);
		return returnValue;
	}
	
 
	@Override
	public String insertModel(String filePath,String title,String introduc,String category,String sort,String storeType,String js_code, String appid, String secrect) {
		VideoInfo	model=new VideoInfo();	
		  
		if(sort!=null){
		 int sorts=Integer.parseInt(sort);
			 model.setSort(sorts);
		}		
		model.setTitle(title);
		model.setIntroduc(introduc);
		model.setLink(filePath);
		model.setCategory(category);
		model.setStoreType(storeType);
		
		model.setStatus(1);
		model.setVideoId(StringUtil.getUUID());		
		if(this.insert(model)){
			return "成功";
		}				
		return "失败";
	}
	
		
	@Override
	public  Page<VideoInfo>  selectModelsByPage(QueryParams queryParams) {

		Page<VideoInfo> page = new Page<VideoInfo>(queryParams.getCurrent(), queryParams.getLimit());		 
		Map<String, Object> map = new HashMap<String, Object>();		
		List<Condition> whereList = queryParams.filtersToDBConditionals();		
		map.put("whereList", whereList);	 
		
		return page.setRecords(baseMapper.selectVideoInfo(page,map));
	}


	@Override
	public VideoInfo updateVideo(VideoInfo data) {
	/*VideoInfo	model= JSON.parseObject(data,VideoInfo.class);*/
		/*if(this.updateById(model)){
			return "成功";
		}
		
		return "失败";*/
	this.updateById(data);
		return null;
	}

	@Override
	public String deleteVideoById(String[] videoId) {
		
			baseMapper.deleteVideoById(videoId);
			
		return null;
	}


    @Override
    public String getToken() {
        String url = PropFileConfig.getProperty("haikang_postUrl");
        Map<String, String> map = new HashMap<String, String>();
        map.put("appKey",PropFileConfig.getProperty("haikang_appKey"));
        map.put("appSecret", PropFileConfig.getProperty("haikang_appSecret"));
        String post = HttpClientUtil.post(url, map);
        JSONObject dataObject = JSONObject.parseObject(post).getJSONObject("data");
        return (String) dataObject.get("accessToken");
    }

/**@param accessToken 海康视频密钥，需要先通过getToken获得
 * @param source 直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式
 * */
    @Override
    public String getVedioAddress(String accessToken) {
        String url ="https://open.ys7.com/api/lapp/live/address/get";
        Map<String, String> map = new HashMap<String, String>();
        map.put("accessToken",accessToken);
        map.put("source", "767908823:1");
        String post = HttpClientUtil.post(url, map);
        return post;
    }

 
}
