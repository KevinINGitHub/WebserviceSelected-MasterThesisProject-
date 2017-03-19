package com.lsm.geneticAlgorithm.gaPro.entity;

import com.lsm.geneticAlorithm.entity.*;

public class CrossMess {
	Chrom crosser;
	int crossLength;
	int startP;
	Chrom[] crossChild;
	public Chrom getCrosser() {
		return crosser;
	}
	public void setCrosser(Chrom crosser) {
		this.crosser = crosser;
	}
	public Chrom[] getCrossChild() {
		return crossChild;
	}
	public void setCrossChild(Chrom[] crossChild) {
		this.crossChild = crossChild;
	}
	
	public int getCrossLength() {
		return crossLength;
	}
	public void setCrossLength(int crossLength) {
		this.crossLength = crossLength;
	}
	public int getStartP() {
		return startP;
	}
	public void setStartP(int startP) {
		this.startP = startP;
	}
}
