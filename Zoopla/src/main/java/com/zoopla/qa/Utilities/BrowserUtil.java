package com.zoopla.qa.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	
		public WebDriver driver;
		/*@BeforeMethod
		@Parameters("browser")
			public  void setUp(String browser) {
			if(browser.contentEquals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		    }
			else if(browser.contentEquals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
		
			
		}*/
		
		
		
		@BeforeTest
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		@AfterSuite
		public void qiut()
		{
			driver.close();
			//driver.quit();
		}
	}


