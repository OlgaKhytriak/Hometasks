package com.epam.objectpattern.driverfactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {
	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;
		if (type.equals(DriverType.CHROME)) {
			driverManager = new ChromeDriverManager();
		} else if (type.equals(DriverType.FIREFOX)) {
			driverManager = new FirefoxDriverManager();
		}
		return driverManager;
	}
}
