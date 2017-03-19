package com.lsm.geneticAlorithm.entity;

public class CodeParam {
	//the number of the variable in chroms
	public int varNum;
	/*
	 * The message of those variable,
	 * the 1th row represent the maxValue of the variables,
	 * the 2th row represent the minValue of the variables,
	 * the 3th row represent the length which the variable occupy in the chrom
	 */
	public double[][] valRg; 
	
	public int chromLength; //the chromLength is represent the length of one variable;
	
	public int popNum; //the scale of the population
	
	
	public int generation;  //The number of evolutionary operation cycle
	
	public int codingStyle;
	
    
	
	public int getPopNum() {
		return popNum;
	}
	public void setPopNum(int popNum) {
		this.popNum = popNum;
	}
	
	
	public int getChromLength() {
		return chromLength;
	}
	public void setChromLength(int chromLength) {
		this.chromLength = chromLength;
	}
	public double[][] getValRg() {
		return valRg;
	}
	public void setValRg(double[][] valReg) {
		this.valRg = valReg;
	}
	public int getVarNum() {
		return varNum;
	}
	public void setVarNum(int varNum) {
		this.varNum = varNum;
	}
	public int getCodingStyle() {
		return codingStyle;
	}
	public void setCodingStyle(int codingStyle) {
		this.codingStyle = codingStyle;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
}
