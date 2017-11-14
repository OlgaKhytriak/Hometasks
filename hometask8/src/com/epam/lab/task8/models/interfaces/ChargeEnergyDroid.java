package com.epam.lab.task8.models.interfaces;

import com.epam.lab.task8.Droid;
import com.epam.lab.task8.SimpleDroid;

public interface ChargeEnergyDroid extends Droid{
	public void charge(SimpleDroid injuredDroid);
}
