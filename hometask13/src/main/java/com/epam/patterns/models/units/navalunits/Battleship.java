package com.epam.patterns.models.units.navalunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Battleship extends SampleNavalUnit {

	public void navigate(int numberOfSteps) {
		System.out.println("Battleship navigate");

	}

	public void fight(Unit victim) {
		System.out.println("Battleship fight");

	}

}
