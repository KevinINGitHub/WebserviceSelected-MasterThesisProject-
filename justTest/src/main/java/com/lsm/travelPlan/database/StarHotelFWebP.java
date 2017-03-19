package com.lsm.travelPlan.database;
import java.io.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lsm.travelPlan.database.TravelPlanDatabase;
import com.lsm.travelPlan.entity.HotelDetail;
public class StarHotelFWebP {

	/**
	 * @param args
	 */
	String HotelMess="";
	public static void saveStarHotelMess(){
		String starHotelMess=StarHotelFWebP.readFileByLines("src/main/resources/StarHotelfromBd.txt");
		starHotelMess=starHotelMess.replaceAll("\\s*", "");
		starHotelMess=starHotelMess.replace("&lt;strong&gt;", "");
		starHotelMess=starHotelMess.replace("&lt;\\/strong&gt;", "");
		JSONObject shdJB;
		try {
			HotelDetail hotelDetail=new HotelDetail();
			shdJB = new JSONObject(starHotelMess);
			JSONArray data=(JSONArray)shdJB.get("data");
			for(int i=0;i<data.length();i++){
				hotelDetail=parseStarHJson((JSONObject) data.get(i));
				StarHotelFWebP.saveHotelDetail(hotelDetail);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void saveHotelDetail(HotelDetail hotelDetail){
		 String sql="insert into starHotelInfo(name,province,objURL)values(?,?,?)";
		   try {
			PreparedStatement ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			ps.setString(1, hotelDetail.getName());
			ps.setString(2, hotelDetail.getProvince());
			ps.setString(3, hotelDetail.getObjURL());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 public static HotelDetail parseStarHJson(JSONObject subData){
		 HotelDetail hotelDetail=new HotelDetail();
			try {
				if(!subData.isNull("fromPageTitle")){
					String fromPageTitle=subData.getString("fromPageTitle");
					if(fromPageTitle.indexOf("星级酒店名录")!=-1&&fromPageTitle.indexOf(":")!=-1){
						int start = fromPageTitle.indexOf(":");
						StringBuffer sb = new StringBuffer(fromPageTitle);
						String starHotelName = sb.substring(start+1);
						String province=subString(fromPageTitle,"(",")");
						String objURL = subData.getString("objURL");
						hotelDetail.setName(starHotelName);
						hotelDetail.setObjURL(objURL);
						hotelDetail.setProvince(province);	
				}
					}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		 return hotelDetail;
	 }
	public static String subString(String originStr,String str1,String str2){
		String lastStr = "";
		int start = originStr.indexOf(str1);
		int end = originStr.indexOf(str2);
		StringBuffer sb = new StringBuffer(originStr);
		return lastStr = sb.substring(start+1, end);
	}
	 public static String readFileByLines(String fileName) {
		 String starHotelMess="";
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	            	starHotelMess+=tempString;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return starHotelMess;
	    }
	public static void main(String[] args) {
		StarHotelFWebP.saveStarHotelMess();
	}

}
