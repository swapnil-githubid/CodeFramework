package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	public WebDriverWait wait;
	
		
	public  Page(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver, 30);

	}
	
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public <TPage extends BasePage>TPage getInstance(Class<TPage> pageClass){
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
