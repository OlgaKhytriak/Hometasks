package com.epam.patterns.units.airunits;

import com.epam.patterns.units.interfaces.Unit;

public class Stealth extends SampleAirUnit {
	public void fight(Unit victim) {
		System.out.println("Stealth fights");

	}

	public void fly(int numberOfSteps) {
		System.out.println("Stealth fly");

	}
}
