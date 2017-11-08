package com.epam.lab.task5.droidsShip;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.task5.droidsShip.io.DroidTypeInfoDisplayer;
import com.epam.lab.task5.droidsShip.models.Droid;
import com.epam.lab.task5.droidsShip.models.SimpleBattleDroid;
import com.epam.lab.task5.droidsShip.ship.ShipDroidsWithGenerics;
import com.epam.lab.task5.droidsShip.ship.ShipDroidsWithWildCard;

public class StartTask5Nom2 {
	private static final Logger LOG = Logger.getLogger(StartTask5Nom2.class);

	public static void main(String[] args) {
		DroidTypeInfoDisplayer droidTypeInfoDisplayer = new DroidTypeInfoDisplayer();
		droidTypeInfoDisplayer.displayAllTypes();
		
		ShipDroidsWithGenerics shipDroidsWithGenerics=new ShipDroidsWithGenerics();
		Droid droid1=new SimpleBattleDroid(10, 30);
		shipDroidsWithGenerics.put(droid1);
		Droid droid2=new SimpleBattleDroid(20, 30);
		shipDroidsWithGenerics.put(droid2);
		
		ShipDroidsWithWildCard shipDroidsWithWildCard=new ShipDroidsWithWildCard();
		List<SimpleBattleDroid> battleDroidsList =new ArrayList<SimpleBattleDroid>();
		shipDroidsWithWildCard.putAll(battleDroidsList);
		

		
		LOG.info("------ End of StartTask4Nom3-----");

	}
}
