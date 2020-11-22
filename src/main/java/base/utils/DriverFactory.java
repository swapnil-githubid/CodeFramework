package base.utils;

/**
 * Determines which browser is being used and sets the driver accordingly.
 */
public class DriverFactory
{
    public  IDriver generateDriver(String typeOfDriver)
    
    {
    	
    	if (typeOfDriver.equalsIgnoreCase("local"))
    	{
    		return new LocalWebDriver();
    	}
    	else if (typeOfDriver.equalsIgnoreCase("remote"))
    	{
    		return new RemoteDriver();
    	}

    	return null;
    }
    
}