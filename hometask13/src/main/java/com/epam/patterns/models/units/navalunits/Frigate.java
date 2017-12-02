package com.epam.patterns.models.units.navalunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Frigate extends SampleNavalUnit {
	public void navigate(int numberOfSteps) {
		System.out.println("Frigate navigate");

	}

	public void fight(Unit victim) {
		System.out.println("Frigate fight");

	}

}
