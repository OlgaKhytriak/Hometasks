package com.epam.lab.task8.models.droids;

import java.io.Serializable;

import com.epam.lab.task8.SimpleDroid;
import com.epam.lab.task8.models.enums.*;
import com.epam.lab.task8.models.interfaces.*;
public class Droideka extends DefenderBattleDroid implements DefenderDroid, Serializable{
	private transient static final DroidType DROIDTYPE=DroidType.DROIDEKA;	
	
	public Droideka(int maxHealth, int maxEnergy) {
		super(maxHealth,maxEnergy);
		setDroidDesription(DROIDTYPE.getDescription());
	}
	public Droideka() {
		this(DROIDTYPE.calcMaxHealth(),DROIDTYPE.calcMaxEnergy());
	}


	
	public Droideka(Integer maxEnergy, Integer maxHealth) {
		super(maxEnergy, maxHealth);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void defenceItself(SimpleDroid droidAttacker) {
		absorbEnergy(droidAttacker);
		droidAttacker.setEnergy(0);	
		shoot(droidAttacker);
	}
	private void absorbEnergy(SimpleDroid droidAttacker) {
		setEnergy(getEnergy()+droidAttacker.getEnergy());
	}
	}

