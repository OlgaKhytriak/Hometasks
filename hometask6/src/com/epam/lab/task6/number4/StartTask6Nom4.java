package com.epam.lab.task6.number4;

import org.apache.log4j.Logger;

public class StartTask6Nom4 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom4.class);

	public static void main(String[] args) throws Exception {
		SimpleFileReader simpleFileReader = new SimpleFileReader();
		String allText = simpleFileReader.readAllFile("TestForComments.java");
		LOG.info(allText);
		CommentsHunter commentsHunter=new CommentsHunter();
		commentsHunter.find(allText);
	}

}
