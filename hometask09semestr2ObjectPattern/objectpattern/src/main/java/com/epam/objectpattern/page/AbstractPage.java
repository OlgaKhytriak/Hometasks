package com.epam.objectpattern.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	private static final Logger LOG = Logger.getLogger(AbstractPage.class);
	public WebDriver driver;
	public AbstractPage(WebDriver driver) {
		LOG.error("START ---- AbstractPage() ---- ");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		LOG.error("END ---- AbstractPage() ---- ");
	}

	protected boolean isSearchElementDisplayed(WebElement element){
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException e){
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
}
