package com.epam.finalproject;

import java.util.List;

import org.apache.log4j.Logger;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		LOG.info("Hello");
	}

	public static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element.toString());
		}
	}

}
