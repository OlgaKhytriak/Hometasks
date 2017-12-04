package com.epam.patterns.factory;

import com.epam.patterns.models.units.airunits.Stealth;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;
import com.epam.patterns.models.units.landunits.Tank;
import com.epam.patterns.models.units.navalunits.Battleship;

public class ModernEraUnitsFactory implements UnitsFactory {

	public AirUnit createAirUnit() {
		return new Stealth();
	}

	public LandUnit createLandUnit() {
		return new Tank();
	}

	public NavalUnit createNavalUnit() {
		return new Battleship();
	}

}
