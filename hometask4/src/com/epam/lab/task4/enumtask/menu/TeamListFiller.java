package com.epam.lab.task4.enumtask.menu;

import org.apache.log4j.Logger;

import com.epam.lab.task4.enumtask.enums.DroidType;
import com.epam.lab.task4.enumtask.models.*;

public class TeamListFiller {
	private final Keyboard readerFromKeyboard;
	private final DroidTypeInfoDisplayer droidTypeInfoDisplayer;
	// private TeamInfoDisplayer teamInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamListFiller.class);

	public TeamListFiller() {
		readerFromKeyboard = new Keyboard();
		// teamInfoDisplayer = new TeamInfoDisplayer();
		droidTypeInfoDisplayer = new DroidTypeInfoDisplayer();
	}

	public void fill(Team team) {
		SimpleDroid currentDroid = null;
		int health = 0;
		int energy = 0;
		int i = 0;
		int teamAmount=team.getBeginNumberOfTeamMembers();
		while (i < teamAmount) {
			Integer typeTeamMember = readerFromKeyboard
					.readIntegerFromKeyboard(String.format("Input the type droid ¹ [%s]", i + 1));
			switch (typeTeamMember) {
			case 1:
				health = DroidType.SIMPLEBATTLEDROID.calcMaxHealth();
				energy = DroidType.SIMPLEBATTLEDROID.calcMaxHealth();
				currentDroid = new SimpleBattleDroid(health, energy);
				LOG.info(DroidType.SIMPLEBATTLEDROID.getDescription());
				break;
			case 2:
				health = DroidType.SIMPLEREPAIRDROID.calcMaxHealth();
				energy = DroidType.SIMPLEREPAIRDROID.calcMaxHealth();
				currentDroid = new SimpleRepairDroid(health, energy);
				LOG.info(DroidType.SIMPLEREPAIRDROID.getDescription());
				break;
			case 3:
				health = DroidType.SIMPLECHARGEENERGYDROID.calcMaxHealth();
				energy = DroidType.SIMPLECHARGEENERGYDROID.calcMaxHealth();
				currentDroid = new SimpleChargeEnergyDroid(health, energy);
				LOG.info(DroidType.SIMPLECHARGEENERGYDROID.getDescription());
				break;
			case 4:
				health = DroidType.DEFENDERBATTLEDROID.calcMaxHealth();
				energy = DroidType.DEFENDERBATTLEDROID.calcMaxHealth();
				currentDroid = new DefenderBattleDroid(health, energy);
				LOG.info(DroidType.DEFENDERBATTLEDROID.getDescription());
				break;
			case 5:
				health = DroidType.DROIDEKA.calcMaxHealth();
				energy = DroidType.DROIDEKA.calcMaxHealth();
				currentDroid = new Droideka(health, energy);
				LOG.info(DroidType.DROIDEKA.getDescription());
				break;
			case 6:
				health = DroidType.DEFENDERREPAIRDROID.calcMaxHealth();
				energy = DroidType.DEFENDERREPAIRDROID.calcMaxHealth();
				currentDroid = new DefenderRepairDroid(health, energy);
				LOG.info(DroidType.DEFENDERREPAIRDROID.getDescription());
				break;
			default:
				LOG.info((String.format("You enter wrong type of droid!! Try again: ", i)));
				break;
			}
			if ((0 < typeTeamMember) && (typeTeamMember < 7)) {
				i++;
				team.getTeamList().add(currentDroid);
			}

		}
	}
}
