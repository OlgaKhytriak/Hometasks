package com.epam.patterns.models.units.navalunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class NuclearCruiser extends SampleNavalUnit {

	public void navigate(int numberOfSteps) {
		System.out.println("NuclearCruiser navigate");

	}

	public void fight(Unit victim) {
		System.out.println("NuclearCruiser fight");

	}

}
