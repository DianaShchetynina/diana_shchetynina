package com.epam.cdp.bdd_task.core;

import com.epam.cdp.bdd_task.util.Constants;
import com.epam.cdp.bdd_task.util.Properties;
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
        System.setProperty(Properties.getChromeDriverName(), Properties.getChromeDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT_IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterStory
    public void afterStory() throws Exception {
        driver.quit();
    }
}
