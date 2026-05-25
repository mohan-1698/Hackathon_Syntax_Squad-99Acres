package com.hackathon.hcl.Acres_Syntax_Squad.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    // ThreadLocal for Parallel Execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize Driver
    public static void initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            driver.set(new ChromeDriver());

            getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(
                            ConfigReader.getTimeout()));
        }
    }

    // Get Driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit Driver
    public static void quitDriver() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}