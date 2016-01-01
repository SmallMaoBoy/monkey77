package com.monkey.utils;

import java.io.IOException;  
import java.util.Properties;  
  
/** 
 *  
 * ��ȡproperties�ļ��Ĺ����� 
 * 
 * @author ĪС��_ly 2012-3-30 
 */  
public class PropertiesUtil {  
    private static Properties p = new Properties();  
  
    /** 
     * ��ȡproperties�����ļ���Ϣ 
     */  
    static{  
        try {  
            p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));  
        } catch (IOException e) {  
            e.printStackTrace();   
        }  
    }  
    /** 
     * ����key�õ�value��ֵ 
     */  
    public static String getValue(String key)  
    {  
        return p.getProperty(key);  
    }  
} 