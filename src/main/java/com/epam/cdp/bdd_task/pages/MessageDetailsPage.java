package com.epam.cdp.bdd_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageDetailsPage extends BasePage {
    private static final By messageBodyLocator = By.cssSelector("div[dir=\"ltr\"]");
    private static final By subjectLocator = By.cssSelector("h2.hP");

    public MessageDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getMessageBody() {
        return findElement(messageBodyLocator).getText();
    }

    public String getMessageSubject() {
        return findElement(subjectLocator).getText();
    }
}
