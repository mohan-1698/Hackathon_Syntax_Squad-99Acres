package com.hackathon.hcl.Acres_Syntax_Squad.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getTimeout()));
    }

    // Wait for Element Visibility
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for Element Clickable
    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for Element Invisible
    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for URL Contains
    public void waitForUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }

    // Wait for Title Contains
    public void waitForTitleContains(String value) {
        wait.until(ExpectedConditions.titleContains(value));
    }
}