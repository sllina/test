package com.yimym.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerialTool {
	
	public static String[] quy = { "like", "in","not in", ">", ">=", "<", "<=", "=", "!=" };

	public static String[] join =  { "and", "or" };

	public static String[] ordersort = { "desc", "asc" };
	
	// 编码生成
	public String getCommonBh() {
		int i = (int) (Math.random() * 900) + 100;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String datenumber = sdf.format(new Date());

		return datenumber + i;
	}
		
		
	//id唯一
	public  String getUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);   
        return temp;   
    } 
	
	
	 private  Pattern humpPattern = Pattern.compile("[A-Z]");  
    /**驼峰转下划线,效率比上面高*/  
    public  String humpToLine2(String str){  
        Matcher matcher = humpPattern.matcher(str);  
        StringBuffer sb = new StringBuffer();  
        while(matcher.find()){  
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());  
        }  
        matcher.appendTail(sb);  
        return sb.toString();  
    }
    
  //hashMap to Json
  	@SuppressWarnings("rawtypes")
  	public static String hashMapToJson(HashMap map) {
  		String string = "{";
  		for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
  			Entry e = (Entry) it.next();
  			string += "'" + e.getKey() + "':";
  			string += "'" + e.getValue() + "',";
  		}
  		string = string.substring(0, string.lastIndexOf(","));
  		string += "}";
  		return string;
  	}
  	
  //判断输入的参数是否符合要求，提出的公共部分
  	public  String judgeParam(String[] va, String name) {
  		for (int i = 0; i < va.length; i++) {
  			if (va[i].equals(name)) {
  				return null;
  			}
  		}
  		return name;
  	}

  	 //属性文件的路径   
    static String profilepath="order.properties";  
    private static Properties props = new Properties();   
    
    /**  
     * 根据主键key读取主键的值value  
     * @param filePath 属性文件路径  
     * @param key 键名  
     */   
     public static String readValue(String key) {   
         Properties props = new Properties();   
         try {   
             InputStream in = new BufferedInputStream(new FileInputStream(profilepath));  
             props.load(in);   
             String value = props.getProperty(key);   
             return value;   
         } catch (Exception e) {   
             e.printStackTrace();   
             return null;   
         }   
     }   
     
     /**  
      * 更新properties文件的键值对  
      * 如果该主键已经存在，更新该主键的值；  
      * 如果该主键不存在，则插件一对键值。  
      * @param keyname 键名  
      * @param keyvalue 键值  
      */   
      public static void updateProperties(String keyname,String keyvalue) {   
          try {   
              props.load(new FileInputStream(profilepath));   
              // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
              // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
              OutputStream fos = new FileOutputStream(profilepath);              
              props.setProperty(keyname, keyvalue);   
              // 以适合使用 load 方法加载到 Properties 表中的格式，   
              // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
              props.store(fos, "");
          } catch (IOException e) {   
              System.err.println("属性文件更新错误");   
          }   
      }  
      
      //不足长度的在前面补0
      public static String addZeroForNum(String str, int strLength) {
          int strLen = str.length();
          StringBuffer sb = null;
           while (strLen < strLength) {
                 sb = new StringBuffer();
                 sb.append("0").append(str);// 左补0
              // sb.append(str).append("0");//右补0
                 str = sb.toString();
                 strLen = str.length();
           }
          return str;
      }
      
}
