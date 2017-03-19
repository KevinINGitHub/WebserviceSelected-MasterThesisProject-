package com.lsm.geneticAlorithm.baseTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsm.geneticAlorithm.entity.AlgorithmComp;
import com.lsm.geneticAlorithm.entity.Chrom;
import com.lsm.geneticAlorithm.entity.SelectParam;
import com.lsm.travelPlan.database.WebServiceInfoSql;
import com.lsm.travelPlan.entity.WebServiceInfo;
import com.lsm.util.PropertiesUtil;

public class wsDataCenter {
	static ArrayList wsInfoList=new ArrayList();
	static Chrom[][] wsInfoArray=null;
	static Map wsInfoMap=null;
	static double[][][] originWSInfoList;
	static double[][][] standardWSInfoList;
	static double[][] maxMin;
	static int[] wsNum;
	static int qosNum=4;
	static double[] restract={22,22,22,22};
	static double[] weight={0.2,0.2,0.2,0.2,0.2};
	static int wsType=3;
	static List<WebServiceInfo> selectedWebService;
	static Map gOptimalQos=new HashMap();
	static ArrayList gOptimalQosAl=new ArrayList();
	static AlgorithmComp algorithmComp=new AlgorithmComp();
	
	public static AlgorithmComp getAlgorithmComp() {
		return algorithmComp;
	}

	public static void setAlgorithmComp(AlgorithmComp algorithmComp) {
		wsDataCenter.algorithmComp = algorithmComp;
	}

	public static ArrayList getgOptimalQosAl() {
		return gOptimalQosAl;
	}

	public static void setgOptimalQosAl(ArrayList gOptimalQosAl) {
		wsDataCenter.gOptimalQosAl = gOptimalQosAl;
	}

	
	public static List<WebServiceInfo> getSelectedWebService() {
		return selectedWebService;
	}

	public static void setSelectedWebService(List<WebServiceInfo> selectedWebService) {
		wsDataCenter.selectedWebService = selectedWebService;
	}

	public static Map getgOptimalQos() {
		return gOptimalQos;
	}

	public static void setgOptimalQos(Map gOptimalQos) {
		wsDataCenter.gOptimalQos = gOptimalQos;
	}

	static{
		List<WebServiceInfo> webServiceInfoList=new ArrayList();
		String sql="select * from webserviceinfo where wsType='scenicSpotInfo' limit 10";
		String sql1="select * from webserviceinfo where wsType='trainTicketInfo' limit 10";
		String sql2="select * from webserviceinfo where wsType='starHotelInfo' limit 10";
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql);
		wsInfoList.add(0,webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql1);
		wsInfoList.add(1,webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql2);
		wsInfoList.add(2,webServiceInfoList);
		
		double[] initSGA={1,1,1,1,1,1,1,1,1,1};
		double[] initFEGA={2,2,2,2,2,2,2,2,2,2};
		algorithmComp.setInitFEGA(initFEGA);
		algorithmComp.setInitSGA(initSGA);
		gOptimalQosAl.add(initSGA);
		gOptimalQosAl.add(initFEGA);
		
