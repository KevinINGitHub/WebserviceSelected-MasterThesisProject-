package com.lsm.travelPlan.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lsm.travelPlan.entity.HotelDetail;
import com.lsm.travelPlan.entity.ScenicDetail;


public class ScenicSpotSql {

	/**
	 * @param args
	 */
	public static ArrayList getScenicSpotList(String sql){
		ArrayList scenicSpotList=new ArrayList();
		
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = TravelPlanDatabase.getConnection().createStatement();
		    rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	ScenicDetail scenicDetail=new ScenicDetail();
		    	scenicDetail.setAddress(rs.getString("address"));
		    	scenicDetail.setSpotName(rs.getString("spotName"));
		    	scenicDetail.setImageUrl(rs.getString("imageUrl"));
		    	scenicSpotList.add(scenicDetail);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scenicSpotList;
	}

	public static void main(String[] args) {

	}

}
