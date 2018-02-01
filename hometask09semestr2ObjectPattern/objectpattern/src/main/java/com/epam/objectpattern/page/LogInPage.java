package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage extends AbstractPage{
	public LogInPage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOG = Logger.getLogger(LogInPage.class);
//private WebDriver driver;

@FindBy(xpath="//input[@type='email'][@name='identifier']")
//@CacheLookup
private WebElement logInField;

@FindBy(id="identifierId")
//@CacheLookup
private WebElement logInNextButton;

/*
	public LogInPage(WebDriver driver) {
		LOG.error("START ---- LogInPage() ---- ");
		PageFactory.initElements(driver, this);
		LOG.error(logInField.toString());
		LOG.error(logInNextButton.toString());
		this.driver=driver;
		LOG.error("END ---- LogInPage() ---- ");
	}
*/
	public void openPage() {
		LOG.error("START ---- LogInPage.openPage() ---- ");
		driver.get(WEB_SITE_URL);
		LOG.error("FINISH ---- LogInPage.openPage() ---- ");
	}

	public void inputLogIn(String userLogin) {
		LOG.error("START ---- LogInPage.inputLogIn() ---- ");
		logInField.sendKeys(userLogin);
		logInNextButton.click();
		LOG.error("FINISH ---- LogInPage.inputLogIn() ---- ");
		
	}

}
