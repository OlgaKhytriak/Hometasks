package com.epam.lab.task6.number1.ship;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task6.number1.models.interfaces.Droid;

public class ShipDroidsWithGenerics<T extends Droid> {
	private List<T> shipList;

	public ShipDroidsWithGenerics() {
		shipList = new ArrayList<T>();
	}

	public void put(T droid) {
		shipList.add(droid);
	}

	public void get(T droid) {
		shipList.remove(droid);
	}

	public List<T> getShipList() {
		return shipList;
	}

	public void setShipList(List<T> shipList) {
		this.shipList = shipList;
	}

}
