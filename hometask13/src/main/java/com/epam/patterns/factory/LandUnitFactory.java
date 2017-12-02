package com.epam.patterns.factory;

import com.epam.patterns.units.enums.UnitType;
import com.epam.patterns.units.interfaces.Unit;
import com.epam.patterns.units.land.Archer;
import com.epam.patterns.units.land.Musketeer;
import com.epam.patterns.units.land.Warrior;

public class LandUnitFactory  extends AbstractFactory{
	public Unit createUnit(UnitType unitType) {
		if (unitType.equals(UnitType.ARCHER)) {
			return new Archer();
		} else if (unitType.equals(UnitType.MUSKETEER)) {
			return new Musketeer();
		} else if (unitType.equals(UnitType.WARRIOR)) {
			return new Warrior();
		} else {
			System.out.println("Incorrect unit type");
			return null;
		}
	}

}
