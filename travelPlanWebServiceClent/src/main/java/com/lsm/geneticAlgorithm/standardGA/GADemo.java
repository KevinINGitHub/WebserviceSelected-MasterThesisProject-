package com.lsm.geneticAlgorithm.standardGA;

import java.math.*;

import java.util.*;
import java.util.Map.Entry;

import com.lsm.geneticAlgorithm.gaPro.entity.CrossMess;
import com.lsm.geneticAlgorithm.gaPro.entity.MutMess;
import com.lsm.geneticAlorithm.baseTool.GATools;
import com.lsm.geneticAlorithm.baseTool.TravelPlanWsSelect;
import com.lsm.geneticAlorithm.entity.Chrom;
import com.lsm.geneticAlorithm.entity.CodeParam;
import com.lsm.geneticAlorithm.entity.Group;
import com.lsm.geneticAlorithm.entity.SelectedWsResult;
import com.lsm.travelPlan.database.GeneticProcessSql;

public class GADemo {

	/**
	 * @param args
	 */
	// The range of those variable,
	// the (n-1)*2~(n-1)*2+1 represent the nth variable range

	// the chromLength is represent the length of one variable;

	public static double[] parseChrom(int[] chrom, CodeParam cp) {
		double[] variable = new double[cp.getVarNum()];
		int tempt = 0;
		for (int i = 0; i < cp.getVarNum(); i++) {
			int[] varList = Arrays.copyOfRange(chrom, tempt,
					(int) (tempt + cp.getValRg()[2][i]));
			tempt = (int) (tempt + cp.getValRg()[2][i]);
			int lastNum = decoding(varList);
			int totalNum = (int) Math.pow(2, cp.getValRg()[2][i] + 1);
			variable[i] = cp.getValRg()[0][i]
					+ (cp.getValRg()[1][i] - cp.getValRg()[0][i]) * lastNum
					/ totalNum;
		}
		return variable;
	}

	public static double[][] parseChromList(int[][] chromList, CodeParam cp) {
		double[][] parseChromL = new double[chromList.length][cp.getVarNum()];
		for (int k = 0; k < chromList.length; k++) {
			parseChromL[k] = parseChrom(chromList[k], cp);
		}
		return parseChromL;
	}

	// encode the problem space to the chrom space
	public static int[][] byteEncoding(CodeParam cp) {
		int[][] Population = new int[cp.getPopNum()][cp.getChromLength()
				* cp.getVarNum()];
		// generate the initial population
		for (int i = 0; i < cp.getPopNum(); i++) {
			for (int j = 0; j < cp.getChromLength(); j++) {
				Population[i][j] = (int) Math.round(Math.random());
			}
		}
		return Population;
	}

	// decode the population to the independent value
	public static double[] poputionDecoding(int[][] population, CodeParam cp) {
		double[] funVList = new double[cp.getPopNum()];
		for (int i = 0; i < cp.getPopNum(); i++) {
			funVList[i] = decoding(population[i]);
		}
		return funVList;
	}

	// decode chrom to independent value
	public static int decoding(int[] chrom) {
		int variable = 0;
		for (int i = 0; i < chrom.length; i++) {
			variable += chrom[i] * Math.pow(2, chrom.length - i);
		}
		return variable;
	}

	// print the population
	public static void printChrom(double[][] funcVList, String printMessage) {
		System.out.println(printMessage + ":");
		for (int i = 0; i < funcVList.length; i++) {
			for (int j = 0; j < funcVList[0].length; j++) {
				System.out.print(funcVList[i][j]);
			}
			System.out.print("\n");
		}

	}

	public static Group calcFitnessV(int[][] chromList, CodeParam cp) {
		Group group = new Group();
		group.setGeneList(chromList);
		double[] functionVList = null;
		double[][] varVList = parseChromList(chromList, cp);
		for (int i = 0; i < varVList.length; i++) {
			functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
		}
		group.setFunctionVList(functionVList);
		return group;
	}

	public static double[] calcFitness(int[][] chromList, CodeParam cp) {
		double[] functionVList = null;
		double[][] varVList = parseChromList(chromList, cp);
		Map<int[], Double> functionMap = new HashMap<int[], Double>();
		for (int i = 0; i < varVList.length; i++) {
			functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
			functionMap.put(chromList[i], functionVList[i]);
		}
		return functionVList;
	}

	public static double[] calcRoundBetRate(double[] functionVList) {
		double[] roundBetRate = new double[functionVList.length];
		double[] roundBetFVList = new double[functionVList.length];
		double totalFV = 0;
		for (int i = 0; i < functionVList.length; i++) {
			totalFV += functionVList[i];
			roundBetFVList[i] = totalFV;
		}
		for (int j = 0; j < roundBetFVList.length; j++) {
			roundBetRate[j] = roundBetFVList[j] / totalFV;
		}
		return roundBetRate;
	}

