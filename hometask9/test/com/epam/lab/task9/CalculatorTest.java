package com.epam.lab.task9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	private static Calculator calculator;

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
    int[] aArray = {1, 0, -4, 5};
    int[] bArray = {1, 0, -4, 5};
    int[] aaArray = {1, 0, -4, 5, 6};
   
	}
	@Test
	public void testAddArrays() {//Positiv

	}
	
	@Test
	public void testAddArraysDiffrentSize() {//Negativ

	}


	@Test
	public void testAddInt() {// Positiv
		assertEquals("Error in add", 7, calculator.add(2, 5));
	}

	@Test
	public void testDivInt() {// Positiv
		assertEquals("Error in div", 2.0, calculator.div(8, 4));
	}

	@Test(expected = ArithmeticException.class)
	public void testDivIntNull() {// Negativ
		calculator.div(4, 0);
	}

}