		extractQos();
		standardQos();
	}
	public static void baseDataInit(SelectParam sp){
		restract[0]=Double.parseDouble(sp.getConstrPrice());
		restract[1]=Double.parseDouble(sp.getConstrResponseTime());
		restract[2]=Double.parseDouble(sp.getConstrReliable());
		restract[3]=Double.parseDouble(sp.getConstrAvailably());
		List<WebServiceInfo> webServiceInfoList=new ArrayList();
		String sql="select * from webserviceinfo where wsType='scenicSpotInfo' limit 10";
		String sql1="select * from webserviceinfo where wsType='trainTicketInfo' limit 10";
		String sql2="select * from webserviceinfo where wsType='starHotelInfo' limit 10";
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql);
		wsInfoList.add(webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql1);
		wsInfoList.add(webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql2);
		wsInfoList.add(webServiceInfoList);
		extractQos();
		standardQos();
	}
	
	public static void baseDataInit(){
		if(wsInfoMap!=null){
			for(Object object:wsInfoMap.keySet()){
				String wsType=(String)object;
				switch(wsType){
				case "scenicSpotInfo":
					wsInfoList.remove(0);
					wsInfoList.add(0, (List<WebServiceInfo>)wsInfoMap.get(wsType));
				case "trainTicketInfo":
					wsInfoList.remove(1);
					wsInfoList.add(1, (List<WebServiceInfo>)wsInfoMap.get(wsType));
				case "starHotelInfo":
					wsInfoList.remove(2);
					wsInfoList.add(2,(List<WebServiceInfo>)wsInfoMap.get(wsType));
				}
			}
		}
		extractQos();
		standardQos();
	}
	public static void travelPlanWsSelect(){
		List<WebServiceInfo> webServiceInfoList=new ArrayList();
		String sql="select * from webserviceinfo where wsType='scenicSpotInfo' limit 50";
		String sql1="select * from webserviceinfo where wsType='trainTicketInfo' limit 50";
		String sql2="select * from webserviceinfo where wsType='starHotelInfo' limit 50";
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql);
		wsInfoList.add(webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql1);
		wsInfoList.add(webServiceInfoList);
		webServiceInfoList=WebServiceInfoSql.getWebServiceInfo(sql2);
		wsInfoList.add(webServiceInfoList);
		extractQos();
		standardQos();
	}
	public static double calculateQos(double[] varVList){
		double resultQos=0;
		double[] component=new double[4];
		for(int i=0;i<varVList.length;i++){
			for(int k=0;k<standardWSInfoList[i][(int) varVList[i]].length;k++){
				component[k]+=standardWSInfoList[i][(int) varVList[i]][k];
			}
		}
		for(int p=0;p<component.length;p++){
			double gap=restract[p]-component[p];
			resultQos+=component[p]*weight[p];
			if(gap<0){
				resultQos+=gap*weight[weight.length-1];
			}
		}
		return resultQos;
	}
	
	public static void standardQos(){
		standardWSInfoList=new double[wsType][wsNum[wsType]][qosNum];
		for(int p=0;p<originWSInfoList.length;p++){
			for(int q=0;q<originWSInfoList[0].length;q++){
				for(int k=0;k<4;k++){
					standardWSInfoList[p][q][k]=
							(originWSInfoList[p][q][k]-maxMin[1][k])/maxMin[0][k];
				}
			}
		}
	}
	public static void extractQos(){
		maxMin=new double[2][qosNum];
		WebServiceInfo wsInfo=new WebServiceInfo();
		wsInfo=(WebServiceInfo) ((ArrayList)(wsInfoList.get(0))).get(0);
		maxMin[0][0]=wsInfo.getPrice();
		maxMin[0][1]=wsInfo.getResponseTime();
		maxMin[0][2]=wsInfo.getReliability();
		maxMin[0][3]=wsInfo.getAvailable();
		maxMin[1][0]=wsInfo.getPrice();
		maxMin[1][1]=wsInfo.getResponseTime();
		maxMin[1][2]=wsInfo.getReliability();
		maxMin[1][3]=wsInfo.getAvailable();
		wsNum=new int[wsInfoList.size()+1];            //record the number of each type webservice
		for(int q=0;q<wsInfoList.size();q++){
			wsNum[q]=((ArrayList) wsInfoList.get(q)).size();
			if(wsNum[q]>wsNum[wsNum.length-1]){
				wsNum[wsNum.length-1]=wsNum[q];
			}
		}
		originWSInfoList=new double[wsType][wsNum[wsNum.length-1]][qosNum];
		for(int i=0;i<wsInfoList.size();i++){
			ArrayList wsInfoTempt=new ArrayList();
			wsInfoTempt=(ArrayList) wsInfoList.get(i);
			wsNum[i]=wsInfoTempt.size();
			for(int j=0;j<wsInfoTempt.size();j++){
				WebServiceInfo webServiceInfo=new WebServiceInfo();
				webServiceInfo=(WebServiceInfo) wsInfoTempt.get(j);
				originWSInfoList[i][j][0]=webServiceInfo.getPrice();
				if(originWSInfoList[i][j][0]>maxMin[0][0]){
					maxMin[0][0]=originWSInfoList[i][j][0];
				}else if(originWSInfoList[i][j][0]<maxMin[1][0]){
					maxMin[1][0]=originWSInfoList[i][j][0];
				}
				originWSInfoList[i][j][1]=webServiceInfo.getResponseTime();
				if(originWSInfoList[i][j][0]>maxMin[0][0]){
					maxMin[0][0]=originWSInfoList[i][j][0];
				}else if(originWSInfoList[i][j][0]<maxMin[1][0]){
					maxMin[1][0]=originWSInfoList[i][j][0];
				}
				originWSInfoList[i][j][2]=webServiceInfo.getReliability();
				if(originWSInfoList[i][j][0]>maxMin[0][0]){
					maxMin[0][0]=originWSInfoList[i][j][0];
				}else if(originWSInfoList[i][j][0]<maxMin[1][0]){
					maxMin[1][0]=originWSInfoList[i][j][0];
				}
				originWSInfoList[i][j][3]=webServiceInfo.getAvailable();
				if(originWSInfoList[i][j][0]>maxMin[0][0]){
					maxMin[0][0]=originWSInfoList[i][j][0];
				}else if(originWSInfoList[i][j][0]<maxMin[1][0]){
					maxMin[1][0]=originWSInfoList[i][j][0];
				}
			}
		}
		for(int n=0;n<maxMin[0].length;n++){
			if(maxMin[0][n]==maxMin[1][n]){
				maxMin[1][n]=maxMin[0][n]/2;
			}
		}
	}
	
	public static ArrayList getWsInfoList() {
		return wsInfoList;
	}

	public static void setWsInfoList(ArrayList wsInfoList) {
		wsDataCenter.wsInfoList = wsInfoList;
	}

	public static Map getWsInfoMap() {
		if(wsInfoMap==null){
			wsInfoMap=new HashMap();
		}
		return wsInfoMap;
	}

	public static void setWsInfoMap(Map wsInfoMap) {
		wsDataCenter.wsInfoMap = wsInfoMap;
	}

	public static double[][][] getOriginWSInfoList() {
		return originWSInfoList;
	}

	public static void setOriginWSInfoList(double[][][] originWSInfoList) {
		wsDataCenter.originWSInfoList = originWSInfoList;
	}

	public static double[][][] getStandardWSInfoList() {
		return standardWSInfoList;
	}

	public static void setStandardWSInfoList(double[][][] standardWSInfoList) {
		wsDataCenter.standardWSInfoList = standardWSInfoList;
	}

	public static double[][] getMaxMin() {
		return maxMin;
	}

	public static void setMaxMin(double[][] maxMin) {
		wsDataCenter.maxMin = maxMin;
	}

	public static int[] getWsNum() {
		return wsNum;
	}

	public static void setWsNum(int[] wsNum) {
		wsDataCenter.wsNum = wsNum;
	}

	public static int getQosNum() {
		return qosNum;
	}

	public static void setQosNum(int qosNum) {
		wsDataCenter.qosNum = qosNum;
	}

	public static double[] getRestract() {
		return restract;
	}

	public static void setRestract(double[] restract) {
		wsDataCenter.restract = restract;
	}

	public static double[] getWeight() {
		return weight;
	}

	public static void setWeight(double[] weight) {
		wsDataCenter.weight = weight;
	}

	public static int getWsType() {
		return wsType;
	}

	public static void setWsType(int wsType) {
		wsDataCenter.wsType = wsType;
	}
	
	public static List<WebServiceInfo> getSerialWs(double[] wsSerial){
		ArrayList selectedWebServiceTempt=new ArrayList();
		for(int i=0;i<wsSerial.length;i++){
			ArrayList sgWsList=(ArrayList)wsInfoList.get(i);
			WebServiceInfo webServiceInfo=(WebServiceInfo) sgWsList.get((int) wsSerial[i]);
			selectedWebServiceTempt.add(webServiceInfo);
		}
		selectedWebService=selectedWebServiceTempt;
		return selectedWebServiceTempt;
	}
	
	public static void bdSelectedWs(){
		for(Object object:selectedWebService){
			WebServiceInfo webServiceInfo=(WebServiceInfo) object;
			PropertiesUtil.writeWsUrlValue(webServiceInfo.getWsType(),webServiceInfo.getWsURL());
		}
		
	}
	public static void main(String[] args) {
		wsDataCenter.travelPlanWsSelect();
		double[] selectWs={1,1,1};
		double result=calculateQos(selectWs);
		System.out.println(result);
	}

	public static void setRestract(SelectParam sp) {
		restract[0]=Double.parseDouble(sp.getConstrPrice());
		restract[1]=Double.parseDouble(sp.getConstrResponseTime());
		restract[2]=Double.parseDouble(sp.getConstrReliable());
		restract[0]=Double.parseDouble(sp.getConstrAvailably());
	}

}
