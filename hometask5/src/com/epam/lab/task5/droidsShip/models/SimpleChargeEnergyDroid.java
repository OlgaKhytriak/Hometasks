package com.epam.lab.task5.droidsShip.models;

import com.epam.lab.task5.droidsShip.constants.DriodConstants;

public class SimpleChargeEnergyDroid extends SimpleDroid implements ChargeEnergyDroid {
	public SimpleChargeEnergyDroid(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
	}

	public void charge(SimpleDroid injuredDroid) {
		Integer injuredDroidEnergy = injuredDroid.getEnergy();
		Integer maxEnergy = injuredDroid.getMaxEnergy();
		Integer energy = getEnergy();
		while ((injuredDroidEnergy < maxEnergy) && (energy > 0)) {
			injuredDroidEnergy++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setEnergy(injuredDroidEnergy);
	}
}
