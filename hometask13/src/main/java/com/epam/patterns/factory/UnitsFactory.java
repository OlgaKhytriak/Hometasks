package com.epam.patterns.factory;

import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;

public abstract class UnitsFactory{
	public abstract AirUnit createAirUnit();
	public abstract LandUnit createLandUnit();
	public abstract NavalUnit createNavalUnit();
}
