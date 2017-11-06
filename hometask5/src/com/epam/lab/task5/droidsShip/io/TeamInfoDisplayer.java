package com.epam.lab.task5.droidsShip.io;

import org.apache.log4j.Logger;

import com.epam.lab.task5.droidsShip.models.*;

public class TeamInfoDisplayer { 
	private DriodInfoDisplayer driodInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamInfoDisplayer.class);
	public TeamInfoDisplayer() {
		driodInfoDisplayer = new DriodInfoDisplayer();
	}

	public void printTeamList(Team team) {
		if (team.getTeamList().isEmpty()) {
			LOG.info(String.format("The team [ %s ] is empty", team.getTeamName()));
		}
		LOG.info(String.format("[ %s ]",team.getTeamName()) );
		int i = 0;
		for (SimpleDroid currentDroid : team.getTeamList()) {
			i++;
			driodInfoDisplayer.printAllInformation(currentDroid);
		}
	}

}
