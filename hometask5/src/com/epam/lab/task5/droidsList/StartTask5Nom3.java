package com.epam.lab.task5.droidsList;
import com.epam.lab.task5.droidsShip.models.*;
import java.util.List;

public class StartTask5Nom3 {
 public static void main(String[] args) {
	 System.out.println("  ---- BEGIN StartTask5Nom3 ---");
	List<Droid> droidList=new DroidsList<Droid>();
	BattleDroid battleDroid=new SimpleBattleDroid(10, 20);
	droidList.add(battleDroid);
	RepairDroid repairDroid = new SimpleRepairDroid(10, 30);
	droidList.add(repairDroid);
	BattleDroid droideka=new Droideka(56, 10);
	droidList.add(0, droideka);
	ChargeEnergyDroid chargeDroid=new SimpleChargeEnergyDroid(25, 13);
	droidList.add(3, chargeDroid);
	for (int i=0; i<droidList.size(); i++) {
		Droid dr=droidList.get(i);
		System.out.println(dr.toString());
	}
	System.out.println( "---- END StartTask5Nom3");
	
}
}
