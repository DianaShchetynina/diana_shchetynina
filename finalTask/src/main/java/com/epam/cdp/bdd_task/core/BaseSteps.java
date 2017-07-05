package com.epam.cdp.bdd_task.core;

import com.epam.cdp.bdd_task.util.PropertiesReader;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseSteps {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeStory
    public void beforeStory() {
        System.setProperty(PropertiesReader.getPropertyValue("chromeDriverName"), PropertiesReader.getPropertyValue("chromeDriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterStory
    public void afterStory() throws Exception {
        driver.quit();
    }
}
