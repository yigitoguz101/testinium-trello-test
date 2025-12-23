package org.example.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected static String API_KEY;
    protected static String TOKEN;

    @BeforeAll
    static void setup() {

        try {
            Properties properties = new Properties();
            InputStream inputStream =
                    BaseTest.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (inputStream == null) {
                throw new RuntimeException("config.properties file not found");
            }

            properties.load(inputStream);

            API_KEY = properties.getProperty("trello.api.key");
            TOKEN = properties.getProperty("trello.token");

            RestAssured.baseURI = "https://api.trello.com/1";

        } catch (Exception e) {
            throw new RuntimeException("Failed to load Trello configuration", e);
        }
    }
}