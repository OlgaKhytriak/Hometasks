package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class DraftsPage extends AbstractPage{
	private static final Logger LOG = Logger.getLogger(DraftsPage.class);

	public DraftsPage(WebDriver driver) {
		super(driver);
	}
	public void openPage() {
		LOG.error("START ---- DraftsPage.openPage() ---- ");
		driver.get("https://mail.google.com/mail/u/0/#drafts");
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}
}
