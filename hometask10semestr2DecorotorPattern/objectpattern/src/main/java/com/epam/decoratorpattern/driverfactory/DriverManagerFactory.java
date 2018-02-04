package com.epam.decoratorpattern.driverfactory;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {
	// private static DriverManagerFactory driverManagerFactory=null;
	private static DriverManager driverManager;

	private DriverManagerFactory() {
	}

	public static DriverManager getManager(DriverType type) {
		if (null == driverManager) {
			// DriverManager driverManager = null;
			if (type.equals(DriverType.CHROME)) {
				driverManager = new ChromeDriverManager();
			} else if (type.equals(DriverType.FIREFOX)) {
				driverManager = new FirefoxDriverManager();
			}
			;
		}
		return driverManager;
	}
}
