package com.epam.patterns.factory;

import com.epam.patterns.units.airunits.Biplane;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.NavalUnit;
import com.epam.patterns.units.landunits.Infantryman;
import com.epam.patterns.units.navalunits.Frigate;

public class IndustrialEraUnitsFactory extends UnitsFactory {

	@Override
	public AirUnit createAirUnit() {
		return new Biplane();
	}

	@Override
	public LandUnit createLandUnit() {
		return new Infantryman();
	}

	@Override
	public NavalUnit createNavalUnit() {
		return new Frigate();
	}

}
