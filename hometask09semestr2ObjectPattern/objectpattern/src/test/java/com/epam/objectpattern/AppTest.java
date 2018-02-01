package com.epam.objectpattern;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest extends TestCase {
	private static final String DRIVER_TYPE = "webdriver.chrome.driver";
	private static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
	private static final String WEB_SITE_URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	private static final String MY_LOGIN = 	"ForHometaskTest";
	private static final String MY_PASSWORD ="12345aKids";
	private static final String SENT_TO = "ForHometaskTest@gmail.com";
	private static final String MESSAGE_TEXT="Message text. Massage text";
	private static WebDriver driver;
	public AppTest(String testName) {
		super(testName);
	}
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty(DRIVER_TYPE, DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(WEB_SITE_URL);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(AppTest.class);
	}

	@Test
	public void testApp() {
		driver.findElement(By.xpath("//input[@type='email'][@name='identifier']")).sendKeys(MY_LOGIN);
				 driver.findElement(By.id("identifierNext")).click();
		WebElement myElement = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", myElement);
		myElement.sendKeys(MY_PASSWORD);
		driver.findElement(By.id("passwordNext")).click();
		
		driver.findElement(By.xpath("//div[@role='navigation']/preceding-sibling::div//div[@role='button']")).click();
		
		
		WebElement elementToSent = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//textarea[@name='to']"));	
		elementToSent.sendKeys(SENT_TO);
		elementToSent.click();
		
		driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")).click();
		
		WebElement elementSubject = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//input[@name='subjectbox']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elementSubject).build().perform();
		elementSubject.sendKeys("Test");
		
		WebElement elementMessage = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		builder.moveToElement(elementMessage).click().sendKeys(MESSAGE_TEXT).perform();
		
		elementMessage.sendKeys(Keys.ESCAPE);
		
		driver.get("https://mail.google.com/mail/u/0/#drafts");
		if (isAlertPresent()) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		
		driver.findElement(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		
		WebElement elementTableTr = driver
				.findElement(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]/parent::td/parent::tr"));
		
		WebElement elementLinkDiv = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		//HERE 
		builder.moveToElement(elementLinkDiv).click().perform();
		
		
		WebElement elementSentForm = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		WebElement elementSentFormButton = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]"));
		elementSentFormButton.click();
		
		driver.get("https://mail.google.com/mail/u/0/#sent");
		
		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		assertTrue("Draft has been sended",(elementsDrafts.size()> 0));
		
	}
	
	private boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	@AfterClass
    public void tearDown(){
        if (driver != null) {
          // driver.close();
          //  driver.quit();

}
	 }

}