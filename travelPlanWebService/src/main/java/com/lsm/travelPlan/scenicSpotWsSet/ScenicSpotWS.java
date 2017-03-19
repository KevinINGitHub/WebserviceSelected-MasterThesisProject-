package com.lsm.travelPlan.scenicSpotWsSet;

import java.util.List;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.entity.ScenicDetail;
import com.lsm.travelPlan.service.ReceiveDataFRestful;
import com.lsm.travelPlan.starHotelWs.StarHotelWebService;

public class ScenicSpotWS{
	public String getScenicSpotInfoList(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
	public String getSearchScenicSpotInfo(String destination){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotListRev?destination="+destination;
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
}
