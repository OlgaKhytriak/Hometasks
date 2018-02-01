package com.epam.objectpattern.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.objectpattern.page.LogInPage;
import com.epam.objectpattern.page.*;
import static com.epam.objectpattern.constant.Constant.*;

import java.util.concurrent.TimeUnit;

public class Steps {
	private static final Logger LOG = Logger.getLogger(Steps.class);
	private WebDriver driver;
	
	public Steps() {	
	}

	public void loginGmail(String userLogin, String userPassword) {
		LOG.error("START ---- Steps.loginGmail() ---- ");
		
		LogInPage logInPage=new LogInPage(driver);
		logInPage.openPage();
		logInPage.inputLogIn(userLogin);
		
		PasswordPage passwordPage=new  PasswordPage(driver);
		passwordPage.inputPassword(userPassword);

		LOG.error("FINISH ---- Steps.loginGmail() ---- ");
	}

	public boolean isUserLoggedIn(String isLoggedInUrl) {
		String ss = driver.getCurrentUrl();
		return ss.equals(isLoggedInUrl);
	}

	public void initBrowser() {
		LOG.error("START ---- Steps.initBrowser() ---- ");
		System.setProperty(DRIVER_TYPE, DRIVER_PATH);
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
		LOG.error("FINISH ---- Steps.initBrowser() ---- ");
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}

	}
	
	//--------------Getters and setters-------------
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	//--------------Additional --------------
	public boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

}
