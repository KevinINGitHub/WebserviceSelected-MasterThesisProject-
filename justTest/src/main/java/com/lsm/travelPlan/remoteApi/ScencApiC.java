package com.lsm.travelPlan.remoteApi;
import java.net.*;
import org.json.*;

import com.lsm.travelPlan.database.TravelPlanDatabase;
import com.lsm.travelPlan.entity.ScenicDetail;

import java.io.*;
public class ScencApiC {

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
    
	

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String requestDetail(String httpUrl, String httpArg) {
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
    
	public static String scenicList(String page,String pagesize){
		String httpUrl = "http://apis.baidu.com/apistore/qunaerticket/querylist";
		String httpArg = "pageno="+page+"&pagesize="+pagesize;
		String jsonResult = request(httpUrl, httpArg);
		return jsonResult;
	}
	public static String scenicDetail(String id){
		String httpUrl = "http://apis.baidu.com/apistore/qunaerticket/querydetail";
		String httpArg = "id="+id;
		String jsonResult = request(httpUrl, httpArg);
		return jsonResult;
	}
	
	public static void saveScenicData(){
		
		int k=1;
		int q=1;
		for (int j=1;j<=k+1&&q!=0;j++){
			String scenicList=scenicList(j+"","500");
			try {
				JSONObject scenicListJson= new JSONObject(scenicList); 
				JSONObject retDataL=(JSONObject) scenicListJson.get("retData");
				if(k==1){
				int totalRecord=(Integer)retDataL.get("totalRecord");
				k=totalRecord/100;
				q=totalRecord%100;
				}
				JSONArray ticketList=(JSONArray) retDataL.get("ticketList");
				ScenicDetail scenicDetailE=new ScenicDetail();
				for(int i=0;i<ticketList.length();i++){
					JSONObject ticketL=(JSONObject) ticketList.get(i);
					String productId=(String) ticketL.get("productId");
					String scenicDetail=scenicDetail(productId);
					JSONObject scenicDetailJson= new JSONObject(scenicDetail);
					JSONObject retData=(JSONObject) scenicDetailJson.get("retData");
					JSONObject ticketDetail=(JSONObject) retData.get("ticketDetail");
					JSONObject data=(JSONObject) ticketDetail.get("data");
					JSONObject display=(JSONObject) data.get("display");
					JSONObject ticket=(JSONObject) display.get("ticket");
					String spotName=(String) ticket.get("spotName");
					String description="";
					if(!ticket.isNull("description")){
						description=(String) ticket.get("description");
					}
					String address=(String) ticket.get("address");
					String province=(String) ticket.get("province");
					String city=(String) ticket.get("city");
					String imageUrl=(String) ticket.get("imageUrl");
					JSONObject priceM=null;
					String normalPrice="";
					Object o=ticket.get("priceList");
					if(o instanceof JSONArray){
						JSONArray priceList=(JSONArray) ticket.get("priceList");
						 priceM=(JSONObject) priceList.get(0);
						 normalPrice=(String) priceM.get("normalPrice");
					}else if(o instanceof JSONObject){
						 priceM=(JSONObject) ticket.get("priceList");
						 normalPrice=(String) priceM.get("normalPrice");
					}
				
					System.out.println("spotName:"+spotName);
					System.out.println(province);
					System.out.println(city);
					scenicDetailE.setAddress(address);
					scenicDetailE.setCity(city);
					scenicDetailE.setDescription(description);
					scenicDetailE.setProductId(productId);
					scenicDetailE.setProvince(province);
					scenicDetailE.setSpotName(spotName);
					scenicDetailE.setNormalPrice(normalPrice);
					scenicDetailE.setImageUrl(imageUrl);
					//scenicDetailE.setScenicDetail(scenicDetail);
					
					/*try {
						scenicDetailE.setAddress(address.getBytes("utf-8"));
						scenicDetailE.setCity(city.getBytes("utf-8"));
						//scenicDetailE.setDescription(address.getBytes("utf-8"));
						scenicDetailE.setProductId(productId);
						scenicDetailE.setProvince(province.getBytes("utf-8"));
						scenicDetailE.setSpotName(spotName.getBytes("utf-8"));
						scenicDetailE.setScenicDetail("");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}*/
					
					TravelPlanDatabase.saveScenicDetail(scenicDetailE);
				}
				
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
	
		
	}
	public static void main(String[] args) {
		/*String httpUrl = "http://apis.baidu.com/apistore/qunaerticket/querylist";
		String httpArg = "pageno=1&pagesize=20";
		String jsonResult = request(httpUrl, httpArg);
		System.out.println(jsonResult);*/
		
		/*String httpUrl = "http://apis.baidu.com/apistore/qunaerticket/querydetail";
		String httpArg = "id=1361653183";
		String jsonResult = request(httpUrl, httpArg);
		System.out.println(jsonResult);*/
		saveScenicData();
	}

}
