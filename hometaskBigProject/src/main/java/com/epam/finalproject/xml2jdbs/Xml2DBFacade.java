package com.epam.finalproject.xml2jdbs;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.jdbc.service.CallPricesService;
import com.epam.finalproject.jdbc.service.*;
import com.epam.finalproject.jdbc.service.TariffService;
import com.epam.finalproject.xml.model.*;
import com.epam.finalproject.xml.parser.Xml2Object;
import com.epam.finalproject.xml.parser.Xml2ObjectAdapter;


public class Xml2DBFacade implements Xml2DB {
	private final Xml2Object xml2Object;
	private final ModelsTransformer modelsTransformer;
	private final TariffService tariffService;
	private final ParametersService parametersService;
	private final CallPricesService callPricesService;
	private final GeneralService generalService;
	public Xml2DBFacade(){
	xml2Object= new Xml2ObjectAdapter(); 
	modelsTransformer = new ModelsTransformer();
	tariffService = new TariffService();
	parametersService=new ParametersService();
	callPricesService= new CallPricesService();
	generalService=new GeneralService();
	}

	@Override
	public void save2DB(String xmlFilePath) {
		generalService.createAllTables();
		Tariffs tariffs=xml2Object.loadBySAX(Constants.XML_FILE_PATH_TARIFFS);
		for (int i=0; i<tariffs.size();i++) {
			Tariff tariffXML = new Tariff();
			tariffXML=tariffs.getTariff(i);	
			saveOneXMLElement(tariffXML);
		}
	}

	private void saveOneXMLElement(Tariff tariffXML){	
		try {
			tariffService.addTariff(modelsTransformer.getTariff(tariffXML));
			parametersService.addParameters(modelsTransformer.getParameters(tariffXML));
			callPricesService.addCallPrices(modelsTransformer.getCallPrices(tariffXML));
		} catch (Exception e) {
			System.out.println("Exception in Xml2DBAdapter.saveOneXMLElement()");
			e.printStackTrace();
		}
	}
	
	
}
