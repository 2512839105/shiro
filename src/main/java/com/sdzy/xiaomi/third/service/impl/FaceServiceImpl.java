/*package com.sdzy.xiaomi.third.service.impl;

import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.utils.PropFileConfig;
import com.asdzy.common.utils.StringUtil;
 
import com.baidu.aip.face.AipFace;
import com.sdzy.xiaomi.third.service.FaceAddType;
import com.sdzy.xiaomi.third.service.FaceService;
import com.sdzy.xiaomi.third.service.FaceUtil;
import com.sdzy.xiaomi.third.service.GroupType;

@Service
public class FaceServiceImpl implements FaceService {

    public AipFace client;
    
    private static String TITLE       = "人脸识别";
    private static String APP_ID      = null;
    private static String API_KEY     = null;
    private static String SECRET_KEY  = null;
    //大于 SCORE_MATCH 为同一个人
    private static Double SCORE_MATCH = null;
    //小于 该值 则为二次翻拍，不是活体
    private static Double FACELIVENESS_VALUE_LIMIT = null;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FaceServiceImpl.class);
    
    static {
        faceConfig();
        
        LOGGER.info(TITLE + " [APP_ID]         ->" + APP_ID);
        LOGGER.info(TITLE + " [API_KEY]        ->" + API_KEY);
        LOGGER.info(TITLE + " [SECRET_KEY]     ->" + SECRET_KEY);
        LOGGER.info(TITLE + " [SCORE_MATCH]    ->" + SCORE_MATCH);
        LOGGER.info(TITLE + " [FACELIVENESS_VALUE_LIMIT]    ->" + FACELIVENESS_VALUE_LIMIT);
    }
    
    private static void faceConfig() {
        String appId        = PropFileConfig.getProperty("face.app.id");
        String apiKey       = PropFileConfig.getProperty("face.api.key");
        String secretKey    = PropFileConfig.getProperty("face.secret.key");
        String scoreMatch   = PropFileConfig.getProperty("face.score.match");
        String faceValueLimit = PropFileConfig.getProperty("face.faceliveness.value.limit");
        
        APP_ID      = StringUtil.isEmpty(appId)?        "10849404" : appId;
        API_KEY     = StringUtil.isEmpty(apiKey)?       "8ueLxkVTNeS0aIFbA5FyG7rx" : apiKey;
        SECRET_KEY  = StringUtil.isEmpty(secretKey)?    "MzOx0Z4t04iQunyWY9X7HiW2az1browl" : secretKey;
        SCORE_MATCH = StringUtil.isEmpty(scoreMatch)?   80 : Double.valueOf(scoreMatch);
        FACELIVENESS_VALUE_LIMIT = StringUtil.isEmpty(faceValueLimit)?  0.393241 : Double.valueOf(faceValueLimit);
    }
    
    public FaceServiceImpl() {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    @Override
    public String match(Byte[] imageDatas, Boolean faceliveness, Integer groupType) {
        
        JSONObject res = client.identifyUser(GroupType.getGroup(groupType), ArrayUtils.toPrimitive(imageDatas), getMatchOption(faceliveness));
        
        return matchResultResolve(res.toString(), faceliveness);
    }

    @Override
    public String match(String imagePath, Boolean faceliveness, Integer groupType) {
        
        JSONObject res = client.identifyUser(GroupType.getGroup(groupType), imagePath, getMatchOption(faceliveness));
        
        return matchResultResolve(res.toString(), faceliveness);
    }
    
    private HashMap<String, String> getMatchOption(boolean faceliveness){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        if(faceliveness)
            options.put("ext_fields", "faceliveness");
        options.put("user_top_num", "1");
        
        return options;
    }
    
    *//**
     * 相似度数据解析
     * @param res 返回的数据字符串
     * @param faceliveness 是否需要活体检测
     * @return
     *//*
    private String matchResultResolve(String res, boolean faceliveness) {
        JSONObject resultObject = new JSONObject(res);
        
        if(faceliveness) {
            if(!facelivenessResolve(resultObject))
                return null;
        }
                
        if(resultObject.isNull("result"))
            return null;
        
        JSONArray jsonArray = resultObject.getJSONArray("result");
        if(jsonArray.length()==0)
            return null;
        
        JSONObject resultObj = jsonArray.getJSONObject(0);
        JSONArray scores = resultObj.getJSONArray("scores");
        
        Double score = Double.valueOf(scores.get(0).toString());
        
        String uid = resultObj.getString("uid");
        
        LOGGER.info(String.format("当前最匹配的识别结果为：%s，相似度为：%s %%", uid, score));
        
        if(score>SCORE_MATCH) {
            return uid;
        }
        
        return null;
    }
    
    *//**
     * 活体数据解析
     * @param resultObject
     * @return
     *//*
    private boolean facelivenessResolve(JSONObject resultObject) {
        if(resultObject.isNull("ext_info"))
            return false;
        
        JSONObject extInfo = resultObject.getJSONObject("ext_info");
        //活体数据
        Double facelivenessValue = Double.valueOf(extInfo.get("faceliveness").toString());
        
        if (facelivenessValue<FACELIVENESS_VALUE_LIMIT) {
            LOGGER.info("不是活体对象！");
            throw new CustomerException("无匹配！");
            
//            return false;
        }

        return true;
    }

    @Override
    public Boolean addFaceImage(String imagePath, String uid, Integer groupType, Integer addType) {
        
        return addFaceImage(FaceUtil.getByteDatas(imagePath), uid, groupType, addType);
    }
    
    @Override
    public Boolean addFaceImage(Byte[] imageDatas, String uid, Integer groupType, Integer addType) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", FaceAddType.getAddType(addType));
        
        // 参数为本地图片路径
        JSONObject res = client.addUser(uid, null, GroupType.getGroup(groupType), ArrayUtils.toPrimitive(imageDatas), options);
        if(!res.isNull("error_code")) {
            LOGGER.error(res.get("error_msg").toString());
            
            return false;
        }
        
        LOGGER.info(String.format("%s 图片，添加成功", uid));
        
        return true;
    }

    @Override
    public String faceDetection(String imagePath) {
        
        return faceDetection(FaceUtil.getByteDatas(imagePath));
    }

    @Override
    public String faceDetection(Byte[] imageDatas) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "qualities,faceliveness");
        
        JSONObject jsonObject = client.detect(ArrayUtils.toPrimitive(imageDatas), options);
        System.out.println(jsonObject.toString(2));
        
        return jsonObject.toString();
    }

    @Override
    public String faceValidate(String res, Boolean faceliveness) {
        JSONObject jsonObject = new JSONObject(res);
        JSONObject validateResult = new JSONObject();
        if(!jsonObject.isNull("result")&&jsonObject.getJSONArray("result").length()>0) {
            JSONObject resultObject = jsonObject.getJSONArray("result").getJSONObject(0);
            if(resultObject.length()>0) {
                Double blurValue = Double.valueOf(resultObject.getJSONObject("qualities").get("blur").toString());
                
                if(blurValue>=0.7) {
                    validateResult.put("blur", blurValue);
                    validateResult.put("standard", 0.7);
                    validateResult.put("type", "lt");
                    validateResult.put("errorText", String.format("模糊度过高，当前模糊度为：%f，应小于 %f！", blurValue, 0.7));
                    
                    return validateResult.toString();
                }
                
                Integer completeness = resultObject.getJSONObject("qualities").getInt("completeness");
                
                if(completeness!=1) {
                    validateResult.put("completeness", 0);
                    validateResult.put("standard", 1);
                    validateResult.put("type", "eq");
                    validateResult.put("errorText", "当前获取的人脸不完整，请重新拍摄！");
                    
                    return validateResult.toString();
                }
                
                Integer width = resultObject.getJSONObject("location").getInt("width");
                Integer height = resultObject.getJSONObject("location").getInt("height");
                
                if(width<100||height<100) {
                    validateResult.put("size", width+"*"+height);
                    validateResult.put("standard", "100*100");
                    validateResult.put("type", "ge");
                    validateResult.put("errorText", String.format("人脸范围过小，当前人脸长宽像素值为：%d*%d，应大于或等于 %s", width, height, "100*100"));
                    
                    return validateResult.toString();
                }
                
                if(faceliveness) {
                    Double facelivenessValue = Double.valueOf(resultObject.get("faceliveness").toString());
                    if(facelivenessValue<FACELIVENESS_VALUE_LIMIT) {
                        validateResult.put("faceliveness", facelivenessValue);
                        validateResult.put("standard", FACELIVENESS_VALUE_LIMIT);
                        validateResult.put("type", "ge");
                        validateResult.put("errorText", "请在现场抓拍！");
                        
                        return validateResult.toString();
                    }
                }
                
                return "success";
            }
        }
        
        validateResult.append("imageType", "nonsupport");
        validateResult.put("errorText", "请将您的脸部对准摄像头!");
        
        return validateResult.toString();
    }

    @Override
    public Boolean deleteFaceImage(String uid, Integer groupType, Boolean backup) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("group_id", GroupType.getGroup(groupType));
        
        if(backup)
            this.addFaceToBackup(groupType, uid);
        
        JSONObject res = client.deleteUser(uid, options);
        if(!res.isNull("error_code")) {
            LOGGER.error(res.get("error_msg").toString());
            
            return false;
        }
        
        LOGGER.info(String.format("%s 图片，删除成功", uid));
        
        return true;
    }

    @Override
    public String faceVerify(String imagePath, String uid, Integer groupType) {
        
        return faceVerify(FaceUtil.getByteDatas(imagePath), uid, groupType);
    }

    @Override
    public String faceVerify(Byte[] imageDatas, String uid, Integer groupType) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "1");
        
        JSONObject res = client.verifyUser(uid, GroupType.getGroup(groupType), ArrayUtils.toPrimitive(imageDatas), options);
        JSONObject verifyResult = new JSONObject();
        if(res.isNull("result")) {
            if(!res.isNull("error_code")) {
                String errorCode = res.get("error_code").toString();
                if("216611".equals(errorCode)) {
                    
                    return "success";
                }
            }
            verifyResult.put("face", "verifyError");
            verifyResult.put("errorText", "认证错误！");
        }else {
            JSONArray resultArray = res.getJSONArray("result");
            Double result = Double.valueOf(resultArray.get(0).toString());
            if(result>80) {
                
                return "success";
            }else {
                verifyResult.put("face", "verifyFail");
                verifyResult.put("errorText", "不是同一个人！");
            }
        }
        
        return verifyResult.toString();
    }
    
    public static void main(String[] args) {
        FaceServiceImpl faceService = new FaceServiceImpl();
//        faceService.addFaceImage("C:\\Users\\sdzy\\Desktop\\699bf7cc633628ff-7652b36ba6945424-738cdf5020782e0a7aee2b4a0fc1bfe7.jpg", "123", GroupType.MEMBER, FaceAddType.APPEND);
        
        faceService.addFaceToBackup(GroupType.MEMBER, "21312");
    }

    @Override
    public String faceComparison(Byte[] imageDatas, Byte[] compImageDatas) {
        byte[][] bytes = new byte[2][];
        bytes[0] = ArrayUtils.toPrimitive(imageDatas);
        bytes[1] = ArrayUtils.toPrimitive(compImageDatas);
        JSONObject res = client.match(bytes, null);
        JSONObject comparisonResult = new JSONObject();
        
        if(res.isNull("result")||res.getJSONArray("result").length()==0) {
            comparisonResult.put("face", "comparisonError");
            comparisonResult.put("errorText", "比对错误！");
        }else {
            JSONArray resultArray = res.getJSONArray("result");
            JSONObject jsonObject = resultArray.getJSONObject(0);
            Double score = Double.valueOf(jsonObject.get("score").toString());
            
            if(score>80) {
                
                return "success";
            }else {
                comparisonResult.put("face", "comparisonFail");
                comparisonResult.put("errorText", "不是同一个人！");
            }
            
        }
        
        return comparisonResult.toString();
    }

    @Override
    public String faceComparison(String imagePath, String compImagePath) {
        
        return faceComparison(FaceUtil.getByteDatas(imagePath), FaceUtil.getByteDatas(compImagePath));
    }

    @Override
    public Integer deleteFaceImages(String[] uids, Integer groupType, Boolean backup) {
        int result = 0;
        for(String uid : uids) {
            if(this.deleteFaceImage(uid, groupType, backup)) {
                result += 1;
            }
        }
        
        return result;
    }

    @Override
    public Boolean addFaceToBackup(Integer groupType, String uid) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String srcGroupId = GroupType.getGroup(groupType);
        String groupId = GroupType.getBackupGroup(groupType);
        // 组间复制用户
        client.addGroupUser(srcGroupId, groupId, uid, options);
        
        return true;
    }

    @Override
    public Boolean addFaceFromBackup(Integer groupType, String uid) {
     // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        String srcGroupId = GroupType.getBackupGroup(groupType);
        String groupId = GroupType.getGroup(groupType);
        // 组间复制用户
        client.addGroupUser(srcGroupId, groupId, uid, options);
        
        return true;
    }

    @Override
    public Integer addFacesToBackup(Integer groupType, String[] uids) {
        int result = 0;
        for(String uid : uids) {
            if(this.addFaceToBackup(groupType, uid)) {
                result += 1;
            }
        }
        
        return result;
    }

    @Override
    public Integer addFacesFromBackup(Integer groupType, String[] uids) {
        int result = 0;
        for(String uid : uids) {
            if(this.addFaceFromBackup(groupType, uid)) {
                result += 1;
            }
        }
        
        return result;
    }
    
}
*/