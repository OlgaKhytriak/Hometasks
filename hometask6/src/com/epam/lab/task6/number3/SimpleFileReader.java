package com.epam.lab.task6.number3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SimpleFileReader {

	public void read(String path) {
		try (FileReader reader = new FileReader(path); Scanner scan = new Scanner(reader)) {
			int i = 1;
			while (scan.hasNextLine()) {
				scan.nextLine();
				i++;
			}
		} catch (IOException e) {
			System.out.println("Error in read with FileReader");
		}
	}

}
