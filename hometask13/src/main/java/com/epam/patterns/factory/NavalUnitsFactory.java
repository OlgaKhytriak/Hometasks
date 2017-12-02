package com.epam.patterns.factory;

import com.epam.patterns.units.enums.UnitType;
import com.epam.patterns.units.interfaces.Unit;
import com.epam.patterns.units.naval.AircraftCarrier;
import com.epam.patterns.units.naval.Battleship;
import com.epam.patterns.units.naval.Frigate;

public class NavalUnitsFactory  extends AbstractFactory{
	public Unit createUnit(UnitType unitType) {
		if (unitType.equals(UnitType.FRIGATE)) {
			return new Frigate();
		} else if (unitType.equals(UnitType.AIRCRAFTCARRIER)) {
			return new AircraftCarrier();
		} else if (unitType.equals(UnitType.BATTLESHIP)) {
			return new Battleship();
		} else {
			System.out.println("Incorrect unit type");
			return null;
		}
	}
}
