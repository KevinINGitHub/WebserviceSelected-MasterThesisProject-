package com.lsm.demo;
import java.util.*;
public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList aTest=new ArrayList(3);
		aTest.add(0,"hello");
		aTest.add(1, "whatName");
		aTest.add(2,"hello");
		aTest.remove(1);
		aTest.add(1, "repeat");
		for(Object s:aTest){
			System.out.println(s.toString());
		}
	}

}
