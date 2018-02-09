package com.epam.fivethreads.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.fivethreads.elements.single.Button;
import com.epam.fivethreads.elements.single.TextField;

import static com.epam.fivethreads.constant.Constant.*;

public class DraftsPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(DraftsPage.class);

    @FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
    @CacheLookup
    private TextField sentMessageForm;

    @FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]")
    @CacheLookup
    private Button sentFormButton;

    public void openPage() {
        LOG.info("START ---- DraftsPage.openPage() ---- ");
        driver.get(DRAFTS_URL);

        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

    }

    private WebElement findMessageByText(String messageText) {
        //openPage();
        WebElement element = driver
                .findElement(By.xpath("//div[@role='link'][contains(.,'" + String.format("%s", messageText) + "')]"));
        return element;
    }

    private WebElement findMessageBySubject(String messageSubject) {
        WebElement element = driver
                .findElement(By.xpath("//*[text()='Test']"));
        return element;
    }

    public WebElement findMessageBySubject2(String subject) {
        subject = "Test";
        //WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span"));

        return letter;
    }

    public boolean isMasageFound(String messageText) {
        WebElement elementLinkDiv = findMessageByText(messageText);
        return elementLinkDiv.isDisplayed();
    }

    public WebElement findMessageFirst() {
        WebElement letter = driver.findElement(By.xpath("//div[@gh='mtb']//div[@act='10']"));
        return letter;
    }
        public void sendMasageFound (String messageText){
            LOG.info("START ---- DraftsPage.sendMasageFound() ---- ");
            WebElement elementLinkDiv = findMessageByText(messageText);
            /*
            if (null == elementLinkDiv) {
                elementLinkDiv = findMessageBySubject2(messageText);
            } else if (null == elementLinkDiv) {
                elementLinkDiv = findMessageBySubject(messageText);
            }else if (null == elementLinkDiv){
                elementLinkDiv=findMessageFirst();
        }
        */
            //elementLinkDiv.click();
            LOG.info(" ---- DraftsPage.findMessageByText() ---- Mail is founded=" + elementLinkDiv.toString());
            Actions builder = new Actions(driver);
            builder.moveToElement(elementLinkDiv).click().perform();
            //waitForElementLoad(sentFormButton);
            sentFormButton.click();
        }

    }
