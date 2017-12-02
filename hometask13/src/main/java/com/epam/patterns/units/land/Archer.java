package com.epam.patterns.units.land;

import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Archer extends SampleLandUnit{

	public void go(int numberOfSteps) {
		System.out.println("Archer goes");

	}

	public void fight(Unit victim) {
		System.out.println("Archer fights");

	}

}
