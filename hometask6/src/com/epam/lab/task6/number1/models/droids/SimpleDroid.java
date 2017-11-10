package com.epam.lab.task6.number1.models.droids;

import java.io.Serializable;

import com.epam.lab.task6.number1.models.interfaces.Droid;

public abstract class SimpleDroid implements Droid, Serializable {
	private Integer health;
	private Integer energy;
	private Integer maxHealth;
	private Integer maxEnergy;
	private Integer maxPower;
	private String droidDesription;

	public SimpleDroid() {
	}

	public SimpleDroid(Integer maxHealth, Integer maxEnergy) {
		this.maxEnergy = maxEnergy;
		this.maxHealth = maxHealth;
		this.energy = maxEnergy;
		this.health = maxHealth;
		// System.out.println("SimpleDroid Constructor");
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}

	public boolean isAlive() {
		return !(0 == health);
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
	}

	public Integer getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(Integer maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public Integer getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(Integer maxPower) {
		this.maxPower = maxPower;
	}

	public String getDroidDesription() {
		return droidDesription;
	}

	public void setDroidDesription(String droidDesription) {
		this.droidDesription = droidDesription;
	}

}
