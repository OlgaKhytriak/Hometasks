package com.epam.decoratorpattern.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.decoratorpattern.driverfactory.DriverManager;
import com.epam.decoratorpattern.driverfactory.DriverManagerFactory;
import com.epam.decoratorpattern.driverfactory.DriverType;
import com.epam.decoratorpattern.page.*;

import static com.epam.decoratorpattern.constant.Constant.*;

import java.util.concurrent.TimeUnit;

public class Steps {
	private static final Logger LOG = Logger.getLogger(Steps.class);
	private WebDriver driver;
    private DriverManager driverManager;

	public Steps() {
	}

	public void loginGmail(String userLogin, String userPassword) {
		LOG.info("START ---- Steps.loginGmail() ---- ");
		LogInPage logInPage = new LogInPage(driver);
		logInPage.openPage();
		logInPage.inputLogIn(userLogin);
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.inputPassword(userPassword);
	}

	public void openSentMail() {
		LOG.info("START ---- Steps.openSentMail() ---- ");
		SentPage sentPage = new SentPage(driver);
		sentPage.openPage();
	}

	public boolean isUserLoggedIn() {
		LOG.info("START ---- Steps.isUserLoggedIn() ---- ");
		StartPage startPage = new StartPage(driver);
		return startPage.isOpened();
	}

	public void openDrafts() {
		LOG.info("START ---- Steps.openDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		draftsPage.openPage();
	}

	public void createDraft(String messageSentTo, String messageSubject, String messageText) {
		LOG.info("START ---- Steps.createDraft() ---- ");
		StartPage startPage = new StartPage(driver);
		startPage.craeteMessage(messageSentTo, messageSubject, messageText);

	}
	
	public boolean isMessageInDrafts(String messageText) {
		LOG.info("START ---- Steps.isMessageInDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		return draftsPage.isMasageFound(messageText);
		
	}

	public void sendMessageFromDrafts(String messageText) {
		LOG.info("START ---- Steps.sendMessageFromDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		draftsPage.openPage();
		draftsPage.sendMasageFound(messageText);
	}
	
	public boolean isMessageInSent(String messageText) {
		LOG.info("START ---- Steps.isMessageInSent() ---- ");
		SentPage sentPage = new SentPage(driver);
		return sentPage.isMasageFound(messageText);
		
	}
	
	public void initBrowser(DriverType driverType) {
		LOG.info("START ---- Steps.initBrowser() ---- ");
		//System.setProperty(DRIVER_TYPE, DRIVER_PATH);
		//this.driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);		
		this.driver = DriverManagerFactory.getManager(driverType).getDriver();	
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();		
		}

	}

	// --------------Getters and setters-------------
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	

}
