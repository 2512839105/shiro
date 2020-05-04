package com.sdzy.mall.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.asdzy.common.utils.PropFileConfig;
import com.baomidou.mybatisplus.plugins.Page;

public class BaseUtil {
    public static String vloginIdList = PropFileConfig.getProperty("vloginId");
    public static String vpwdList =PropFileConfig.getProperty("vpwd");
    
    /**地球半径平均值，千米为单位*/
    public static double EARTH_RADIUS = 6371.0;

    private static final Random random = new Random(System.currentTimeMillis());
    public static final String TOKENPARAM = "sessionToken";
    
    /**权限校验  vloginIdArray和vpwdListArray数量一定相等，且一一对应。
     * */
    public static boolean validate(String vloginId,String vpwd) {
        String[] vloginIdArray = vloginIdList.split(",");
        String[] vpwdListArray = vpwdList.split(",");
        
        for(int i=0;i<vloginIdArray.length;i++) {
            if((vloginIdArray[i].equals(vloginId)&&vpwdListArray[i].equals(vpwd))) {
                return true;
            }
        }
        return false;
    }
    
       public static Page unValidate() {
           Page page = new Page<>();
           List<Map<String, Object>> records = new ArrayList<>();
           Map<String, Object> map = new HashMap<String, Object>();
           map.put("error", "接口校验不成功");
           map.put("errorStatus", "500");
           records.add(map);
           page.setRecords(records);
           return page;
       }
       
       ///通过经纬度精算两点距离
       public static double OrderWithDit(String latitude1, String latitude2,String longitude1,String longitude2) {
           double radLat1 = getRadian(latitude1);
           double radLat2 = getRadian(latitude2);
           double a = radLat1 - radLat2;// 两点纬度差
           double b = getRadian(longitude1) - getRadian(longitude2);// 两点的经度差
           double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                   * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
           s = s * EARTH_RADIUS;
           return s * 1000;
       }
     //封装方法。 计算
       private static double getRadian(String degree) {
           return Double.parseDouble(degree) * Math.PI / 180.0;
       }
       
       
       /**
        * 生成一个token
        */
       public static synchronized String generateToken(HttpSession session) {
           String s = String.valueOf(random.nextLong());
           session.setAttribute(TOKENPARAM, s);
           return s;
       }
}
