package com.epam.lab.task4.enumtask.models;

import com.epam.lab.task4.enumtask.constants.DriodConstants;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {

	public SimpleBattleDroid() {
		super(DriodConstants.MAX_BEGIN_BATTLE_DROID_ENERGY, DriodConstants.MAX_BEGIN_BATTLE_DROID_HEALTH);
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
