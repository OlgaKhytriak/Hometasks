package com.epam.lab.task6.number3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class StartTask6Nom3 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom3.class);

	public static void main(String[] args) {
		StartTask6Nom3 startTask6Nom3=new StartTask6Nom3();
		startTask6Nom3.comparePerformance();
		
		
	}
	public void comparePerformance() {
		LOG.info(String.format("Method \"read\" from FileReader  performed %s msec", testFileReader()));
		LOG.info(String.format("Method \"readLine\" from BufferedReader"));
		LOG.info(String.format("buferSize = 1 performed %s msec", testBufferedReader(1)));
		LOG.info(String.format("buferSize = 10 performed %s msec", testBufferedReader(10)));
		LOG.info(String.format("buferSize = 100 performed %s msec", testBufferedReader(100)));
		LOG.info(String.format("buferSize = 1000 performed %s msec", testBufferedReader(1000)));
		LOG.info(String.format("buferSize = 5000 performed %s msec", testBufferedReader(5000)));
		LOG.info(String.format("buferSize = 5000 performed %s msec", testBufferedReader(10000)));
		LOG.info(String.format("buferSize = 5000 performed %s msec", testBufferedReader(15000)));
	
	}

	private long testFileReader() {
		Date startLinked = new Date();
		SimpleFileReader simpleFileReader = new SimpleFileReader();
		simpleFileReader.read("war.txt");
		Date finishLinked = new Date();
		return finishLinked.getTime() - startLinked.getTime();
	}
	private long testBufferedReader(int buferSize) {
		Date startLinked = new Date();
		SimpleBufferedReader simpleBufferedReader = new SimpleBufferedReader();
		simpleBufferedReader.read("war.txt",buferSize);
		Date finishLinked = new Date();
		return finishLinked.getTime() - startLinked.getTime();
	}
}
