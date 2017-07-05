package com.epam.cdp.bdd_task.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    public static Map<String, String> getProperty() {
        Properties prop = new Properties();
        Map<String, String> map = new HashMap<String, String>();
        try (InputStream inputStream = new FileInputStream("config.properties")) {
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some issue finding or loading file....!!! " + e.getMessage());
        }
        for (final Map.Entry<Object, Object> entry : prop.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        return map;
    }
}
