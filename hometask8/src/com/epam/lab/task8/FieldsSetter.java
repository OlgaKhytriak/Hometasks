package com.epam.lab.task8;

import java.lang.reflect.Field;

public class FieldsSetter {
	public void setField(Object obj, String fieldName, Object value) {
		try {
			Class<?> clazz = obj.getClass();
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			// if (valueClazz.isAssignableFrom(field.getType())) {
			field.set(obj, value);
			// }
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			System.err.println("In FieldsInvoker method  exception. Set is failed");
		}
	}
}
