package com.epam.patterns;


import java.util.List;

import org.apache.log4j.Logger;

import com.epam.patterns.factory.UnitsFactory;
import com.epam.patterns.units.enums.UnitType;
import com.epam.patterns.units.interfaces.Unit;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		LOG.info("Hello");
		Unit unit=new UnitsFactory().createUnit(UnitType.AIRCRAFTCARRIER);
	}

	

}
