package com.epam.lab.task4.comparetask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.log4j.Logger;

public class StartTask4Nom5 {
	private static final Logger LOG = Logger.getLogger(StartTask4Nom5.class);
	public static void main(String[] args) {
		Generator generator=new Generator();
		CountryCapitalClass[] tastArray=generator.generateArray(5);
		ArrayList<CountryCapitalClass> testArrayList=generator.generateArrayList(6);
		StartTask4Nom5 startTask4Nom5=new StartTask4Nom5();
		
		LOG.info("----- ArrayList Before sort");
		startTask4Nom5.printArrayList(testArrayList);
		LOG.info("-------ArrayList After sort");
		Collections.sort(testArrayList);
		startTask4Nom5.printArrayList(testArrayList);
		
		LOG.info("----- Array Before sort");
		startTask4Nom5.printArray(tastArray);
		LOG.info("-------Array After sort");
		Arrays.sort(tastArray);
		startTask4Nom5.printArray(tastArray);
	
	}
	
	private void printArray(CountryCapitalClass[] tastArray) {
		for (CountryCapitalClass element:tastArray) {
			LOG.info(String.format("%s - %s", element.getCountry(),element.getCapital()));
					}
	}
	
	private void printArrayList(ArrayList<CountryCapitalClass> testArrayList) {
		for (CountryCapitalClass element:testArrayList) {
			LOG.info(String.format("%s - %s", element.getCountry(),element.getCapital()));
		}
	}

}
