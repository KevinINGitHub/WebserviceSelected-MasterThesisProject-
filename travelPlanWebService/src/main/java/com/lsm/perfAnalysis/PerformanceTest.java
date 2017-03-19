package com.lsm.perfAnalysis;
import java.sql.*;

import com.lsm.travelPlan.database.TravelPlanDatabase;
import com.lsm.travelPlan.entity.WebServiceInfo;
public class PerformanceTest {

	/**
	 * @param args
	 */
	
	
	
	
	
	public static int tempt=0;
	public static long genResponseTime(){
		long begin=System.currentTimeMillis();
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		return (end-begin)/1000;
	}
	
	
	
	public static void ArrayIndexOutOfBoundsExcep(){
		int k=(int)( Math.random()*3);
		int result=0;
		int[] testArray={1,2};
		switch(k){
		case 1: 
			tempt=k;
			result=testArray[k];
		case 2:
			tempt=k;
			result=testArray[k];
		case 3:
			tempt=k;
			result=testArray[k];
		case 4:
			tempt=k;
			result=testArray[k];
		case 5:
			tempt=k;
			result=testArray[k];
			default:
				;
		}
	}
	public static void NullPointExcep(){
		
	}
	public static void main(String[] args) {
		/*for(int i=0;i<50;i++){
			try{
				ArrayIndexOutOfBoundsExcep();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("The first time the error occor is:"+i);
				System.out.println("The case is:"+PerformanceTest.tempt);
			}finally{
				
			}
			
		}*/
		
	
}
}
