package com.epam.lab.task6.number6;

import org.apache.log4j.Logger;

public class StartTask6Nom6 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom6.class);

	public static void main(String[] args) throws Exception {
		LOG.info("---- Start task 6 Number 6 -------");
		String filePath = "TestForMistakes.txt";
		SimpleFileReader simpleFileReader = new SimpleFileReader();
		String allText = simpleFileReader.readAllFile(filePath);
		MistakesFixer mistakesFixer = new MistakesFixer();
		String rez = mistakesFixer.fixAll(allText);
		SimpleFileWriter simpleFileWriter = new SimpleFileWriter();
		simpleFileWriter.write(rez, filePath);
		LOG.info("---- End task 6 Number 6 -------");

	}

}
