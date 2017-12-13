package com.epam.finalproject.jdbc.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityField {
	String value() default "null";
	String type() default "VARCHAR(45)";
}
