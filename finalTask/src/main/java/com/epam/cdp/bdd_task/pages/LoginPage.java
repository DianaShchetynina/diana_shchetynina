package com.epam.cdp.bdd_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailLocator;
    private By nextButtonLocator;
    private By passwordLocator;
    private By signInLocator;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        emailLocator = By.id("identifierId");
        nextButtonLocator = By.id("identifierNext");
        passwordLocator = By.cssSelector("input[name=\"password\"]");
        signInLocator = By.id("passwordNext");
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
