package com.epam.lab.task5.droidsShip;

import org.apache.log4j.Logger;
import com.epam.lab.task5.droidsShip.io.DroidTypeInfoDisplayer;
import com.epam.lab.task5.droidsShip.ship.Team;

public class StartTask5Nom2 {
	private static final Logger LOG = Logger.getLogger(StartTask5Nom2.class);

	public static void main(String[] args) {

		DroidTypeInfoDisplayer droidTypeInfoDisplayer = new DroidTypeInfoDisplayer();
		droidTypeInfoDisplayer.displayAllTypes();
		Team team=new Team(6);
		LOG.info("------ End of StartTask4Nom3-----");

	}
}
