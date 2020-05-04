package com.sdzy.xiaomi.third.service;

import com.asdzy.common.exception.CustomerException;

public class FaceAddType {

    /**
     * 追加
     */
    public static final int APPEND = 0;
    
    /**
     * 替换，删除该uid下的所有图片，然后进行添加
     */
    public static final int REPLACE = 1;
    
    /**
     * 获取添加类型
     * @param addType 0为追加；1为删除该uid下的所有图片，然后进行添加
     * @return
     */
    public static String getAddType(Integer addType) {
        String addTypeStr = "";
        
        if(addType == 0) {
            addTypeStr = "append";
        }else if(addType == 1) {
            addTypeStr = "replace";
        }else {
            throw new CustomerException("不存在的添加类型！");
        }
            
        return addTypeStr;
    }
    
}
