package com.lsm.travelPlan.api;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lsm.travelPlan.database.HotelInfoSql;
import com.lsm.travelPlan.entity.APIResultBase;
import com.lsm.travelPlan.entity.HotelDetail;

@Path("/hotelInfo")
public class HotelInfoApi extends BaseWebService{
	@GET
	@Path("/hotelDetailList")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getHotelDetailList(){
		APIResultBase result=new APIResultBase();
		List<HotelDetail> hotelDetailList;
		String sql="select * from starhotelinfo where id<100";
		hotelDetailList=HotelInfoSql.getHotelList(sql);
		result.setHotelDetailList(hotelDetailList);
		return getResponseOK(result);
	}
	
	@GET
	@Path("/hotelDetailListRev")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getHotelDetailListRev(@QueryParam("destination") String destination){
		APIResultBase result=new APIResultBase();
		try {
			destination=URLDecoder.decode(destination, "UTF-8");
			System.out.println("destination:"+destination);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<HotelDetail> hotelDetailList;
		String sql="SELECT * FROM starhotelinfo where address Like '%"+destination+"%'";
		hotelDetailList=HotelInfoSql.getHotelList(sql);
		result.setHotelDetailList(hotelDetailList);
		return getResponseOK(result);
	}
}
