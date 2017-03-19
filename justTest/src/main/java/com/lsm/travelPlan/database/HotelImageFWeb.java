package com.lsm.travelPlan.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lsm.travelPlan.entity.HotelDetail;
import com.lsm.travelPlan.entity.HotelImage;

public class HotelImageFWeb {

	/**
	 * @param args
	 */
	public static void saveHotelImage(){
		String starHotelMess=StarHotelFWebP.readFileByLines("src/main/resources/HotelImageFromBD.txt");
		starHotelMess=starHotelMess.replaceAll("\\s*", "");
	/*	starHotelMess=starHotelMess.replace("&lt;strong&gt;", "");
		starHotelMess=starHotelMess.replace("&lt;\\/strong&gt;", "");*/
		JSONObject shdJB;
		try {
			HotelImage hotelImage=new HotelImage();
			shdJB = new JSONObject(starHotelMess);
			JSONArray data=(JSONArray)shdJB.get("data");
			for(int i=0;i<data.length()-1;i++){
				JSONObject imageData=(JSONObject) data.get(i);
				String thumbURL = imageData.getString("thumbURL");
				String objURL = imageData.getString("objURL");
				hotelImage.setThumbURL(thumbURL);
				hotelImage.setObjURL(objURL);
				HotelImageFWeb.saveHotelImage(hotelImage);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void saveHotelImage(HotelImage HotelImage){
		 String sql="insert into hotelImage(thrumbURL,objectURL,type)values(?,?,?)";
		   try {
			PreparedStatement ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			ps.setString(1, HotelImage.getThumbURL());
			ps.setString(2, HotelImage.getObjURL());
			ps.setString(3, HotelImage.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<1;i++){
			HotelImageFWeb.saveHotelImage();
		}
		
	}

}
