package com.epam.lab.task6.number5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class SimpleConsole {
	private final Scanner scan;
	private final Path startPath;
	private Path currentPath;

	public SimpleConsole() {
		scan = new Scanner(System.in);
		startPath = Paths.get(".").toAbsolutePath();
		currentPath = startPath;
	}

	public void run() {
		printInformation();
		String userMessage = "";
		System.out.println("WorkingDirectory:: " + startPath);
		while (!userMessage.equals("exit")) {
			userMessage = scan.next();
			doUserAction(userMessage);
		}
		scan.close();
	}

	private void printInformation() {
		System.out.println(
				"Print:: \n exit - to finish;  \n ls - folder content;  \n la - full information folder content; \n cd - one level up");
	}

	private void doUserAction(String userMessage) {
		if (userMessage.equals("exit")) {
			return;
		} else if (userMessage.equals("ls")) {
			doLS(currentPath);
		} else if (userMessage.equals("la")) {
			doLSLA(currentPath);
		} else if (userMessage.equals("cd")) {
			doCD();
		} else {
			boolean ifPathChanged = changePath(userMessage);
			if (!ifPathChanged) {
				System.out.println("Unknown operation. Try again");
				return;
			}
		}
	}

	private boolean changePath(String message) {
		Path newPath = Paths.get(message);
		File f = new File(message);
		if (Files.exists(newPath)) {
			if (newPath.isAbsolute()) {
				currentPath = newPath;
				System.out.println("WorkingDirectory:: " + currentPath);
				System.out.println(newPath.toAbsolutePath());
			}
			return true;
		} else
			return false;
	}

	private void doCD() {
		currentPath = currentPath.getParent();
		System.out.println(currentPath);
	}

	private void doLS(Path currentPath) {
		try {
			Files.list(currentPath).limit(100).forEach(path -> {
				System.out.println(path.getFileName());
			});
		} catch (IOException e) {
			System.out.println("Exception in doLS");
		}
	}

	private void doLSLA(Path currentPath) {
		try {
			Files.list(currentPath).limit(100).forEach(path -> {
				printAtributes(path);
			});
		} catch (IOException e) {
			System.out.println("Exception in doLS");
		}
	}

	private void printAtributes(Path file) {
		BasicFileAttributes attr;
		try {
			attr = Files.readAttributes(file, BasicFileAttributes.class);
			System.out.println("name:" + file.getFileName());
			System.out.println("creationTime: " + attr.creationTime());
			System.out.println("lastAccessTime: " + attr.lastAccessTime());
			System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
			System.out.println("isDirectory: " + attr.isDirectory());
			System.out.println("isOther: " + attr.isOther());
			System.out.println("isRegularFile: " + attr.isRegularFile());
			System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
			System.out.println("size: " + attr.size());

		} catch (IOException e) {
			System.out.println("Exception in doLSLA");
		}
	}
}
