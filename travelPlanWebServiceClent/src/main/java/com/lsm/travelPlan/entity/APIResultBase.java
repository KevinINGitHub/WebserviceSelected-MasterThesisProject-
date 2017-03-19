package com.lsm.travelPlan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.lsm.geneticAlorithm.entity.AlgorithmComp;
import com.lsm.geneticAlorithm.entity.AuxGroup;
import com.lsm.geneticAlorithm.entity.Chrom;
import com.lsm.geneticAlorithm.entity.Group;
import com.lsm.geneticAlorithm.entity.SelectedWsResult;

@XmlRootElement(name = "APIResult")
public class APIResultBase {
	int page=1;
	int total=2;
	int records=13;
	List<WebServiceInfo> rows;
	SelectedWsResult swr;
	double[] optimalVs;
	Map<String,double[]> AlgSelectedResult;
	List<double[]> algSelectRs;
	AlgorithmComp algorithmComp;
	AuxGroup auxGroup;
	
	public AuxGroup getAuxGroup() {
		return auxGroup;
	}


	public void setAuxGroup(AuxGroup auxGroup) {
		this.auxGroup = auxGroup;
	}


	public AlgorithmComp getAlgorithmComp() {
		return algorithmComp;
	}


	public void setAlgorithmComp(AlgorithmComp algorithmComp) {
		this.algorithmComp = algorithmComp;
	}


	public List<double[]> getAlgSelectRs() {
		return algSelectRs;
	}


	public void setAlgSelectRs(List<double[]> algSelectRs) {
		this.algSelectRs = algSelectRs;
	}


	public void setAlgSelectedResult(Map<String, double[]> algSelectedResult) {
		AlgSelectedResult = algSelectedResult;
	}

	
	public double[] getOptimalVs() {
		return optimalVs;
	}

	public void setOptimalVs(double[] optimalVs) {
		this.optimalVs = optimalVs;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<WebServiceInfo> getRows() {
		return rows;
	}

	public void setRows(List<WebServiceInfo> rows) {
		this.rows = rows;
	}
	public List<WebServiceInfo> getWebServiceInfoList() {
		return rows;
	}
	public void setWebServiceInfoList(List<WebServiceInfo> webServiceInfoList) {
		this.rows = webServiceInfoList;
	}
	public SelectedWsResult getSwr() {
		return swr;
	}

	public void setSwr(SelectedWsResult swr) {
		this.swr = swr;
	}
	public Map<String,double[]> getAlgSelectedResult() {
		return AlgSelectedResult;
	}
}
