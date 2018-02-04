package com.epam.decoratorpattern.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverManager {
	protected static WebDriver driver;

	protected abstract void createDriver();
	

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			createDriver();
		}
		return driver;
	}
}
