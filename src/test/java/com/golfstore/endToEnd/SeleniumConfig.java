package com.golfstore.endToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SeleniumConfig {

    private WebDriver driver;
    private String baseUrl;

    public SeleniumConfig() {
        Properties properties = getProperties();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("selenium.driver.location"));
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chrome\\chromedriver.exe");
        baseUrl = properties.getProperty("http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/");
        driver = new ChromeDriver();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }


}
