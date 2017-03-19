package com.lsm.travelPlan.api;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.lsm.travelPlan.remoteApi.TrainTicketRmApi;

@Path("/trainTicket")
public class TrainTicketApi {

	@GET
	@Path("/TicketInfo/{from}/{to}")
	@Produces(MediaType.TEXT_PLAIN)
	public String searchTrainTicket(@PathParam("from")String from,@PathParam("to")String to){
		/*from="º¼ÖÝ";
		to="À¥Ã÷";*/
		String httpUrl = "http://apis.baidu.com/qunar/qunar_train_service/s2ssearch";
		String httpArg=null;
		try {
			httpArg = "version=1.0&from="+new String(from.getBytes("utf-8"))+"&to="+new String(to.getBytes("utf-8"))+"&date=2016-02-01";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonResult =TrainTicketRmApi.request(httpUrl, httpArg);
		return jsonResult;
	}
	
	
	
	
}
