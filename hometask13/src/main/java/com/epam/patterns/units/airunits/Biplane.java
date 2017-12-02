package com.epam.patterns.units.airunits;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Biplane extends SampleAirUnit{
	public void fight(Unit victim) {
		System.out.println("Biplane fights");
		
	}

	public void fly(int numberOfSteps) {
		System.out.println("Biplane fly");
		
	}
}
