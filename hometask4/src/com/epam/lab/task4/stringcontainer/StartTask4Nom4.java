package com.epam.lab.task4.stringcontainer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class StartTask4Nom4 {
	private static final Logger LOG = Logger.getLogger(StartTask4Nom4.class);
	private static final int kIteration = 1000;

	public static void main(String[] args) {
		LOG.info("Start task 4");
		StartTask4Nom4 startTask4Nom4 = new StartTask4Nom4();
		startTask4Nom4.comparePerformance();
		LOG.info("End task 4");
	}

	public void comparePerformance() {
		List<String> stringsContainer = new StringsContainer();
		List<String> stringsArrayList = new ArrayList<String>();
		long rezContainer = testAddMethod(stringsContainer);
		long rezArrayList = testAddMethod(stringsArrayList);
		LOG.info(String.format("Method \"add\" in StringContainer  performed %s msec", rezContainer));
		LOG.info(String.format("Method \"add\" in ArrayList  performed %s msec", rezArrayList));
	}

	private long testAddMethod(List<String> listToTest) {
		Date startLinked = new Date();
		for (int i = 0; i < kIteration; i++) {
			listToTest.add("some string");
		}
		Date finishLinked = new Date();
		return finishLinked.getTime() - startLinked.getTime();
	}
}
