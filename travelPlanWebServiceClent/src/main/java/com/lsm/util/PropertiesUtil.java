package com.lsm.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;



public class PropertiesUtil {

	/**
	 * @param args
	 */
	static String wsURLFilePath= "travelPlanProperties/travelPlanWs.properties";
	
	public static String getWsURLFilePath() {
		File file = new File("");
		String path="";
		return getRootPath()+File.separator+wsURLFilePath;
	}
	public static void setWsURLFilePath(String wsURLFilePath) {
		PropertiesUtil.wsURLFilePath = wsURLFilePath;
	}
	public static String readWsUrlValue(String key) {
		String value="";
		value=readProperties(getWsURLFilePath(),key);
		return value;
	}
	public static void writeWsUrlValue(String key,String value) {
		writeProperties(getWsURLFilePath(),key,value);
	}
	 public static synchronized String getRootPath() {
	        String root = PropertiesUtil.class.getResource("/").toString();
	        if (root.startsWith("file:/")) {
	            root = root.substring(6);
	        }
	        if (root.endsWith("/")) {
	            root = root.substring(0, root.length() - 1);
	        }
	        if (!root.startsWith("/")) {
	            root = "" + root;
	        }
	        if(root.contains("test-classes")){
	            root=root.replace("test-classes","classes");
	        }
	        return root;
	    }
	 public static String readProperties(String filePath,String key) {
		  Properties props = new Properties();
		        try {
		         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
		         props.load(in);
		         String value = props.getProperty (key);
	            return value;
		        } catch (Exception e) {
		         e.printStackTrace();
		         return null;
		        }
		 }
		 
		 //��ȡproperties��ȫ����Ϣ
		    public static void readProperties(String filePath) {
		     Properties props = new Properties();
		        try {
		         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
		         props.load(in);
		            Enumeration en = props.propertyNames();
		             while (en.hasMoreElements()) {
		              String key = (String) en.nextElement();
		                    String Property = props.getProperty (key);
		                    System.out.println(key+Property);
		                }
		        } catch (Exception e) {
		         e.printStackTrace();
		        }
		    }

		    //д��properties��Ϣ
		    public static void writeProperties(String filePath,String parameterName,String parameterValue) {
		     Properties prop = new Properties();
		     try {
		      InputStream fis = new FileInputStream(filePath);
		            //���������ж�ȡ�����б�����Ԫ�ضԣ�
		            prop.load(fis);
		            //���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
		            //ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
		            OutputStream fos = new FileOutputStream(filePath);
		            prop.setProperty(parameterName, parameterValue);
		            //���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
		            //���� Properties ���е������б�����Ԫ�ضԣ�д�������
		            prop.store(fos, "Update '" + parameterName + "' value");
		        } catch (IOException e) {
		         System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");
		        }
		    }
	public static void main(String[] args) {
		System.out.println(getWsURLFilePath());
		readWsUrlValue("scenicSpotWsURL");
		
		
	}

}
