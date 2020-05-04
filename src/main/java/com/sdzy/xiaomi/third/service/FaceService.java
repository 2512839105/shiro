package com.sdzy.xiaomi.third.service;

public interface FaceService {

    /**
     * 人脸识别
     * @param imageDatas
     * @param faceliveness 是否需要活体检测
     * @param groupType 0为会员，1为用户
     * @return
     */
    String match(Byte[] imageDatas, Boolean faceliveness, Integer groupType);
    
    /**
     * 人脸识别
     * @param imageDatas
     * @param faceliveness 是否需要活体检测
     * @param groupType 0为会员，1为用户
     * @return
     */
    String match(String imagePath, Boolean faceliveness, Integer groupType);
    
    /**
     * 添加图片
     * @param imagePath
     * @param uid
     * @param groupType 0为会员，1为用户
     * @param addType 0为追加；1为删除该uid下的所有图片，然后进行添加
     * @return
     */
    Boolean addFaceImage(String imagePath, String uid, Integer groupType, Integer addType);
    
    /**
     * 添加图片
     * @param imageDatas
     * @param uid
     * @param groupType 0为会员，1为用户
     * @param addType 0为追加；1为删除该uid下的所有图片，然后进行添加
     * @return
     */
    Boolean addFaceImage(Byte[] imageDatas, String uid, Integer groupType, Integer addType);
    
    /**
     * 人脸检测
     * @param imagePath
     * @return
     */
    String faceDetection(String imagePath);
    
    /**
     * 人脸检测
     * @param imageDatas
     * @return
     */
    String faceDetection(Byte[] imageDatas);
    
    /**
     * 人脸验证
     * @param res
     * @param faceliveness 是否需要活体检测
     * @return
     */
    String faceValidate(String res, Boolean faceliveness);
    
    /**
     * 删除人脸图片
     * @param uid
     * @param groupType 0为会员，1为用户
     * @param backup 是否需要备份用户
     * @return
     */
    Boolean deleteFaceImage(String uid, Integer groupType, Boolean backup);
    
    /**
     * 删除多张人脸图片
     * @param uids
     * @param groupType
     * @param backup 是否需要备份用户
     * @return
     */
    Integer deleteFaceImages(String[] uids, Integer groupType, Boolean backup);
    
    /**
     * 备份用户
     * @param groupType
     * @param backupGroupType
     * @return
     */
    Boolean addFaceToBackup(Integer groupType, String uid);
    
    /**
     * 备份多个用户
     * @param groupType
     * @param uids
     * @return
     */
    Integer addFacesToBackup(Integer groupType, String[] uids);
    
    /**
     * 还原用户
     * @param groupType
     * @param uid
     * @return
     */
    Boolean addFaceFromBackup(Integer groupType, String uid);
    
    /**
     * 还原多个用户
     * @param groupType
     * @param uids
     * @return
     */
    Integer addFacesFromBackup(Integer groupType, String[] uids);
    
    /**
     * 人脸认证
     * @param imagePath
     * @param uid
     * @param groupType 0为会员，1为用户
     * @return
     */
    String faceVerify(String imagePath, String uid, Integer groupType);
    
    /**
     * 人脸认证
     * @param imageDatas
     * @param uid
     * @param groupType 0为会员，1为用户
     * @return
     */
    String faceVerify(Byte[] imageDatas, String uid, Integer groupType);
    
    /**
     * 人脸比对
     * @param imageDatas
     * @param compImageDatas
     * @return
     */
    String faceComparison(Byte[] imageDatas, Byte[] compImageDatas);
    
    /**
     * 人脸比对
     * @param imagePath
     * @param compImagePath
     * @return
     */
    String faceComparison(String imagePath, String compImagePath);
    
}
