package com.lsm.travelPlan.ws.scenicSpotWs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.service.ReceiveDataFRestful;

public class ScenicSpotWebServiceNew21 {
	public String getScenicSpotInfoList(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
	public String getSearchScenicSpotList(String destination){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		try {
			destination = URLEncoder.encode(destination,  "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String httpArg="destination="+destination;
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotListRev";
		String result=ReceiveDataFRestful.request(httpUrl,httpArg);
		return result;
	}
}
