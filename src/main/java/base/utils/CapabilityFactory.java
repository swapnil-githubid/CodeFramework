package base.utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    public Capabilities capabilities;

    public Capabilities getCapabilities (String browser) {
        if (browser.equals("firefox"))
            capabilities = OptionsManager.getFirefoxOptions();
        if (browser.equals("chrome"))
            capabilities = OptionsManager.getChromeOptions();
        if (browser.equals("IE"))
        	capabilities = OptionsManager.getIEOptions();
        else 
        	capabilities = OptionsManager.getChromeOptions();
        return capabilities;
    }
}
