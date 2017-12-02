package com.epam.patterns.units.landunits;

import com.epam.patterns.units.interfaces.Unit;

public class Infantryman extends SampleLandUnit {

	public void go(int numberOfSteps) {
		System.out.println("Infantryman goes");

	}

	public void fight(Unit victim) {
		System.out.println("Infantryman fights");

	}
}
