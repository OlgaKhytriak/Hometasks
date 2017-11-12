package com.epam.lab.task6.number5;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public class StartTask6Nom5 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom5.class);

	public static void main(String[] args) throws Exception {
		LOG.info("---- Start task 6 Number 5 -------");
		SimpleConsole simpleConsole = new SimpleConsole();
		simpleConsole.run();

		// поточна директорія

		// System.out.println(startPath.getParent());
		// String filePath = "TestForMistakes.txt";
		// String filePath="//D:/Olga/Hometasks/hometask6/TestForMistakes.txt"; //! Не
		// працюэ
		String filePath = "D:/Olga/Hometasks/hometask6/TestForMistakes.txt"; // !!!Отак працює
		
		Path testFilePath = Paths.get(filePath);
		/*
		 * System.out.println("Printing file information: ");
		 * System.out.println("\t file name: " + testFilePath.getFileName());
		 * System.out.println("\t root of the path: " + testFilePath.getRoot());
		 * System.out.println("It's URI is: " + testFilePath.toUri());
		 * System.out.println("\t parent of the target: " + testFilePath.getParent());
		 * //Вывод элементов пути System.out.println("Printing elements of the path: ");
		 * for (Path element : testFilePath) { System.out.println("\t path element: " +
		 * element);
		 * 
		 * } System.out.println("It's absolute path is: " +
		 * testFilePath.toAbsolutePath());
		 * System.out.println("It's normalized path is: " + testFilePath.normalize());
		 * 
		 * //Получение другого объекта строки по нормализованному относительному пути
		 * Path testPathNormalized = Paths .get(testFilePath.normalize().toString());
		 * System.out.println("It's normalized absolute path is: " +
		 * testPathNormalized.toAbsolutePath());
		 * System.out.println("It's normalized real path is: " +
		 * testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
		 * 
		 * System.out.println(" -------------Ex 2 ----------");
		 * 
		 * /* String filePath = "./Test"; Path testFilePath = Paths.get(filePath);
		 * 
		 * //Пример строки пути для запуска в Windows //Path testFilePath =
		 * Paths.get(".\\Test");
		 * 
		 * System.out.println("The file name is: " + testFilePath.getFileName());
		 * System.out.println("It's URI is: " + testFilePath.toUri());
		 * System.out.println("It's absolute path is: " +
		 * testFilePath.toAbsolutePath());
		 * System.out.println("It's normalized path is: " + testFilePath.normalize());
		 */
		//Получение другого объекта строки по нормализованному относительному пути
		Path testPathNormalized = Paths .get(testFilePath.normalize().toString());
		System.out.println("It's normalized absolute path is: " +
		testPathNormalized.toAbsolutePath());
		System.out.println("It's normalized real path is: " +
		testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
	
		LOG.info("---- End task 6 Number 5 -------");

	}

}
