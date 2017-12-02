package com.epam.patterns.models.units.landunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Infantryman extends SampleLandUnit {

	public void go(int numberOfSteps) {
		System.out.println("Infantryman goes");

	}

	public void fight(Unit victim) {
		System.out.println("Infantryman fights");

	}
}
