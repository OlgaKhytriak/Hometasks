package com.epam.lab.task6.number2.ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task6.number2.models.interfaces.Droid;

public class DroidsShip<T extends Droid> implements Serializable{
	private List<T> shipList;

	public DroidsShip() {
		shipList = new ArrayList<T>();
	}
	public DroidsShip(int n) {
		shipList = new ArrayList<T>(n);
	}
	public int size() {
		return shipList.size();
	}

	public void put(T droid) {
		shipList.add(droid);
	}

	public T get(int index) {
		return shipList.get(index);
	}

	public void delete(int index) {
		shipList.remove(index);
	}

	public List<T> getShipList() {
		return shipList;
	}

	public void setShipList(List<T> shipList) {
		this.shipList = shipList;
	}

}
