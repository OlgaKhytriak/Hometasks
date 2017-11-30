package com.epam.finalproject.model;

import java.util.List;

public class Tariff {
	String name;
	String operatorName;
	Integer payroll;
	Integer smsPrice;
	List<CallPrice> callPrices;
	List<Parameter> parameters;
}
