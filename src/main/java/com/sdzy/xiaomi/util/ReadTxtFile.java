package com.sdzy.xiaomi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadTxtFile {
 
 
public static String readTxt(String filePath) {
 
  try {
    File file = new File(filePath);
    if(file.isFile() && file.exists()) {
      InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
      BufferedReader br = new BufferedReader(isr);
      String lineTxt = null;
       
      StringBuffer  stringBuffer=new StringBuffer();
      while ((lineTxt = br.readLine()) != null) {
    	  stringBuffer.append(lineTxt);
    	  
      }
      br.close();
      return stringBuffer.toString();
    } else {
      System.out.println("文件不存在!");
      return "文件不存在!";
    }
  } catch (Exception e) {
    System.out.println("文件读取错误!");
    return "文件不存在!";
  }

 
 }

}
  
 
