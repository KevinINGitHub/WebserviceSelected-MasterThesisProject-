package com.lsm.travelPlan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RestfulUtil {
   
   // еп╤ожпнд  
   public static boolean isChineseChar(String str)  
       {  
           boolean temp = false;  
           Pattern p=Pattern.compile("[\u4e00-\u9fa5]");  
           Matcher m=p.matcher(str);  
           if(m.find()){  
               temp =  true;  
           }  
           return temp;  
       }  
}
