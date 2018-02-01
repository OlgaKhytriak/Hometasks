package com.epam.objectpattern;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest extends TestCase {
	private static final String DRIVER_TYPE = "webdriver.chrome.driver";
	private static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
	private static final String WEB_SITE_URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	private static final String MY_LOGIN = "ForHometaskTest";
	private static final String MY_PASSWORD = "12345aKids";
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
		//driver.findElement(By.xpath("//div[@role='button']//span[contains(text(),'Next')]")).click();
		 driver.findElement(By.id("identifierNext")).click();
		WebElement myElement = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", myElement);
		myElement.sendKeys(MY_PASSWORD);
		driver.findElement(By.id("passwordNext")).click();
		//driver.findElement(By.xpath("//div[@role='button'][contains(text(),'COMPOSE')]")).click();
		//driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3'][@role='button']")).click();
		driver.findElement(By.xpath("//div[@role='navigation']/preceding-sibling::div//div[@role='button']")).click();
		
		//WebElement elementToSent = driver
		//		.findElement(By.xpath("//form[@enctype='multipart/form-data']/div[1]/table[1]//textarea"));
		WebElement elementToSent = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//textarea[@name='to']"));	
		elementToSent.sendKeys(SENT_TO);
		elementToSent.click();
		//driver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
		//driver.findElement(By.xpath("//div[@role='textbox']")).click();
		driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")).click();
		
		WebElement elementSubject = driver
				.findElement(By.xpath("//form[@enctype='multipart/form-data']//input[@name='subjectbox']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elementSubject).build().perform();
		elementSubject.sendKeys("Test");
		//WebElement elementMessage = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		//WebElement elementMessage = driver.findElement(By.xpath("//div[@role='textbox']"));
		WebElement elementMessage = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		builder.moveToElement(elementMessage).click().sendKeys(MESSAGE_TEXT).perform();
		//WebElement elementCloser = driver.findElement(By.xpath("//img[@aria-label='Save & Close']"));
		//elementCloser.click();
		elementMessage.sendKeys(Keys.ESCAPE);
		driver.get("https://mail.google.com/mail/u/0/#drafts");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		WebElement elementTableTr = driver
				.findElement(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]/parent::td/parent::tr"));
		WebElement elementLinkDiv = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		builder.moveToElement(elementLinkDiv).click().perform();
		
		//WebElement elementSentButton = driver.findElement(By.xpath(
		//		"//form[@enctype='multipart/form-data']/following-sibling::table//div[@role='button'][contains(@class, 'J-J5-Ji')]"));
		//elementSentButton.click();
		//WebElement elementSentForm = driver.findElement(By.xpath("//div[@role='textbox'][contains(@class, 'editable')] "));
		WebElement elementSentForm = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
		WebElement elementSentFormButton = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]"));
		elementSentFormButton.click();
		//++
		//String keysPressed =  Keys.chord(Keys.CONTROL, Keys.ENTER);
		//elementSentForm.sendKeys(keysPressed) ;
		//++
		driver.get("https://mail.google.com/mail/u/0/#sent");
		//driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/#sent']")).click();
		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'"+String.format("%s", MESSAGE_TEXT)+"')]"));
		assertTrue("Draft has been sended",(elementsDrafts.size()> 0));
		System.out.println("1111111111111111");
	}
	
	@AfterClass
    public void tearDown(){
        if (driver != null) {
          // driver.close();
          //  driver.quit();
//    		"//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']"));
}
	 }

}
