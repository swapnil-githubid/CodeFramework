
package TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.utils.ConfigReader;
import base.utils.EnvironmentFileUtil;

public class TestListener  implements ITestListener,IExecutionListener {
	
	static WebDriver listenerDriver;
	@Override
	public synchronized void onTestStart(ITestResult result) {
	try {
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		
		try {
			
			
		} 
	    catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
			
		try {
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public static void setListenerDriver(WebDriver driver) {
		
		listenerDriver=driver;
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExecutionFinish() {
		EnvironmentFileUtil.generateEnvironmentPropFile();
	}

}
