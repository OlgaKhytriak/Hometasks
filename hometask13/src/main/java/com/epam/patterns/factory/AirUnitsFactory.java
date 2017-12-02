package com.epam.patterns.factory;

import com.epam.patterns.units.air.Bomber;
import com.epam.patterns.units.air.Fighter;
import com.epam.patterns.units.air.Stealth;
import com.epam.patterns.units.enums.UnitType;
import com.epam.patterns.units.interfaces.Unit;

public class AirUnitsFactory extends AbstractFactory{
	public Unit createUnit(UnitType unitType) {
		if (unitType.equals(UnitType.BOMBER)) {
			return new Bomber();
		} else if (unitType.equals(UnitType.FIGHTER)) {
			return new Fighter();
		} else if (unitType.equals(UnitType.STEALTH)) {
			return new Stealth();
		} else {
			System.out.println("Incorrect unit type");
			return null;
		}
	}

}
