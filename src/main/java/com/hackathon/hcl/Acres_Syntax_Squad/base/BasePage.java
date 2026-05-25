package com.hackathon.hcl.Acres_Syntax_Squad.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hackathon.hcl.Acres_Syntax_Squad.utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getTimeout()));
    }

    // Wait for element visibility
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element clickable
    protected void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click Element
    protected void clickElement(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    // Enter Text
    protected void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    // Get Element Text
    protected String getElementText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    // Verify Element Displayed
    protected boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get Current URL
    protected String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    // Get Page Title
    protected String getPageTitle() {
        return driver.getTitle();
    }
}