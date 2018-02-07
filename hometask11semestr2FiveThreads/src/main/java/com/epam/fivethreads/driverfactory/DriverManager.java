package com.epam.fivethreads.driverfactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public abstract class DriverManager {
	private static final Logger LOG = Logger.getLogger(DriverManager.class);
	protected static WebDriver driver;
	//protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	//protected static final ThreadLocal<WebDriver> driver = new  ThreadLocal<>();
	//private Map<Long, WebDriver> driverMap = new HashMap<>();


	protected abstract WebDriver createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		//LOG.info(" ---- START DriverManager.getDriver() ----");
		/*long currentThreadID = Thread.currentThread().getId();
		WebDriver driver=driverMap.get(currentThreadID);
		if (null==driver) {
			driverMap.put(currentThreadID, createDriver());
		}
		LOG.info(" ---- currentThreadID = " + currentThreadID);
		LOG.info(" ---- current driver = " + driver);
		LOG.info(" ---- END  DriverManager.getDriver() ---------------------------");
		*/
		if (null == driver) {
			driver = createDriver();
		}
		return driver;
	}
}
