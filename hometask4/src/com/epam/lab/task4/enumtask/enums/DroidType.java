package com.epam.lab.task4.enumtask.enums;

public enum DroidType {
	SIMPLEBATTLEDROID(1, new int[] { 2, 4 }), 
	SIMPLEREPAIRDROID(2, new int[] { 1, 3 }), 
	SIMPLECHARGEENERGYDROID(3,new int[] { 2, 2 }), 
	DEFENDERBATTLEDROID(4,new int[] { 4, 4 }), 
	DROIDEKA(5, new int[] { 4, 6 }), 
	DEFENDERREPAIRDROID(6, new int[] { 6, 6 });

	private static final int BASIC_VALUE = 10;
	private final int id;
	private final int koefHealth; // в килограммах
	private final int koefEnergy; // в метрах

	DroidType(int id, int[] healthEnergyArray) {
		this.id = id;
		this.koefHealth = healthEnergyArray[1];
		this.koefEnergy = healthEnergyArray[2];
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
}
