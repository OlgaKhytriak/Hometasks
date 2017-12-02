package com.epam.patterns.factory;

import com.epam.patterns.units.airunits.Ñosmoplan;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.NavalUnit;
import com.epam.patterns.units.landunits.Robot;
import com.epam.patterns.units.navalunits.NuclearCruiser;

public class FutureEraUnitsFactory extends UnitsFactory{

	@Override
	public AirUnit createAirUnit() {
		return new Ñosmoplan();
	}

	@Override
	public LandUnit createLandUnit() {
		return new Robot();
	}

	@Override
	public NavalUnit createNavalUnit() {
		return new NuclearCruiser();
	}

}
