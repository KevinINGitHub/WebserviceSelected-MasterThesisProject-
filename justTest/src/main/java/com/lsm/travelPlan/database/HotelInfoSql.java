package com.lsm.travelPlan.database;

import java.util.ArrayList;
import java.sql.*;

import com.lsm.travelPlan.entity.HotelDetail;

public class HotelInfoSql{
	
	public static ArrayList getHotelList(String sql){
			ArrayList hotelList=new ArrayList();
			
			Statement stmt;
			ResultSet rs = null;
			try {
				stmt = TravelPlanDatabase.getConnection().createStatement();
			    rs = stmt.executeQuery(sql);
			    while(rs.next()){
			    	HotelDetail hotelDetail=new HotelDetail();
			    	hotelDetail.setName(rs.getString("name"));
			    	hotelDetail.setAddress(rs.getString("address"));
			    	hotelDetail.setObjURL(rs.getString("objURL"));
			    	hotelDetail.setTel(rs.getString("tel"));
			    	hotelDetail.setStarLevel(rs.getString("starlevel"));
			    	hotelList.add(hotelDetail);
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hotelList;
		}

	public static void main(String[] args) {

	}

}
