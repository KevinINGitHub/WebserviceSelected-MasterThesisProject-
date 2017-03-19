package com.lsm.travelPlan.database;

import java.sql.*;

import com.lsm.travelPlan.entity.ScenicDetail;

public class TravelPlanDatabase {
   private	static String name="com.mysql.jdbc.Driver";
   private	static String url="jdbc:mysql://127.0.0.1/travelplan";
   private	static String user="root";
   private	static String password="";
   private	static Connection conn;
	static{
		try {
			Class.forName(name);
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   public static void close(){
	   try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
   }
   public static Connection getConnection(){
	   return conn;
   } 
   public static void saveScenicDetail(ScenicDetail scenicDetail){
	   String sql="insert into scenicInfo(id,spotName,description,province,city,address,imageUrl,normalPrice,detail)values(?,?,?,?,?,?,?,?,?)";
	   try {
		PreparedStatement ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
		ps.setString(1, scenicDetail.getProductId());
		ps.setString(2, scenicDetail.getSpotName());
		ps.setString(3, scenicDetail.getDescription());
		ps.setString(4, scenicDetail.getProvince());
		ps.setString(5, scenicDetail.getCity());
		ps.setString(6, scenicDetail.getAddress());
		ps.setString(7, scenicDetail.getImageUrl());
		ps.setString(8, scenicDetail.getNormalPrice());
		ps.setString(9, scenicDetail.getScenicDetail());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static void main(String[] args){
	   
   }
}
