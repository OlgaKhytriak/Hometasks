package com.epam.patterns.factory;

import java.util.LinkedList;
import java.util.List;

import com.epam.patterns.models.units.interfaces.*;

public class SquadCreator {

	public List<Unit> create(UnitsFactory factory) {
		List<Unit> subdivisionList=new LinkedList<Unit>();
		AirUnit airUnit=factory.createAirUnit();
		subdivisionList.add(airUnit);
		LandUnit landUnit=factory.createLandUnit();
		subdivisionList.add(landUnit);
		NavalUnit navalUnit=factory.createNavalUnit();
		subdivisionList.add(navalUnit);		
		return subdivisionList;
	}
}
