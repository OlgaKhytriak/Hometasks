package com.epam.patterns.units.enums;

public enum UnitType {
	BOMBER(1, new int[] { 2, 4 }, "Bomber air unit"), 
	FIGHTER(2, new int[] { 1, 3 },"Fighter air unit"), 
	STEALTH(3,new int[] { 2, 2 },"Stealth air unit"), 
	ARCHER(4,new int[] { 4, 4 },"Archer land unit"), 
	MUSKETEER(5, new int[] { 4, 6 },"Musketeer land unit"), 
	WARRIOR(6, new int[] { 6, 6 },"Warior land unit"),
	AIRCRAFTCARRIER(7,new int[] { 5, 2 },"AircraftCarrier naval unit"), 
	BATTLESHIP(8, new int[] { 3, 6 },"Battleship naval unit"), 
	FRIGATE(9, new int[] { 1, 7 },"Frigate naval unit");
	private static final int BASIC_VALUE = 10;
	private final int id;
	private final int koefHealth; 
	private final int koefEnergy; 
	private final String description;

	UnitType(int id, int[] healthEnergyArray, String description) {
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
