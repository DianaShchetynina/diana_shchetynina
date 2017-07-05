package com.epam.cdp.bdd_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailLocator = By.id("identifierId");
    private By nextButtonLocator = By.id("identifierNext");
    private By passwordLocator = By.cssSelector("input[name=\"password\"]");
    private By signInLocator = By.id("passwordNext");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage typeEmail(String email) {
        findElement(emailLocator).sendKeys(email);
        findElement(nextButtonLocator).click();
        return this;
    }

    public LoginPage typePassword(String password) {
        findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPage signIn() {
        findElement(signInLocator).click();
        return this;
    }
}
