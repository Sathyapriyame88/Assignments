package com.zoopla.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage {

	WebDriver driver;

	public AgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//h1[@class=\"bottom-half\"]//b[1]")
	//WebElement agentDetails;
	
//	@FindBy(xpath=" //body//div//h1[1]")
//	WebElement agentDetails;
	@FindBy(xpath="//body/div[3]/div[2]/div[1]/div[1]/div[1]/h1[1]/a")
	WebElement agentDetails;
	

	public String getDetailsfromAgentPage() {
		String agentName = agentDetails.getText();
		System.out.println("agentNameDetailsfrom agent page: " + agentName);

		return agentName;
	}
}
