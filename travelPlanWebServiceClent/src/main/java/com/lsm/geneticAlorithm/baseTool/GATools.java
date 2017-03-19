package com.lsm.geneticAlorithm.baseTool;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsm.geneticAlorithm.entity.Chrom;
import com.lsm.geneticAlorithm.entity.CodeParam;
import com.lsm.geneticAlorithm.entity.Group;

public class GATools {
	static CodeParam cp=new CodeParam();
	public static CodeParam getCp() {
		return cp;
	}

	public static void setCp(CodeParam cp) {
		GATools.cp = cp;
	}

	public static double[] parseChrom(int [] chrom,CodeParam cp){
		double[] variable=new double[cp.getVarNum()];
		int tempt=0;
		for(int i=0;i<cp.getVarNum();i++){
			int[] varList=Arrays.copyOfRange(chrom,tempt, (int)(tempt+cp.getValRg()[2][i]));
			tempt=(int) (tempt+cp.getValRg()[2][i]);
			int lastNum=decoding(varList);
			int totalNum=(int) Math.pow(2, cp.getValRg()[2][i]+1);
			variable[i]=cp.getValRg()[0][i]+(cp.getValRg()[1][i]-cp.getValRg()[0][i])*lastNum/totalNum;
		}
		return variable;
	}
	
	public static double[] parseChromFInt(int [] chrom,CodeParam cp){
		double[] variable=new double[cp.getVarNum()];
		int tempt=0;
		for(int i=0;i<cp.getVarNum();i++){
			int[] varList=Arrays.copyOfRange(chrom,tempt, (int)(tempt+cp.getValRg()[2][i]));
			tempt=(int) (tempt+cp.getValRg()[2][i]);
			int lastNum=decoding(varList);
			int totalNum=(int) Math.pow(2, cp.getValRg()[2][i]+1);
			variable[i]=Math.round(cp.getValRg()[0][i]+(cp.getValRg()[1][i]-cp.getValRg()[0][i])*lastNum/totalNum);
		}
		return variable;
	}
	
	public static double[] parseChromFInt(int [] chrom){
		double[] variable=new double[cp.getVarNum()];
		int tempt=0;
		for(int i=0;i<cp.getVarNum();i++){
			int[] varList=Arrays.copyOfRange(chrom,tempt, (int)(tempt+cp.getValRg()[2][i]));
			tempt=(int) (tempt+cp.getValRg()[2][i]);
			int lastNum=decoding(varList);
			int totalNum=(int) Math.pow(2, cp.getValRg()[2][i]+1);
			variable[i]=Math.round(cp.getValRg()[0][i]+(cp.getValRg()[1][i]-cp.getValRg()[0][i])*lastNum/totalNum);
		}
		return variable;
	}
	
	public static double[][] parseChromList(int [][] chromList,CodeParam cp){
		double[][] parseChromL=new double[chromList.length][cp.getVarNum()];
		for(int k=0;k<chromList.length;k++){
			parseChromL[k]=parseChrom(chromList[k],cp);
		}
		return parseChromL;
	}
	
	public static double[][] parseChromListFInt(int [][] chromList,CodeParam cp){
		double[][] parseChromL=new double[chromList.length][cp.getVarNum()];
		for(int k=0;k<chromList.length;k++){
			parseChromL[k]=parseChromFInt(chromList[k],cp);
		}
		return parseChromL;
	}
	
	//encode the problem space to the chrom space
	public static int[][] byteEncoding(CodeParam cp){
		int[][] Population=new int[cp.getPopNum()][cp.getChromLength()*cp.getVarNum()];
		//generate the initial population
		for(int i=0;i<cp.getPopNum();i++){
			for(int j=0;j<cp.getChromLength();j++){
				Population[i][j]=(int)Math.round( Math.random());
			}
		}
		return Population;
	}
	
	//decode the population to the independent value 
	public static double[] poputionDecoding(int[][] population,CodeParam cp){
		double[] funVList=new double[cp.getPopNum()];
		for(int i=0;i<cp.getPopNum();i++){
			funVList[i]=decoding(population[i]);
		}
		return funVList;
	}
	
	//decode chrom to independent value 
	 public static int decoding(int[] chrom){
		int variable=0;
		for(int i=0;i<chrom.length;i++){
			variable+=chrom[i]*Math.pow(2,chrom.length-i);
		}
		return variable;
	}
	 //print the population
	public static void printChrom(double[][] funcVList,String printMessage){
		System.out.println(printMessage+":");
		for(int i=0;i<funcVList.length;i++){
			for(int j=0;j<funcVList[0].length;j++){
				System.out.print(funcVList[i][j]);
			}
			System.out.print("\n");
		}
		
	}
	 