	// select appropriate individual from the after-evolution population to make
	// up new population
	public static Group roundBetSelect(int[][] originPop, CodeParam cp) {
		int[][] chromsNew = new int[cp.getPopNum()][cp.getChromLength()];
		double[] functionListNew = new double[cp.getPopNum()];
		double[] functionVList = calcFitness(originPop, cp);
		double[] roundBetProb = calcRoundBetRate(functionVList);
		for (int k = 0; k < cp.popNum; k++) {
			double selectRate = Math.random();
			for (int l = 0; l < roundBetProb.length; l++) {
				if (roundBetProb[l] > selectRate) {
					chromsNew[k] = originPop[l];
					functionListNew[k] = functionVList[l];
				}
			}
		}
		Group group = new Group();
		group.setGeneList(chromsNew);
		group.setFunctionVList(functionListNew);
		return group;
	}

	// crossover the individuals in the population
	public static int[][] crossoverChrom(int[][] originPop, double crossRate,
			CodeParam cp) {
		int[][] chroms = new int[cp.getPopNum() * 2][cp.getChromLength()];
		// copy the value of orginPop to new chroms
		for (int k = 0; k < originPop.length; k++) {
			chroms[k] = originPop[k].clone();
		}
		
		int crossLength = (int) (crossRate * cp.getChromLength());
		// generate the random sequence of chromosome individual
		int[] initSeq = generateInitSeq(cp.getPopNum());
		int[] randomSeq = randomSequence(initSeq);
		// according the individuals which selected to crossover

		for (int k = 0; k < randomSeq.length / 2; k++) {
			int k1=randomSeq[2 * k];
			int k2=randomSeq[2 * k + 1];
			int[] chrom1 = originPop[k1];
			int[] chrom2 = originPop[k2];
			int startP = (int) Math.floor(Math.random()
					* (cp.getChromLength() - crossLength));
			// exchange the chroms selected from the start point
			for (int p = 0; p < crossLength; p++) {
				int geneTempt = chrom1[startP + p];
				chrom1[startP + p] = chrom2[startP + p];
				chrom2[startP + p] = geneTempt;
			}
			chroms[cp.getPopNum() + 2 * k] = chrom1.clone();
			chroms[cp.getPopNum() + 2 * k + 1] = chrom2.clone();
			
			
		}
		return chroms;
	}
	
	public static Group crossoverChrom(Group group, double crossRate,
			CodeParam cp) {
		Chrom[] orginChromList=group.getOrginChromArray();
		Chrom[] crossChromList=new Chrom[orginChromList.length];
		
		// copy the value of orginPop to new chroms
		int crossLength = (int) (crossRate * cp.getChromLength());
		
		// generate the random sequence of chromosome individual
		int[] initSeq = generateInitSeq(cp.getPopNum());
		int[] randomSeq = randomSequence(initSeq);
		
		// according the individuals which selected to crossover
		Chrom[] chromList=group.getOrginChromArray();
		for (int k = 0; k < randomSeq.length / 2; k++) {
			Chrom chromCross1=new Chrom();
			Chrom chromCross2=new Chrom();
			
			CrossMess crossMess=new CrossMess();
			int k1=randomSeq[2 * k];
			int k2=randomSeq[2 * k + 1];
			int[] chrom1 = chromList[k1].getGene();
			int[] chrom2 = chromList[k2].getGene();
			int startP = (int) Math.floor(Math.random()
					* (cp.getChromLength() - crossLength));
			
			// exchange the chroms selected from the start point
			for (int p = 0; p < crossLength; p++) {
				int geneTempt = chrom1[startP + p];
				chrom1[startP + p] = chrom2[startP + p];
				chrom2[startP + p] = geneTempt;
			}
			
			crossMess.setCrossLength(crossLength);
			crossMess.setStartP(startP);
			
			chromCross1.setGene(chrom1.clone());
			chromCross1.setIndex(k1);
			chromCross1.setGeneId(100+k1);
			chromCross1.setCrossMess(crossMess);
			
			chromCross2.setGene(chrom2.clone());
			chromCross2.setIndex(k2);
			chromCross2.setGeneId(100+k2);
			chromCross2.setCrossMess(crossMess);
			
			crossChromList[2*k]=chromCross1;
			crossChromList[2*k+1]=chromCross2;
		}
		group.setCrossChromArray(crossChromList);
		return group;
	}
	
