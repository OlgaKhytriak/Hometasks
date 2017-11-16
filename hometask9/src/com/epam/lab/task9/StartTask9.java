package com.epam.lab.task9;

public class StartTask9 {
	private static Calculator calculator = new Calculator();

	public static void main(String[] args) {
		CalculatorResultWriter calculatorResultWriter = new CalculatorResultWriter();
		int[] aArray = { 1, 1, 1, 1 };
		int[] bArray = { 2, 2, 2, 2 };
		calculatorResultWriter.writeAddArrays(aArray, bArray, "AddMatrix.txt");

	}

	private static void forArrays() {
		int[] aArray = { 1, 1, 1, 1 };
		int[] bArray = { 2, 2, 2, 2 };
		int[] cArray;
		cArray = calculator.add(aArray, bArray);
		for (int i = 0; i < cArray.length; i++) {
			System.out.println(cArray[i]);
		}
	}

	private static void forStrings() {
		String str1 = "aaa";
		String str2 = "bbb";
		String StringAdd = "aaabbb";
		System.out.println(calculator.add(str1, str2));

	}

}
