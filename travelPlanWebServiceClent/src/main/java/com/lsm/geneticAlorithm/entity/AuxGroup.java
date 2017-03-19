package com.lsm.geneticAlorithm.entity;

import java.util.ArrayList;
import java.util.List;

public class AuxGroup {
	int generation;
	List<Chrom> orginChromList=new ArrayList();
	List<Chrom> crossChromList=new ArrayList();
	List<Chrom> mutChromList=new ArrayList();
	List<Chrom> selectChromList=new ArrayList();
    public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public List<Chrom> getOrginChromList() {
		return orginChromList;
	}
	public void setOrginChromList(List<Chrom> orginChromList) {
		this.orginChromList = orginChromList;
	}
	public List<Chrom> getCrossChromList() {
		return crossChromList;
	}
	public void setCrossChromList(List<Chrom> crossChromList) {
		this.crossChromList = crossChromList;
	}
	public List<Chrom> getMutChromList() {
		return mutChromList;
	}
	public void setMutChromList(List<Chrom> mutChromList) {
		this.mutChromList = mutChromList;
	}
	public List<Chrom> getSelectChromList() {
		return selectChromList;
	}
	public void setSelectChromList(List<Chrom> selectChromList) {
		this.selectChromList = selectChromList;
	}
	
	
}
