package com.epam.patterns.units.naval;

import com.epam.patterns.units.interfaces.Unit;

public class Battleship extends SampleNavalUnit {

	public void navigate(int numberOfSteps) {
		System.out.println("Battleship navigate");

	}

	public void fight(Unit victim) {
		System.out.println("Battleship fight");

	}

}
