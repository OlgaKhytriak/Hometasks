package com.epam.lab.task6.number2.models.interfaces;

import com.epam.lab.task6.number2.models.droids.SimpleDroid;

/**
 * @author okhytadmin
 *
 */
public interface BattleDroid extends Droid{
	public void shoot(SimpleDroid enemyDroid);
}
