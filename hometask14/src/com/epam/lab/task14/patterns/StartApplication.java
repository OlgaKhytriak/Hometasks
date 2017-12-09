package com.epam.lab.task14.patterns;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.epam.lab.task14.patterns.diffrentExamples.AdapterExamples;
import com.epam.lab.task14.patterns.diffrentExamples.BuilderExamples;

public class StartApplication {
	public static void main(String[] args) throws Exception {
		useBuilderPatterns();
		useAdapterPattern();
		
	}
	
	private static void useBuilderPatterns() {
		BuilderExamples builderExamples = new BuilderExamples();
		System.out.println("--- Inner Builder Example ------------------------------------");
		builderExamples.runExampleInnerBuilder();
		System.out.println("--- Outer Builder Example ------------------------------------");
		builderExamples.runExampleOuterBuilder();
	}
	private static void useAdapterPattern() throws JAXBException, IOException {
		System.out.println("--- Adaper Examples ------------------------------------");
		AdapterExamples adapterExamples = new AdapterExamples();
		System.out.println("             --- Rate.class example ---");
		adapterExamples.runAdapterJAXBForRate();
		System.out.println("             --- Tariff.class example ---");
		adapterExamples.runAdapterJAXBForTariff();
	}
}
