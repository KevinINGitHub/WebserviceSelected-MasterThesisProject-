package com.lsm.travelPlan.scenicSpotWs;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


import com.lsm.perfAnalysis.GenerateQos;
import com.lsm.travelPlan.service.ReceiveDataFRestful;

public class ScenicSpotWebService {
	public String getScenicSpotInfo(){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotList";
		String result=ReceiveDataFRestful.request(httpUrl,"");
		return result;
	}
	public String getScenicSpotInfo(String destination){
		String className=this.getClass().getSimpleName();
		GenerateQos.generateReliab(className);
		GenerateQos.generateResponseT(className);
		try {
			destination = URLEncoder.encode("北京",  "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String httpUrl="http://localhost:8080/justTest/rest/ScenicSpot/ScenicSpotListRev";
		String result=ReceiveDataFRestful.request(httpUrl,destination);
		return result;
	}
	public static void main(String[] args){
		ScenicSpotWebService scenicSpotWebService=new ScenicSpotWebService();
		String destination=null;
		try {
			destination = URLEncoder.encode("北京",  "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String result=scenicSpotWebService.getScenicSpotInfo(destination);
		System.out.println(result);
	}
}
