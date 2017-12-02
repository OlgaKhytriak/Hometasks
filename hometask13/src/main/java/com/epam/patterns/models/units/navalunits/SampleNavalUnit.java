package com.epam.patterns.models.units.navalunits;

import com.epam.patterns.models.units.SampleUnit;
import com.epam.patterns.models.units.interfaces.NavalUnit;
import com.epam.patterns.models.units.interfaces.Unit;

public abstract class SampleNavalUnit extends SampleUnit implements NavalUnit {

	public abstract void fight(Unit victim);

	public abstract void navigate(int numberOfSteps);

}
