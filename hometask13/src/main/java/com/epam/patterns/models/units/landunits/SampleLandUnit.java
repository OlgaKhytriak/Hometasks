package com.epam.patterns.models.units.landunits;

import com.epam.patterns.models.units.SampleUnit;
import com.epam.patterns.models.units.interfaces.LandUnit;
import com.epam.patterns.models.units.interfaces.Unit;

public abstract class SampleLandUnit extends SampleUnit implements LandUnit {

	public abstract void fight(Unit victim);

	public abstract void go(int numberOfSteps);

}
