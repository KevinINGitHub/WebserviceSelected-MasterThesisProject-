package com.lsm.geneticAlorithm.entity;

import com.lsm.geneticAlgorithm.gaPro.entity.*;
import com.lsm.geneticAlorithm.baseTool.GATools;
import com.lsm.geneticAlorithm.baseTool.TravelPlanWsSelect;

public class Chrom implements Cloneable{
	String type="";
	int elite=0;
	CrossMess crossMess;
	MutMess mutMess;
	
	double fitnessV=0;
	int length;
	int crossone=-1;
	int[] crossP;
	int[] mutP;
    int[] gene;
	
	int groupId=-1;
	int geneId=-1;
	int crossNum;
	int mutNum;
	
	int parent;
	int index=-1;

	
	public int getElite() {
		return elite;
	}
	public void setElite(int elite) {
		this.elite = elite;
	}
		
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
	public int getMutNum() {
		return mutNum;
	}
	public void setMutNum(int mutNum) {
		this.mutNum = mutNum;
	}
	
	public int getCrossNum() {
		return crossNum;
	}
	public void setCrossNum(int crossNum) {
		this.crossNum = crossNum;
	}
	
	
	public CrossMess getCrossMess() {
		return crossMess;
	}
	public void setCrossMess(CrossMess crossMess) {
		this.crossMess = crossMess;
	}
	public MutMess getMutMess() {
		return mutMess;
	}
	public void setMutMess(MutMess mutMess) {
		this.mutMess = mutMess;
	}
	public int getCrossone() {
		return crossone;
	}
	public void setCrossone(int crossone) {
		this.crossone = crossone;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getGeneId() {
		return geneId;
	}
	public void setGeneId(int geneId) {
		this.geneId = geneId;
	}
	
	
	public int[] getGene() {
		return gene;
	}
	
	public String getGeneString(){
		String geneString="";
		geneString=gene[0]+"";
		for(int i=1;i<gene.length;i++){
			geneString+=":"+gene[i];
		}
		return geneString;
	}
	
	public void setGene(int[] gene) {
		this.gene = gene;
		caculateFitnessV();
	}
	
	
	public int[] getCrossP() {
		return crossP;
	}
	public String getCrossPStr(){
		String result="";
		if(crossMess!=null){
			result=crossMess.getCrossLength()+":"+crossMess.getStartP();
		}
		
		return result;
	}
	public void setCrossP(int[] crossP) {
		this.crossP = crossP;
	}
	public int[] getMutP() {
		return mutP;
	}
	public String getMutPStr(){
		String result="";
		if(mutMess!=null){
			result=mutMess.getMutNum()+"";
			for(int i=1;i<mutMess.getMutSeq().length;i++){
				result+=":"+mutMess.getMutSeq()[i];
			}
		}
		return result;
	}
	public void setMutP(int[] mutP) {
		this.mutP = mutP;
	}
	
	public double getFitnessV() {
		return fitnessV;
	}
	public void setFitnessV(double fitnessV) {
		this.fitnessV = fitnessV;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void caculateFitnessV(){
		double[] varList=GATools.parseChromFInt(gene);
		this.fitnessV=TravelPlanWsSelect.calculateQos(varList);
	}
	
	public Object clone() throws CloneNotSupportedException  
    {  
        return super.clone();  
    }  

}
