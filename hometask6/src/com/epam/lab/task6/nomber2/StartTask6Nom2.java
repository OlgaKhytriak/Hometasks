package com.epam.lab.task6.nomber2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class StartTask6Nom2 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom2.class);

	public static void main(String[] args) {
		StartTask6Nom2 startTask6Nom2=new StartTask6Nom2();
		startTask6Nom2.comparePerformance();
		
		
	}
	public void comparePerformance() {
		LOG.info(String.format("Method \"read\" in FileReader  performed %s msec", testFileReader()));
		LOG.info(String.format("Method \"readLine\" in BufferedReader  performed %s msec", testBufferedReader()));
	}

	private long testFileReader() {
		Date startLinked = new Date();
		SimpleFileReader simpleFileReader = new SimpleFileReader();
		simpleFileReader.read("war.txt");
		Date finishLinked = new Date();
		return finishLinked.getTime() - startLinked.getTime();
	}
	private long testBufferedReader() {
		Date startLinked = new Date();
		SimpleBufferedReader simpleBufferedReader = new SimpleBufferedReader();
		simpleBufferedReader.read("war.txt");
		Date finishLinked = new Date();
		return finishLinked.getTime() - startLinked.getTime();
	}
}
