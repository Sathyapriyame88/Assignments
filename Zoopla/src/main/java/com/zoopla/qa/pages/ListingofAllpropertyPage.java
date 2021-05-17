package com.zoopla.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListingofAllpropertyPage {
	WebDriver driver;

	public ListingofAllpropertyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "sort-order-dropdown")
	WebElement mostRecent;

	// @FindBy(xpath="//body/div/div/div/main[@data-testid='search-content']/div[1]/div[1]")
	@FindBy(xpath = "//div[starts-with(@id,'listing_')]")
	List<WebElement> listings;//

	public void mostRecentArrow() throws InterruptedException {
		Select sort = new Select(mostRecent);
		sort.selectByVisibleText("Highest price");
		Thread.sleep(2000);

	}

	public void getAllTheListings() {
		System.out.println("All the listings in the page are: " + listings.size());

		for (int i = 0; i < listings.size(); i++) {
			System.out.println("The propery : " + listings.get(i).getText());

		}
	}

	public PropertyDetailPage pickingFifthListing() throws InterruptedException {
		Thread.sleep(2000);
		WebElement fifthListing = listings.get(4)
				.findElement(By.xpath("//body/div/div/div/main[@data-testid='search-content']/div/div/div[5]/div[1]"));
		System.out.println("The fifth listing is : " + fifthListing.getText());
		fifthListing.click();
		System.out.println("The fifth listing is clicked: ");
		System.out.println("");
		return new PropertyDetailPage(driver);
	}

}
