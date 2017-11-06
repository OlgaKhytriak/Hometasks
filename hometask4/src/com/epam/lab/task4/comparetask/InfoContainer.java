package com.epam.lab.task4.comparetask;

import java.util.HashMap;
import java.util.Map;

public class InfoContainer {
	public static final Map<String, String> CAPITALS_COUNTRIES = createContainer();

	private InfoContainer() {
	}

	private static Map<String, String> createContainer() {

		Map<String, String> container = new HashMap<String, String>();
		container.put("England", "London");
		container.put("Albania", "Tirana");
		container.put("Madagascar", "Antananarivo");
		container.put("Monaco", "Monaco");
		container.put("France", "Paris");
		container.put("Australia", "Canberra");
		container.put("Germany", "Berlin");
		container.put("Iran", "Tehran");
		container.put("Belarus", "Minsk");
		container.put("Greece", "Athens");
		container.put("Egypt", "Cairo");
		container.put("Cuba", "Havana");
		container.put("Morocco", "Rabat");
		container.put("Belgium", "Brussels");
		container.put("Netherlands", "Amsterdam");
		container.put("Austria", "Vienna");
		container.put("Guyana", "Georgetown");
		container.put("Italy", "Rome");
		container.put("Bulgaria", "Sofia");
		container.put("Jordan", "Amman");
		container.put("Colombia", "Bogota");
		container.put("Norway", "Oslo");
		container.put("Brazil", "Brasilia");
		container.put("Pakistan", "Islamabad");
		container.put("Latvia", "Riga");
		container.put("Poland", "Warsaw");
		container.put("China", "Beijing");
		container.put("Japan", "Tokyo");
		container.put("Iraq", "Baghdad");
		container.put("Estonia", "Tallinn");
		container.put("Portugal", "Lisbon");
		return container;
	}

}
