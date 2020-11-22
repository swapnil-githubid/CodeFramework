package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}
	
	
	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try
		{
			waitForElementPresent(locator);
			element=driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while creating element"+locator.toString());
			e.getStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		
		try
		{
			Thread.sleep(20000);
		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while waiting for the element"+ locator.toString());
			System.out.println(e.getStackTrace());
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try
		{
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while waiting for the title"+ title);
			System.out.println(e.getStackTrace());
		}
		
	}

	public List<WebElement> getElements(By locator) {
		try
		{
			waitForElementPresent(locator);
			return driver.findElements(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while getting list of elements"+locator.toString());
			e.getStackTrace();
			return null;
		}
	}

}
