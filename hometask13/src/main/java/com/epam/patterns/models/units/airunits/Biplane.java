package com.epam.patterns.models.units.airunits;

import com.epam.patterns.models.units.SampleUnit;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.Unit;

public class Biplane extends SampleAirUnit{
	public void fight(Unit victim) {
		System.out.println("Biplane fights");
		
	}

	public void fly(int numberOfSteps) {
		System.out.println("Biplane fly");
		
	}
}