	// generate the initial sequence
	public static int[] generateInitSeq(int Num) {
		int[] initSeq = new int[Num];
		for (int i = 0; i < Num; i++) {
			initSeq[i] = i;
		}
		return initSeq;
	}

	// generate the random sequence according the directed array
	public static int[] randomSequence(int[] orginSeq) {
		int[] randomSeq = new int[orginSeq.length];
		for (int i = orginSeq.length - 1; i > -1; i--) {
			int selectN = (int) Math.floor(Math.random() * i);
			randomSeq[i] = orginSeq[selectN];
			orginSeq[selectN] = orginSeq[i];
		}
		return randomSeq;
	}

	public static int[] partRandSeq(int originNum, int randNum) {
		int[] originNums = generateInitSeq(originNum);
		int[] randNums = new int[randNum];
		for (int i = originNum - 1, k = 0; i > originNum - 1 - randNum; i--) {
			int selectN = (int) Math.floor(Math.random() * i);
			randNums[k++] = originNums[selectN];
			originNums[selectN] = originNums[i];
		}
		return randNums;
	}

	// Muting the individuals in the population
	public static int[][] mutChrom(int[][] originPop, double mutRate,
			CodeParam cp) {
		int mutNum = (int) Math.floor(cp.getChromLength() * mutRate);
		int tempt = 0;
		for (int i = 0; i < cp.getPopNum(); i++) {
			int[] mutSeq = partRandSeq(cp.getChromLength(), mutNum);
			for (int j = 0; j < mutSeq.length; j++) {
				tempt = mutSeq[j];
				originPop[i][tempt] = 1 - originPop[i][tempt];
			}
		}
		return originPop;
	}
	
	public static Group mutChrom(Group group, double mutRate,
			CodeParam cp) {
		Chrom[] orginChromList=group.getOrginChromArray();
		Chrom[] crossChromList=group.getCrossChromArray();
		List<Chrom> mutChromList=new ArrayList();
		int tempt = 0;
		for (int i = 0; i < orginChromList.length; i++) {
			Chrom mutChrom=new Chrom();
			MutMess mutMess=new MutMess();
			int[] gene=orginChromList[i].getGene();
			int index=orginChromList[i].getGeneId()%100;
			int mutNum = (int) Math.floor(cp.getChromLength() * mutRate);
			int[] mutSeq = partRandSeq(cp.getChromLength(), mutNum);
			for (int j = 0; j < mutSeq.length; j++) {
				tempt = mutSeq[j];
				gene[tempt] = 1 - gene[tempt];
			}
			
			mutMess.setMutNum(mutNum);
			mutMess.setMutSeq(mutSeq);
			mutChrom.setGene(gene);
			mutChrom.setMutMess(mutMess);
			mutChrom.setIndex(index);
			mutChrom.setGeneId(200+index);
			
			mutChromList.add(mutChrom);
		}
		
		for (int i = 0; i < crossChromList.length; i++) {
			Chrom mutChrom=new Chrom();
			MutMess mutMess=new MutMess();
			int[] gene=crossChromList[i].getGene();
			int index=crossChromList[i].getGeneId()%100;
			int mutNum = (int) Math.floor(cp.getChromLength() * mutRate);
			int[] mutSeq = partRandSeq(cp.getChromLength(), mutNum);
			for (int j = 0; j < mutSeq.length; j++) {
				tempt = mutSeq[j];
				gene[tempt] = 1 - gene[tempt];
			}
			
			mutMess.setMutNum(mutNum);
			mutMess.setMutSeq(mutSeq);
			mutChrom.setGene(gene);
			mutChrom.setMutMess(mutMess);
			mutChrom.setIndex(index);
			mutChrom.setGeneId(200+index);
			mutChromList.add(mutChrom);
		}
		group.setMutChromList(mutChromList);
		return group;
	}

	public double sinFun(double x) {
		double y = 0;
		y = Math.sin(x);
		return y;
	}

	
	
