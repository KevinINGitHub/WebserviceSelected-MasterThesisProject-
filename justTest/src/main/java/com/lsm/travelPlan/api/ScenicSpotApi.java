package com.lsm.travelPlan.api;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;


import javax.ws.rs.*;

import com.lsm.travelPlan.database.ScenicSpotSql;
import com.lsm.travelPlan.entity.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ScenicSpot")
public class ScenicSpotApi extends BaseWebService{
	
	@GET
	@Path("/ScenicSpotList")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getScenicSpotList(){
		APIResultBase result =new APIResultBase();
		List<ScenicDetail> scenicDetailList;
		String sql="select * from scenicinfo limit 10";
		scenicDetailList=ScenicSpotSql.getScenicSpotList(sql);
		result.setScenicDetail(scenicDetailList);
		return getResponseOK(result);
	}
	
	@GET
	@Path("/ScenicSpotListRev")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public Response getScenicSpotListRev(@QueryParam("destination") String destination){
		APIResultBase result =new APIResultBase();
		try {
			destination=URLDecoder.decode(destination, "UTF-8");
			System.out.println("destination:"+destination);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<ScenicDetail> scenicDetailList;
		String sql="select * from scenicinfo where address LIKE'%"+destination+"%'";
		scenicDetailList=ScenicSpotSql.getScenicSpotList(sql);
		result.setScenicDetail(scenicDetailList);
		return getResponseOK(result);
	}
	
	@GET
	@Path("/ScenicSpotListFws")
	@Produces()
	public Response getScenicSpotListFws(){
		APIResultBase result =new APIResultBase();
		List<ScenicDetail> scenicDetailList;
		String sql="select * from scenicinfo limit 10";
		scenicDetailList=ScenicSpotSql.getScenicSpotList(sql);
		result.setScenicDetail(scenicDetailList);
		return getResponseOK(result);
	}
}
