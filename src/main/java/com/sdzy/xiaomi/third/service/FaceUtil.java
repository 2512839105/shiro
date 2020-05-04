package com.sdzy.xiaomi.third.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import com.asdzy.common.exception.CustomerException;
public class FaceUtil {
    
    /**
     * 人脸图片存储的基路径
     */
    public static String baseFilePath;

    /**
     * 解码并存储图片
     * @param base64
     * @param path
     * @param imgName
     */
    public static void decodeBase64ToImage(String base64, String path) {  
        Base64 decoder = new Base64();
        try {  
            File file = new File(path);
            file.getParentFile().mkdirs();
            FileOutputStream write = new FileOutputStream(file);
            byte[] decoderBytes = decoder.decode(base64);
            write.write(decoderBytes);
            write.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
    
    /**
     * 存储图片
     * @param byteDatas
     * @param path
     */
    public static void byteDatasToImage(Byte[] byteDatas, String path) {
        try {  
            File file = new File(path);
            
            file.getParentFile().mkdirs();
            FileOutputStream write = new FileOutputStream(file);
            write.write(ArrayUtils.toPrimitive(byteDatas));
            write.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }

    /**
     * 根据图片路径获取 byte
     * @param imagePath
     * @return
     */
    public static Byte[] getByteDatas(String imagePath) {
        byte[] imageDatas;
        
        try {
            imageDatas = FileUtils.readFileToByteArray(new File(imagePath));
            
            return ArrayUtils.toObject(imageDatas);
        } catch (IOException e) {
            e.printStackTrace();
            
            throw new CustomerException("读取图片异常");
        }
    }
    
    /**
     * 图片解码并返回 byte
     * @param base64Str
     * @return
     */
    public static Byte[] decodeImageStrBase64ToByte(String base64Str) {
        base64Str = base64Str.trim();
        base64Str = base64Str.replace("data:image/png;base64,", "");
        base64Str = base64Str.replace("data:image/jpeg;base64,", "");
        base64Str = base64Str.substring(0, base64Str.length()-1);

        Byte[] bytes = ArrayUtils.toObject(Base64.decodeBase64(base64Str));
        
        return bytes;
    }
    
    /**
     * 根据路径删除图片
     * @param path
     */
    public static void deleteFile(String path) {
        File file = new File(path);
        if(file.exists())
            file.delete();
    }
    
}
