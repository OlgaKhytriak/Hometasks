package com.epam.lab.task6.number1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

import sun.rmi.runtime.Log;

public class StartTask6Nom1 {
	private static final Logger LOG = Logger.getLogger(StartTask6Nom1.class);

	public static void main(String[] args) {
		StartTask6Nom1 startTask6Nom1 = new StartTask6Nom1();

		ShipDroidsWithGenerics<Droid> shipDroidsWithGenerics = new ShipDroidsWithGenerics<Droid>();
		DefenderBattleDroid defbatDroid1 = new DefenderBattleDroid();
		SimpleBattleDroid sbDr1 = new SimpleBattleDroid();
		SimpleChargeEnergyDroid schDr1 = new SimpleChargeEnergyDroid();
		Droid[] droidsArray = { defbatDroid1, sbDr1, schDr1 };
		for (int i = 0; i < droidsArray.length; i++) {
			shipDroidsWithGenerics.put(droidsArray[i]);
		}
		startTask6Nom1.serializeOneDroidExample();
		
		LOG.info("------ End of StartTask6Nom1-----");

	}
	private void serializeOneDroidExample() {
		DefenderBattleDroid defbatDroid1 = new DefenderBattleDroid();
		doSerialization(defbatDroid1, "droids.dat");
		Droid defbatDroidNew=new DefenderBattleDroid();
		try {
			defbatDroidNew=(DefenderBattleDroid)doDeSerialization("droids.dat");
		} catch (ClassNotFoundException e) {
			LOG.info("Exception after deSerialiszation");
		}
		LOG.info(String.format("equals = ",defbatDroid1.equals(defbatDroidNew)));
		LOG.info(String.format("Parameters BEFORE serialization: HashCode=%s; MaxHealth=%s; MaxEnergy=%s. This is %s",  defbatDroid1.hashCode(), defbatDroid1.getHealth(), defbatDroid1.getMaxEnergy(), defbatDroid1.getDroidDesription()));
		LOG.info(String.format("Parameters AFTER serialization: HashCode=%s; MaxHealth=%s; MaxEnergy=%s. This is %s", defbatDroidNew.hashCode(), defbatDroidNew.getHealth(), defbatDroidNew.getMaxEnergy(), defbatDroidNew.getDroidDesription()));
		
	}

	private void doSerialization(Droid droid, String filePath) {
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
			 ob= objectOutputStream.readObject();
		} catch (IOException e) {
			LOG.info("Exception in doDeSerialization method");
			e.printStackTrace();
		}
		return ob;
	}
}
