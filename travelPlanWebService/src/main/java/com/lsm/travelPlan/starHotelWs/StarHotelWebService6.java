package com.lsm.travelPlan.starHotelWs;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.service.ReceiveDataFRestful;
import com.lsm.travelPlan.trainTicketWs.TrainTicketWebService;

public class StarHotelWebService6 {
	public String getStarHotelInfo(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/hotelInfo/hotelDetailList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
}
