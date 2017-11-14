package com.epam.lab.task8;

public class StartTask8 {

	public static void main(String[] args) {
		
		SimpleDroid simpleDroid = new SimpleDroid();
		AnnotationProcessor annotationProcessor = new AnnotationProcessor();
		annotationProcessor.inspectHealthField(simpleDroid.getClass());
	}

}
