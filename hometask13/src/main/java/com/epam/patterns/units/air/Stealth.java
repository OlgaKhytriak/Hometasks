package com.epam.patterns.units.air;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Stealth extends SampleUnit implements AirUnit{
	public void fight(Unit victim) {
		System.out.println("Stealth fights");
		
	}

	public void fly(int numberOfSteps) {
		System.out.println("Stealth fly");
		
	}
}
