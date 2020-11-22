package com.test.ProblemStatements;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import tests.ui.base.BaseTest;

@Epic("Epic Description Goes Here")
public class ProblemStatement002 extends BaseTest{


	@BeforeMethod(alwaysRun=true)
	public void beforeTest () throws InterruptedException {
		try{
			String url = ConfigReader.getValue("BASE_URL");
			System.out.println("BASE_URL: "+url);
		
			System.out.println("driver: "+driver);
			
		driver.get(url);	 
		Thread.sleep(20000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("US-XYZ: Story Description")	
	@Description("Story Description goes here.")
	@Parameters({ "platform", "browser" })
	@Test(description="Test Description goes here", groups = { "Regression" })
	public void validateCartPage() 
	{	  	
		
	}
	
		
}

