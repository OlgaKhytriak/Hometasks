package com.epam.decoratorpattern.page;

import static com.epam.decoratorpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.decoratorpattern.elements.Button;

public class LogInPage extends AbstractPage {

	private static final Logger LOG = Logger.getLogger(LogInPage.class);

	@FindBy(xpath = "//input[@type='email'][@name='identifier']")
	// @CacheLookup
	private WebElement logInField;

	@FindBy(id = "identifierNext")
	// @CacheLookup
	//private WebElement logInNextButton;
	private Button logInNextButton;

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		LOG.info("START ---- LogInPage.openPage() ---- ");
		driver.get(WEB_SITE_URL);
	}

	public PasswordPage inputLogIn(String userLogin) {
		logInField.sendKeys(userLogin);
		logInNextButton.click();
		return new PasswordPage(driver);

	}

}
