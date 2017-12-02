package com.epam.patterns.models.units.interfaces;

import com.epam.patterns.models.weapons.Weapon;

public interface Unit {
public void fight(Unit victim);
public void useWeapon();
public Weapon getWeapon();
public void setWeapon(Weapon weapon);
}
