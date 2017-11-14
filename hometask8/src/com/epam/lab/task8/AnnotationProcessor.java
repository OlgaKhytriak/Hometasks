package com.epam.lab.task8;

import java.lang.reflect.Field;

public class AnnotationProcessor {
 public void inspectHealthField(Class<?> clazz) {
	 Field[] fields=clazz.getDeclaredFields();
	 for (int i=0;i<fields.length;i++) {
		 if (fields[i].isAnnotationPresent(HealthField.class)) {
			 System.out.println(fields[i].getName());
		 }
	 }
 }
}
