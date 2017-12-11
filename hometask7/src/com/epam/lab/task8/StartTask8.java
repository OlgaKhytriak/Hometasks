package com.epam.lab.task8;

public class StartTask8 {

	public static void main(String[] args) {
		Tasks2And3();
		Task4();
		Task5();
		Task7();

	}

	private static void Tasks2And3() {
		System.out.println("---------------------- Tasks2And3 -------------");
		SimpleDroid simpleDroid = new SimpleDroid();
		AnnotationProcessor annotationProcessor = new AnnotationProcessor();
		annotationProcessor.inspectHealthField(simpleDroid.getClass());
		System.out.println("---------------------------------------");
	}

	private static void Task4() {
		System.out.println("---------------------- Task4 ------------------");
		MethodsInvoker methodsInvoker = new MethodsInvoker();
		SimpleDroid droid = new SimpleDroid(20, 30);
		System.out.println("Before invoking: " + droid.calcLevel(20, 0.5));
		System.out.println("After invoking: " + methodsInvoker.invokeCalcLevelMethod(droid));
		methodsInvoker.invokeSetEnergyMethod(droid);
		System.out.println(String.format("Energy = %s", droid.getEnergy()));

		System.out.println("---------------------------------------");
	}

	private static void Task5() {
		System.out.println("---------------------- Task5 ------------------");
		FieldsSetter fieldsSetter = new FieldsSetter();
		SimpleDroid droid = new SimpleDroid(20, 30);
		System.out.println("Before set: " + droid.getEnergy());
		fieldsSetter.setField(droid, "energy", 555);
		System.out.println("After set: " + droid.getEnergy());
		System.out.println("---------------------------------------");
	}

	private static void Task7() {
		System.out.println("---------------------- Task7 ------------------");
		ClassAnalizer classAnalizer = new ClassAnalizer();
		classAnalizer.analize(DroidsShip.class);
		System.out.println("---------------------------------------");
	}

}
