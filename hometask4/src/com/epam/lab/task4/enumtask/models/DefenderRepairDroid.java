package com.epam.lab.task4.enumtask.models;

import com.epam.lab.task4.enumtask.constants.DriodConstants;;
public class DefenderRepairDroid extends SimpleRepairDroid implements DefenderDroid{
	
	public DefenderRepairDroid(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
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
