package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjectClasses.SearchFlightPOM;

public class Driverfactory {
	
	public static WebDriver driver;
	public static SearchFlightPOM flightSearch;
	
	public WebDriver getDriver()
	{
		try
		{
			if(driver== null)
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		
		finally
		{
			flightSearch = PageFactory.initElements(driver,SearchFlightPOM.class);
		}
		
		return driver;
	}
	
}