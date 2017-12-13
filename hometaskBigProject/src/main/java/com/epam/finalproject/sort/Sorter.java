package com.epam.finalproject.sort;

import java.util.Collections;
import java.util.List;

import com.epam.finalproject.xml.model.Tariff;
import com.epam.finalproject.xml.model.Tariffs;


public class Sorter {

	public Tariffs sort(Tariffs tariffs) {
		Tariffs sortedtariffs=new Tariffs();
		List<Tariff> tariffsList = tariffs.getTariffs();
		Collections.sort(tariffsList, new ComparatorName());
		sortedtariffs.setTariffs(tariffsList);	
		return sortedtariffs;	
	}
}
