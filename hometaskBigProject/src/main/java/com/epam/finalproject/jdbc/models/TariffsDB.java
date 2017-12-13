package com.epam.finalproject.jdbc.models;

import java.util.ArrayList;
import java.util.List;

public class TariffsDB {
	private List<TariffDB> tariffs;

	public TariffsDB() {
		tariffs = new ArrayList<TariffDB>();
	}

	public void add(TariffDB tariff) {
		this.tariffs.add(tariff);
	}

	public List<TariffDB> getTariffs() {
		return tariffs;
	}

	public void setTariffs(List<TariffDB> tariffs) {
		this.tariffs = tariffs;
	}

	public String toString() {
		StringBuilder rez = new StringBuilder();
		for (TariffDB tariff : tariffs) {
			rez.append(tariff.toString());
			rez.append("\n");
		}
		return rez.toString();
	}
}
