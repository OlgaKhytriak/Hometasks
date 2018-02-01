package com.epam.objectpattern.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends AbstractPage{
	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOG = Logger.getLogger(PasswordPage.class);
	//private WebDriver driver;

	@FindBy(xpath = "//input[@type='password'][@name='password']")
	private WebElement passwordField;
	
	@FindBy(id="passwordNext")
	private WebElement passwordNextButton;

	/*
	public PasswordPage(WebDriver driver) {
		LOG.error("START ---- PasswordPage() ---- ");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOG.error(passwordField.toString());
		
		LOG.error("END ---- PasswordPage() ---- ");
	}
	*/

	public void inputPassword(String userPassword) {
		LOG.error("START ---- PasswordPage.inputPassword() ---- ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//waitForElementToLoad(passwordField);
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", passwordField);
		passwordField.sendKeys(userPassword);
		passwordNextButton.click();
		LOG.error("END ---- PasswordPage.inputPassword() ---- ");
	}

}
