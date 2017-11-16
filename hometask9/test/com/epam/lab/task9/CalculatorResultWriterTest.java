package com.epam.lab.task9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorResultWriterTest {
	private static final Logger LOG = Logger.getLogger(CalculatorStringsTest.class);
	private static CalculatorResultWriter ñalculatorResultWriter;
	private int[] aArray;
	private int[] bArray;
	String testFilePath;
	String testMessage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ñalculatorResultWriter = new CalculatorResultWriter();
	}

	@Before
	public void setUp1() throws Exception {
		testFilePath = "TestFile.txt";
	}

	@Test
	public void testCreateFile() {
		invokeCreateFileMethod(ñalculatorResultWriter, testFilePath);
	}

	@Before
	public void setUp2() throws Exception {
		testFilePath = "TestFileNew.txt";
		testMessage = "Hello";
		invokeCreateFileMethod(ñalculatorResultWriter, testFilePath);		
	}

	@Test
	public void testWriteToFile() {
		invokeWriteToFileMethod(ñalculatorResultWriter, testMessage, testFilePath);
		String messageFromFile=readFromFile(testFilePath);
		assertEquals(testMessage, messageFromFile);
	}

	private String readFromFile(String filePath) {
		String allText = "";
		String delimiter = "";
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				allText = String.join(delimiter, allText, line);
			}
		} catch (FileNotFoundException e) {
			LOG.info("FileNotFoundException in readFromFile method");
		}
		return allText;
	}

	private void invokeWriteToFileMethod(Object obj, String message, String filePath) {
		Class<?>[] paramTypes = new Class[] { String.class, String.class, boolean.class };
		Object[] args = new Object[] { new String(message), new String(filePath), new Boolean(false) };
		try {
			Method method = obj.getClass().getDeclaredMethod("writeToFile", paramTypes);
			method.setAccessible(true);
			method.invoke(obj, args);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			LOG.info("In invokeWriteToFileMethod method  exception. Invoking is failed");
		}
	}

	private void invokeCreateFileMethod(Object obj, String filePath) {
		Class<?>[] paramTypes = new Class[] { String.class };
		Object[] args = new Object[] { new String(filePath) };
		try {
			Method method = obj.getClass().getDeclaredMethod("createFile", paramTypes);
			method.setAccessible(true);
			method.invoke(obj, args);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			LOG.info("In invokeCreateFileMethod method  exception. Invoking is failed");
		}
	}

}
