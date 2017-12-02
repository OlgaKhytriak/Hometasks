package com.epam.patterns.models.units.airunits;

import com.epam.patterns.models.units.interfaces.Unit;

public class Stealth extends SampleAirUnit {
	public void fight(Unit victim) {
		System.out.println("Stealth fights");

	}

	public void fly(int numberOfSteps) {
		System.out.println("Stealth fly");

	}
}
