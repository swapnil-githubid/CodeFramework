package tests.ui.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import TestListeners.TestListener;
import base.utils.DriverFactory;
import base.utils.ConfigReader;
import base.utils.EnvironmentFileUtil;
import base.utils.ScreenshotUtil;
import base.utils.WebEventListener;
import pages.ui.BasePage;
import pages.ui.Page;


public class BaseTest {

	public WebDriver driver;
	public Page page;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Logger log = Logger.getLogger(BaseTest.class);
	DriverFactory df;
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser", "platform","env","updateJira","testExecutionId"})
	public void setUpTest(String browser,  @Optional("local") String platform, @Optional("QA") String env,@Optional("false") boolean updateJira,@Optional("0000") String testExecutionId)
	{
		//Fetching Class name for Passing it to BrowserStack Execution.
		String className = this.getClass().getName();
		df = new DriverFactory();
		try {

//			if(platform.equalsIgnoreCase("browserStack") || platform.equalsIgnoreCase("browserStackid"))
//			{
//				
//			}
//			else
//			{
//				driver = df.generateDriver(platform).initDriver(browser);
//			}

			driver = (WebDriver) df.generateDriver(platform); //.initDriver(browser);
			System.out.println(driver);
			System.out.println(df);
			System.out.println(platform);
			System.out.println(browser);
			

//		driver = df.generateDriver(platform).initDriver(browser);

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener(log);
			e_driver.register(eventListener);
			driver = e_driver;
			page=new BasePage(driver);
			//TestListener.setListenerDriver(driver); //Not used anywhere
			//Updating Xray flag for Jira update
			if(updateJira==true) {
				ConfigReader.setValue("updateTestStatus", "true");
				ConfigReader.setValue("TestExecutionID", testExecutionId);
			}
			//Setting Base URL based on Environments
			String value=ConfigReader.getValue(env);
			if(env.equals("STG"))
				ConfigReader.setValue("BASE_URL",value);
			else if(env.equals("DEV"))
				ConfigReader.setValue("BASE_URL",value);
			else if(env.equals("QA"))
				ConfigReader.setValue("BASE_URL",value);
			EnvironmentFileUtil.setUp(browser, platform,env);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Base Test Exception ");
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun=true)
	public void Screenshot()
	{
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun=true)
	public void TearDown()
	{
		driver.quit();
	}

}


//package tests.ui.base;
//
//import java.io.IOException;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import base.utils.ConfigReader;
//import base.utils.DriverFactory;
//import base.utils.EnvironmentFileUtil;
//import base.utils.ScreenshotUtil;
//
//import pages.ui.BasePage;
//import pages.ui.Page;
//
//
//public class BaseTest {
//
//	public WebDriver driver;
//	public  static EventFiringWebDriver e_driver;
//	public Page page;
//
//	public Logger log = Logger.getLogger(BaseTest.class);
//	
//	@BeforeClass(alwaysRun=true)
//	@Parameters({"browser", "platform","env"})
//	public void setUpTest(String browser,  @Optional("local") String platform, @Optional("QA") String env)
//	{
//		
//
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		
//		driver = e_driver;
//		
//		DriverFactory df = new DriverFactory();
//		driver = df.generateDriver(platform).initDriver(browser);
//		page=new BasePage(driver);
//		
//		//TestListener.setListenerDriver(driver);
//		
//		//Setting Base URL based on Environments
//		String value=ConfigReader.getValue(env);
//		
//		if(env.equals("STG"))			
//		ConfigReader.setValue("STGURL",value);
//		else if(env.equals("DEV"))
//			ConfigReader.setValue("DEVURL",value);
//		else if(env.equals("QA"))
//			ConfigReader.setValue("QAURL",value);
//		EnvironmentFileUtil.setUp(browser, platform,env);
//		
//
//	}
//	
//	@AfterMethod(alwaysRun=true)
//	public void Screenshot()
//	{
//		try {
//			ScreenshotUtil.takeScreenshotForAllure(driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//	@AfterClass(alwaysRun=true)
//	public void TearDown()
//	{
//		driver.quit();
//	}
//
//}
