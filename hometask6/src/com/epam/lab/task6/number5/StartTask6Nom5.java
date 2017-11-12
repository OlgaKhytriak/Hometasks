package com.epam.lab.task6.number5;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public class StartTask6Nom5 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom5.class);

	public static void main(String[] args) throws Exception {
		LOG.info("---- Start task 6 Number 5 -------");
		SimpleConsole simpleConsole = new SimpleConsole();
		simpleConsole.run();
		LOG.info("---- End task 6 Number 5 -------");

	}

}
