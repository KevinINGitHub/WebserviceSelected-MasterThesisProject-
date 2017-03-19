package com.lsm.travelPlan.wscResultApi;



import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lsm.geneticAlgorithm.fuzzyElitGA.FuzzyEliteGADemo;
import com.lsm.geneticAlgorithm.standardGA.GADemo;
import com.lsm.geneticAlorithm.baseTool.*;
import com.lsm.geneticAlorithm.entity.AlgorithmComp;
import com.lsm.geneticAlorithm.entity.CodeParam;
import com.lsm.geneticAlorithm.entity.SelectParam;
import com.lsm.geneticAlorithm.entity.SelectedWsResult;
import com.lsm.travelPlan.database.WebServiceInfoSql;
import com.lsm.travelPlan.entity.APIResultBase;
import com.lsm.travelPlan.entity.WebServiceInfo;


@Path("/wsResult")
public class WsResultInfo extends BaseWebService{
	@GET
	@Path("/webServiceInfo")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getScenicSpotList(){
		APIResultBase result =new APIResultBase();
		List<WebServiceInfo> webServiceInfoList;
		String sql="select * from webserviceinfo limit 10";
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql);
		result.setWebServiceInfoList(webServiceInfoList);
		result.setRecords(webServiceInfoList.size());
		return getResponseOK(result);
	}
	
	@GET
	@Path("/searchWsList")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSearchWsList(@QueryParam("wsType") String wsType,@QueryParam("wsNumber") String wsNumber,
			@QueryParam("priceMax") String priceMax,@QueryParam("priceMin") String priceMin,@QueryParam("responseTimeMin") String responseTimeMin
			,@QueryParam("responseTimeMax") String responseTimeMax,@QueryParam("reliableMin") String reliableMin,@QueryParam("reliableMax") String reliableMax){
		APIResultBase result =new APIResultBase();
		List<WebServiceInfo> webServiceInfoList;
		String sql="select * from webserviceinfo where wsType='"+ wsType+"' and price>"+Double.parseDouble(priceMin)+" and price<"+Double.parseDouble(priceMax)
				+" and responseTime>"+Double.parseDouble(responseTimeMin)+" and responseTime<"+Double.parseDouble(responseTimeMax)
				+" and reliability>"+Double.parseDouble(reliableMin)+" and reliability<"+Double.parseDouble(reliableMax)
				+" limit "+Integer.parseInt(wsNumber);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql);
		
		switch(wsType){
		case "scenicSpotInfo":
			
			break;
		case "starHotelInfo":
			break;
		case "trainTicketInfo":
			break;
			
		}
		
		
		TravelPlanWsSelect.getWsInfoMap().put(wsType, webServiceInfoList);
		
		
		result.setWebServiceInfoList(webServiceInfoList);
		result.setRecords(webServiceInfoList.size());
		return getResponseOK(result);
	}
	
	@GET
	@Path("/selectOptimalWs")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSelectOptimalWs(@QueryParam("algorithm") String algorithm,@QueryParam("constrPrice") String constrPrice,
			@QueryParam("constrResponseTime") String constrResponseTime,@QueryParam("constrReliable") String constrReliable,@QueryParam("constrAvailably") String constrAvailably){
		APIResultBase result =new APIResultBase();
		SelectParam sp=new SelectParam();
		sp.setAlgorithm(algorithm);
		sp.setConstrAvailably(constrAvailably);
		sp.setConstrPrice(constrPrice);
		sp.setConstrReliable(constrReliable);
		sp.setConstrResponseTime(constrResponseTime);
		TravelPlanWsSelect.setRestract(sp);
		
		SelectedWsResult optimalVs=new SelectedWsResult();
		if(Integer.parseInt(algorithm)==0){
			optimalVs=GADemo.gaSelectProcess();
			//optimalVs=GADemo.gaSelection();
		}else if(Integer.parseInt(algorithm)==1){
			optimalVs=FuzzyEliteGADemo.fegaSelection();
		}
		
		result.setSwr(optimalVs);
		
		return getResponseOK(result);
	}
	
	@GET
	@Path("/bdSelectOptWs")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response bdSelectOptWs(@QueryParam("algorithm") String algorithm,@QueryParam("constrPrice") String constrPrice,
			@QueryParam("constrResponseTime") String constrResponseTime,@QueryParam("constrReliable") String constrReliable,@QueryParam("constrAvailably") String constrAvailably){
		APIResultBase result =new APIResultBase();
		TravelPlanWsSelect.bdSelectedWs();
		return getResponseOK(result);
	}
	
	@GET
	@Path("/wsSelectionResult")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSelectionResult(){
		APIResultBase result =new APIResultBase();
		ArrayList algSelectRs=TravelPlanWsSelect.getgOptimalQosAl();
		Map algSelectRsM=TravelPlanWsSelect.getgOptimalQos();
		AlgorithmComp algorithmComp=TravelPlanWsSelect.getAlgorithmComp();
		result.setAlgorithmComp(algorithmComp);
		result.setAlgSelectRs(algSelectRs);
		return getResponseOK(result);
	}
	
	@POST
	@Path("/setWsSelectionResult")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response setSelectionResult(){
		APIResultBase result =new APIResultBase();
		//TravelPlanWsSelect.travelPlanWsSelect();
		CodeParam cp=new CodeParam();
		cp.setVarNum(3);
		double [][] ValRg={{0 ,0 ,0},{10 ,10 ,10},{7,7,7}};
		cp.setValRg(ValRg);
		cp.setChromLength(21);
		cp.setPopNum(20);
		cp.setGeneration(50);
		SelectedWsResult optimalVs=GADemo.gaSelection();
		result.setSwr(optimalVs);
		return getResponseOK(result);
	}
}
