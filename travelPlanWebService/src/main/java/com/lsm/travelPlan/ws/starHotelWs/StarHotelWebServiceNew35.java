package com.lsm.travelPlan.ws.starHotelWs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebService;
import com.lsm.travelPlan.service.ReceiveDataFRestful;
import com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew;

public class StarHotelWebServiceNew35 {
	public String getStarHotelListInfo(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/hotelInfo/hotelDetailList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result; 
	}
	
	public String getSearchStarHotelInfo(String destination){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		try {
			destination = URLEncoder.encode(destination,  "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String httpArg="destination="+destination;
		String httpUrl="http://localhost:8080/justTest/rest/hotelInfo/hotelDetailListRev";
		String result=ReceiveDataFRestful.request(httpUrl,httpArg);
		return result;
	}
}
