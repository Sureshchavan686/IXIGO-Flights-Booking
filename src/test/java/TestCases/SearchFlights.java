/**
 * 
 */
package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjectClasses.SearchFlightPOM;

/**
 * @author Suresh R Chavan
 *
 */
public class SearchFlights extends SearchFlightPOM{
	
	
	
	@Test
	public void searchFlights() throws InterruptedException
	{
		setup();
		findFlights();
		filterOptions();
		getFaredetails();
		System.out.println("Verified");
		
	}
	

}
