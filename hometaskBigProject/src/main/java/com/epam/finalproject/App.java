package com.epam.finalproject;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.models.Tariffs;
import com.epam.finalproject.tariffBuilder.TriffsBuilder;
import com.epam.finalproject.xml.jaxb.CreaterXML;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		CreaterXML  createrXML = new CreaterXML();
		createrXML.create();
	}

	public static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element.toString());
		}
	}

}
