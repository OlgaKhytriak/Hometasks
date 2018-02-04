package com.epam.decoratorpattern.page;

import static com.epam.decoratorpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.decoratorpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.decoratorpattern.elements.Button;
import com.epam.decoratorpattern.elements.InputTextField;
import com.epam.decoratorpattern.elements.TextField;

public class DraftsPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(DraftsPage.class);

	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
	@CacheLookup
	//private WebElement sentMessageForm;
	private TextField sentMessageForm;
	
	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]")
	@CacheLookup
	//private WebElement sentFormButton;
	private Button sentFormButton;
	
	
	public DraftsPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		LOG.info("START ---- DraftsPage.openPage() ---- ");
		driver.get("https://mail.google.com/mail/u/0/#drafts");
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	private WebElement findMessageByText(String messageText) {
		WebElement element = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'" + String.format("%s", messageText) + "')]"));
		return element;
	}
	

	public boolean isMasageFound(String messageText) {
		WebElement elementLinkDiv = findMessageByText(messageText);
		return elementLinkDiv.isDisplayed();
	}

	public void sendMasageFound(String messageText) {
		LOG.info("START ---- DraftsPage.sendMasageFound() ---- ");
		WebElement elementLinkDiv = findMessageByText(messageText);
		Actions builder = new Actions(driver);
		builder.moveToElement(elementLinkDiv).click().perform();
		sentFormButton.click();
	}

}
