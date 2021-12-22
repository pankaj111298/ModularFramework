package com.tests;

import Pages.LoginPage;
import commonLibs.Utils.PropReader;
import commonLibs.implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    CommonDriver commonDriver;
    WebDriver driver;
    PropReader reader;
    Properties properties;
    String currentWorkingDirectory;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        currentWorkingDirectory = System.getProperty("user.dir");
        reader = new PropReader();
        try {
            properties = PropReader.getProperties("/src/test/resources/config/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        commonDriver = new CommonDriver(properties.getProperty("browserName"));
        driver = commonDriver.getDriver();
        commonDriver.navigateToURL(properties.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        commonDriver.closeBrowser();
    }
}
