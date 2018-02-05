package com.epam.decoratorpattern.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.decoratorpattern.driverfactory.DriverManagerFactory;
import com.epam.decoratorpattern.driverfactory.DriverType;
import com.epam.decoratorpattern.page.DraftsPage;
import com.epam.decoratorpattern.page.LogInPage;
import com.epam.decoratorpattern.page.PasswordPage;
import com.epam.decoratorpattern.page.SentPage;
import com.epam.decoratorpattern.page.StartPage;

public class Steps {
	private static final Logger LOG = Logger.getLogger(Steps.class);
	protected WebDriver driver;

	public Steps() {
	}

	public void loginGmail(String userLogin, String userPassword) {
		LOG.info("START ---- Steps.loginGmail() ---- ");
		LogInPage logInPage = new LogInPage();
		logInPage.openPage();
		PasswordPage passwordPage = logInPage.inputLogIn(userLogin);
		// PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.inputPassword(userPassword);
	}

	public void openSentMail() {
		LOG.info("START ---- Steps.openSentMail() ---- ");
		SentPage sentPage = new SentPage();
		sentPage.openPage();
	}

	public boolean isUserLoggedIn() {
		LOG.info("START ---- Steps.isUserLoggedIn() ---- ");
		StartPage startPage = new StartPage();
		return startPage.isOpened();
	}

	public void openDrafts() {
		LOG.info("START ---- Steps.openDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		draftsPage.openPage();
	}

	public void createDraft(String messageSentTo, String messageSubject, String messageText) {
		LOG.info("START ---- Steps.createDraft() ---- ");
		StartPage startPage = new StartPage();
		startPage.craeteMessage(messageSentTo, messageSubject, messageText);

	}

	public boolean isMessageInDrafts(String messageText) {
		LOG.info("START ---- Steps.isMessageInDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		return draftsPage.isMasageFound(messageText);

	}

	public void sendMessageFromDrafts(String messageText) {
		LOG.info("START ---- Steps.sendMessageFromDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		draftsPage.openPage();
		draftsPage.sendMasageFound(messageText);
	}

	public boolean isMessageInSent(String messageText) {
		LOG.info("START ---- Steps.isMessageInSent() ---- ");
		SentPage sentPage = new SentPage();
		return sentPage.isMasageFound(messageText);

	}

	public void initBrowser(DriverType driverType) {
		LOG.info("START ---- Steps.initBrowser() ---- ");
		this.driver = DriverManagerFactory.getDriver(driverType);
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
