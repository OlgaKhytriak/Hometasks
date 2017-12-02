package com.epam.patterns.models.units.landunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Tank extends SampleLandUnit {

	public void go(int numberOfSteps) {
		System.out.println("Tank goes");

	}

	public void fight(Unit victim) {
		System.out.println("Tank fights");

	}
}
