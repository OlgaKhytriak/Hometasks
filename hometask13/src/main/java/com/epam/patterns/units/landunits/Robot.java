package com.epam.patterns.units.landunits;

import com.epam.patterns.units.interfaces.Unit;

public class Robot extends SampleLandUnit {

	public void go(int numberOfSteps) {
		System.out.println("Robot goes");

	}

	public void fight(Unit victim) {
		System.out.println("Robot fights");

	}

}
