package com.epam.finalproject.xml2jdbs;

import com.epam.finalproject.jdbc.model.CallPricesDB;
import com.epam.finalproject.jdbc.model.ParametersDB;
import com.epam.finalproject.jdbc.model.TariffDB;
import com.epam.finalproject.xml.model.Tariff;

public class ModelsTransformer {

	public TariffDB getTariff(Tariff tariffXML) {
		TariffDB tariffDB = new TariffDB();
		tariffDB.setId(tariffXML.getId());
		tariffDB.setTariffName(tariffXML.getTariffName());
		tariffDB.setOperatorName(tariffXML.getOperatorName());
		tariffDB.setSmsPrice(tariffXML.getSmsPrice());
		tariffDB.setParametersId(tariffXML.getParameters().getParametersId());
		tariffDB.setCallPricesId(tariffXML.getCallPrices().getCallPriceId());
		return tariffDB;

	}

	public ParametersDB getParameters(Tariff tariffXML) {
		ParametersDB parametersDB = new ParametersDB();
		parametersDB.setId(tariffXML.getParameters().getParametersId());
		parametersDB.setFavouriteNumbers(tariffXML.getParameters().getFavouriteNumbers());
		parametersDB.setInternet3G(tariffXML.getParameters().isInternet3G());
		parametersDB.setHomeInternet(tariffXML.getParameters().isHomeInternet());
		return parametersDB;
	}

	public CallPricesDB getCallPrices(Tariff tariffXML) {
		CallPricesDB callPricesDB = new CallPricesDB();
		callPricesDB.setId(tariffXML.getCallPrices().getCallPriceId());
		callPricesDB.setInsideNetwork(tariffXML.getCallPrices().getInsideNetwork());
		callPricesDB.setOutsideNetwork(tariffXML.getCallPrices().getOutsideNetwork());
		callPricesDB.setLandlinePhone(tariffXML.getCallPrices().getLandlinePhone());
		return callPricesDB;

	}

}
