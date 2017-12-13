package com.epam.finalproject.sort;

import java.util.Comparator;

import com.epam.finalproject.xml.model.Tariff;

public class ComparatorName implements Comparator<Tariff>{

	@Override
	public int compare(Tariff o1, Tariff o2) {
		return o1.getTariffName().compareTo(o2.getTariffName());
	}

}
