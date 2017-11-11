package com.epam.lab.task6.number1.models.droids;

import java.io.Serializable;

import com.epam.lab.task6.number1.models.enums.*;
import com.epam.lab.task6.number1.models.interfaces.*;

public class DefenderRepairDroid extends SimpleRepairDroid implements DefenderDroid, Serializable{
	private transient static final DroidType DROIDTYPE=DroidType.DEFENDERREPAIRDROID;	
	
	public DefenderRepairDroid(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
	}
	public DefenderRepairDroid() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
	}
	
	@Override
		public void defenceItself(SimpleDroid droidAttacker) {
		absorbEnergy(droidAttacker);
		droidAttacker.setEnergy(0);		
	}
	private void absorbEnergy(SimpleDroid droidAttacker) {
		setEnergy(getEnergy()+droidAttacker.getEnergy());
	}

}
