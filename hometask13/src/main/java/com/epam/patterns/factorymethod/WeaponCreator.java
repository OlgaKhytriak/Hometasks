package com.epam.patterns.factorymethod;

import com.epam.patterns.models.units.interfaces.Unit;
import com.epam.patterns.models.units.landunits.Infantryman;
import com.epam.patterns.models.units.landunits.Robot;
import com.epam.patterns.models.units.landunits.Tank;
import com.epam.patterns.models.weapons.*;

public class WeaponCreator {

	public Weapon create(Unit unit) {
		Weapon weapon = null;
        if (unit instanceof Infantryman) {
        	weapon = new MachineGun();
        } else if (unit instanceof Tank) {
        	weapon = new Cannon();
        }else if (unit instanceof Robot) {
        	weapon=new Laser();
        }
        return weapon;
    }
}
