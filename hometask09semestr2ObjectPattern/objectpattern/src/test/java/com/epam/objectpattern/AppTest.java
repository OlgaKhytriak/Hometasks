package com.epam.objectpattern;

import static com.epam.objectpattern.constant.Constant.DRIVER_PATH;
import static com.epam.objectpattern.constant.Constant.DRIVER_TYPE;
import static com.epam.objectpattern.constant.Constant.GLOBAL_WAIT_TIME;
import static com.epam.objectpattern.constant.Constant.IS_LOGGED_IN_URL;
import static com.epam.objectpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.objectpattern.constant.Constant.*;
import static com.epam.objectpattern.constant.Constant.USER_LOGIN;
import static com.epam.objectpattern.constant.Constant.USER_PASSWORD;
import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.objectpattern.steps.Steps;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

	// private static WebDriver driver;
	private Steps steps;

	public AppTest(String testName) {
		super(testName);
	}

	public static TestSuite suite() {
		return new TestSuite(AppTest.class);
	}

	@BeforeClass(description = "init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void userCanLoginTest() {
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		assertTrue(steps.isUserLoggedIn());
	}

	@Test
	public void userCanCreateNewDraft() {
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		steps.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		steps.openDrafts();
		assertTrue(steps.isUserLoggedIn());
	}

	@Test
	public void draftSentLetterTest() {
		WebDriver driver = steps.getDriver();
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		steps.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		steps.openDrafts();
		/*steps.findMessageInDrafts(MESSAGE_TEXT);
		
		driver.findElement(By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]"));

		WebElement elementTableTr = driver.findElement(
				By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]/parent::td/parent::tr"));
*/
		WebElement elementLinkDiv = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'" + String.format("%s", MESSAGE_TEXT) + "')]"));
		// HERE
		Actions builder = new Actions(driver);
		builder.moveToElement(elementLinkDiv).click().perform();

		WebElement elementSentForm = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		WebElement elementSentFormButton = driver.findElement(By.xpath(
				"//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]"));
		elementSentFormButton.click();
		///
		steps.openSentMail();
		///
		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]"));
		assertTrue("Draft has been sended", (elementsDrafts.size() > 0));

	}

	@AfterClass(description = "close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}

}