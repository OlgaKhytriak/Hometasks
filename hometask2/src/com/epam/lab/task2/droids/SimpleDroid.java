package com.epam.lab.task2.droids;

import com.epam.lab.task2.battle.Team;
import com.epam.lab.task2.constants.DroidType;
import com.epam.lab.task2.io.DriodInfoDisplayer;

/**
 * @author okhytadmin
 *
 */
public abstract class SimpleDroid implements Droid{
	/**
	 * Basic health value. It is used to define the MAX_HEALTH for different droids
	 */
	private Integer health;
	private Integer energy;
	private Integer maxHealth;
	private Integer maxEnergy;
	private Integer maxPower;
	private Team myTeam;
	
	protected SimpleDroid(Integer maxEnergy,Integer maxHealth) {
		setMaxHealth(maxEnergy);
		setMaxEnergy(maxHealth);
		setEnergy(maxEnergy);
		setHealth(maxHealth);
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

		public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}

	
	
	
	
}
