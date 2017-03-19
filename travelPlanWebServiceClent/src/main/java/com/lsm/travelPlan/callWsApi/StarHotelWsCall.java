package com.lsm.travelPlan.callWsApi;

import java.rmi.RemoteException;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.lsm.travelPlan.starHotelWs.StarHotelWebServiceProxy;
import com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewProxy;
import com.lsm.util.PropertiesUtil;

@Path("/starHotelInfoFWs")
public class StarHotelWsCall {
	@GET
	@Path("/starHotelInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getScenicSpotInfoFWs(){
		String starHotelInfo=null;
		StarHotelWebServiceNewProxy starHotelWebServiceProxy=new StarHotelWebServiceNewProxy();
		//String endpoint=PropertiesUtil.readWsUrlValue("starHotelInfo");
		String endpoint=PropertiesUtil.readWsUrlValue("starHotelInfo");
		starHotelWebServiceProxy.setEndpoint(endpoint);
		try {
			starHotelInfo=starHotelWebServiceProxy.getStarHotelListInfo();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return starHotelInfo;
	}
	
	@GET
	@Path("/starHotelInfoNew")
	@Produces(MediaType.TEXT_PLAIN)
	public String getScenicSpotInfoFWsN(@QueryParam("destination") String destination){
		String starHotelInfo=null;
		StarHotelWebServiceNewProxy starHotelWebServiceProxy=new StarHotelWebServiceNewProxy();
		String endpoint=PropertiesUtil.readWsUrlValue("starHotelWsURLNew");
		starHotelWebServiceProxy.setEndpoint(endpoint);
		try {
			starHotelInfo=starHotelWebServiceProxy.getSearchStarHotelInfo(destination);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return starHotelInfo;
	}
}
