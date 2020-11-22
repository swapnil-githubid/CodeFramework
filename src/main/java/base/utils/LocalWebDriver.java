package base.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import base.utils.ConfigReader;

public class LocalWebDriver implements IDriver {
	
	protected static WebDriver driver = null;

    public CapabilityFactory capabilityFactory = new CapabilityFactory();

	@Override
	public WebDriver initDriver(String browserName) {
		
		if(browserName.equals("firefox"))
		{
			System.setProperty(ConfigReader.getValue("FirefoxDriver"), ConfigReader.getValue("FirefoxDriverPath"));
			FirefoxDriver firefox = new FirefoxDriver(OptionsManager.getFirefoxOptions());
			firefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	firefox.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			firefox.manage().window().maximize();
			firefox.manage().deleteAllCookies();
			driver = firefox;
			return driver;
		}
		if (browserName.equals("chrome"))
		{
		System.setProperty(ConfigReader.getValue("ChromeDriver"), ConfigReader.getValue("ChromeDriverPath"));
			ChromeDriver chrome=new ChromeDriver(OptionsManager.getChromeOptions());
			chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			chrome.manage().window().maximize();
			chrome.manage().deleteAllCookies();
			driver = chrome;
			return driver;

		}
		if (browserName.equals("IE"))
		{
				System.setProperty(ConfigReader.getValue("IEDriver"), ConfigReader.getValue("IEDriverPath"));
				driver=new InternetExplorerDriver(OptionsManager.getIEOptions());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			return driver;
		}
		if (browserName.equals("Edge"))
		{
			System.setProperty(ConfigReader.getValue("EdgeDriver"), ConfigReader.getValue("EdgeDriverPath"));
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			return driver;
		}
		else 
		{
			System.setProperty(ConfigReader.getValue("ChromeDriver"), ConfigReader.getValue("ChromeDriverPath"));
			ChromeDriver chrome=new ChromeDriver();
			chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			chrome.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			chrome.manage().window().maximize();
			chrome.manage().deleteAllCookies();
			return chrome;
		}


	}

}