	//crossover the individuals in the population 
	public static int[][] crossoverChrom(int[][] originPop,double crossRate,CodeParam cp){
		int[][] chroms=new int[originPop.length*2][cp.getChromLength()];
		//copy the value of orginPop to new chroms
		for(int k=0;k<originPop.length;k++){
			chroms[k]=originPop[k].clone();
		}
		int crossLength=(int) (crossRate*cp.getChromLength());
		//generate the random sequence of chromosome individual
		int[] initSeq=generateInitSeq(originPop.length);
		int[] randomSeq=randomSequence(initSeq);
		//according the individuals which selected to crossover
		
		for(int k=0;k<randomSeq.length/2;k++){
			
			int[] chrom1=originPop[randomSeq[2*k]];
			int[] chrom2=originPop[randomSeq[2*k+1]];
			int startP=(int) Math.floor(Math.random()*(cp.getChromLength()-crossLength));
			//exchange the chroms selected from the start point
			for(int p=0;p<crossLength;p++){
				int geneTempt=chrom1[startP+p];
				chrom1[startP+p]=chrom2[startP+p];
				chrom2[startP+p]=geneTempt;
			}
			chroms[originPop.length+2*k]=chrom1.clone();
			chroms[originPop.length+2*k+1]=chrom2.clone();
		}
		return chroms;
	}
	
	public static int[][] crossoverWithElite(int[][] originPop,int[] elite,double crossRate,CodeParam cp){
		int[][] chroms=new int[originPop.length*2][cp.getChromLength()];
		//copy the value of orginPop to new chroms
		for(int k=0;k<originPop.length;k++){
			chroms[k]=originPop[k].clone();
		}
		int crossLength=(int) (crossRate*cp.getChromLength());
		//generate the random sequence of chromosome individual
		int[] initSeq=generateInitSeq(originPop.length);
		int[] randomSeq=randomSequence(initSeq);
		//according the individuals which selected to crossover
		
		for(int k=0;k<originPop.length;k++){
			int[] chrom1=elite;
			int[] chrom2=originPop[k];
			int startP=(int) Math.floor(Math.random()*(cp.getChromLength()-crossLength));
			//exchange the chroms selected from the start point
			for(int p=0;p<crossLength;p++){
				int geneTempt=chrom1[startP+p];
				chrom1[startP+p]=chrom2[startP+p];
				chrom2[startP+p]=geneTempt;
			}
			chroms[originPop.length+k]=chrom2.clone();
		}
		return chroms;
	}
	
	//generate the initial sequence
		public static int[] generateInitSeq(int Num){
			int[] initSeq=new int[Num];
			for(int i=0;i<Num;i++){
				initSeq[i]=i;
			}
			return initSeq;
		}
	//generate the random sequence according the directed array
	public static int[] randomSequence(int[] orginSeq){
		int[] randomSeq=new int[orginSeq.length];
		for(int i=orginSeq.length-1;i>-1;i--){
			int selectN=(int) Math.floor(Math.random()*i);
			randomSeq[i]=orginSeq[selectN];
			orginSeq[selectN]=orginSeq[i];
		}
		return randomSeq;
	}
	
	public static int[] partRandSeq(int originNum,int randNum){
		int[] originNums=generateInitSeq(originNum);
		int[] randNums=new int[randNum];
		for(int i=originNum-1,k=0;i>originNum-1-randNum;i--){
			int selectN=(int) Math.floor(Math.random()*i);
			randNums[k++]=originNums[selectN];
			originNums[selectN]=originNums[i];
		}
		return randNums;
	}
	//Muting the individuals in the population
	public static int[][] mutChrom(int[][] originPop,double mutRate,CodeParam cp){
	    int mutNum=(int) Math.floor(originPop.length*mutRate);
		int [] mutSeq=partRandSeq(cp.getChromLength(),mutNum);
		int tempt=0;
		for(int i=0;i<originPop.length;i++){
			for(int j=0;j<mutSeq.length;j++){
				tempt=mutSeq[j];
				originPop[i][tempt]=1-originPop[i][tempt];
			}
		}
		return originPop;
	}
	public static Group calcFitnessV(int[][] chromList,CodeParam cp){
		Group group=new Group();
		group.setGeneList(chromList);
		double[] functionVList=null;
		double[][] varVList = parseChromList(chromList, cp);
		for (int i = 0; i < varVList.length; i++) {
			functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
		}
		group.setFunctionVList(functionVList);
		return group;
	}
	
