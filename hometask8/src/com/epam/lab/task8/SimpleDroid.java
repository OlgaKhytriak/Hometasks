package com.epam.lab.task8;

import com.epam.lab.task8.models.interfaces.DefenderDroid;

public class SimpleDroid implements Droid {
	@HealthField (basicValue=20,description="Current health")
	private Integer health;
	private Integer energy;
	@HealthField (basicValue=100,description="As much as possible health")
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
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		if ((enemyDroid instanceof DefenderDroid)) {
			((DefenderDroid) enemyDroid).defenceItself(this);
		}
		Integer energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
	}
	public void repair(SimpleDroid injuredDroid) {
		Integer injuredDroidHealth = injuredDroid.getHealth();
		Integer maxHelth = injuredDroid.getMaxHealth();
		Integer energy = getEnergy();
		while ((injuredDroidHealth < maxHelth) && (energy > 0)) {
			injuredDroidHealth++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setHealth(injuredDroidHealth);
	}
	public void charge(SimpleDroid injuredDroid) {
		Integer injuredDroidEnergy = injuredDroid.getEnergy();
		Integer maxEnergy = injuredDroid.getMaxEnergy();
		Integer energy = getEnergy();
		while ((injuredDroidEnergy < maxEnergy) && (energy > 0)) {
			injuredDroidEnergy++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setEnergy(injuredDroidEnergy);
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
