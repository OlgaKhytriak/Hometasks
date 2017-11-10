package com.epam.lab.task6.number1.models.interfaces;

import com.epam.lab.task6.number1.models.droids.SimpleDroid;

/**
 * @author okhytadmin
 *
 */
public interface BattleDroid extends Droid{
	public void shoot(SimpleDroid enemyDroid);
}
