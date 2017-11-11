package com.epam.lab.task6.number3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleBufferedReader {
	public void read(String path, int buferSize) {
		try (BufferedReader reader = new BufferedReader((new FileReader(path)), buferSize)) {
			String s;
			while ((s = reader.readLine()) != null) {
				// System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error in read with FileReader");
		}
	}
}