	public static SelectedWsResult gaSelectProcess() {
		SelectedWsResult swr=new SelectedWsResult();
		double begin = System.currentTimeMillis();
		CodeParam cp = new CodeParam();
		cp.setVarNum(3);
		//set the variable range and the length which represent in the chrom
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
		cp.setGeneration(15);
		GATools.setCp(cp);
		
		
		
		double[] selectResult = new double[cp.generation];
		Group group=new Group();
		Group groupNew=new Group();
		group=GATools.initGroup(cp);
		
		TravelPlanWsSelect.baseDataInit();
		
		for (int g = 0; g < cp.getGeneration();) {
			crossoverChrom(group, 0.5, cp);
			mutChrom(group,0.2, cp);
			//int[][] newGroup=reInsertChrom(group);
			Chrom[] selectChromList=GATools.roundBetSelect(group,cp);
			groupNew.setGeneration(g+1);
			groupNew.setOrginChromArray(selectChromList);
			
			GeneticProcessSql.saveGroup(group);
			
			group=groupNew;
			
			//reinsert the individual to the group
			g++;
		}
		double end = System.currentTimeMillis(); // 程序结束时间，调用系统当前时间
		double time = end - begin;// 程序的运行时间
		
		swr.setTime(time/60);
		swr.setgOptQos(selectResult);
		//double[] wsSerial=GATools.parseChromFInt(group.getElite().getGene(), cp);
		double[] wsSerial={1,2,3};
		swr.setWsSerial(wsSerial);
		swr.setWsInfoResult(TravelPlanWsSelect.getSerialWs(wsSerial));
		return swr;
	}
	public static int[][] reInsertChrom(Group group) {
		
		
		
		
		
		
		return null;
	}
	
	

	public static SelectedWsResult gaSelection() {
		double begin = System.currentTimeMillis();
		CodeParam cp = new CodeParam();
		cp.setVarNum(3);
		//set the variable range and the length which represent in the chrom
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

		//TravelPlanWsSelect.baseDataInit();
		double[] selectResult = new double[cp.generation];
		Group group=new Group();
		//group.setGeneration(1);
		int[][] chromList = byteEncoding(cp);
		
		Chrom elite=new Chrom();
		for (int g = 0; g < cp.getGeneration();) {
			int[][] crossChroms = crossoverChrom(chromList, 0.5, cp);
			int[][] mutChroms = mutChrom(crossChroms, 0.2, cp);
			
			double[][] varVList =GATools.parseChromListFInt(mutChroms, cp);
			double[] functionVList = new double[varVList.length];
			
			//GeneticProcessSql.saveGroup(group);
			
			Map<int[], Double> functionMap = new HashMap<int[], Double>();
			for (int i = 0; i < varVList.length; i++) {
				functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
				functionMap.put(mutChroms[i], functionVList[i]);
			}

			// Thought the genetic algorithm to obtain the maxV in the give
			// interval
			// 将map.entrySet()转换成list
			List<Map.Entry<int[], Double>> list = new ArrayList<Map.Entry<int[], Double>>(
					functionMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<int[], Double>>() {
				// 降序排序
				@Override
				public int compare(Entry<int[], Double> o1,
						Entry<int[], Double> o2) {
					// return o1.getValue().compareTo(o2.getValue());
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			
			selectResult[g] = list.get(0).getValue(); // save the max functionV
														// of every generation
			
			elite.setFitnessV(list.get(0).getValue());
			elite.setGene(list.get(0).getKey());
			group.setElite(elite);
			int p = 0;
			System.out.println("The function value is below:");
			//reinsert the individual to the group
			for (Map.Entry<int[], Double> mapping : list) {
				System.out.println(mapping.getValue());
				if (p < chromList.length) {
					chromList[p] = mapping.getKey();
					p++;
				}
			}
			//group.setGeneList(chromList);
			g++;
		}
		double end = System.currentTimeMillis(); // 程序结束时间，调用系统当前时间
		double time = end - begin;// 程序的运行时间
		SelectedWsResult swr=new SelectedWsResult();
		swr.setTime(time/60);
		TravelPlanWsSelect.getgOptimalQosAl().remove(0);
		TravelPlanWsSelect.getgOptimalQosAl().add(0, selectResult);
		TravelPlanWsSelect.getgOptimalQos().put("standardGA",selectResult);
		TravelPlanWsSelect.getAlgorithmComp().setInitSGA(selectResult);
		swr.setgOptQos(selectResult);
		double[] wsSerial=GATools.parseChromFInt(elite.getGene(), cp);
		swr.setWsSerial(wsSerial);
		swr.setWsInfoResult(TravelPlanWsSelect.getSerialWs(wsSerial));
		return swr;
	}
	public static void main(String[] args) {
		/*
		 * CodeParam cp=new CodeParam(); cp.setVarNum(3); double [][] ValRg={{0
		 * ,0 ,0},{10 ,10 ,10},{7,7,7}}; cp.setValRg(ValRg);
		 * cp.setChromLength(21); cp.setPopNum(20); cp.setGeneration(50);
		 * 
		 * TravelPlanWsSelect.baseDataInit();
		 */

		SelectedWsResult result = gaSelectProcess();
		for (int i = 0; i < result.getWsSerial().length; i++) {
			System.out.println(result.getWsSerial()[i]);
		}
		System.out.println("end!!!!");
	}

}
