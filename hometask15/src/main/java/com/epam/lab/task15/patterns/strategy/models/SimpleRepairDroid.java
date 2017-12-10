package com.epam.lab.task15.patterns.strategy.models;


public class SimpleRepairDroid extends SimpleDroid implements RepairDroid {

	public SimpleRepairDroid(String name,Integer maxEnergy, Integer maxHealth) {
		super(name,maxEnergy, maxHealth);
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
