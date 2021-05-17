package com.zoopla.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.Utilities.BrowserUtil;

public class HomePage extends BrowserUtil {
	WebDriver driver;

	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ui-button-secondary")
	WebElement preferenceButton;

	@FindBy(id = "header-location")
	WebElement cityName;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	public void preferedButtonClick() {
		preferenceButton.click();
	}

	public void enterCityName(String city) {
		cityName.sendKeys(city);

	}

	public ListingofAllpropertyPage clickOnSearch() {
		searchButton.click();
		return new ListingofAllpropertyPage(driver);
	}

}
