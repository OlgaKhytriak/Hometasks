package com.epam.decoratorpattern.page;

import static com.epam.decoratorpattern.constant.Constant.ALERT_WAIT_TIME;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.decoratorpattern.customfielddecorator.ExtendedFieldDecorator;

public abstract class AbstractPage {
	private static final Logger LOG = Logger.getLogger(AbstractPage.class);
	protected final WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
		
	}
	
	
	//--------------Additional --------------
	public boolean isElementPresent(By locator) {
return driver.findElements(locator).size()>0;}
	
	protected boolean isSearchElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void waitForElementToLoad(WebElement element) {
		int secondsCount = 0;
		boolean isElementShownIndicator = isSearchElementDisplayed(element);
		while (!isElementShownIndicator && secondsCount < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			secondsCount++;
			isElementShownIndicator = isSearchElementDisplayed(element);
		}
		if (!isElementShownIndicator) {
			throw new AssertionError("Element was not shown");
		}
	}
	

		public boolean isAlertPresent() {
			boolean foundAlert = false;
			WebDriverWait wait = new WebDriverWait(driver, ALERT_WAIT_TIME);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				foundAlert = true;
			} catch (TimeoutException eTO) {
				foundAlert = false;
			}
			return foundAlert;
		}
}
