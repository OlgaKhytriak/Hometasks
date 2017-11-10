package com.epam.lab.task6.number1.models.droids;

import java.io.Serializable;

import com.epam.lab.task6.number1.models.enums.*;
import com.epam.lab.task6.number1.models.interfaces.*;

public class DefenderBattleDroid extends SimpleBattleDroid implements DefenderDroid, Serializable {
	private static final DroidType DROIDTYPE=DroidType.DEFENDERBATTLEDROID;	
	
	public DefenderBattleDroid(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
	}
	public DefenderBattleDroid() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
		//System.out.println("DefenderBattleDroid Constructor");
	}
	
@Override
public void defenceItself(SimpleDroid droidAttacker) {
	Integer attackerEnergy=droidAttacker.getEnergy();
	droidAttacker.setEnergy(attackerEnergy/2);	
}
}
