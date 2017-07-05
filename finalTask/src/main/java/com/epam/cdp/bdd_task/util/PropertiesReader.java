package com.epam.cdp.bdd_task.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;

    public static String getPropertyValue(String name) {
        if (properties == null) {
            properties = new Properties();

            try (InputStream input = new FileInputStream("config.properties")) {
                properties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties.getProperty(name);
    }
}
