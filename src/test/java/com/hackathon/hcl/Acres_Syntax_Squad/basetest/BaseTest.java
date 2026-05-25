package com.hackathon.hcl.Acres_Syntax_Squad.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hackathon.hcl.Acres_Syntax_Squad.utils.DriverFactory;
import com.hackathon.hcl.Acres_Syntax_Squad.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Initialize Driver
        DriverFactory.initDriver(ConfigReader.getBrowser());

        // Get Driver Instance
        driver = DriverFactory.getDriver();

        // Launch Application
        driver.get(ConfigReader.getBaseUrl());

        // Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        // Quit Driver
        DriverFactory.quitDriver();
    }
}