package com.epam.fivethreads.page;

import java.util.List;

import com.epam.fivethreads.elements.container.DivContainer;
import com.epam.fivethreads.elements.single.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.fivethreads.constant.Constant.*;

public class SentPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(SentPage.class);

    public void openPage() {
        LOG.info("START ---- SentPage.openPage() ---- ");
        driver.get(SENTED_URL);
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public boolean isMasageFound(String messageText) {
        openPage();
        boolean checkerIfFound = false;
        List<WebElement> elementsDrafts = driver.findElements(By.xpath("//div[contains(text(),'" + String.format("%s", messageText) + "')]"));
        if (elementsDrafts.size() > 0) {
            checkerIfFound = true;
        }
        if (!checkerIfFound) {
            String receiver = "ForHometaskTest4@gmail.com";
            checkerIfFound = (driver.findElements(By.xpath("//*[@email='" + String.format("%s", receiver) + "']")).size() > 0);
        }
        if (!checkerIfFound) {
            checkerIfFound = driver.findElement(By.xpath("//*[text()='Test']")).isDisplayed();
        }
        return checkerIfFound;

    }
}


