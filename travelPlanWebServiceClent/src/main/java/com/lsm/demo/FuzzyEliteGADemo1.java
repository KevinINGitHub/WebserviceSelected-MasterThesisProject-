package com.lsm.demo;

import java.math.*;


import java.util.*;
import java.util.Map.Entry;

import com.lsm.geneticAlorithm.baseTool.TravelPlanWsSelect;
import com.lsm.geneticAlorithm.entity.CodeParam;
import com.lsm.geneticAlorithm.entity.SelectParam;

public class FuzzyEliteGADemo1 {

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

	// select appropriate individual from the after-evolution population to make
	// up new population
	public static int[][] selectChrom(int[][] originPop, CodeParam cp) {
		int[][] chroms = new int[cp.getPopNum()][cp.getChromLength()];

		return chroms;
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

			int[] chrom1 = originPop[randomSeq[2 * k]];
			int[] chrom2 = originPop[randomSeq[2 * k + 1]];
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
		int[] mutSeq = partRandSeq(cp.getChromLength(), mutNum);
		int tempt = 0;
		for (int i = 0; i < cp.getPopNum(); i++) {
			for (int j = 0; j < mutSeq.length; j++) {
				tempt = mutSeq[j];
				originPop[i][tempt] = 1 - originPop[i][tempt];
			}
		}
		return originPop;
	}

	public double sinFun(double x) {
		double y = 0;
		y = Math.sin(x);
		return y;
	}

	public static double[] geneticForQosSelection(CodeParam cp) {
		double[] selectResult = new double[cp.generation];
		int[][] chromList = byteEncoding(cp);
		for (int g = 0; g < cp.getGeneration();) {
			int[][] crossChroms = crossoverChrom(chromList, 0.5, cp);
			// printChrom(crossChroms,"crossChroms");
			int[][] mutChroms = mutChrom(crossChroms, 0.2, cp);

			double[][] varVList = parseChromList(mutChroms, cp);
			printChrom(varVList, "parseChromList");

			double[] functionVList = new double[varVList.length];
			Map<int[], Double> functionMap = new HashMap<int[], Double>();
			for (int i = 0; i < varVList.length; i++) {

				functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
				functionMap.put(mutChroms[i], functionVList[i]);
			}

			// Thought the genetic algorithm to obtain the maxV in the give
			// interval
			// Ω´map.entrySet()◊™ªª≥…list
			List<Map.Entry<int[], Double>> list = new ArrayList<Map.Entry<int[], Double>>(
					functionMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<int[], Double>>() {
				// Ωµ–Ú≈≈–Ú
				@Override
				public int compare(Entry<int[], Double> o1,
						Entry<int[], Double> o2) {
					// return o1.getValue().compareTo(o2.getValue());
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			selectResult[g] = list.get(0).getValue(); // save the max functionV
														// of every generation

			int p = 0;
			System.out.println("The function value is below:");
			for (Map.Entry<int[], Double> mapping : list) {
				System.out.println(mapping.getValue());
				if (p < chromList.length) {
					chromList[p] = mapping.getKey();
					p++;
				}
			}
			g++;
		}
		return selectResult;
	}

	public static double[] geneticForQosSelection(CodeParam cp,SelectParam sp) {
		double[] selectResult = new double[cp.generation];
		int[][] chromList = byteEncoding(cp);
		for (int g = 0; g < cp.getGeneration();) {
			int[][] crossChroms = crossoverChrom(chromList, 0.5, cp);
			// printChrom(crossChroms,"crossChroms");
			int[][] mutChroms = mutChrom(crossChroms, 0.2, cp);

			double[][] varVList = parseChromList(mutChroms, cp);
			printChrom(varVList, "parseChromList");

			double[] functionVList = new double[varVList.length];
			Map<int[], Double> functionMap = new HashMap<int[], Double>();
			for (int i = 0; i < varVList.length; i++) {

				functionVList[i] = TravelPlanWsSelect.calculateQos(varVList[i]);
				functionMap.put(mutChroms[i], functionVList[i]);
			}

			// Thought the genetic algorithm to obtain the maxV in the give
			// interval
			// Ω´map.entrySet()◊™ªª≥…list
			List<Map.Entry<int[], Double>> list = new ArrayList<Map.Entry<int[], Double>>(
					functionMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<int[], Double>>() {
				// Ωµ–Ú≈≈–Ú
				@Override
				public int compare(Entry<int[], Double> o1,
						Entry<int[], Double> o2) {
					// return o1.getValue().compareTo(o2.getValue());
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			selectResult[g] = list.get(0).getValue(); // save the max functionV
														// of every generation

			int p = 0;
			System.out.println("The function value is below:");
			for (Map.Entry<int[], Double> mapping : list) {
				System.out.println(mapping.getValue());
				if (p < chromList.length) {
					chromList[p] = mapping.getKey();
					p++;
				}
			}
			g++;
		}
		return selectResult;
	}
	public static void main(String[] args) {
		// TravelPlanWsSelect.travelPlanWsSelect();
		CodeParam cp = new CodeParam();
		cp.setVarNum(3);
		double[][] ValRg = { { 0, 0, 0 }, { 10, 10, 10 }, { 7, 7, 7 } };
		cp.setValRg(ValRg);
		cp.setChromLength(21);
		cp.setPopNum(20);
		cp.setGeneration(50);
		double[] result = geneticForQosSelection(cp);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("end!!!!");
	}

}
