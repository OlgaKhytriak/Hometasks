package com.epam.lab.task4.enumtask.models;

import com.epam.lab.task4.enumtask.constants.DriodConstants;

public class DefenderBattleDroid extends SimpleBattleDroid implements DefenderDroid {
	

public DefenderBattleDroid(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
	}

@Override
public void defenceItself(SimpleDroid droidAttacker) {
	Integer attackerEnergy=droidAttacker.getEnergy();
	droidAttacker.setEnergy(attackerEnergy/2);	
}
}
