package com.epam.lab.task9;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int [] add(int[] aArray, int[] bArray) {
		int[] cArray=new int[aArray.length];
		if (aArray.length!=bArray.length) {
			throw new ArrayIndexOutOfBoundsException("Arrays must be the same size"); 
		}else
			for(int i=0;i<=aArray.length;i++) {
				cArray[i]=aArray[i]+bArray[i];
			}		
		return cArray;
		
		
	}

	public double div(int a, int b) {
		return (double) (a / b);
	}
	
}
