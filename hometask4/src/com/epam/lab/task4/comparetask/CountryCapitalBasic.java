package com.epam.lab.task4.comparetask;

public class CountryCapitalBasic implements Comparable<CountryCapitalBasic> {
	private String capital;
	protected String country;

	public CountryCapitalBasic() {
	}

	public CountryCapitalBasic(String country, String capital) {
		this.capital = capital;
		this.country = country;
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

	@Override
	public int compareTo(CountryCapitalBasic o) {
		return country.compareTo(o.country);
	}
}
