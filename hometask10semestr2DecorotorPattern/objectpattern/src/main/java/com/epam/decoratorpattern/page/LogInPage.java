package com.epam.decoratorpattern.page;

import static com.epam.decoratorpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import com.epam.decoratorpattern.elements.singleelement.Button;
import com.epam.decoratorpattern.elements.singleelement.InputTextField;
import com.epam.decoratorpattern.elements.singleelement.TextField;

public class LogInPage extends AbstractPage {

	private static final Logger LOG = Logger.getLogger(LogInPage.class);

	@FindBy(xpath = "//input[@type='email'][@name='identifier']")
	// @CacheLookup
	// private WebElement logInField;
	private TextField logInField;

	@FindBy(id = "identifierNext")
	// @CacheLookup
	// private WebElement logInNextButton;
	private Button logInNextButton;

	public void openPage() {
		LOG.info("START ---- LogInPage.openPage() ---- ");
		LOG.info(driver);
		driver.get(WEB_SITE_URL);
	}

	public PasswordPage inputLogIn(String userLogin) {
		// logInField.sendKeys(userLogin);
		logInField.type(userLogin);
		logInNextButton.click();
		return new PasswordPage();

	}

}
