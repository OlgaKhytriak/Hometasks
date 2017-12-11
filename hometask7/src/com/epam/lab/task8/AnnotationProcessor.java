package com.epam.lab.task8;

import java.lang.reflect.Field;

public class AnnotationProcessor {
	public void inspectHealthField(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();
		System.out.println(String.format("Fields in the class [%s] that were annotate by @[%s] annotation:",
				clazz.getSimpleName(), HealthField.class.getSimpleName()));
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(HealthField.class)) {
				System.out.println("Annotation name:");
				System.out.println(fields[i].getName());
				HealthField fieldAnnotations = fields[i].getDeclaredAnnotation(HealthField.class);
				System.out.println(String.format("Basic value= %s", fieldAnnotations.basicValue()));
			}
		}
	}

}
