package com.epam.finalproject.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "tariffs")
@XmlSeeAlso({ Tariff.class, Parameters.class, CallPrices.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class Tariffs {
	@XmlElement(name = "tariff")
		private List<Tariff> tariffs;
		
		public Tariffs(){
			tariffs=new ArrayList<Tariff>();
		}

		public void add(Tariff tariff) {
			this.tariffs.add(tariff);
		}
		
		public List<Tariff> getTariffs() {
			return tariffs;
		}

		public void setTariffs(List<Tariff> tariffs) {
			this.tariffs = tariffs;
		}
		
		public String toString() {
			StringBuilder rez = new StringBuilder();
			for(Tariff tariff:tariffs) {
				rez.append(tariff.toString());
				rez.append("\n");
			}
			return rez.toString();
		}
}
