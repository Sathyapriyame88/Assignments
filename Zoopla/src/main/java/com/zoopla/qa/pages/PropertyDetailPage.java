package com.zoopla.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailPage {
	WebDriver driver;

	public PropertyDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='View agent properties']")
	WebElement viewAgentProperties;
	@FindBy(xpath = "//body/div[@id='__next']/main[@id='main-content']/div[1]/div[10]/div[1]/div[1]/div[1]/h3[1]")
	WebElement agentName;
	//@FindBy(xpath = "//div[@data-testid='agent-details']//h3[1]")
//	WebElement agentName;
	

	public String getAgentName() {
		String agentNameDetails = agentName.getText();
		System.out.println("agentNameDetails from propertydetailsPage : " + agentNameDetails);
		return agentNameDetails;

	}

	public AgentPage clickOnAgentName() {
		viewAgentProperties.click();
		return new AgentPage(driver);
	}

}
