package com.epam.lab.task8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAnalizer {

	public void analize(Class<?> clazz) {
		analizeGeneralInformation(clazz);
		analizeFields(clazz);
		analizeClasses(clazz);
		analizeConstructors(clazz);
		analizeMethods(clazz);
		}
	
	private void analizeGeneralInformation(Class<?> clazz) {
		System.out.println(String.format("Class full name: %s", clazz.getName()));
		System.out.println(String.format("Class simple name: %s", clazz.getSimpleName()));
		System.out.println(String.format("Class parent : %s", clazz.getSuperclass().getSimpleName()));
 
	}
	private void analizeConstructors(Class<?> clazz) {
		System.out.println("Constructors:");
		Constructor[] constr=clazz.getDeclaredConstructors();
		for(Constructor cls: constr) {
			System.out.println( String.format("%s", cls.getName()));
		}
		if (0==constr.length) System.out.println("No one");
		
	}
	
	
	private void analizeFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(String.format("Private fields in the class:"));
		for (int i = 0; i < fields.length; i++) {		
				System.out.println(String.format("%s, %s",fields[i].getName(), fields[i].getType().getSimpleName()));				
			}
	}
	private void analizeMethods(Class<?> clazz) {
		System.out.println("Methods:");
		Method[] methods=clazz.getDeclaredMethods();
		for(Method mtd: methods) {
			System.out.println( String.format("%s; retutn : %s", mtd.getName(),mtd.getReturnType().getSimpleName()));
		}
		if (0==methods.length) System.out.println("No one");
		
	}
	private void analizeClasses(Class<?> clazz) {
		System.out.println("All of the classes interfaces, and enums that are explicitly declared:");
		Class<?>[] clazzes=clazz.getDeclaredClasses();
		for(Class<?> cls: clazzes) {
			System.out.println(cls.getName());
		}
		if (0==clazzes.length) System.out.println("No one");
	}
}

//System.out.println(String.format(format, args));