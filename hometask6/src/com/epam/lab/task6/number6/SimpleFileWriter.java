package com.epam.lab.task6.number6;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {
	public void write(String message, String path) {

		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(message);
		} catch (IOException e) {
			System.out.println("Error in read with FileReader");
		}
	}
}
