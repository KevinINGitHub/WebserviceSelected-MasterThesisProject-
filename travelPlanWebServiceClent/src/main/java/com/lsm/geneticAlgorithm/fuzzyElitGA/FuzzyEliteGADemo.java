package com.lsm.geneticAlgorithm.fuzzyElitGA;


import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.lsm.geneticAlorithm.baseTool.GATools;
import com.lsm.geneticAlorithm.baseTool.TravelPlanWsSelect;
import com.lsm.geneticAlorithm.entity.*;
import com.lsm.util.PropertiesUtil;

public class FuzzyEliteGADemo {

	public static SelectedWsResult fegaSelection(){
		SelectedWsResult swr=new SelectedWsResult();
		double[] wsSerial=null;
		
		double begin = System.currentTimeMillis();
		CodeParam cp = new CodeParam();
		cp.setVarNum(3);
		double[] varMin=new double[TravelPlanWsSelect.getWsNum().length];
		double[] varMax=new double[TravelPlanWsSelect.getWsNum().length];
		double[] geneLength=new double[TravelPlanWsSelect.getWsNum().length];
		for(int i=0;i<TravelPlanWsSelect.getWsNum().length;i++){
			varMin[i]=0;
			varMax[i]=TravelPlanWsSelect.getWsNum()[i]-1;
			geneLength[i]=7;
		}
		double[][] ValRg = new double[3][TravelPlanWsSelect.getWsNum().length];
		ValRg[0]=varMin;
		ValRg[1]=varMax;
		ValRg[2]=geneLength;
		cp.setValRg(ValRg);
		cp.setChromLength(21);
		cp.setPopNum(20);
		cp.setGeneration(50);
		
		TravelPlanWsSelect.baseDataInit();
		
		double[] selectResult = new double[cp.generation];
		Group group=new Group();
		Group groupA=new Group();
		Group groupB=new Group();
		int[][] chromListA=null;
		int[][] chromListB=null;
		double[][] fuzzyRule=FuzzyControl.fuzzyRuleFExcel();
		int[][] chromList = GATools.byteEncoding(cp);
		group.setGeneList(chromList);
		group.setFunctionVList(GATools.calcFitness(chromList,cp));
		for (int g = 0; g < cp.getGeneration();g++) {
			ArrayList divideChromList=FuzzyControl.dividGroup(group,cp,g,fuzzyRule);
			chromListA=(int[][]) divideChromList.get(0);
			chromListB=(int[][]) divideChromList.get(1);
			groupB.setGeneList(chromListB);
			chromListA=FuzzyControl.groupAEvolution(chromListA,cp);
			chromListB=FuzzyControl.groupBEvolution(groupB,cp);
			groupA=GATools.roundBetSelect(chromListA,cp);
			groupB=GATools.roundBetSelect(chromListB,cp);
			group=FuzzyControl.groupMerge(groupA,groupB);
			selectResult[g]=group.getElite().getFitnessV();
		}	
		double end = System.currentTimeMillis(); // 程序结束时间，调用系统当前时间
		double time = end - begin;// 程序的运行时间
		swr.setTime(time/60);
		wsSerial=GATools.parseChromFInt(group.getElite().getGene(), cp);
		swr.setWsSerial(wsSerial);
		swr.setWsInfoResult(TravelPlanWsSelect.getSerialWs(wsSerial));
		TravelPlanWsSelect.getgOptimalQosAl().remove(1);
		TravelPlanWsSelect.getgOptimalQosAl().add(1, selectResult);
		TravelPlanWsSelect.getgOptimalQos().put("fuzzyEliteGA",selectResult);
		TravelPlanWsSelect.getAlgorithmComp().setInitFEGA(selectResult);
		swr.setgOptQos(selectResult);
		return swr;
	}
	
	public static void main(String[] args) {
		
	}

}
