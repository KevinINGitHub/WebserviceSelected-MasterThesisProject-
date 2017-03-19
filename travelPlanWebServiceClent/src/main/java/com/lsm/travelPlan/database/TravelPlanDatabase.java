package com.lsm.travelPlan.database;

import java.sql.*;
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
  
	   
 
   public static void main(String[] args){
	   
   }
}
