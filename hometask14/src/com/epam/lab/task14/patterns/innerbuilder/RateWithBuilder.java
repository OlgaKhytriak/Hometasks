package com.epam.lab.task14.patterns.innerbuilder;

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
@XmlSeeAlso({ Option.class, MegaBytePrice.class })
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "rate")
public class RateWithBuilder {
	private static Integer idCounter = 0;
	@XmlAttribute
	private Integer id;
	@XmlElement(required = true, name = "name")
	private String name;
	@XmlElement(required = true, name = "provider-name")
	private String providerName;
	@XmlElement(required = true, name = "speed")
	private Double speed;
	@XmlElement
	@XmlElementWrapper(name = "options")
	List<Option> options;
	@XmlElement
	@XmlElementWrapper(name = "prices-per-megabyte")
	List<MegaBytePrice> megaBytePrices;

	private RateWithBuilder() {
		idCounter++;
		this.id = idCounter;
	}

	public static Builder newBuilder() {
		return new RateWithBuilder().new Builder();
	}

	public class Builder {

		private Builder() {
			// !!! private constructor
		}

		public RateWithBuilder build() {
			return RateWithBuilder.this;
		}

		public Builder setName(String name) {
			RateWithBuilder.this.name = name;
			return this;
		}

		public Builder setProviderName(String providerName) {
			RateWithBuilder.this.providerName = providerName;
			return this;
		}

		public Builder setSpeed(Double speed) {
			RateWithBuilder.this.speed = speed;
			return this;
		}

		public Builder setOptions(List<Option> options) {
			RateWithBuilder.this.options = options;
			return this;
		}

		public Builder setMegaBytePrices(List<MegaBytePrice> megaBytePrices) {
			RateWithBuilder.this.megaBytePrices = megaBytePrices;
			return this;
		}
	}

	public String toString() {
		String full = String.format(
				"InternetRate: id= %s | name= %s | providerName = %s | speed = %s | parameters (%s) | MB Prices (%s)",
				id, name, providerName, speed, options.toString(), megaBytePrices.toString());
		return full;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProviderName() {
		return providerName;
	}

	public Double getSpeed() {
		return speed;
	}

	public List<Option> getRateParameters() {
		return options;
	}

	public List<MegaBytePrice> getGigaBytePrices() {
		return megaBytePrices;
	}

}
