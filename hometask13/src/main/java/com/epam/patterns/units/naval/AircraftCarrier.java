package com.epam.patterns.units.naval;

import com.epam.patterns.units.interfaces.Unit;

public class AircraftCarrier extends SampleNavalUnit {

	public void navigate(int numberOfSteps) {
		System.out.println("AircraftCarrier navigate");

	}

	public void fight(Unit victim) {
		System.out.println("AircraftCarrier fight");

	}

}
