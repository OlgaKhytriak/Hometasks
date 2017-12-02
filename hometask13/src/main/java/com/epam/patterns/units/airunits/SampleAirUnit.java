package com.epam.patterns.units.airunits;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.AirUnit;
import com.epam.patterns.units.interfaces.Unit;

public abstract class SampleAirUnit extends SampleUnit implements AirUnit{

	public abstract void fight(Unit victim);

	public abstract void fly(int numberOfSteps);

}
