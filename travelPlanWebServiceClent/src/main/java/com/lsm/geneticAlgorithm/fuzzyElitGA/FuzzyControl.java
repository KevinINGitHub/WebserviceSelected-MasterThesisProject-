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
import com.lsm.geneticAlorithm.entity.*;
import com.lsm.util.PropertiesUtil;

public class FuzzyControl {
	
	public static ArrayList dividGroup(Group group,CodeParam cp,int generation,double[][] fuzzyRule){
		ArrayList chromListT=new ArrayList();
		double groupDivideRate=generateGroupDividRate(group,generation,fuzzyRule);
		int chromListANum=(int) Math.round(group.getLength()*groupDivideRate);
		int[][] chromListA=new int[chromListANum][cp.chromLength];
		int[][] chromListB=new int[group.getLength()-chromListANum][cp.chromLength];
		for(int i=0;i<group.getLength();i++){
			if(i<chromListANum){
				chromListA[i]=group.getGeneList()[i];
			}else{
				chromListB[i-chromListANum]=group.getGeneList()[i];
			}
			
		}
		chromListT.add(chromListA);
		chromListT.add(chromListB);
		return chromListT;
	}
	
	public static int[][] groupAEvolution(int[][] chromListA,CodeParam cp){
		int[][] crossChromsA = GATools.crossoverChrom(chromListA, 0.5, cp);
		int[][] mutChromsA = GATools.mutChrom(crossChromsA, 0.2, cp);
		return mutChromsA;
	}
	
	public static int[][] groupBEvolution(Group groupB,CodeParam cp){
		int[] elite=groupB.getElite(cp).getGene();
		int[][] crossChromsB = GATools.crossoverWithElite(groupB.getGeneList(),elite, 0.5, cp);
		int[][] mutChromsB = GATools.mutChrom(crossChromsB, 0.2, cp);
		return mutChromsB;
	}
	
	
	public static int[][] groupMerge(int[][] chromListA,int[][] chromListB){
		int[][] chromList=new int[chromListA.length+chromListB.length][chromListA[0].length];
		for(int p=0;p<chromListA.length;p++){
			chromList[p]=chromListA[p];
		}
		for(int p=0;p<chromListB.length;p++){
			chromList[chromListA.length+p]=chromListB[p];
		}
		return chromList;
	}
	
	public static Group groupMerge(Group groupA,Group groupB){
		Group group=new Group();
		int[][] chromList=new int[groupA.getLength()+groupB.getLength()][groupA.getGeneList()[0].length];
		double[] functionVList=new double[groupA.getLength()+groupB.getLength()];
		
		int[][] chromListA=groupA.getGeneList();
		double[] functionVListA=groupA.getFunctionVList();
		for(int p=0;p<groupA.getLength();p++){
			chromList[p]=chromListA[p];
			functionVList[p]=functionVListA[p];
		}
		int[][] chromListB=groupB.getGeneList();
		double[] functionVListB=groupB.getFunctionVList();
		for(int p=0;p<groupB.getLength();p++){
			chromList[chromListA.length+p]=chromListB[p];
			functionVList[functionVListA.length+p]=functionVListB[p];
		}
		group.setGeneList(chromList);
		group.setFunctionVList(functionVList);
		return group;
	}
	
