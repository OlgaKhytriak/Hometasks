package com.epam.lab.task8.models.droids;

import java.io.Serializable;

import com.epam.lab.task8.SimpleDroid;
import com.epam.lab.task8.models.enums.*;
import com.epam.lab.task8.models.interfaces.*;

public class SimpleChargeEnergyDroid extends SimpleDroid implements ChargeEnergyDroid, Serializable {
	private transient static final DroidType DROIDTYPE=DroidType.SIMPLECHARGEENERGYDROID;	
	
	public SimpleChargeEnergyDroid(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
	}
	public SimpleChargeEnergyDroid() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
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
