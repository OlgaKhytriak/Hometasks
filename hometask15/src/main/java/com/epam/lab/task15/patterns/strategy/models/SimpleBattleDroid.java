package com.epam.lab.task15.patterns.strategy.models;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {

	public SimpleBattleDroid(String name,Integer maxEnergy, Integer maxHealth) {
		super(name,maxEnergy, maxHealth);

	}
	public void shoot(SimpleDroid enemyDroid) {Integer enemyDroidHealth = enemyDroid.getHealth();
	if ((enemyDroid instanceof DefenderDroid)) {
		((DefenderDroid) enemyDroid).defenceItself(this);
	}
	Integer energy = getEnergy();
	while ((enemyDroidHealth > 0) && (energy > 0)) {
		enemyDroidHealth--;
		energy--;
	}
	enemyDroid.setHealth(enemyDroidHealth);
	setEnergy(energy);}

}
