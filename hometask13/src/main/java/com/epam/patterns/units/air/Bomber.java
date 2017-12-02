package com.epam.patterns.units.air;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Bomber extends SampleUnit implements AirUnit{

	public void fight(Unit victim) {
		System.out.println("Bomber fights");
		
	}

	public void fly(int numberOfSteps) {
		System.out.println("Bomber fly");
		
	}

}
