package PageObjectClasses;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.org.apache.bcel.internal.generic.INEG;

import generics.BaseLibrary;
import generics.Driverfactory;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class SearchFlightPOM extends BaseLibrary{
	
	public WebDriver driver;
	public String OriginalTabTitle = "ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels";
	Driverfactory df = new Driverfactory();
	
	
	//public WebDriverWait wait = new WebDriverWait();
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[1]")
	public static WebElement fld_from;
	
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[2]")
	public static WebElement fld_to;
	
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[3]")
	public static WebElement fld_depDate;
	
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[4]")
	public static WebElement fld_retDate;
	
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[5]")
	public static WebElement fld_travellers;
	
	@FindBy(xpath = "(//div[@class='u-ripple'])[1]")
	public static WebElement btn_Search;
	
	@FindBy(xpath = "(//td[@data-date='27042021'])[1]")
	public static WebElement val_depDate;
	
	@FindBy(xpath = "(//td[@data-date='24062021'])[1]")
	public static WebElement val_retDate;
	
	@FindBy(xpath = "(//button[@class='ixi-icon-arrow rd-next'])[2]")
	public static WebElement btn_nextMonth;
	
	@FindBy(xpath = "(//span[@data-val='2'])[1]")
	public static WebElement fld_pasNo;
	
	@FindBy(xpath = "//span[contains(text(),'Round Trip')]")
	public static WebElement fld_RoundTrip;
	
	@FindBy(xpath = "(//div[@class='clear-input ixi-icon-cross'])[1]")
	public static WebElement btn_clrfld1;
	
	@FindBy(xpath = "(//div[@class='clear-input ixi-icon-cross'])[2]")
	public static WebElement btn_clrfld2;
	
	@FindBy(xpath = "//div[@class='stops']/span[@class='checkbox-list'][1]/div[@data-checkboxindex='0']")
	public static WebElement chk_nonStop;
	
	@FindBy(xpath = "//div[@class='active-filter']")
	public static WebElement msg_filter;
	
	@FindBy(xpath = "//div[@class='summary-section']//div[@class='u-text-ellipsis']")
	public static List<WebElement> flightNames;
	
	/*@FindBy(xpath = "//div[@class='u-text-ellipsis']")
	public static List<WebElement> flightNames;
	
	@FindBy(xpath = "//div[@class='u-text-ellipsis']")
	public static List<WebElement> flightNames;*/
	
	@FindBy(xpath = " ")
	public static List<WebElement> flightPrices;
	
	
	public void setup()
	{
		driver = getDriver();
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	/*public void verifyTabTitle()
	{
		String title= driver.getTitle();
		Assert.assertEquals(title,OriginalTabTitle); 
		System.out.println("inside verifyTable method");
	}*/
	
	public void findFlights()
	{
		String searchPageTitle = "New Delhi - Bengaluru, Economy Flights, roundtrip, 27 Apr - 24 Jun";
		System.out.println("Inside flight method...");
		waitTill("3");
		click(fld_RoundTrip);
		click(fld_from);
		click(btn_clrfld1);
		sendKeysToWebElement(fld_from, "New Delhi");
		waitTill("3");
		sendkeyBoardkey(fld_from, Keys.ENTER);
		click(fld_to);
		click(btn_clrfld2);
		sendKeysToWebElement(fld_to, "Bengaluru");
		waitTill("3");
		sendkeyBoardkey(fld_to, Keys.ENTER);
		waitTill("3");
		mouseHover(val_depDate);
		val_depDate.click();
		waitTill("3");
		mouseHover(btn_nextMonth);
		btn_nextMonth.click();
		waitTill("3");
		mouseHover(val_retDate);
		val_retDate.click();
		click(fld_pasNo);
		btn_Search.click();
		waitTill("15");
		String actualsearchPageTitle= driver.getTitle();
		System.out.println(actualsearchPageTitle);
		assertEquals(actualsearchPageTitle,searchPageTitle);
		
	}
	
	public void filterOptions()
	{
		System.out.println("Inside filterOptions");
		waitTill("5");
		click(chk_nonStop);
		boolean filterDisplayed = msg_filter.isDisplayed();
		System.out.println("Filter selected: "+filterDisplayed);
		
	}
	
	public void getFaredetails()
	{
		closeBrowser();
		//ArrayList<WebElement> fnames = new ArrayList<WebElement>();
		//List<WebElement> fname =driver.findElements(By.xpath("//div[@class='u-text-ellipsis']"));
		//fname.get
		
		/*int Airfare ;
		//System.out.println(Airfare);
		for(int i=0;i<flightPrices.size();i++)
		{
			String fare = flightPrices.get(i).getText();
			try {
				Airfare = Integer.parseInt(fare);
			    return true;
			} catch (NumberFormatException e) {
			    System.out.println("Input String cannot be parsed to Integer.");
			}
			 if (fare<700)
			 {
				 String flname = flightNames.get(i).getText();
				 System.out.println("Fligt name is: "+flname+ "and its price: "+ fare);
			 }
			 
			//int fpriceSize = flightPrices.size();
			//int [] Airfare = new int [fpriceSize];
			//for(int j=0;j<fpriceSize; j++)
			//{
			//	Airfare[j] = Integer.parseInt(fare);
			//}
			//
			//if(fare<=7000)
			//{
			//	
			//}
			
			
			
			
			//int Air_fare = Integer.parseInt(fare);
				
			
			
		}*/
		
		
	}
	
	public boolean closeBrowser()
	{
		int Airfare =0;
		for(int i=0;i<flightPrices.size();i++)
		{
			String fare = flightPrices.get(i).getText().trim();
			try {
				Airfare = Integer.parseInt(fare);
				if (Airfare<700)
				 {
					 String flname = flightNames.get(i).getText();
					 System.out.println("Fligt name is: "+flname+ "and its price: "+ fare);
				 }
			    return true;
			} catch (NumberFormatException e) {
			    System.out.println("Input String cannot be parsed to Integer.");
			}
			 
		}
		return true;
		
	}

	
}
