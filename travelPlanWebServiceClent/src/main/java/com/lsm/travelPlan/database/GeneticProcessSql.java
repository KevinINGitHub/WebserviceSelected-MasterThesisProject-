package com.lsm.travelPlan.database;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.lsm.geneticAlgorithm.gaPro.entity.*;
import com.lsm.geneticAlorithm.entity.*;

public class GeneticProcessSql {
	
	public static void saveOrginChrom(Chrom chrom,Group group){
		String sql="insert into gagroup(geneid,groupId,gene,fitnessV,chromType,chromIndex,elite)values(?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			 ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			 ps.setInt(1, chrom.getGeneId());
			 ps.setInt(2, group.getGeneration());
			 ps.setString(3, chrom.getGeneString());
			 ps.setDouble(4, chrom.getFitnessV());
			 ps.setString(5, chrom.getType());
			 ps.setInt(6, chrom.getIndex());
			 ps.setInt(7, chrom.getElite());
			 ps.executeUpdate();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void saveCrossChrom(Chrom chrom,Group group){
		String sql="insert into gagroup(geneid,groupId,gene,fitnessV,crossP,chromType,chromIndex,elite)values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			 ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			 ps.setInt(1, chrom.getGeneId());
			 ps.setInt(2, group.getGeneration());
			 ps.setString(3, chrom.getGeneString());
			 ps.setDouble(4, chrom.getFitnessV());
			 ps.setString(5, chrom.getCrossPStr());
			 ps.setString(6, chrom.getType());
			 ps.setInt(7, chrom.getIndex());
			 ps.setInt(8, chrom.getElite());
			 ps.executeUpdate();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveMutChrom(Chrom chrom,Group group){
		String sql="insert into gagroup(geneid,groupId,gene,fitnessV,mutP,chromType,chromIndex,elite)values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			 ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			 ps.setInt(1, chrom.getGeneId());
			 ps.setInt(2, group.getGeneration());
			 ps.setString(3, chrom.getGeneString());
			 ps.setDouble(4, chrom.getFitnessV());
			 ps.setString(5, chrom.getMutPStr());
			 ps.setString(6, chrom.getType());
			 ps.setInt(7, chrom.getIndex());
			 ps.setInt(8, chrom.getElite());
			 ps.executeUpdate();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void saveGeneration(Group group) {
		String sql = "insert into generation (groupId) values (?)";
		PreparedStatement ps = null;
		try {
			ps = TravelPlanDatabase.getConnection().prepareStatement(sql);
			ps.setInt(1, group.getGeneration());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveGroup(Group group){
		//saveGeneration(group);
		for(Chrom chrom:group.getOrginChromArray()){
			GeneticProcessSql.saveOrginChrom(chrom,group);
		}
		for(Chrom chrom:group.getCrossChromArray()){
			GeneticProcessSql.saveCrossChrom(chrom,group);
		}
		for(Chrom chrom:group.getMutChromList()){
			GeneticProcessSql.saveMutChrom(chrom,group);
		}
		/*for(Chrom chrom:group.getSelectChromArray()){
			GeneticProcessSql.saveGAProcess(chrom,group);
		}*/
	}
	 
	public static AuxGroup getAuxGroup(int generation){
		List<Chrom> chromList=null;
		ResultSet rs=null;
		Statement sm=null;
		AuxGroup auxGroup=new AuxGroup();
		List<Chrom> orginChromList=new ArrayList();
		List<Chrom> crossChromList=new ArrayList();
		List<Chrom> mutChromList=new ArrayList();
		List<Chrom> selectChromList=new ArrayList();
		try {
			String sql1="select * from gagroup where chromType='orgin' and groupId="+generation;
			sm=TravelPlanDatabase.getConnection().createStatement();
			rs=sm.executeQuery(sql1);
			while(rs.next()){
				Chrom chrom=new Chrom();
				chrom.setGeneId(rs.getInt(1));
				chrom.setGroupId(rs.getInt(2));
				String geneStr=rs.getString(3);
				String[] s=geneStr.split(":");
				int[] gene=new int[s.length];
				for(int i=0;i<s.length;i++){
					gene[i]=Integer.parseInt(s[i]);
				}
				chrom.setGene(gene);
				chrom.setFitnessV(rs.getDouble(4));
				
				/*CrossMess crossMess=new CrossMess();
				String crossMessStr=rs.getString(5);
				String[] crossMessArray=crossMessStr.split(":");
				crossMess.setCrossLength(Integer.parseInt(crossMessArray[0]));
				crossMess.setStartP(Integer.parseInt(crossMessArray[1]));
				chrom.setCrossMess(crossMess);
				
				MutMess mutMess=new MutMess();
				String mutMessStr=rs.getString(5);
				String[] mutMessArray=crossMessStr.split(":");
				mutMess.setMutNum(Integer.parseInt(mutMessArray[0]));
				int[] mutSq=new int[mutMessArray.length-1];
				for(int i=1;i<mutMessArray.length;i++){
					mutSq[i]=Integer.parseInt(mutMessArray[i]);
				}
				mutMess.setMutSeq(mutSq);
				chrom.setMutMess(mutMess);*/
				
				chrom.setType(rs.getString(8));
				chrom.setIndex(rs.getInt(9));
				orginChromList.add(chrom);
				//chrom.setGene()
			}
			String sql2="select * from gagroup where chromType='cross' and groupId="+generation;
			sm=TravelPlanDatabase.getConnection().createStatement();
			rs=sm.executeQuery(sql2);
			while(rs.next()){
				Chrom chrom=new Chrom();
				chrom.setGeneId(rs.getInt(1));
				chrom.setGroupId(rs.getInt(2));
				String geneStr=rs.getString(3);
				String[] s=geneStr.split(":");
				int[] gene=new int[s.length];
				for(int i=0;i<s.length;i++){
					gene[i]=Integer.parseInt(s[i]);
				}
				chrom.setGene(gene);
				chrom.setFitnessV(rs.getDouble(4));
				
				CrossMess crossMess=new CrossMess();
				String crossMessStr=rs.getString(5);
				String[] crossMessArray=crossMessStr.split(":");
				crossMess.setCrossLength(Integer.parseInt(crossMessArray[0]));
				crossMess.setStartP(Integer.parseInt(crossMessArray[1]));
				chrom.setCrossMess(crossMess);
				
				/*MutMess mutMess=new MutMess();
				String mutMessStr=rs.getString(5);
				String[] mutMessArray=crossMessStr.split(":");
				mutMess.setMutNum(Integer.parseInt(mutMessArray[0]));
				int[] mutSq=new int[mutMessArray.length-1];
				for(int i=1;i<mutMessArray.length;i++){
					mutSq[i]=Integer.parseInt(mutMessArray[i]);
				}
				mutMess.setMutSeq(mutSq);
				chrom.setMutMess(mutMess);*/
				
				chrom.setType(rs.getString(8));
				chrom.setIndex(rs.getInt(9));
				crossChromList.add(chrom);
				//chrom.setGene()
			}
			
			String sql3="select * from gagroup where chromType='mut' and groupId="+generation;
			sm=TravelPlanDatabase.getConnection().createStatement();
			rs=sm.executeQuery(sql3);
			while(rs.next()){
				Chrom chrom=new Chrom();
				chrom.setGeneId(rs.getInt(1));
				chrom.setGroupId(rs.getInt(2));
				String geneStr=rs.getString(3);
				String[] s=geneStr.split(":");
				int[] gene=new int[s.length];
				for(int i=0;i<s.length;i++){
					gene[i]=Integer.parseInt(s[i]);
				}
				chrom.setGene(gene);
				chrom.setFitnessV(rs.getDouble(4));
				
				/*CrossMess crossMess=new CrossMess();
				String crossMessStr=rs.getString(5);
				String[] crossMessArray=crossMessStr.split(":");
				crossMess.setCrossLength(Integer.parseInt(crossMessArray[0]));
				crossMess.setStartP(Integer.parseInt(crossMessArray[1]));
				chrom.setCrossMess(crossMess);*/
				
				MutMess mutMess=new MutMess();
				String mutMessStr=rs.getString(6);
				String[] mutMessArray=mutMessStr.split(":");
				mutMess.setMutNum(Integer.parseInt(mutMessArray[0]));
				int[] mutSq=new int[mutMessArray.length-1];
				for(int i=1;i<mutMessArray.length;i++){
					mutSq[i-1]=Integer.parseInt(mutMessArray[i]);
				}
				mutMess.setMutSeq(mutSq);
				chrom.setMutMess(mutMess);
				
				chrom.setType(rs.getString(8));
				chrom.setIndex(rs.getInt(9));
				mutChromList.add(chrom);
				//chrom.setGene()
			}
			
			String sql4="select * from gagroup where chromType='select' and groupId="+generation;
			sm=TravelPlanDatabase.getConnection().createStatement();
			rs=sm.executeQuery(sql4);
			while(rs.next()){
				Chrom chrom=new Chrom();
				chrom.setGeneId(rs.getInt(1));
				chrom.setGroupId(rs.getInt(2));
				String geneStr=rs.getString(3);
				String[] s=geneStr.split(":");
				int[] gene=new int[s.length];
				for(int i=0;i<s.length;i++){
					gene[i]=Integer.parseInt(s[i]);
				}
				chrom.setGene(gene);
				chrom.setFitnessV(rs.getDouble(4));
				
				/*CrossMess crossMess=new CrossMess();
				String crossMessStr=rs.getString(5);
				String[] crossMessArray=crossMessStr.split(":");
				crossMess.setCrossLength(Integer.parseInt(crossMessArray[0]));
				crossMess.setStartP(Integer.parseInt(crossMessArray[1]));
				chrom.setCrossMess(crossMess);
				
				MutMess mutMess=new MutMess();
				String mutMessStr=rs.getString(6);
				String[] mutMessArray=crossMessStr.split(":");
				mutMess.setMutNum(Integer.parseInt(mutMessArray[0]));
				int[] mutSq=new int[mutMessArray.length-1];
				for(int i=1;i<mutMessArray.length;i++){
					mutSq[i]=Integer.parseInt(mutMessArray[i]);
				}
				mutMess.setMutSeq(mutSq);
				chrom.setMutMess(mutMess);*/
				
				chrom.setType(rs.getString(8));
				chrom.setIndex(rs.getInt(9));
				selectChromList.add(chrom);
				//chrom.setGene()
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		auxGroup.setOrginChromList(orginChromList);
		auxGroup.setCrossChromList(crossChromList);
		auxGroup.setMutChromList(mutChromList);
		auxGroup.setSelectChromList(selectChromList);
		return auxGroup;
	}
	public static void getGroupMess(){
		
	}
	public static void main(String[] args) {
		AuxGroup auxGroup=GeneticProcessSql.getAuxGroup(1);
		List<Chrom> orginChromList=auxGroup.getOrginChromList();
		for(Chrom chrom:orginChromList){
			System.out.println(chrom.getType());
		}
	}

}
