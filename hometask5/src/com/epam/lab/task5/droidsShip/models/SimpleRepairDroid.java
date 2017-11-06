package com.epam.lab.task5.droidsShip.models;

import com.epam.lab.task5.droidsShip.constants.DriodConstants;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends SimpleDroid implements RepairDroid {

	public SimpleRepairDroid(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
	}

	public void repair(SimpleDroid injuredDroid) {
		Integer injuredDroidHealth = injuredDroid.getHealth();
		Integer maxHelth = injuredDroid.getMaxHealth();
		Integer energy = getEnergy();
		while ((injuredDroidHealth < maxHelth) && (energy > 0)) {
			injuredDroidHealth++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setHealth(injuredDroidHealth);
	}

}
