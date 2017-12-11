package com.epam.lab.task14.patterns;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import com.epam.lab.task14.patterns.examples.AdapterExamples;
import com.epam.lab.task14.patterns.examples.BuilderExamples;
import com.epam.lab.task14.patterns.examples.CompositeExample;
import com.epam.lab.task14.patterns.examples.PrototypeExamples;

public class Appl {
	public static void main(String[] args) throws Exception {
		useBuilderPatterns();
		useAdapterPattern();
		useCompositePattern();
		usePrototypePattern();
	}
	
	private static void useBuilderPatterns() {
		BuilderExamples builderExamples = new BuilderExamples();
		System.out.println("---------- Inner Builder Example ------------------------------------");
		builderExamples.runExampleInnerBuilder();
		System.out.println("---------- Outer Builder Example ------------------------------------");
		builderExamples.runExampleOuterBuilder();
	}
	private static void useAdapterPattern() throws JAXBException, IOException {
		System.out.println("---------- Adaper Examples ------------------------------------");
		AdapterExamples adapterExamples = new AdapterExamples();
		System.out.println("             --- Rate.class example ---");
		adapterExamples.runAdapterJAXBForRate();
		System.out.println("             --- Tariff.class example ---");
		adapterExamples.runAdapterJAXBForTariff();
	}
	
	private static void useCompositePattern() {
		System.out.println("---------- Composite Examples ------------------------------------");
		CompositeExample compositeExample = new CompositeExample();
		compositeExample.runTourExample();
	}
	private static void usePrototypePattern() {
		System.out.println("---------- Prototype Examples ------------------------------------");
		PrototypeExamples prototypeExamples = new PrototypeExamples();
		System.out.println("-----------CLONE --------");
		prototypeExamples.runCopyExample();
		System.out.println("-----------COPY --------");
		prototypeExamples.runCloneExample();
	}
	
}
