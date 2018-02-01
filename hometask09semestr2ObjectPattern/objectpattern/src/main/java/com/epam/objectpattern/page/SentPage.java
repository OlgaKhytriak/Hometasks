package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class SentPage extends AbstractPage{
	private static final Logger LOG = Logger.getLogger(SentPage.class);

	public SentPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void openPage() {
		LOG.error("START ---- SentPage.openPage() ---- ");
		driver.get("https://mail.google.com/mail/u/0/#sent");
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}
}
