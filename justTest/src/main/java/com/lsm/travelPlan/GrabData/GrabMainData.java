package com.lsm.travelPlan.GrabData;
import java.io.*;
import java.net.*;
public class GrabMainData {

	/**
	 * @param args
	 */
    public String captureHtml(String strURL) throws Exception {  
       // String strURL = "http://ip.chinaz.com/?IP=" + ip;  
        URL url = new URL(strURL);  
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        InputStreamReader input = new InputStreamReader(httpConn  
                .getInputStream(), "utf-8");  
        BufferedReader bufReader = new BufferedReader(input);  
        String line = "";  
        StringBuilder contentBuf = new StringBuilder();  
        while ((line = bufReader.readLine()) != null) {  
            contentBuf.append(line);  
        }  
        String buf = contentBuf.toString();  
        return buf;
      /*  int beginIx = buf.indexOf("查询结果[");  
        int endIx = buf.indexOf("上面四项依次显示的是");  
        String result = buf.substring(beginIx, endIx);  
        System.out.println("captureHtml()的结果：\n" + result);  */
    }  
	  
	public static void main(String[] args) {
		 GrabMainData p = new GrabMainData();  
		 String strUrl="http://apistore.baidu.com/astore/toolshttpproxy?apiId=ssu-&isAworks=1";
	        try {
	        	String result=p.captureHtml(strUrl);
	        	System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
