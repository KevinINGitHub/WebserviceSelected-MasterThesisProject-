package com.lsm.travelPlan.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lsm.travelPlan.entity.*;
public class WebServiceInfoSql {

	/**
	 * @param args
	 */
	public static List<WebServiceInfo> getWebServiceInfo(String sql){
		List<WebServiceInfo> webServiceInfoList=new ArrayList();
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = TravelPlanDatabase.getConnection().createStatement();
		    rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	WebServiceInfo webServiceInfo=new WebServiceInfo();
		    	webServiceInfo.setWsName(rs.getString("wsName"));
		    	webServiceInfo.setWsURL(rs.getString("wsURL"));
		    	webServiceInfo.setWsType(rs.getString("wsType"));
		    	webServiceInfo.setPrice(Double.parseDouble(rs.getString("price")));
		    	webServiceInfo.setResponseTime(Double.parseDouble(rs.getString("responseTime")));
		    	webServiceInfo.setReliability(Double.parseDouble(rs.getString("reliability")));
		    	webServiceInfo.setAvailable(Double.parseDouble(rs.getString("available")));
		    	webServiceInfoList.add(webServiceInfo);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return webServiceInfoList;
	}
	public static void main(String[] args) {

	}

}
