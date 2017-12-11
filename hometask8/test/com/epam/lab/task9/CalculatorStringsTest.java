package com.epam.lab.task9;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CalculatorStringsTest {
	private static final Logger LOG = Logger.getLogger(CalculatorStringsTest.class);
	private static Calculator calculator;
	private String str1;
	private String str2;
	private String StringAddFail;
	private String StringAdd;

	@Rule
	public TestWatcher watchman = new TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			LOG.info(String.format("Method: \"%s\" - failed", description.getMethodName()));
		}

		@Override
		protected void succeeded(Description description) {
			LOG.info(String.format("Method: \"%s\" - succeeded", description.getMethodName()));
		}
	};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calculator = new Calculator();
	}

	@Before
	public void setUp() throws Exception {
		str1 = "aaa";
		str2 = "bbb";
		StringAddFail = "aaabbb1";
		StringAdd = "aaabbb";
	}

	@Test
	public void testAddStringsFail() {// Mast fail
		assertEquals("Error in add strings", StringAddFail, (calculator.add(str1, str2)));
	}

	@Test
	public void testAddStrings() {// Positiv mast be done
		assertEquals("Error in add strings", StringAdd, (calculator.add(str1, str2)));
	}

}
