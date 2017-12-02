package com.epam.patterns.models.units.landunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Robot extends SampleLandUnit {

	public void go(int numberOfSteps) {
		System.out.println("Robot goes");

	}

	public void fight(Unit victim) {
		System.out.println("Robot fights");

	}

}
