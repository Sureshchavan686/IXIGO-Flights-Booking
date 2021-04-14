package generics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectClasses.SearchFlightPOM;

public class BaseLibrary extends Driverfactory {

	protected WebDriverWait wait;
	protected JavascriptExecutor jsExecutor;

	public void sendKeysToWebElement(WebElement element, String textToSend) {

		this.waitForElement(element);
		element.clear();
		element.sendKeys(textToSend);

	}

	public WebElement waitForElement(WebElement element) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();

		} catch (Exception e) {

		}
		return element;

	}

	public void click(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			waitForElement(element);
			element.click();
		}

	}

	public void waitTill(String durationInSecond) {
		try {
			long n = (long) Double.parseDouble(durationInSecond);
			Thread.sleep(n * 1000);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void sendkeyBoardkey(WebElement element, Keys keyButton) {

		try {
			this.waitForElement(element);

			element.sendKeys(keyButton);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void mouseHover(WebElement element)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(element).perform();
	}

}