	public static double[] calcFitness(int[][] chromList,CodeParam cp){
		double[] functionVList=new double[chromList.length];
		double[][] varVList = parseChromListFInt(chromList, cp);
		for (int i = 0; i < varVList.length; i++) {
			functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
		}
		return functionVList;
	}
	
	public static Group calcFitness(Group group,CodeParam cp){
		List<Chrom> chromList=group.getMutChromList();
		for(Chrom chrom:chromList){
			double[] varVList=parseChromFInt(chrom.getGene(),cp);
			double fitnessV=TravelPlanWsSelect.calculateQos(varVList);
			chrom.setFitnessV(fitnessV);
		}
		return group;
	}
	
	public static double[] calcRoundBetRate(double[] functionVList){
		double[] roundBetRate=new double[functionVList.length];
		double[] roundBetFVList=new double[functionVList.length];
		double totalFV=0;
		for(int i=0;i<functionVList.length;i++){
			totalFV+=functionVList[i];
			roundBetFVList[i]=totalFV;
		}
		for(int j=0;j<roundBetFVList.length;j++){
			roundBetRate[j]=roundBetFVList[j]/totalFV;
		}
		return roundBetRate;
	}
	
	public static double[] calcRoundBetRate(List<Chrom> chromList){
		double[] roundBetRate=new double[chromList.size()+1];
		double[] roundBetFVList=new double[chromList.size()];
		double totalFV=0;
		roundBetRate[0]=0;
		for(int i=0;i<chromList.size();i++){
			totalFV+=chromList.get(i).getFitnessV();
			roundBetFVList[i]=totalFV;
		}
		for(int j=0;j<roundBetFVList.length;j++){
			roundBetRate[j+1]=roundBetFVList[j]/totalFV;
		}
		return roundBetRate;
	}
	
	
	//select  appropriate individual from the after-evolution population to make up new population
	public static Group roundBetSelect(int[][] originPop,CodeParam cp){
		int[][] chromsNew=new int[cp.getPopNum()][cp.getChromLength()];
		double[] functionListNew=new double[cp.getPopNum()];
		double[] functionVList=calcFitness(originPop,cp);
		double[] roundBetProb=calcRoundBetRate(functionVList);
		for(int k=0;k<cp.popNum;k++){
			double selectRate=Math.random();
			for(int l=0;l<roundBetProb.length;l++){
				if(roundBetProb[l]>selectRate){
					chromsNew[k]=originPop[l];
					functionListNew[k]=functionVList[l];
				}
			}
		}
		Group group=new Group();
		group.setGeneList(chromsNew);
		group.setFunctionVList(functionListNew);
		return group;
	}
	
	public static Chrom[] roundBetSelect(Group group,CodeParam cp) {
		Chrom[] selectChromArray=new Chrom[cp.popNum];
		double[] functionListNew=new double[cp.getPopNum()];
		List<Chrom> mutChromList=group.getMutChromList();
		double[] roundBetProb=calcRoundBetRate(mutChromList);
		for(int k=0;k<cp.popNum;k++){
			double selectRate=Math.random();
			for(int l=0;l<roundBetProb.length;l++){
				if(roundBetProb[l]<selectRate&&selectRate<roundBetProb[l+1]){
					Chrom chrom=null;
					try {
						chrom = (Chrom) mutChromList.get(l).clone();
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
					chrom.setIndex(chrom.getGeneId());
					selectChromArray[k]=chrom;
					break;
				}
			}
		}
		group.setSelectChromArray(selectChromArray);
		return selectChromArray;
	}
	
	public static Group initGroup(CodeParam cp){
		Group group=new Group();
		Chrom[] chromArray=new Chrom[ cp.getPopNum()];
		for (int i = 0; i < cp.getPopNum(); i++) {
			Chrom chrom=new Chrom();
			int[] gene=new int[ cp.getChromLength()];
			for (int j = 0; j < cp.getChromLength(); j++) {
				gene[j] = (int) Math.round(Math.random());
			}
			chrom.setGeneId(i);
			chrom.setGene(gene);
			chromArray[i]=chrom;
		}
		group.setOrginChromArray(chromArray);
		group.setGeneration(1);
		return group;
	}
	
	
	
	
	
	
	
}
