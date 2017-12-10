package com.epam.lab.task15.patterns.strategy.models;

public class SimpleChargeEnergyDroid extends SimpleDroid implements ChargeEnergyDroid {
	public SimpleChargeEnergyDroid(String name, Integer maxEnergy, Integer maxHealth) {
		super(name,maxEnergy, maxHealth);
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
