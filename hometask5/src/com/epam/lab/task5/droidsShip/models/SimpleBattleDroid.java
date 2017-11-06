package com.epam.lab.task5.droidsShip.models;

import com.epam.lab.task5.droidsShip.constants.DriodConstants;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {

	public SimpleBattleDroid(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		if ((enemyDroid instanceof DefenderDroid)) {
			((DefenderDroid) enemyDroid).defenceItself(this);
		}
		Integer energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {// ALL energy is used to reduce heals points.
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
	}

}
