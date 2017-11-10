package com.epam.lab.task6.number1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import com.epam.lab.task6.number1.models.*;
import com.epam.lab.task6.number1.models.droids.DefenderBattleDroid;
import com.epam.lab.task6.number1.models.droids.SimpleBattleDroid;
import com.epam.lab.task6.number1.models.droids.SimpleChargeEnergyDroid;
import com.epam.lab.task6.number1.models.interfaces.Droid;
import com.epam.lab.task6.number1.ship.*;

public class StartTask6Nom1 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom1.class);

	public static void main(String[] args) {
		StartTask6Nom1 startTask6Nom1=new StartTask6Nom1();
		
		ShipDroidsWithGenerics<Droid> shipDroidsWithGenerics = new ShipDroidsWithGenerics<Droid>();
		DefenderBattleDroid dbDr1=new DefenderBattleDroid();
		SimpleBattleDroid sbDr1=new SimpleBattleDroid();
		SimpleChargeEnergyDroid schDr1=new SimpleChargeEnergyDroid() ;
		Droid[] droidsArray = { dbDr1,sbDr1 , schDr1};
		for (int i = 0; i < droidsArray.length; i++) {
			shipDroidsWithGenerics.put(droidsArray[i]);
		}

		startTask6Nom1.doSerialization(dbDr1);
		LOG.info("------ End of StartTask6Nom1-----");

	}

	private void doSerialization(Droid droid) {
		try (FileOutputStream fileOutputStream = new FileOutputStream("temp.out ");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(droid);
			objectOutputStream.flush();
		} catch (IOException e) {
			LOG.info("Exception ");
			e.printStackTrace();
		}
	}

}
