package com.epam.objectpattern;

import static com.epam.objectpattern.constant.Constant.DRIVER_PATH;
import static com.epam.objectpattern.constant.Constant.DRIVER_TYPE;
import static com.epam.objectpattern.constant.Constant.GLOBAL_WAIT_TIME;
import static com.epam.objectpattern.constant.Constant.IS_LOGGED_IN_URL;
import static com.epam.objectpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.objectpattern.constant.Constant.SENT_TO;
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
	
	//private static WebDriver driver;
	private Steps steps;

	public AppTest(String testName) {
		super(testName);
	}
	public static TestSuite suite() {
		return new TestSuite(AppTest.class);
	}

	@BeforeClass(description="init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	@Test
	public void userCanLoginTest() {	
		steps.loginGmail(USER_LOGIN,USER_PASSWORD);
		assertTrue(steps.isUserLoggedIn(IS_LOGGED_IN_URL));
	}
	
	@Test
	public void draftSentLetterTest() {
		WebDriver driver=steps.getDriver();
		steps.loginGmail(USER_LOGIN,USER_PASSWORD);
		/*
		driver.findElement(By.xpath("//input[@type='email'][@name='identifier']")).sendKeys(USER_LOGIN);
		driver.findElement(By.id("identifierNext")).click();
		WebElement myElement = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", myElement);
		myElement.sendKeys(USER_PASSWORD);
		driver.findElement(By.id("passwordNext")).click();
*/
		driver.findElement(By.xpath("//div[@role='navigation']/preceding-sibling::div//div[@role='button']")).click();

		WebElement elementToSent = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//textarea[@name='to']"));
		elementToSent.sendKeys(SENT_TO);
		elementToSent.click();

		driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"))
				.click();

		WebElement elementSubject = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//input[@name='subjectbox']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elementSubject).build().perform();
		elementSubject.sendKeys("Test");

		WebElement elementMessage = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		builder.moveToElement(elementMessage).click().sendKeys(MESSAGE_TEXT).perform();

		elementMessage.sendKeys(Keys.ESCAPE);

		driver.get("https://mail.google.com/mail/u/0/#drafts");
		if (steps.isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		driver.findElement(By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]"));

		WebElement elementTableTr = driver.findElement(
				By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]/parent::td/parent::tr"));

		WebElement elementLinkDiv = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'" + String.format("%s", MESSAGE_TEXT) + "')]"));
		// HERE
		builder.moveToElement(elementLinkDiv).click().perform();

		WebElement elementSentForm = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		WebElement elementSentFormButton = driver.findElement(By.xpath(
				"//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]"));
		elementSentFormButton.click();

		driver.get("https://mail.google.com/mail/u/0/#sent");

		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'" + String.format("%s", MESSAGE_TEXT) + "')]"));
		assertTrue("Draft has been sended", (elementsDrafts.size() > 0));

	}
	
	@AfterClass(description="close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}
	
	

	

}