package com.lsm.travelPlan.callWsApi;

import java.rmi.RemoteException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceProxy;
import com.lsm.util.PropertiesUtil;

@Path("/trainTicketInfoFWs")
public class TrainTicketWsCall {
	@GET
	@Path("/trainTicketInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getScenicSpotInfoFWs(@QueryParam("from") String from,
			@QueryParam("to") String to,@QueryParam("date") String date)
	{
		String starHotelInfo="";
		TrainTicketWebServiceProxy trainTicketWebServiceProxy=new TrainTicketWebServiceProxy();
		String endpoint=PropertiesUtil.readWsUrlValue("trainTicketInfo");
		trainTicketWebServiceProxy.setEndpoint(endpoint);
		try {
			starHotelInfo=trainTicketWebServiceProxy.getTrainTicketInfo(from, to, date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return starHotelInfo;
	}

}
