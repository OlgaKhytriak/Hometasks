package com.epam.lab.task5.droidsShip.models;

public interface Droid {

	public String toString();

	public boolean isAlive();

	public Integer getHealth();

	public void setHealth(Integer health);

	public Integer getEnergy();

	public void setEnergy(Integer energy);

	public Integer getMaxHealth();

	public void setMaxHealth(Integer maxHealth);

	public Integer getMaxEnergy();

	public void setMaxEnergy(Integer maxEnergy);

	public Integer getMaxPower();

	public void setMaxPower(Integer maxPower);

}
