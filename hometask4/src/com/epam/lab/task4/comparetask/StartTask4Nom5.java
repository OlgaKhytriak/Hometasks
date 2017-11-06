package com.epam.lab.task4.comparetask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

public class StartTask4Nom5 {
	private static final Logger LOG = Logger.getLogger(StartTask4Nom5.class);

	public static void main(String[] args) {
		StartTask4Nom5 startTask4Nom5 = new StartTask4Nom5();
		startTask4Nom5.processArray(2);
		startTask4Nom5.processArrayList(2);
	}

	private void processArray(int n) {
		Generator generator = new Generator();
		CountryCapitalBasic[] tastArray = generator.generateArray(n);
		LOG.info("----- Array Before sort");
		printArray(tastArray);
		LOG.info("-------Array After sort by countries");
		Arrays.sort(tastArray);
		printArray(tastArray);
		CountryCapitalBasic objectForSearch = new CountryCapitalBasic("Greece", "Athens");
		int searchResult = Arrays.binarySearch(tastArray, objectForSearch);
		LOG.info(String.format("-------Search result: %s", searchResult));
		LOG.info("-------Array After sort by capitals");
		Arrays.sort(tastArray, new CapitalComparator());
		printArray(tastArray);

	}

	private void processArrayList(int n) {
		Generator generator = new Generator();
		ArrayList<CountryCapitalBasic> testArrayList = generator.generateArrayList(n);
		LOG.info("----- ArrayList Before sort");
		printArrayList(testArrayList);
		LOG.info("-------ArrayList After sort by countries");
		Collections.sort(testArrayList);
		printArrayList(testArrayList);
		LOG.info("-------ArrayList After sort by capitals");
		Collections.sort(testArrayList, new CapitalComparator());
		printArrayList(testArrayList);
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
