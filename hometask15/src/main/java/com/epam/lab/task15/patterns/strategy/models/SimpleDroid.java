package com.epam.lab.task15.patterns.strategy.models;


/**
 * @author okhytadmin
 *
 */
public abstract class SimpleDroid implements Droid{

	private Integer health;
	private Integer energy;
	private Integer maxHealth;
	private Integer maxEnergy;
	private Integer maxPower;
	private String name;
	
	public SimpleDroid() {}
	
	public SimpleDroid(String name, Integer maxEnergy,Integer maxHealth) {
		this.maxEnergy=maxEnergy;
		this.maxHealth=maxHealth;
		this.energy=maxEnergy;
		this.health=maxHealth;
		this.name=name;
	}
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public boolean isAlive() {
		return !(0==health);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
