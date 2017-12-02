package com.epam.patterns.factory;

import com.epam.patterns.units.enums.UnitType;
import com.epam.patterns.units.interfaces.Unit;

public interface UnitsFactory {
	public Unit createUnit(UnitType unitType);
}
