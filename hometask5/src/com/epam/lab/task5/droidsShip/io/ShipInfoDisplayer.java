package com.epam.lab.task5.droidsShip.io;


import org.apache.log4j.Logger;

import com.epam.lab.task5.droidsShip.models.*;
import com.epam.lab.task5.droidsShip.ship.ShipDroidsWithGenerics;
import com.epam.lab.task5.droidsShip.ship.Team;

public class ShipInfoDisplayer { 
	private DriodInfoDisplayer driodInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamInfoDisplayer.class);
	public ShipInfoDisplayer() {
		driodInfoDisplayer = new DriodInfoDisplayer();
	}

	public void printShipList(ShipDroidsWithGenerics team) {
		if (team.getShipList().isEmpty()) {
			LOG.info(String.format("The ship [ %s ] is empty"));
		}
		//LOG.info(String.format("[ %s ]",team.getTeamName()) );
		int i = 0;
		for (Droid currentDroid :team.getShipList()) {
			i++;
			driodInfoDisplayer.printAllInformation(currentDroid);
		}
	}

}
