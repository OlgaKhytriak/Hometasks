package com.epam.lab.task5.droidsShip.ship;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task5.droidsShip.models.Droid;

public class ShipDroidsWithWildCard {

	private List<Droid> shipList;
	
	public ShipDroidsWithWildCard(){
		shipList=new ArrayList<>();
	}
	public void putAll(List<? extends Droid> droidsList) {
		shipList.addAll(droidsList);
	}
	public void put(Droid droid) {
		shipList.add(droid);
	}

	public void get(Droid droid) {
		shipList.remove(droid);
	}
	public List<Droid> getShipList() {
		return shipList;
	}

	public void setShipList(List<Droid> shipList) {
		this.shipList = shipList;
	}
	
	


}
