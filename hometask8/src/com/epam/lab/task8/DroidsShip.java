package com.epam.lab.task8;
import java.util.ArrayList;
import java.util.List;


public class DroidsShip<T>{
	private List<T> shipList;
	private int size;
	private String shipName;

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

}
