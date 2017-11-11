package com.epam.lab.task6.number1.models.droids;

import java.io.Serializable;

import com.epam.lab.task6.number1.models.enums.DroidType;
import com.epam.lab.task6.number1.models.interfaces.BattleDroid;
import com.epam.lab.task6.number1.models.interfaces.DefenderDroid;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid, Serializable {
	private transient static final DroidType DROIDTYPE=DroidType.SIMPLEBATTLEDROID;	
	
	public SimpleBattleDroid(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
		//System.out.println("SimpleBattleDroid Constructor");
	}
	public SimpleBattleDroid() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
	}
	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		if ((enemyDroid instanceof DefenderDroid)) {
			((DefenderDroid) enemyDroid).defenceItself(this);
		}
		Integer energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
	}

}
