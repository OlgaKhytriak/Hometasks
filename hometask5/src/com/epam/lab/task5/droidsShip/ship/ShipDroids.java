package com.epam.lab.task5.droidsShip.ship;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task5.droidsShip.models.Droid;

public class ShipDroids<T extends Droid> {
	private List<T> sheapList;
	
	ShipDroids(){
		sheapList=new ArrayList<T>();
	}
	
	public void put(T droid) {
		sheapList.add(droid);
	}

	public void get(T droid) {
		sheapList.remove(droid);
	}
	public List<T> getSheapList() {
		return sheapList;
	}

	public void setSheapList(List<T> sheapList) {
		this.sheapList = sheapList;
	}
	
	
}
