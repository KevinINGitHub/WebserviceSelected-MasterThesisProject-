package com.lsm.travelPlan.remoteApi;
import java.net.*;
import java.io.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.lsm.travelPlan.api.BaseWebService;
@Path("/trainTicketRm")
public class TrainTicketRmApi extends BaseWebService{

	/**
	 * @param args
	 */

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	@GET
	@Path("/trainDetailList")
	@Produces(MediaType.TEXT_PLAIN)
    public String getSTSTicketInfo(@QueryParam("from") String from,@QueryParam("to") String to,@QueryParam("date") String date){
		String result=null;
		String httpUrl = "http://apis.baidu.com/qunar/qunar_train_service/s2ssearch";
		String httpArg=null;
		try {
			httpArg = "version=1.0&from="+new String(from.getBytes("utf-8"))+"&to="+new String(to.getBytes("utf-8"))+"&date=2016-02-22"/*+new String(to.getBytes("utf-8"))*/;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result=request(httpUrl, httpArg);
		return result;
	}
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "030e547389b78b54befb182fad713926");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static void main(String[] args) {
		String from="北京";
		String to="杭州";
		String httpUrl = "http://apis.baidu.com/qunar/qunar_train_service/s2ssearch";
		String httpArg=null;
		try {
			httpArg = "version=1.0&from="+new String(from.getBytes("utf-8"))+"&to="+new String(to.getBytes("utf-8"))+"&date=2016-02-01";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonResult = request(httpUrl, httpArg);
		System.out.println(jsonResult);
	}

}
