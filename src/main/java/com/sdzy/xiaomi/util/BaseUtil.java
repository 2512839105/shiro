package com.sdzy.xiaomi.util;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import com.alibaba.fastjson.JSON;
import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.utils.DateUtil;
import com.asdzy.common.utils.PropFileConfig;
import com.baomidou.mybatisplus.plugins.Page;
import com.sdzy.xiaomi.base.entity.SysUser;
import com.sdzy.xiaomi.stock.entity.BaseProduct;
import com.sdzy.xiaomi.stock.entity.DaySummary;
import com.sdzy.xiaomi.stock.entity.SaleOrderDetail;
import com.sdzy.xiaomi.stock.entity.StockBatchInventory;



public class BaseUtil {
	 public static String appidList = PropFileConfig.getProperty("appid");
	 public static String secrectList =PropFileConfig.getProperty("secrect");
	    
		
	 public static final String WX_CHECK_URL = "https://api.weixin.qq.com/sns/jscode2session?";
	
	 /**
	  * 
	  * @param js_code
	  * @return
	  */
/*	 public static boolean hasCheckByWX(String js_code,String appid,String secret){
		String params = "appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String json = HttpClient.post( params);	
		JSONObject jsonObj = JSONObject.from(json);
		if(jsonObj.get("errcode")==200 ){
			return true;
		}
		return false;
	 }*/		
		/**
	 * 执行sql语句，返回结果集，用于查询类sql
	 * 
	 * @param sql:传入的查询sql
	 * @return List<T>
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 *
	 */
	public static <T> Object executeQueryByJdbc(String sql, Object obj, BaseProduct baseProduct)
			throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
		NoSuchMethodException, SecurityException {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Object convertList = convertList(rs, obj, baseProduct);
		ps.close();
		conn.close();
		return convertList;
	}

