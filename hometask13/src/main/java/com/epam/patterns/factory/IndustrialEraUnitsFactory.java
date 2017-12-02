package com.epam.patterns.factory;

import com.epam.patterns.models.units.airunits.Biplane;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;
import com.epam.patterns.models.units.landunits.Infantryman;
import com.epam.patterns.models.units.navalunits.Frigate;

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
