package com.epam.cdp.bdd_task.pages;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagePage extends BasePage {
    private By openMessagePopupLocator = By.cssSelector("div[class='T-I J-J5-Ji T-I-KE L3']");
    private By recipientLocator = By.cssSelector("textarea.vO");
    private By subjectLocator = By.cssSelector("input[name=\"subjectbox\"]");
    private By messageTextLocator = By.cssSelector("div.editable");
    private By sendMessageLocator = By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3");
    private By moreLocator = By.cssSelector("span.CJ");
    private By allMessageLocator = By.cssSelector("a[href=\"https://mail.google.com/mail/u/0/#all\"]");
    private By messageLocator;

    public MessagePage(WebDriver webDriver) {
        super(webDriver);

    }

    public MessagePage sendMessage(String recipient, String subject, String text) {
        findElement(openMessagePopupLocator).click();
        findElement(recipientLocator).sendKeys(recipient);
        findElement(subjectLocator).sendKeys(subject);
        findElement(messageTextLocator).sendKeys(text);
        findElement(sendMessageLocator).click();

        return this;
    }

    public MessagePage openAllMessage() {
        findElement(moreLocator).click();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(allMessageLocator)).click();
        return this;
    }

    public MessagePage openSentMessage(String sender) {
        messageLocator = By.xpath("(//*[@class='yW']/span[text()='" + sender + "'])[1]");
        findElement(messageLocator).click();
        return this;
    }
}
