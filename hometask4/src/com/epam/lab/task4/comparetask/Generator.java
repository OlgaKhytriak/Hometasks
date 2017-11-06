package com.epam.lab.task4.comparetask;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

	public CountryCapitalBasic[] generateArray(int n) throws ArrayIndexOutOfBoundsException {
		CountryCapitalBasic[] rezArray = null;
		if (n > InfoContainer.CAPITALS_COUNTRIES.size()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			rezArray = new CountryCapitalBasic[n];
			for (int i = 0; i < n; i++) {
				String[] pair = chooseRandomPair(InfoContainer.CAPITALS_COUNTRIES);
				CountryCapitalBasic element = new CountryCapitalBasic();
				element.setCountry(pair[0]);
				element.setCapital(pair[1]);
				rezArray[i] = element;
			}
		}
		return rezArray;

	}

	public ArrayList<CountryCapitalBasic> generateArrayList(int n) throws ArrayIndexOutOfBoundsException {
		ArrayList<CountryCapitalBasic> rezArrayList = null;
		if (n > InfoContainer.CAPITALS_COUNTRIES.size()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			rezArrayList = new ArrayList<CountryCapitalBasic>(n);
			for (int i = 0; i < n; i++) {
				String[] pair = chooseRandomPair(InfoContainer.CAPITALS_COUNTRIES);
				CountryCapitalBasic element = new CountryCapitalBasic();
				element.setCountry(pair[0]);
				element.setCapital(pair[1]);
				rezArrayList.add(element);
			}
		}
		return rezArrayList;
	}

	public String[] chooseRandomPair(Map<String, String> currentMap) {
		int max = currentMap.size();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		Set<String> keySet = currentMap.keySet();
		String[] keyArray = (String[]) keySet.toArray(new String[0]);
		String[] rez = new String[2];
		String keyToFind = keyArray[index];
		rez[0] = keyArray[index];
		rez[1] = currentMap.get(keyToFind);
		return rez;

	}

}
