package com.epam.patterns.factory;

import com.epam.patterns.models.units.airunits.Stealth;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;
import com.epam.patterns.models.units.landunits.Tank;
import com.epam.patterns.models.units.navalunits.Battleship;

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
