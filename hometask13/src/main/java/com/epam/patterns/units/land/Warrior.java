package com.epam.patterns.units.land;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.Unit;

public class Warrior extends SampleUnit implements LandUnit{

	public void go(int numberOfSteps) {
		System.out.println("Warrior goes");
		
	}

	public void fight(Unit victim) {
		System.out.println("Warrior fights");
		
	}
}
