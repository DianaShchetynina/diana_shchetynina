package com.epam.cdp.bdd_task.util;

import java.util.Map;

public class Properties {
    public static Map<String, String> properties;

    public static String getChromeDriverName() {
        return properties.get("chromeDriverName");
    }

    public static String getbaseURL() {
        return properties.get("GMAIL_LOGIN_URL");
    }

    public static String getChromeDriver() {
        return properties.get("chromeDriver");
    }

    public static String getDefaultStory() {
        return properties.get("defaultStory");
    }
}
