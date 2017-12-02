package com.epam.patterns.models.units.airunits;

import com.epam.patterns.models.units.SampleUnit;
import com.epam.patterns.models.units.interfaces.AirUnit;
import com.epam.patterns.models.units.interfaces.Unit;

public abstract class SampleAirUnit extends SampleUnit implements AirUnit{

	public abstract void fight(Unit victim);

	public abstract void fly(int numberOfSteps);

}
