package com.epam.lab.task5.droidsShip.enums;

public enum DroidType {
	SIMPLEBATTLEDROID(1, new int[] { 2, 4 }, "Battle droid"), 
	SIMPLEREPAIRDROID(2, new int[] { 1, 3 },"Repair droid"), 
	SIMPLECHARGEENERGYDROID(3,new int[] { 2, 2 },"Charge droid"), 
	DEFENDERBATTLEDROID(4,new int[] { 4, 4 },"Defender battle droid"), 
	DROIDEKA(5, new int[] { 4, 6 },"Droideka"), 
	DEFENDERREPAIRDROID(6, new int[] { 6, 6 },"Defender rapair droid");

	private static final int BASIC_VALUE = 10;
	private final int id;
	private final int koefHealth; 
	private final int koefEnergy; 
	private final String description;

	DroidType(int id, int[] healthEnergyArray, String description) {
		this.id = id;
		this.koefHealth = healthEnergyArray[0];
		this.koefEnergy = healthEnergyArray[1];
		this.description=description;
	}

	public int calcMaxHealth() {
		return koefHealth * BASIC_VALUE;
	}

	public int calcMaxEnergy() {
		return koefEnergy * BASIC_VALUE;
	}

	public int getID() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
