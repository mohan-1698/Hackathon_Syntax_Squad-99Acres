package com.hackathon.hcl.Acres_Syntax_Squad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackathon.hcl.Acres_Syntax_Squad.base.BasePage;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Cookie Accept Button
    @FindBy(id = "cookie_set_popup_ok")
    private WebElement cookieAcceptBtn;

    // Buy Option
    @FindBy(id = "inPageSearchForm_0")
    private WebElement buyOption;

    // Search Input
    @FindBy(id = "keyword2")
    private WebElement searchInput;

    // First Suggestion
    @FindBy(xpath = "(//ul[@id='suggestions_custom']//li)[1]")
    private WebElement firstSuggestion;

    // Accept Cookies
    public HomePage acceptCookies() {

        try {
            clickElement(cookieAcceptBtn);
        } catch (Exception e) {
            System.out.println("Cookie popup not displayed");
        }

        return this;
    }

    // Click Buy Option
    public HomePage clickBuyOption() {

        clickElement(buyOption);
        return this;
    }

    // Enter Location
    public HomePage enterLocation() {

        enterText(searchInput, "Hyderabad");
        return this;
    }

    // Select First Suggestion
    public HomePage selectFirstSuggestion() {

        clickElement(firstSuggestion);
        return this;
    }
}