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
		writeToFile("", filePath, false);
		writeArrayToFile(sumArray, filePath);
	}

	private void writeArrayToFile(int[] aArray, String filePath) {
		for (int i = 0; i < aArray.length; i++) {
			writeToFile(new Integer(aArray[i]).toString(), filePath, true);
			writeToFile(";", filePath, true);
		}
	}

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

	private void writeToFile(String message, String path, boolean ifAppend) {
		try (FileWriter fileWriter = new FileWriter(path, ifAppend)) {
			fileWriter.write(message);
		} catch (IOException e) {
			System.out.println("Error in read with writeToFile");
		}
	}
}
