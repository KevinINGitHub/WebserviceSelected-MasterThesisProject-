package com.lsm.geneticAlorithm.entity;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lsm.travelPlan.entity.*;
@XmlRootElement(name = "SelectedWsResult")
public class SelectedWsResult {
	String algorithm;
	double[] gOptQos;
	double time;
	double[] wsSerial;
	List<WebServiceInfo> wsInfoResult;
	double optQos;
	public double[] getgOptQos() {
		return gOptQos;
	}
	public void setgOptQos(double[] gOptQos) {
		this.gOptQos = gOptQos;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getOptQos() {
		return optQos;
	}
	public void setOptQos(double optQos) {
		this.optQos = optQos;
	}
	
	public double[] getWsSerial() {
		return wsSerial;
	}
	public void setWsSerial(double[] wsSerial) {
		this.wsSerial = wsSerial;
	}
	public List<WebServiceInfo> getWsInfoResult() {
		return wsInfoResult;
	}
	public void setWsInfoResult(List<WebServiceInfo> wsInfoResult) {
		this.wsInfoResult = wsInfoResult;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}
