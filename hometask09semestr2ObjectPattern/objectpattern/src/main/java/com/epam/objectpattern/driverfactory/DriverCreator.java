package com.epam.objectpattern.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCreator {

	public WebDriver create(DriverType driverType) {
		WebDriver driver = null;
		if (driverType.equals(DriverType.CHROME)) {
			driver = new ChromeDriver();
		} else if (driverType.equals(DriverType.FIREFOX)) {
			driver = new FirefoxDriver();
		} else if (driverType.equals(DriverType.SAFARI)) {
			driver = new SafariDriver();
		} else if (driverType.equals(DriverType.IEXPLORER)) {
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
}
