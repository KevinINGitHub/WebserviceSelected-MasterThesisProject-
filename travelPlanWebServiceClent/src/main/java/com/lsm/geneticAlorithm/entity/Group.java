package com.lsm.geneticAlorithm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lsm.geneticAlorithm.baseTool.GATools;

/*@XmlRootElement(name = "gagroup")*/
public class Group implements Cloneable{
	int generation;
	int[][] geneList;
	double[] functionVList;
	Chrom[] orginChromArray = null;
	Chrom[] crossChromArray;
	Chrom[] selectChromArray;
	
	List<Chrom> chromList=new ArrayList();
	
	List<Chrom> orginChromList=new ArrayList();
	

	List<Chrom> crossChromList=new ArrayList();
	List<Chrom> mutChromList=new ArrayList();
	List<Chrom> selectChromList=new ArrayList();
	
	
	double averV;
	double totalV;
	Chrom elite = null;
	CodeParam cp=null;
	public int length;
	public boolean isInit = false;
	
	
	public List<Chrom> getOrginChromList() {
		return orginChromList;
	}
	public void setOrginChromList(List<Chrom> orginChromList) {
		this.orginChromList = orginChromList;
	}
	public List<Chrom> getSelectChromList() {
		return selectChromList;
	}
	public void setSelectChromList(List<Chrom> selectChromList) {
		this.selectChromList = selectChromList;
	}

	public List<Chrom> getCrossChromList() {
		return crossChromList;
	}
	public void setCrossChromList(List<Chrom> crossChromList) {
		this.crossChromList = crossChromList;
	}
	public List<Chrom> getMutChromList() {
		for(Chrom chrom: mutChromList){
			chrom.setType("mut");
		}
		return mutChromList;
	}
	public void setMutChromList(List<Chrom> mutChromList) {
		for(Chrom chrom: mutChromList){
			chrom.setType("mut");
		}
		this.mutChromList = mutChromList;
	}
	
	public Chrom[] getOrginChromArray() {
		return orginChromArray;
	}
	public void setOrginChromArray(Chrom[] orginChromArray) {
		int k=0;
		for(Chrom chrom:orginChromArray){
			chrom.setType("orgin");
			chrom.setGeneId(k++);
		}
		this.orginChromArray = orginChromArray;
	}
	public Chrom[] getCrossChromArray() {
		return crossChromArray;
	}
	public void setCrossChromArray(Chrom[] crossChromArray) {
		for(Chrom chrom:crossChromArray){
			chrom.setType("cross");
		}
		this.crossChromArray = crossChromArray;
	}
	public List<Chrom> getChromList() {
		return chromList;
	}
	public void setChromList(List<Chrom> chromList) {
		this.chromList = chromList;
	}
	public double getTotalV() {
		return totalV;
	}
	public void setTotalV(double totalV) {
		this.totalV = totalV;
	}
	public CodeParam getCp() {
		return cp;
	}
	public void setCp(CodeParam cp) {
		this.cp = cp;
	}
	public boolean isInit() {
		return isInit;
	}
	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}

	
	public Group(int generation){
		this.generation=generation;
/*		orginChromArray=new Chrom[groupNum];
*/	}
	public Group(){
		chromList=new ArrayList();
	}
	public void init() {
		isInit = true;
		if (functionVList != null) {
			int totalV = 0;
			double maxV = functionVList[0];
			int maxIndex = 0;
			for (int i = 0; i < functionVList.length; i++) {
				totalV += functionVList[i];
				if (functionVList[i] > maxV) {
					maxV = functionVList[i];
					maxIndex = i;
				}
			}
			this.totalV = totalV;
			averV = totalV / functionVList.length;
			this.averV=averV;
			elite = new Chrom();
			elite.setGene(geneList[maxIndex]);
			elite.setFitnessV(maxV);
		}else{
			 functionVList=GATools.calcFitness(geneList,cp);
			 int totalV = 0;
				double maxV = functionVList[0];
				int maxIndex = 0;
				for (int i = 0; i < functionVList.length; i++) {
					totalV += functionVList[i];
					if (functionVList[i] > maxV) {
						maxV = functionVList[i];
						maxIndex = i;
					}
				}
				this.totalV = totalV;
				averV = totalV / functionVList.length;
				this.averV=averV;
				elite = new Chrom();
				elite.setGene(geneList[maxIndex]);
				elite.setFitnessV(maxV);
		}
	}

	public int[][] getGeneList() {
		return geneList;
	}

	public void setGeneList(int[][] geneList) {
		this.geneList = geneList;
		orginChromArray=new Chrom[geneList.length];
		Chrom chrom=new Chrom();
		for(int i=0;i<orginChromArray.length;i++){
			chrom.setGeneId(i);
			chrom.setGene(geneList[i]);
			orginChromArray[i]=chrom;
		}
		
	}

	public double[] getFunctionVList() {
		return functionVList;
	}

	public void setFunctionVList(double[] functionVList) {
		this.functionVList = functionVList;
	}


	public int getLength() {
		length = geneList.length;
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Chrom getElite(CodeParam cp) {
		this.cp=cp;
		if (!isInit) {
			init();
		}
		return elite;
	}
	
	public Chrom getElite() {
		if (!isInit) {
			init();
		}
		return elite;
	}
	public void setElite(Chrom elite) {
		this.elite = elite;
	}

	public double getAverV() {
		if (!isInit) {
			init();
		}
		return averV;
	}

	public void setAverV(double averV) {
		this.averV = averV;
	}
	public Chrom[] getSelectChromArray() {
		return selectChromArray;
	}
	public void setSelectChromArray(Chrom[] selectChromArray) {
		for(Chrom chrom:selectChromArray){
			chrom.setType("select");
		}
		this.selectChromArray = selectChromArray;
	}
	
	public Object clone() throws CloneNotSupportedException  
    {  
        return super.clone();  
    }  

}
