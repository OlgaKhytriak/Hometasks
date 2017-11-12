package com.epam.lab.task6.number5;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SimpleConsole {
	private final Scanner scan;
	private final Path startPath;
	private Path currentPath;

	// private final KeyboardReader keyboardReader;
public SimpleConsole(){
	scan = new Scanner(System.in);	
	startPath =Paths.get(".").toAbsolutePath();
	currentPath=startPath;
}

	public void run() {
		String userMessage = "";
		System.out.println("WorkingDirectory:: " + startPath);
		while (!userMessage.equals("exit")) {
			userMessage = scan.next();
			System.out.println("----" + userMessage);
		}
		scan.close();
	}

}
