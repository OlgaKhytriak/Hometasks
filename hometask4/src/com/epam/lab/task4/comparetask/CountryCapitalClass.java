package com.epam.lab.task4.comparetask;

public class CountryCapitalClass implements Comparable<CountryCapitalClass>{
	private String capital;
	private String country;

	public CountryCapitalClass() {
	}

	public CountryCapitalClass(String capital, String country) {
		this.capital = capital;
		this.country = country;
	}
	
	@Override
	public int compareTo(CountryCapitalClass o) {
		return country.compareTo(o.country);		
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
