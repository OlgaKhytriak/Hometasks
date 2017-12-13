package com.epam.finalproject.xml.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "tariffs")
@XmlSeeAlso({ Tariff.class, Parameters.class, CallPrices.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class Tariffs {
	@XmlElement(name = "tariff")
	private List<Tariff> tariffsList;

	public Tariffs() {
		tariffsList = new ArrayList<Tariff>();
	}

	public void add(Tariff tariff) {
		this.tariffsList.add(tariff);
	}

	public int size() {
		return tariffsList.size();
	}

	public Tariff getTariff(int index) {
		return tariffsList.get(index);
	}

	public List<Tariff> getTariffs() {
		return tariffsList;
	}

	public void setTariffs(List<Tariff> tariffs) {
		this.tariffsList = tariffs;
	}

	public String toString() {
		StringBuilder rez = new StringBuilder();
		for (Tariff tariff : tariffsList) {
			rez.append(tariff.toString());
			rez.append("\n");
		}
		return rez.toString();
	}
}
