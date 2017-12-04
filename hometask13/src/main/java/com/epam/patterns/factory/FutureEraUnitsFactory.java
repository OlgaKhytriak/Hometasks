package com.epam.patterns.factory;

import com.epam.patterns.models.units.airunits.Ñosmoplan;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;
import com.epam.patterns.models.units.landunits.Robot;
import com.epam.patterns.models.units.navalunits.NuclearCruiser;

public class FutureEraUnitsFactory implements UnitsFactory{

	public AirUnit createAirUnit() {
		return new Ñosmoplan();
	}

	public LandUnit createLandUnit() {
		return new Robot();
	}

	public NavalUnit createNavalUnit() {
		return new NuclearCruiser();
	}

}
