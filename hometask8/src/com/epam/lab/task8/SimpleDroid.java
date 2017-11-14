package com.epam.lab.task8;
public class SimpleDroid{
	private final int basicPoints;
	@HealthField(basicValue = 20, description = "Current health")
	private int health;
	private int energy;
	@HealthField(basicValue = 100, description = "As much as possible health")
	private int maxHealth;
	private int maxEnergy;
	private int maxPower;
	private String droidDesription;
	private int level;

	
	public SimpleDroid() {
		basicPoints=10;
	}

	public SimpleDroid(int maxHealth, int maxEnergy) {
		this();
		this.maxEnergy = maxEnergy;
		this.maxHealth = maxHealth;
		this.energy = maxEnergy;
		this.health = maxHealth;
		this.setLevel(1);
	}
	
	
	
	public String toString() {
		return this.getClass().getSimpleName();
	}

	public boolean isAlive() {
		return !(0 == health);
	}

	public int getHealth() {
		return health;
	}

	public void shoot(SimpleDroid enemyDroid) {
		int enemyDroidHealth = enemyDroid.getHealth();
		int energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
	}

	public void repair(SimpleDroid injuredDroid) {
		int injuredDroidHealth = injuredDroid.getHealth();
		int maxHelth = injuredDroid.getMaxHealth();
		int energy = getEnergy();
		while ((injuredDroidHealth < maxHelth) && (energy > 0)) {
			injuredDroidHealth++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setHealth(injuredDroidHealth);
	}

	public void charge(SimpleDroid injuredDroid) {
		int injuredDroidEnergy = injuredDroid.getEnergy();
		int maxEnergy = injuredDroid.getMaxEnergy();
		int energy = getEnergy();
		while ((injuredDroidEnergy < maxEnergy) && (energy > 0)) {
			injuredDroidEnergy++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setEnergy(injuredDroidEnergy);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public String getDroidDesription() {
		return droidDesription;
	}

	public void setDroidDesription(String droidDesription) {
		this.droidDesription = droidDesription;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int calcLevel(int additionalEnergy, double koef) {		
		return (int) ((maxEnergy+additionalEnergy+energy*koef)/basicPoints);
	}

	public int getBasicPoints() {
		return basicPoints;
	}
}
