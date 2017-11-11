package com.epam.lab.task6.number2.models.droids;

import java.io.Serializable;

import com.epam.lab.task6.number2.models.enums.DroidType;
import com.epam.lab.task6.number2.models.interfaces.RepairDroid;

public class SimpleRepairDroid extends SimpleDroid implements RepairDroid, Serializable {
	private transient static final DroidType DROIDTYPE=DroidType.SIMPLEREPAIRDROID;	
	
	public SimpleRepairDroid(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
	}
	public SimpleRepairDroid() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
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
