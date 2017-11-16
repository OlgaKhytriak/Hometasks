package com.epam.lab.task9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author okhytadmin
 *
 */
public class CalculatorResultWriter {
	private final Calculator calculator;

	CalculatorResultWriter() {
		calculator = new Calculator();
	}

	public void writeAddArrays(int[] aArray, int[] bArray, String filePath) {
		int[] sumArray = calculator.add(aArray, bArray);
		createFile(filePath);
		writeToFile("First array: ", filePath, false);
		writeArrayToFile(aArray,filePath);
		writeToFile("Second array: ", filePath, true);
		writeArrayToFile(bArray,filePath);
		writeToFile("Sum array: ", filePath, true);
		writeArrayToFile(sumArray,filePath);
	}

	private void writeArrayToFile(int[] aArray, String filePath) {
		writeToFile("(", filePath,true);
		for (int i = 0; i < aArray.length; i++) {
			writeToFile(String.valueOf(aArray[i]), filePath,true);
			writeToFile(";", filePath,true);
		}
		writeToFile(") ", filePath,true);
	}

	// If file already exists return false
	private boolean createFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return false;
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error in file's creation");
			}
			return true;
		}

	}

	public Calculator getCalculator() {
		return calculator;
	}

	private void writeToFile(String message, String path, boolean ifAppend) {
		try (FileWriter fileWriter = new FileWriter(path,ifAppend)) {
			fileWriter.write(message);
		} catch (IOException e) {
			System.out.println("Error in read with FileReader");
		}
	}
}
