package com.epam.lab.task6.number6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SimpleFileReader {
	private static final Logger LOG = Logger.getLogger(SimpleFileReader.class);

	public String readAllFile(String filePath) {
		String allText = "";
		String newLine = "\r";
		String delimiter = "";
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				allText = String.join(delimiter, allText, line, newLine);
			}
		} catch (FileNotFoundException e) {
			LOG.info("FileNotFoundException in readAllFile method");
			e.printStackTrace();
		}
		return allText;
	}
}
