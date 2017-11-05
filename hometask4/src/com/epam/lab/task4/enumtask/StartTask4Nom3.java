package com.epam.lab.task4.enumtask;
import org.apache.log4j.Logger;

import com.epam.lab.task4.enumtask.menu.DroidTypeInfoDisplayer;
import com.epam.lab.task4.enumtask.menu.Team;
import com.epam.lab.task4.enumtask.menu.TeamListFiller;

public class StartTask4Nom3 {
	private static final Logger LOG = Logger.getLogger(StartTask4Nom3.class);

	public static void main(String[] args) {

		DroidTypeInfoDisplayer droidTypeInfoDisplayer=new DroidTypeInfoDisplayer();
		droidTypeInfoDisplayer.displayAllTypes();
		int teamMembers=2;
		Team teamMars=new Team(teamMembers);
		LOG.info("------ End of StartTask4Nom3-----");
		
	}
}
