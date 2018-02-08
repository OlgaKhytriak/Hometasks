package com.epam.fivethreads.page;

import static com.epam.fivethreads.constant.Constant.INBOX_URL;
import static com.epam.fivethreads.constant.Constant.IS_LOGGED_IN_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.fivethreads.elements.single.Button;
import com.epam.fivethreads.elements.single.TextField;

public class StartPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(StartPage.class);

    @FindBy(xpath = "//div[@role='navigation']/preceding-sibling::div//div[@role='button']")
    private Button composeButton;

    @FindBy(xpath = "//form[@enctype='multipart/form-data']//textarea[@name='to']")
    private TextField sentToTextarea;

    @FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
    @CacheLookup
    private TextField messageTexbox;

    @FindBy(xpath = "//form[@enctype='multipart/form-data']//input[@name='subjectbox']")
    private TextField subjectBox;

    @FindBy(css=".Ha")
    private Button composeWindowCloseButton;

    public boolean isOpened() {
        String ss = driver.getCurrentUrl();
        return ss.equals(IS_LOGGED_IN_URL);
    }

    public void openPage() {
        LOG.info("START ---- StartPage.openPage() ---- ");
        driver.get(INBOX_URL);
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }
    public void craeteMessage(String messageSentTo, String messageSubject, String messageText) {
        LOG.info(" ---- StartPage.craeteMessage() ---- ");
        openNewMessageForm();
        fillInMassageFields(messageSentTo, messageSubject, messageText);
    }
    public void craeteDraftMessage(String messageSentTo, String messageSubject, String messageText) {
        LOG.info(" ---- StartPage.craeteMessage() ---- ");
        craeteMessage( messageSentTo,  messageSubject,  messageText);
        closeMessageFormWithotSend();

    }
    private void openNewMessageForm(){
        LOG.info(" ---- StartPage.openNewMessageForm() ---- ");
        composeButton.click();
    }

    private void fillInMassageFields(String messageSentTo, String messageSubject, String messageText) {
        LOG.info(" ---- StartPage.fillInMassageFields() ---- ");
        waitForElementLoad(sentToTextarea);
        sentToTextarea.type(messageSentTo);
        sentToTextarea.click();
        messageTexbox.click();
        waitForElementLoad(subjectBox);
        subjectBox.click();
        subjectBox.type(messageSubject);
        waitForElementLoad(messageTexbox);
        messageTexbox.click();
        messageTexbox.type(messageText);
    }

    private void closeMessageFormWithotSend(){
        LOG.info(" ---- StartPage.closeMessageFormWithotSend() ---- ");
        waitForElementLoad(messageTexbox);
         messageTexbox.type(Keys.ESCAPE);
    }
}
