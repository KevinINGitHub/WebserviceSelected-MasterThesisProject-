package com.lsm.travelPlan.trainTicketWs;

import java.io.UnsupportedEncodingException;

import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.service.ReceiveDataFRestful;

public class TrainTicketWebService36 {
	public String getTrainTicketInfo(String from,String to,String date){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl = "http://apis.baidu.com/qunar/qunar_train_service/s2ssearch";
		String httpArg=null;
		try {
			httpArg = "version=1.0&from="+new String(from.getBytes("utf-8"))+"&to="+new String(to.getBytes("utf-8"))+"&date="+date;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String result = ReceiveDataFRestful.request(httpUrl, httpArg);
		return result;
	}
	
}
