package com.epam.finalproject.tariffbuilder;
import com.epam.finalproject.xml.model.Tariff;
import com.epam.finalproject.xml.model.Tariffs;

public class TriffsBuilder {

	public Tariffs build(){
		Tariffs tariffs = new Tariffs();
		Tariff mtsFamilyTariff=builtTariff(new MTSFamilyTariffBuilder());
		tariffs.add(mtsFamilyTariff);	
		Tariff mtsCompanyTariff=builtTariff(new MTSCompanyTariffBuilder());
		tariffs.add(mtsCompanyTariff);
		Tariff kyivstarFriendsTariff=builtTariff(new KyivstarFriendsTarrifBuilder());
		tariffs.add(kyivstarFriendsTariff);
		Tariff kyivstarCallAbroadTarrif=builtTariff(new KyivstarCallAbroadTarrifBuilder());
		tariffs.add(kyivstarCallAbroadTarrif);	
		return tariffs;
	}
	
	private  Tariff builtTariff(SingleTariffBuilder tariffBuilder) {
		Director director = new Director();
		director.setBuilder(tariffBuilder);
		director.constructTariff();		
		return director.getTariff();
	}
}
