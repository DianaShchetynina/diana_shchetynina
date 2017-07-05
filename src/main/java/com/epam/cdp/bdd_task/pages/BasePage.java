package com.epam.cdp.bdd_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage openUrl(String url) {
        webDriver.get(url);
        return this;
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