	public static List<Map.Entry<int[], Double>> sortChromMap(Map<int[], Double> functionMap){
		List<Map.Entry<int[], Double>> list = new ArrayList<Map.Entry<int[], Double>>(
				functionMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<int[], Double>>() {
			// 降序排序
			@Override
			public int compare(Entry<int[], Double> o1,
					Entry<int[], Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
	}
	public static void performParam(List<Map.Entry<int[], Double>> list,EvolutionParam evolutionParam,EvolutionPerform evolutionPerform ){
		double optimalV=list.get(0).getValue();
		evolutionPerform.getOptimalVList().add(list.get(0).getValue()); // save the max functionV
		evolutionParam.getElite().put(list.get(0).getKey(), list.get(0).getValue());
		int p = 0;
		System.out.println("The function value is below:");
		double totelV=0;
		double averV=0;
		averV=totelV/list.size();
		double gap=optimalV-averV;
	}
	public static double generateGroupDividRate(int[][] chromList){
		double groupDivideRate=0;
		
		return groupDivideRate;
	}
	
	public static double generateGroupDividRate(Group group,int generation,double[][] fuzzyRule){
		double groupDivideRate=0;
		Chrom elite=group.getElite();
		double averV=group.getAverV();
		double gap=elite.getFitnessV()-averV/elite.getFitnessV();
		int column=gaussianInterval(gap);
		int row=triangleInterval(generation);
		groupDivideRate=fuzzyRule[row][column];
		return groupDivideRate;
	}
	public static int gaussianInterval(double x){
		int selectInterV=0;
		int intervalNum=5;
		double interval=0.4;
		double maxIntervalV=0;
		for(int i=0;i<intervalNum;i++){
			if(maxIntervalV<gaussian(interval,0.2*i,x)){
				maxIntervalV=gaussian(interval,0.2*i,x);
				selectInterV=i+1;
			}
		}
		return selectInterV;
	}
	public static int triangleInterval(double x){
		int selectInterV=0;
		int intervalNum=3;
		double interval=0.5;
		double maxIntervalV=0;
		for(int i=0;i<intervalNum;i++){
			if(maxIntervalV<triangle(0.5*i-0.5,0.5*i,0.5*i+0.5,x)){
				maxIntervalV=triangle(0.5*i-0.5,0.5*i,0.5*i+0.5,x);
				selectInterV=i+1;
			}
		}
		return selectInterV;
	}
	
	public static double gaussian(double p,double c,double x){
		double y=Math.exp(Math.pow(x-c, 2)/p);
		return y;
	}
	
	public static double triangle(double a,double b,double c,double x){
		double y=0;
		if(x>a&&x<b){
			y=(x-a)/(b-a);
		}else if(x>b&&x<c){
			y=(c-x)/(c-b);
		}
		return y;
	}
	public static double[][] fuzzyRuleFExcel(){
		double[][] fuzzyRule=null;
		String excelFileName = getRootPath()+File.separator+"fuzzyEliteGA/fuzzyRule.xls";
		String excelFileName1 = "fuzzyEliteGA/fuzzyRule.xls";
		Workbook rwb = null;
		Cell cell = null;
		// 创建输入流
		InputStream stream;
		try {
			stream = new FileInputStream(new File(excelFileName));
			rwb = Workbook.getWorkbook(stream);
			// 获取文件的指定工作表 默认的第一个
			Sheet sheet = rwb.getSheet(0);
			fuzzyRule=new double[sheet.getRows()][sheet.getColumns()];
			for(int i=4;i<sheet.getRows();i++){
				for(int j=3;j<sheet.getColumns();j++){
					cell=sheet.getCell(j, i);
					fuzzyRule[i-4][j-3]=Double.parseDouble(cell.getContents());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fuzzyRule;
	}
	 public static synchronized String getRootPath() {
	        String root = PropertiesUtil.class.getResource("/").toString();
	        if (root.startsWith("file:/")) {
	            root = root.substring(6);
	        }
	        if (root.endsWith("/")) {
	            root = root.substring(0, root.length() - 1);
	        }
	        if (!root.startsWith("/")) {
	            root = "/" + root;
	        }
	        if(root.contains("test-classes")){
	            root=root.replace("test-classes","classes");
	        }
	        return root;
	    }
	
	public static void main(String[] args) {
		CodeParam cp = new CodeParam();
		cp.setVarNum(3);
		double[][] ValRg = { { 0, 0, 0 }, { 10, 10, 10 }, { 7, 7, 7 } };
		cp.setValRg(ValRg);
		cp.setChromLength(21);
		cp.setPopNum(20);
		cp.setGeneration(50);
		
		double[] selectResult = new double[cp.generation];
		int[][] chromList = GATools.byteEncoding(cp);
		for (int g = 0; g < cp.getGeneration();) {
			
		}
		
	}

}
