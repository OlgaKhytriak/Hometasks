package com.epam.patterns.factory;

import com.epam.patterns.units.airunits.Stealth;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.NavalUnit;
import com.epam.patterns.units.landunits.Tank;
import com.epam.patterns.units.navalunits.Battleship;

public class ModernEraUnitsFactory extends UnitsFactory {

	@Override
	public AirUnit createAirUnit() {
		return new Stealth();
	}

	@Override
	public LandUnit createLandUnit() {
		return new Tank();
	}

	@Override
	public NavalUnit createNavalUnit() {
		return new Battleship();
	}

}
