package com.epam.lab.task4.comparetask;

import java.util.Comparator;

public class CapitalComparator implements Comparator<CountryCapitalBasic> {

	@Override
	public int compare(CountryCapitalBasic o1, CountryCapitalBasic o2) {
		String capital1 = o1.getCapital();
		String capital2 = o2.getCapital();
		return capital1.compareTo(capital2);
	}

}
