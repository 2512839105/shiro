package com.sdzy.xiaomi.third.service;

import com.asdzy.common.exception.CustomerException;

public class GroupType {

    /**
     * 会员
     */
    public static final int MEMBER = 0;
    
    /**
     * 用户
     */
    public static final int USER = 1;
    
    /**
     * 会员备份
     */
    public static final int MEMBER_BACKUP = 0;
    
    /**
     * 用户备份
     */
    public static final int USER_BACKUP = 1;
    

    /**
     * 获取组类型
     * @param groupType 0为会员；1为用户
     * @return
     */
    public static String getGroup(Integer groupType) {
        String groupId = "";
        switch(groupType) {
            //会员组
            case 0 : 
                groupId = "group_m";
                break;
            //用户组
            case 1 :
                groupId = "group_u";
                break;
            default :
                throw new CustomerException("不存在的组类型！");
        }
        
        return groupId;
    }
    
    /**
     * 获取备份组类型
     * @param backupGroupType
     * @return
     */
    public static String getBackupGroup(Integer backupGroupType) {
        String groupId = "";
        switch(backupGroupType) {
            //会员组
            case 0 : 
                groupId = "group_m_backup";
                break;
            //用户组
            case 1 :
                groupId = "group_u_backup";
                break;
            default :
                throw new CustomerException("不存在的组类型！");
        }
        
        return groupId;
    }
    
}
