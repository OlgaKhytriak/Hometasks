package com.epam.lab.task8;

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
	public String getDroidDesription();
	public void setDroidDesription(String droidDesription);
	public void shoot(SimpleDroid enemyDroid);
	public void repair(SimpleDroid injuredDroid);
	public void charge(SimpleDroid injuredDroid);


}
