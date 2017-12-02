package com.epam.patterns.units.navalunits;

import com.epam.patterns.units.SampleUnit;
import com.epam.patterns.units.interfaces.NavalUnit;
import com.epam.patterns.units.interfaces.Unit;

public abstract class SampleNavalUnit extends SampleUnit implements NavalUnit {

	public abstract void fight(Unit victim);

	public abstract void navigate(int numberOfSteps);

}
