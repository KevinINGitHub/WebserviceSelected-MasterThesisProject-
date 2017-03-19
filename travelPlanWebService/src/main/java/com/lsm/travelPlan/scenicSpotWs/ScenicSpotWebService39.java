package com.lsm.travelPlan.scenicSpotWs;

import java.util.List;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.entity.ScenicDetail;
import com.lsm.travelPlan.service.ReceiveDataFRestful;
import com.lsm.travelPlan.starHotelWs.StarHotelWebService;

public class ScenicSpotWebService39 {
	public String getScenicSpotInfo(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
}
