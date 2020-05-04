/*package com.sdzy.xiaomi.third.controller;

import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.http.HttpStatus.SC_OK;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.asdzy.common.controller.BaseController;
import com.asdzy.common.model.JsonInfo;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.base.service.SysUserService;
import com.sdzy.xiaomi.third.service.FaceAddType;
import com.sdzy.xiaomi.third.service.FaceService;
import com.sdzy.xiaomi.third.service.FaceUtil;
import com.sdzy.xiaomi.third.service.GroupType;
import com.sdzy.xiaomi.user.model.BaseMember;
import com.sdzy.xiaomi.user.service.BaseMemberService;
 

@Controller
@RequestMapping("/third/face")
public class FaceController extends BaseController {
	
    @Resource
    private FaceService faceService;
    
    @Resource
    private SysUserService sysUserService;
    
    @Resource
    private BaseMemberService baseMemberService;
    
    @Resource
    private ServletContext servletContext;
    
    private static final Logger logger = LoggerFactory.getLogger(FaceController.class);
    
    @PostConstruct
    public void getRealPath() {
        //获取服务器物理路径
        FaceUtil.baseFilePath = servletContext.getRealPath("/");
        logger.info("服务器物理路径：" + FaceUtil.baseFilePath);
    }
    
    *//**
     * 用户人脸匹配
     * @param fileStr
     * @return
     *//*
    @RequestMapping("user/match")
    @ResponseBody
    public JsonInfo userMatch(@RequestParam("fileStr") String fileStr) {
        String uid = match(fileStr, true, GroupType.USER);
        String userAccount ="";
        if (uid == null) {
            // 失败
            return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "无匹配！", null);
        } else {
            SysUser sysUser = sysUserService.findSysUserById(uid);
            if (sysUser != null) {
                if(sysUser.getStatus()==0)
                    return new JsonInfo(SC_OK, "locked", "该用户已被冻结！");

                userAccount = sysUser.getUserAccount();
            } else {
                // 不存在
                return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "该用户不存在！", null);
            }
        }
        return JsonInfo.succ(userAccount);
    }
    
    *//**
     * 会员人脸匹配
     * @param fileStr
     * @return
     *//*
    @RequestMapping("member/match")
    @ResponseBody
    public JsonInfo memberMatch(@RequestParam("fileStr") String fileStr) {
        String uid = match(fileStr, true, GroupType.MEMBER);
        BaseMember member;
        
        if (uid == null) {
            // 失败
            return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "无匹配！", null);
        } else {
            member = baseMemberService.findById(uid);
            if (member == null) {
                // 不存在
                return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "该会员不存在！", null);
            }else {
                if(member.getStatus()==0)
                    return new JsonInfo(SC_OK, "locked", "该会员已被禁用！");

                if (member.getAuditState() == null || member.getAuditState() == 0)
                    return new JsonInfo(SC_OK, "locked", "该会员未经审核！");
            }
        }

        return new JsonInfo(SC_OK, "success", member);
    }

    *//**
     * 添加会员人脸
     * @param fileStr
     * @param memberId
     * @return
     * @throws IOException
     *//*
    @RequestMapping("/member/add.action")
    @ResponseBody
    public JsonInfo memberAdd(@RequestParam("fileStr") String fileStr, String memberId) throws IOException {
        
        return addFace(fileStr, memberId, GroupType.MEMBER, FaceAddType.APPEND);
    }

    *//**
     * 添加用户人脸
     * @param fileStr
     * @param userId
     * @return
     * @throws IOException
     *//*
    @RequestMapping("/user/add.action")
    @ResponseBody
    public JsonInfo userAdd(@RequestParam("fileStr") String fileStr, String userId) throws IOException {
        
        return addFace(fileStr, userId, GroupType.USER, FaceAddType.APPEND);
    }
    
    @RequestMapping("member/detectionAndValidate.action")
    @ResponseBody
    public JsonInfo detectionAndValidate(String fileStr, String validateStr) {
        return detectionAndValidate(fileStr, validateStr, GroupType.MEMBER);
    }
    
    @RequestMapping("/user/detectionAndValidate.action")
    @ResponseBody
    public JsonInfo userDetectionAndValidate(String fileStr, String validateStr) {
        
        return detectionAndValidate(fileStr, validateStr, GroupType.USER);
    }
    
    private JsonInfo detectionAndValidate(String fileStr, String validateStr, Integer groupType) {
        Byte[] imageDatas = FaceUtil.decodeImageStrBase64ToByte(fileStr);
        //人脸图片解析
        String detectionResult = faceService.faceDetection(imageDatas);
        //人脸图片验证
        String result = faceService.faceValidate(detectionResult, true);
        if("success".equals(result)) {
            if(validateStr!=null) {
        //        result = faceService.faceVerify(imageDatas, uid, groupType);
                Byte[] compImageDatas = FaceUtil.decodeImageStrBase64ToByte(validateStr);
                result = faceService.faceComparison(imageDatas, compImageDatas);
                
                if(!"success".equals(result))
                    return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "fail", result);
            }
            
            return new JsonInfo(SC_OK, "success", null);
        }
        
        return new JsonInfo(SC_INTERNAL_SERVER_ERROR, "fail", result);
    }
    
    private String match(String fileStr, Boolean faceliveness, Integer type) {
        Byte[] imageDatas = FaceUtil.decodeImageStrBase64ToByte(fileStr);
        String uid = faceService.match(imageDatas, faceliveness, type);
        return uid;
    }
    
    private JsonInfo addFace(String fileStr, String userId, Integer groupType, Integer addType) {
        JsonInfo jsonInfo;

        Byte[] imageDatas = FaceUtil.decodeImageStrBase64ToByte(fileStr);
        //人脸图片解析
        String detectionResult = faceService.faceDetection(imageDatas);
        //人脸图片验证
        String result = faceService.faceValidate(detectionResult, true);
        if ("success".equals(result)) {
            //保存图片到本地
            String filePath= FaceUtil.baseFilePath + PropFileConfig.getProperty("uploadPath") +"/member/" + DateUtil.formatCurrDateToS("yyyy/MM/dd")+"/"+StringUtil.generate16ShortUUID()+".png";
            FaceUtil.decodeBase64ToImage(fileStr, filePath);
            
            if (faceService.addFaceImage(imageDatas, userId, groupType, addType)) {
                jsonInfo = new JsonInfo(SC_OK, "success", null);
                
                return jsonInfo;
            }
        }
        
        jsonInfo = new JsonInfo(SC_INTERNAL_SERVER_ERROR, "fail", result);
        return jsonInfo;
    }

    @RequestMapping("delete")
    public String delete(String userId) {
        if (faceService.deleteFaceImage(userId, GroupType.USER, true))
            return this.sendSuccJson("success");
        else
            return this.sendFailJson("fail");
    }
    
}
*/