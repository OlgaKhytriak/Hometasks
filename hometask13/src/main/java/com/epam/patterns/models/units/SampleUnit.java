package com.epam.patterns.models.units;

import com.epam.patterns.models.units.interfaces.Unit;
import com.epam.patterns.models.weapons.Weapon;

public abstract class SampleUnit implements Unit{

	private Weapon weapon;
	
	public void useWeapon() {
		System.out.println("Unit "+this.getClass().getSimpleName()+" uses weapon "+weapon.getClass().getSimpleName());
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
