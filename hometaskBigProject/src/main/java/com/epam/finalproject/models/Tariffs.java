package com.epam.finalproject.models;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlSeeAlso({ Tariff.class, Parameters.class, CallPrices.class })
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "tariffs")
public class Tariffs {
		@XmlElement(name = "tariff")
		private List<Tariff> tariffs;

		public List<Tariff> getTariffs() {
			return tariffs;
		}

		public void setTariffs(List<Tariff> tariffs) {
			this.tariffs = tariffs;
		}
}
