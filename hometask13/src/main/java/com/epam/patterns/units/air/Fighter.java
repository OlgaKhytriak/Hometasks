package com.epam.patterns.units.air;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Fighter extends SampleUnit implements AirUnit{
	public void fight(Unit victim) {
		System.out.println("Fighter fights");
		
	}

	public void fly(int numberOfSteps) {
		System.out.println("Fighter fly");
		
	}
}
