package com.epam.lab.task8.models.interfaces;

import com.epam.lab.task8.Droid;
import com.epam.lab.task8.SimpleDroid;

/**
 * @author okhytadmin
 *
 */
public interface BattleDroid extends Droid{
	public void shoot(SimpleDroid enemyDroid);
}
