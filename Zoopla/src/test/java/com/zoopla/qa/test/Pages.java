package com.zoopla.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zoopla.qa.Utilities.BrowserUtil;
import com.zoopla.qa.pages.AgentPage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.ListingofAllpropertyPage;
import com.zoopla.qa.pages.PropertyDetailPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pages extends BrowserUtil{
	
	@Test
	public  void inputLocationAndClickSubmit() throws InterruptedException, IOException
	{
		
		HomePage homePage = new HomePage(driver);
		ListingofAllpropertyPage listingsPage;
		AgentPage agentPage;
		PropertyDetailPage propertydetailsPage;
		
		//opening the page
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//clicking on the popup
		homePage.preferedButtonClick();
		
		//Asserting the Title
		String expectedTitle ="Search Property to Buy, Rent, House Prices, Estate Agents";
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
		//Input location London and click submit
		homePage.enterCityName("london");
		//listingsPage=homePage.clickOnSearch();
		
listingsPage=homePage.clickOnSearch();
		
		//clicked on  to highprice
		listingsPage.mostRecentArrow();
		
		//You will get a list of properties on that page.
		listingsPage.getAllTheListings();
		
		//Selecting the fifth property
		 propertydetailsPage =listingsPage.pickingFifthListing();
		 
		 //getting Agent details on next page
		 String agentfromPropertyPage =propertydetailsPage.getAgentName();
		 
		 //click on the name link to get into the agent’s page.
		 agentPage=propertydetailsPage.clickOnAgentName();
		 Thread.sleep(2000);
		 
		 //check that the the properties listed there belong to the same agent selected
		 String agentFromAgentPage=agentPage.getDetailsfromAgentPage();
		Assert.assertTrue(agentfromPropertyPage.contains(agentFromAgentPage));
		 
	}


}
