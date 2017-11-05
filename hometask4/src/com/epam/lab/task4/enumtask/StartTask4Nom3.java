package com.epam.lab.task4.enumtask;

import com.epam.lab.task4.enumtask.enums.DroidType;
import com.epam.lab.task4.enumtask.menu.EnumeInfoDisplayer;

public class StartTask4Nom3 {

	public static void main(String[] args) {

		EnumeInfoDisplayer enumeInfoDisplayer=new EnumeInfoDisplayer();
		//if (args.length != 1) {
		//	System.err.println("Usage: java Planet &lt;earth_weight&gt;");
		//	System.exit(-1);
		//}
		//double earthWeight = Double.parseDouble(args[0]);
		//double mass = earthWeight / EARTH.surfaceGravity();
		for (DroidType dt : DroidType.values())
			System.out.print(String.format("Your droid is %s with max energy=%s", dt,dt.calcMaxEnergy()));

	}
}
