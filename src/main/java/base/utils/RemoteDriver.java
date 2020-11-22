package base.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriver implements IDriver {
	
	protected static RemoteWebDriver driver = null;

    public CapabilityFactory capabilityFactory = new CapabilityFactory();

	@Override
	public WebDriver initDriver(String browserName) {

    	try {
			driver = new RemoteWebDriver(new URL("http://192.168.6.83:4444/wd/hub"), capabilityFactory.getCapabilities(browserName));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	return driver;


	}
	
	

}
