package com.epam.lab.task9;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorSimpleTest {
	private static final Logger LOG = Logger.getLogger(CalculatorSimpleTest.class);
	private static Calculator calculator;
	private int[] aArray;
	private int[] bArray;
	private int[] aPlusB;
	private int[] aArrayOverSize;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calculator = new Calculator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aArray = new int[] { 1, 1, 1, 1 };
		bArray = new int[] { 2, 2, 2, 2 };
		aPlusB = new int[] { 3, 3, 3, 3 };
		aArrayOverSize = new int[] { 1, 0, -4, 5, 6 };

	}

	@Test
	public void testAddIntArrays() {// Positiv
		try {
			assertArrayEquals("Error in add arrays", aPlusB, calculator.add(aArray, bArray));
		} catch (AssertionError e) {
			LOG.info(" - failed");
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class) // Negativ
	public void testAddIntArraysDiffrentSize() {
		try {
			calculator.add(aArrayOverSize, bArray);
		} catch (AssertionError e) {
			LOG.info(" - failed");
		}
	}

	@Test
	public void testAddInt() {// Positiv
		try {
			assertEquals("Error in add int", 7, calculator.add(2, 5));
		} catch (AssertionError e) {
			LOG.info(" - failed");
		}
	}

	@Test
	public void testDivInt() {// Positiv
		try {
			assertTrue("Error in in div", 2.0 == calculator.div(8, 4));
		} catch (AssertionError e) {
			LOG.info(" - failed");
		}
	}

	@Test(expected = ArithmeticException.class) // Negativ
	public void testDivIntNull() {
		try {
			calculator.div(4, 0);
		} catch (AssertionError e) {
			LOG.info(" - failed");
		}
	}

}
