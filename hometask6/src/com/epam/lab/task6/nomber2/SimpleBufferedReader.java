package com.epam.lab.task6.nomber2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleBufferedReader {
	public void read(String path) {		
		try (BufferedReader reader = new BufferedReader((new FileReader(path)),500))
		{
			String s;
			while ((s = reader.readLine()) != null) {
				//System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error in read with FileReader");
		}
	}
}
