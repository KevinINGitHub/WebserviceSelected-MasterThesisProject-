package com.lsm.perfAnalysis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lsm.travelPlan.database.TravelPlanDatabase;
import com.lsm.travelPlan.entity.WebServiceInfo;

public class GenerateQos {

	/**
	 * @param args
	 */
	public static void generateReliab(String className){
		double reliabRate=getPerformValue(className).getReliability();
		if(reliabRate==0){
			return;
		}
		double rate=Math.random();
		int[] testArray={1,2};
		if(reliabRate<rate){
			testArray[2]=0;
		}
	}
	
	public static void generateResponseT(String className){
		long time=(long) getPerformValue(className).getResponseTime()*1000;
		if(time==0){
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static String  getClassName(Object o){
		return o.getClass().getSimpleName();
	}
	public static WebServiceInfo getPerformValue(String className){
		WebServiceInfo webServiceInfo=new WebServiceInfo();
		double[] perform=new double[2];
		String sql="select * from webserviceinfo where wsName='"+className+"'";
		Statement s=null;
		ResultSet rs=null;
		try {
			s = TravelPlanDatabase.getConnection().createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				double responseTime=Double.parseDouble(rs.getString("responseTime"));
				double reliability=Double.parseDouble(rs.getString("responseTime"));
				webServiceInfo.setResponseTime(responseTime);
				webServiceInfo.setReliability(reliability);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return webServiceInfo;
	}
	public static void main(String[] args) {
		double rate=Math.random();
		int[] testArray={1,2};
		if(0.5<rate){
			testArray[2]=0;
		}
		
	}

}
