package com.epam.patterns.units.navalunits;

import com.epam.patterns.units.interfaces.Unit;

public class Frigate extends SampleNavalUnit {
	public void navigate(int numberOfSteps) {
		System.out.println("Frigate navigate");

	}

	public void fight(Unit victim) {
		System.out.println("Frigate fight");

	}

}
