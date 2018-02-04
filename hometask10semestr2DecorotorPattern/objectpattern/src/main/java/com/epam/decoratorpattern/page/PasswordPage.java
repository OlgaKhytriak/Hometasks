package com.epam.decoratorpattern.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.decoratorpattern.elements.Button;

public class PasswordPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(PasswordPage.class);

	@FindBy(xpath = "//div[@id='password']//input[@name='password']")
	private WebElement passwordField;

	@FindBy(id = "passwordNext")
	//private WebElement passwordNextButton;
	private Button passwordNextButton;

	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	public StartPage inputPassword(String userPassword) {
		LOG.info("START ---- PasswordPage.inputPassword() ---- ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// waitForElementToLoad(passwordField);
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", passwordField);
		passwordField.sendKeys(userPassword);
		// js.executeScript("elem=arguments[0]; elem.setAttribute('type','password'); ",
		// passwordField);
		passwordNextButton.click();
		return new StartPage(driver);

	}

}
