package com.sdzy.xiaomi.video.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.util.BaseUtil;
import com.sdzy.xiaomi.util.UploadUtil;
import com.sdzy.xiaomi.video.model.VideoInfo;
import com.sdzy.xiaomi.video.service.VideoInfoService;



import org.springframework.stereotype.Controller;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.exception.CustomerException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlin
 * @since 2018-07-17
 */
@Controller
@RequestMapping("/video")
public class VideoInfoController extends BaseController {

	@Autowired
	VideoInfoService  videoInfoService;

	 
    /**
     * 根据videoId删除数据
     */
    @RequestMapping("/deleteVideoById.action")
    public String deleteVideoByIds(String[] videoId) {
     	videoInfoService.deleteVideoById(videoId); 
 		return this.sendSuccJson();
    }
    
/*    
    @RequestMapping(value="showImg")
    @ResponseBody
    public void ShowImg(HttpServletRequest request,HttpServletResponse response) throws IOException{
    //String imgFile = request.getParameter("imgFile"); //文件名
    // String path= UrlUtil.getValue("goodsImg");//这里是存放图片的文件夹地址
        String path = request.getServletContext().getRealPath("uploads/2018/07/18");    
		    String imgFile = "8GeZUsftHk9TAvet.avi";
		    FileInputStream fileIs=null;		 
		    fileIs = new FileInputStream(path+"/"+imgFile);		  
		    int i=fileIs.available(); //得到文件大小
		    byte data[]=new byte[i];
		    fileIs.read(data); //读数据 
		    response.setContentType("video/avi"); //设置返回的文件类型
		    OutputStream outStream=response.getOutputStream(); //得到向客户端输出二进制数据的对象
		    outStream.write(data); //输出数据
		    outStream.flush();
		    outStream.close();
		    fileIs.close();		    		    
    }*/
      
    /**
     * 视频上传
     * @param file
     * @return
     */
    @RequestMapping("/upload.action")
    public String upload(MultipartFile file){
    	/*String filename = file.getOriginalFilename();
        //String  filePath= PropFileConfig.getProperty("file.host") +"/"+ DateUtil.formatCurrDateToS("yyyy/MM/dd")+"/"+ StringUtil.generate16ShortUUID()+filename.substring(filename.lastIndexOf("."));
        String  filePath= PropFileConfig.getProperty("file.host");

    	
    	String path=request.getServletContext().getRealPath("/")+ filePath;
        File newFile=new File(path);
        try {
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
        } catch (IOException e) {
	 
            throw new CustomerException("文件过大");           
        }
      
        return this.sendSuccJson(filePath);	*/
    	String IMAGE_PATH =  PropFileConfig.getProperty("file.host");
        String filename = file.getOriginalFilename();
        String filestrExt = filename.substring(filename.lastIndexOf("."));
        filename = StringUtil.generate16ShortUUID() + filestrExt;
        String result = null;
        try {
            File newFile = File.createTempFile("tmp", null);
            file.transferTo(newFile);
            newFile.deleteOnExit();
            String url = IMAGE_PATH + "uploadFile?filename=" +filename;
            result = UploadUtil.postFile(newFile, url, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = IMAGE_PATH + "/upload/" + filename;
        return this.sendSuccJson(path);
    }
    
    
    /**
     * 保存
     */
    @RequestMapping("/insertModel.action")
    public String insertModel(String filePath,String title,String introduc,String js_code, String appid, String secrect,String category,String sort,String storeType) {
    	   	
    	data = videoInfoService.insertModel(filePath,title,introduc,category,sort,storeType,js_code,appid,secrect);
    	return this.sendSuccJson(data);
    }
        
    /**
     * 按主键查询
     */
    @RequestMapping("/findVideoById.action")
    public String findVideoById(String videoId,String js_code, String appid, String secrect) {
    	try {
			if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){
			data = videoInfoService.selectById(videoId); 
			return this.sendSuccJson(data);
			}
			return null;
		} catch (IOException e) {
			throw new CustomerException(e+"验证参数异常");
		}   	 
    }     
    /*
     * 视频管理
     */
    @RequestMapping("/findVideoByIds.action")
    public ModelAndView findVideoByIds(String videoId) {    
			data = videoInfoService.selectById(videoId); 
			return new ModelAndView("videoEdit","model",data);	   	 
    }   
    /**
     * 修改
     */
    @RequestMapping("/updateVideo.action")
    public String updateVideo(VideoInfo video) {
    	   videoInfoService.updateById(video);
    	return this.sendSuccJson();
    }
    
    /**
     * 根据参数分页查询 小程序
     */
    @RequestMapping("/selectModelsByPage.action")
    public @ResponseBody Page selectModelsByPage(QueryParams queryParams,String js_code, String appid, String secrect ) {
       try {
		if(BaseUtil.getSessionAndOpenJson(js_code, appid, secrect)){    
			 return videoInfoService.selectModelsByPage(queryParams);
	    }
	 } catch (IOException e) {
		throw new CustomerException(e+"参数验证异常");
	 }
       return null; 
     }
    
    /**
     * 根据参数分页查询 后台管理
     */
    @RequestMapping("/selectModelsByPages.action")
    public @ResponseBody Page selectModelsByPages(@RequestBody QueryParams queryParams,String js_code, String appid, String secrect ) {
      
   
    	
    	return videoInfoService.selectModelsByPage(queryParams);	 
     }
    
    @RequestMapping("/getToken.action")
    public String haikangVedioToken() {
        return this.sendSuccJson(videoInfoService.getToken());
    }
    
    @RequestMapping("/getVedioAddress.action")
    public String getHaiKangVedioAddress(String accessToken) {
        return this.sendSuccJson(videoInfoService.getVedioAddress(accessToken));
    }
}

