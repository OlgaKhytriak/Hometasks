package com.epam.lab.task8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodsInvoker {

	public int invokeCalcLevelMethod(Object obj) {
		int level = 0;
		Class<?>[] paramTypes = new Class[] { int.class, double.class };
		Object[] args = new Object[] { new Integer(555), new Double(0.22) };
		try {
			Class<?> clazz = Class.forName("com.epam.lab.task8.SimpleDroid");
			Method method = clazz.getDeclaredMethod("calcLevel", paramTypes);
			method.setAccessible(true);
			level = (int) method.invoke(obj, args);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.err.println("In InvokeCalcLevelMethod method  exception. Set is failed");
		}
		return level;
	}
	
	public void invokeSetEnergyMethod(Object obj) {
		Class<?>[] paramTypes = new Class[] {int.class};
		Object[] args = new Object[] {new Integer(333)};
		try {
			Class<?> clazz = Class.forName("com.epam.lab.task8.SimpleDroid");
			Method method = clazz.getDeclaredMethod("setEnergy", paramTypes);
			method.setAccessible(true);
			method.invoke(obj, args);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.err.println("In invokeSetEnergyMethod method  exception. Set is failed");
		}
	}	
}
