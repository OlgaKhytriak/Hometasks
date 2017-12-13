package com.epam.finalproject.jdbc.service;

public class GeneralService {
	private final TariffService tariffService;
	private final ParametersService parametersService;
	private final CallPricesService callPricesService;

	public GeneralService() {
		tariffService = new TariffService();
		parametersService = new ParametersService();
		callPricesService = new CallPricesService();
	}
	
	public void dropAllTables() {
		try {
			tariffService.deleteTableFromDB();
			parametersService.deleteTableFromDB();
			callPricesService.deleteTableFromDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void createAllTables() {
		try {
			tariffService.createTableInDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			parametersService.createTableInDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			callPricesService.createTableInDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