	/**
	 * 通过反射把所有列的值set进去对象里面，并存储到一个集合
	 * 
	 * @param baseProduct
	 */
	public static <T> Object convertList(ResultSet rs, Object object, BaseProduct baseProduct)
			throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		ResultSetMetaData md = rs.getMetaData();// 获取键名
		int columnCount = md.getColumnCount();// 获取列的数量
		T t = null;
		List<Object> resultList=new ArrayList<Object>();
		while (rs.next()) {
			if (object instanceof StockBatchInventory) {
				t = (T) new StockBatchInventory();
			} else if (object instanceof SaleOrderDetail) {
				t = (T) new SaleOrderDetail();
			} else if(object instanceof DaySummary){
				t = (T) new DaySummary();
			}else if(object instanceof SysUser){
				t=(T) new SysUser();
			}else{
				
			}
			for (int i = 1; i <= columnCount; i++) {
				t = (T) setByClass(t, md.getColumnName(i), rs.getObject(i), baseProduct);
			}
			resultList.add(t);
		}
		if (baseProduct != null) {
			baseProduct.setStockBatchInventories(resultList);
			return baseProduct;
		}
		return (List<T>) resultList;
	}

	public static <T> T setByClass(T t, String columnName, Object columnValue, BaseProduct baseProduct)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Field[] field = t.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		if (baseProduct != null) {
			Field[] productField = baseProduct.getClass().getDeclaredFields();
			for (Field field2 : productField) {
				String name = "";
				if ((name = field2.getName()).equals(columnName)) {
					name = upperCase(name); // 将属性的首字符大写，方便构造get，set方法
					Method m = baseProduct.getClass().getMethod("set" + name, String.class);// 目前baseProduct只有String类型的
					m.invoke(baseProduct, columnValue);
					break;
				}
			}
		}
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			String name = field[j].getName(); // 获取属性的名字
			if (name.equals(columnName)) {
				String type = field[j].getGenericType().toString(); // 获取属性的类型
				setMethod(t,type,columnValue,name);
				break;
			}
		}
		return t;
	}

	/**
     * 反射的set方法，传入
     * 
     * @param 传入当前类，方法传入参数类型，方法传入参数值，set方法的名
     * @return boolean
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
     * @throws SQLException
     * 
     */
	private static <T> void setMethod(T t,String type,Object columnValue,String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = null;
        // 将属性的首字符大写，方便构造get，set方法
        name = upperCase(name);
        if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class
            // // "，后面跟类名
            m = t.getClass().getMethod("set" + name, String.class);
            } else if (type.equals("class java.lang.Integer")) {
            if (columnValue != null) {
            if (columnValue.equals(false)) {
            columnValue = 0;
            } else if (columnValue.equals(true)) {
            columnValue = 1;
            } else if (columnValue instanceof BigDecimal) {
            // 存在BigDecimal的情况
            BigDecimal bigdecimal = (BigDecimal) columnValue;
            columnValue = bigdecimal.intValue();
            }
            }
            m = t.getClass().getMethod("set" + name, Integer.class);
            }else if (type.equals("int")) {
            m = t.getClass().getMethod("set" + name, int.class);
            } else if (type.equals("long")) {
            m = t.getClass().getMethod("set" + name, long.class);
            } 
            else if (type.equals("class java.math.BigDecimal")) {
            m = t.getClass().getMethod("set" + name, BigDecimal.class);
            } else if (type.equals("class java.util.Date")) {
            if (columnValue instanceof String) {
            columnValue = DateUtil.parseDateByDefaultFormat(columnValue.toString());
            }
            m = t.getClass().getMethod("set" + name, Date.class);
            } else if (type.equals("class java.lang.Byte")) {
            m = t.getClass().getMethod("set" + name, Byte.class);
            } else if (type.equals("class java.lang.Double")) {
            m = t.getClass().getMethod("set" + name, Double.class);
            } else {
            m = t.getClass().getMethod("set" + name, Object.class);
            }
        m.invoke(t, columnValue);
    }

    /**
	 * 生成返回的JSON格式
	 * 
	 * @param sql:传入的查询sql
	 * @return boolean
	 * @throws SQLException
	 * 
	 */
	public static String productJson(Integer flag, Object data, String msg) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (flag != null) {
			jsonMap.put("state", 200);
			jsonMap.put("data", data);
			jsonMap.put("msg", msg);
			return JSON.toJSONString(jsonMap);
		} else {
			jsonMap.put("state", 500);
			jsonMap.put("data", "");
			jsonMap.put("msg", msg);
			return JSON.toJSONString(jsonMap);
		}
	}

	public static String upperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 执行sql语句，返回成功失败，用于增删改类sql
	 * 
	 * @param sql:传入的查询sql
	 * @return boolean
	 * @throws SQLException
	 * 
	 */
	public static boolean executeByJdbc(String sql) throws SQLException{
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
        try {
		conn.setAutoCommit(false);
		ps= conn.prepareStatement(sql);	
		ps.execute();
        conn.commit();
        } catch (SQLException e) {
        	conn.rollback();
			e.printStackTrace();
		}finally{
				ps.close();
				conn.close();
		}	
		return true;
	}
	/**
     * 传入一个实体，自动加载内部所有私有属性与其对应get,set方法
     * 
     * @param sql:传入的查询sql
     * @return boolean
     * @throws SQLException
     * @author siwei
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
     */
	public static <T> String createSql(T bean,String tableName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	    StringBuilder sBuilder = new StringBuilder();
	    sBuilder = sBuilder.append("INSERT INTO "+tableName+" (");
	    Field[] beanFields = bean.getClass().getDeclaredFields();
	    for (Field field : beanFields) {
            String fieldName = field.getName();
            if("serialVersionUID".equals(fieldName))
            {
                continue;
            }
            sBuilder = sBuilder.append(fieldName+",");            
        }
	    //去除逗号加括号 组成 insert into xx(xx,xx) VALUES(
	    sBuilder= sBuilder.deleteCharAt(sBuilder.length()-1).append(") VALUES(");
	    
	    //通过get方法拼接
	    for (Field field : beanFields) {
            String fieldName = upperCase(field.getName());
            if("SerialVersionUID".equals(fieldName))
            {
                continue;
            }
            Method getMethod = bean.getClass().getMethod("get" + fieldName);
            Object methodValue = getMethod.invoke(bean);
            sBuilder = sBuilder.append(changeNullObj(methodValue)+",");            
        }
	    
	  //去除逗号加括号 组成 insert into xx(xx,xx) VALUES(
        sBuilder= sBuilder.deleteCharAt(sBuilder.length()-1).append(")");
	    return sBuilder.toString();
	}
	
	/**
	 * 执行sql语句，返回成功失败，用于增删改类sql
	 * 
	 * @param sql:传入的查询sql
	 * @return boolean
	 * @throws SQLException
	 * 
	 */
	public static boolean executeAllByJdbc(String[] sqls) throws SQLException{
		Connection conn = JDBCUtil.getConnection();
		Statement stm = null;
        try {
		conn.setAutoCommit(false);
		stm = conn.createStatement();
		for (String sql : sqls) {
			stm.addBatch(sql);
		}
		stm.executeLargeBatch();
        conn.commit();
        conn.setAutoCommit(true); // 还原状态  
        } catch (SQLException e) {
        	conn.rollback();
			e.printStackTrace();
			throw new CustomerException("数据字段出错");
		}finally{
				stm.close();
				conn.close();
		}	
		return true;
	}
	
	public static boolean getSessionAndOpenJson(String js_code,String appid,String secrect) throws IOException {
		/*url由appid，secret，js_code构成，获得appid，secret，是微信平台提供，js_code 是小程序客户端提供,最后
		拼装成https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code*/
	    String[] appidArray = appidList.split(",");//wx6061d5a96520f166  wx6061d5a96520f166
        String[] secrectArray = secrectList.split(",");//5c5ee5e5b9165db90960a124573baa93    5c5ee5e5b9165db90960a124573baa93   
        for(int i=0;i<appidArray.length;i++) {        	 
            if((appidArray[i].equals(appid)&&secrectArray[i].equals(secrect))) {
 
        		return true;	
            }
        }
        
        return false;		
	}
	// 校验不成功的方法
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

	 public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }

	 public static String getOrderNo(){
		 String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 char c1=chars.charAt((int)(Math.random() * 26));
		 char c2=chars.charAt((int)(Math.random() * 26));
		 int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		 int r2=(int)(Math.random()*(10));
		 long now = System.currentTimeMillis();//一个13位的时间戳
		 String paymentID =String.valueOf(c1)+String.valueOf(c2)+String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		 return  paymentID;
	 }
	 private static String changeNullObj(Object obj){
	        if(obj instanceof Date){
	            obj = DateUtil.formatDateTime((Date) obj);
	        }
	        return obj==null?null:"'"+obj+"'";
	    }
	 public static String getURLContent(String urlStr) {               
			//请求的url 
			URL url = null;      
		    //请求的输入流
		    BufferedReader in = null;   
			//输入流的缓冲
		    StringBuffer sb = new StringBuffer(); 
			try{
				url = new URL(urlStr);     
				in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8") ); 
				String str = null;  
				//一行一行进行读入
				while((str = in.readLine()) != null) {
					sb.append( str );     
				}     
			} catch (Exception ex) {   
				            
			} finally{    
				try{
					if(in!=null) {
						in.close(); //关闭流    
				    }     
			    }catch(IOException ex) {      
				        
			    }     
			}     
		   String result =sb.toString();     
		   return result;    
		}
  
}
