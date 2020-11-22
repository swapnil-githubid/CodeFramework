package base.utils;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import base.utils.ConfigReader;

public class OptionsManager {

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        boolean headless =Boolean.parseBoolean(ConfigReader.getValue("headless"));
       		 options.setHeadless(headless);
       		  Map<String, Object> prefs = new HashMap<String, Object>();
       		  prefs.put("credentials_enable_service", false);
       		  prefs.put("profile.password_manager_enabled", false);
       		  options.setExperimentalOption("prefs", prefs); // This is to disable infobars for new chrome driver vesrion.
       		  options.setExperimentalOption("useAutomationExtension", false);
       		  options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
        //options.setHeadless(ConfigReader.getValue("headless"));
        //options.addArguments("--incognito");
        return options;
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("browser.download.folderList", 1);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.openxmlformats-officedocument.presentationml.presentation;"
        		+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;");
       // profile.setPreference("browser.download.folderList", 1);
      //  profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        //Handling Print window Dialogue box for Firefox
        options.addPreference("print.always_print_silent", true);
        options.addPreference("print.show_print_progress", false);
        boolean headless = Boolean.parseBoolean(ConfigReader.getValue("headless"));
		options.setHeadless(headless);
		  
        return options;
    }
    
    public static InternetExplorerOptions getIEOptions()
    {
    	InternetExplorerOptions options=new InternetExplorerOptions();
    	options.setCapability("ignoreZoomSetting", true);
    	options.destructivelyEnsureCleanSession();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
    	//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	return options;
    }
    
    
}