package com.lsm.geneticAlorithm.entity;
import java.util.*;
public class EvolutionParam {
	double[] optimalVList;
	double[] averVList;
	Map elite=new HashMap();
	double fitnessGap;
	
	public double getFitnessGap() {
		return fitnessGap;
	}
	public void setFitnessGap(double fitnessGap) {
		this.fitnessGap = fitnessGap;
	}
	public Map getElite() {
		return elite;
	}
	public void setElite(Map elite) {
		this.elite = elite;
	}
	public double[] getOptimalVList() {
		return optimalVList;
	}
	public void setOptimalVList(double[] optimalVList) {
		this.optimalVList = optimalVList;
	}
	public double[] getAverVList() {
		return averVList;
	}
	public void setAverVList(double[] averVList) {
		this.averVList = averVList;
	}
}
