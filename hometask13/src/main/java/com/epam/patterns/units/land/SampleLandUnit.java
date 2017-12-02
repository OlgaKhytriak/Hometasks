package com.epam.patterns.units.land;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.LandUnit;
import com.epam.patterns.units.interfaces.Unit;

public abstract class SampleLandUnit extends SampleUnit implements LandUnit {

	public abstract void fight(Unit victim);

	public abstract void go(int numberOfSteps);

}
