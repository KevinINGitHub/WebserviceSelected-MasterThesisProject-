package com.lsm.travelPlan.wscResultApi;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lsm.geneticAlorithm.entity.AuxGroup;
import com.lsm.geneticAlorithm.entity.Chrom;
import com.lsm.geneticAlorithm.entity.Group;
import com.lsm.travelPlan.database.GeneticProcessSql;
import com.lsm.travelPlan.entity.APIResultBase;

@Path("/algorithmPerform")
public class AlgorithmPerformApi extends BaseWebService{
	
	@GET
	@Path("/getGroup")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getGroup(@QueryParam("generation") String generation){
		APIResultBase result =new APIResultBase();
		AuxGroup auxGroup=GeneticProcessSql.getAuxGroup(Integer.parseInt(generation));
		result.setAuxGroup(auxGroup);
		return getResponseOK(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
