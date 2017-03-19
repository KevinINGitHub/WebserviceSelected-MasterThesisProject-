package com.lsm.travelPlan.callWsApi;

import java.rmi.RemoteException;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.lsm.travelPlan.scenicSpotWs.ScenicSpotWebServiceProxy;
import com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewProxy;
import com.lsm.util.PropertiesUtil;

@Path("/scenicSpotInfoFWs")
public class ScenicSpotWsCall {
	
	@GET
	@Path("/scenicSpotInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getScenicSpotInfoFWs(){
		ScenicSpotWebServiceNewProxy sampleScenicSpotWebServiceNewProxy=new ScenicSpotWebServiceNewProxy();
		//String endpoint=PropertiesUtil.readWsUrlValue("scenicSpotInfo");
		String endpoint=PropertiesUtil.readWsUrlValue("scenicSpotInfo");
		sampleScenicSpotWebServiceNewProxy.setEndpoint(endpoint);
		String ScenicSpotInfo=null;
		try {
			 ScenicSpotInfo=sampleScenicSpotWebServiceNewProxy.getScenicSpotInfoList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ScenicSpotInfo;
	}
	
	@GET
	@Path("/scenicSpotInfoNew")
	@Produces(MediaType.TEXT_PLAIN)
	public String getScenicSpotInfoFWsN(@QueryParam("destination") String destination){
		ScenicSpotWebServiceNewProxy sampleScenicSpotWebServiceNewProxy=new ScenicSpotWebServiceNewProxy();
		String endpoint=PropertiesUtil.readWsUrlValue("scenicSpotWsURLNew");
		sampleScenicSpotWebServiceNewProxy.setEndpoint(endpoint);
		String ScenicSpotInfo=null;
		try {
			 ScenicSpotInfo=sampleScenicSpotWebServiceNewProxy.getSearchScenicSpotList(destination);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ScenicSpotInfo;
	}
}
