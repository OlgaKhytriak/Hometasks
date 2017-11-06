package com.epam.lab.task4.comparetask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class StartTask4Nom5 {
	private static final Logger LOG = Logger.getLogger(StartTask4Nom5.class);

	public static void main(String[] args) {
		Generator generator = new Generator();
		CountryCapitalBasic[] tastArray = generator.generateArray(5);
		ArrayList<CountryCapitalBasic> testArrayList = generator.generateArrayList(6);
		StartTask4Nom5 startTask4Nom5 = new StartTask4Nom5();

		LOG.info("----- ArrayList Before sort");
		startTask4Nom5.printArrayList(testArrayList);
		LOG.info("-------ArrayList After sort");
		//Collections.sort(testArrayList<CountryCapitalBasic>);
		Collections.sort(testArrayList);
		startTask4Nom5.printArrayList(testArrayList);

		LOG.info("----- Array Before sort");
		startTask4Nom5.printArray(tastArray);
		LOG.info("-------Array After sort");
		Arrays.sort(tastArray);
		startTask4Nom5.printArray(tastArray);
	}

	private void printArray(CountryCapitalBasic[] tastArray) {
		for (CountryCapitalBasic element : tastArray) {
			LOG.info(String.format("%s - %s", element.getCountry(), element.getCapital()));
		}
	}

	private void printArrayList(ArrayList<CountryCapitalBasic> testArrayList) {
		for (CountryCapitalBasic element : testArrayList) {
			LOG.info(String.format("%s - %s", element.getCountry(), element.getCapital()));
		}
	}

}
