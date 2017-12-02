package com.epam.patterns.services;

import org.apache.log4j.Logger;

import com.epam.lab.task4.enumtask.enums.DroidType;

public class DroidTypeInfoDisplayer {
	private static final Logger LOG = Logger.getLogger(DroidTypeInfoDisplayer.class);
	
	public void displayAllTypes() {
		LOG.info("You can choose droid:");
		for (DroidType dt : DroidType.values()) {
				LOG.info(String.format(" (%s) - %s (max health=%s; max energy =%s)", dt.getID(),dt.getDescription(),dt.calcMaxHealth(),dt.calcMaxEnergy()));
		}
	}
}
