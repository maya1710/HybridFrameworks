package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setupBrowser()
	{
		System.out.println("LOG:INFO - Setting up Browser");
		
		//Config - does not suite for cross browser
		
		//String browserName = ConfigReader.getProperty("browser");
		//String appUrl = ConfigReader.getProperty("url");
		
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
		
		System.out.println("LOG:INFO - Application is up and running");
	}
	
	@AfterMethod
    public void closeBrowser()
    {
    	driver.quit();
    	
    	System.out.println("LOG:INFO - Closing the Browser and application");
    }
}
