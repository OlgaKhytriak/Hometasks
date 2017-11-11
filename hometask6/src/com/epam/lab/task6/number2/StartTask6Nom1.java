package com.epam.lab.task6.number2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.epam.lab.task6.number2.models.droids.*;
import com.epam.lab.task6.number2.models.interfaces.Droid;
import com.epam.lab.task6.number2.ship.DroidsShip;

public class StartTask6Nom1 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom1.class);

	public static void main(String[] args) {
		StartTask6Nom1 startTask6Nom1 = new StartTask6Nom1();
		LOG.info("------ One droid-----");
		startTask6Nom1.serializeOneDroidExample();
		LOG.info("------ Droid ship-----");
		startTask6Nom1.serializationShipExample();
		LOG.info("------ End of StartTask6Nom1-----");

	}

	private void serializationShipExample() {
		DroidsShip<Droid> droidShip = createShip();
		DroidsShip<Droid> droidShipNew = new DroidsShip<Droid>();
		doSerialization(droidShip, "Ship.dat");
		
		try {
		droidShipNew = (DroidsShip<Droid>) doDeSerialization("Ship.dat");
		} catch (ClassNotFoundException e) {
			LOG.info("Exception after deSerialiszation");
		}
		LOG.info(String.format("equals = %s", droidShip.equals(droidShipNew)));
		LOG.info(String.format("Parameters BEFORE serialization: HashCode=%s; Size=%s", droidShip.hashCode(),
				droidShip.size()));
		LOG.info("List of droids:");
		for (int i=0; i<droidShip.size(); i++) {
			LOG.info(droidShip.get(i).getDroidDesription());
		}
		LOG.info(String.format("Parameters AFTER serialization: HashCode=%s; Size=%s", droidShipNew.hashCode(),
				droidShipNew.size()));
		LOG.info("List of droids:");
		for (int i=0; i<droidShipNew.size(); i++) {
			LOG.info(droidShipNew.get(i).getDroidDesription());
		}
	}

	private DroidsShip<Droid> createShip() {
		DroidsShip<Droid> droidShip = new DroidsShip<Droid>();
		SimpleBattleDroid dr1 = new SimpleBattleDroid();
		SimpleBattleDroid dr2 = new SimpleBattleDroid();
		SimpleRepairDroid dr3=new SimpleRepairDroid();
		Droid[] droidsArray = { dr1, dr2 ,dr3};
		for (int i = 0; i < droidsArray.length; i++) {
			droidShip.put(droidsArray[i]);
		}
		return droidShip;
	}

	private void serializeOneDroidExample() {
		DefenderBattleDroid defbatDroid1 = new DefenderBattleDroid();
		doSerialization(defbatDroid1, "droids.dat");
		Droid defbatDroidNew = new DefenderBattleDroid();
		try {
			defbatDroidNew = (DefenderBattleDroid) doDeSerialization("droids.dat");
		} catch (ClassNotFoundException e) {
			LOG.info("Exception after deSerialiszation");
		}
		LOG.info(String.format("equals = ", defbatDroid1.equals(defbatDroidNew)));
		LOG.info(String.format("Parameters BEFORE serialization: HashCode=%s; MaxHealth=%s; MaxEnergy=%s. This is %s",
				defbatDroid1.hashCode(), defbatDroid1.getHealth(), defbatDroid1.getMaxEnergy(),
				defbatDroid1.getDroidDesription()));
		LOG.info(String.format("Parameters AFTER serialization: HashCode=%s; MaxHealth=%s; MaxEnergy=%s. This is %s",
				defbatDroidNew.hashCode(), defbatDroidNew.getHealth(), defbatDroidNew.getMaxEnergy(),
				defbatDroidNew.getDroidDesription()));

	}

	private void doSerialization(Object droid, String filePath) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(droid);
			objectOutputStream.flush();
		} catch (IOException e) {
			LOG.info("Exception in doSerialization method");
		}
	}

	private Object doDeSerialization(String filePath) throws ClassNotFoundException {
		Object ob = null;
		try (FileInputStream fileOutputStream = new FileInputStream(filePath);
				ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream)) {
			ob = objectOutputStream.readObject();
		} catch (IOException e) {
			LOG.info("Exception in doDeSerialization method");
			}
		return ob;
	}
}
