package base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigReader {
	
	public static String getValue(String key) {
		File file = new File("src\\main\\resources\\config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);

	}
	/*
	 * Method used to update Config file properties
	 */
	public static void setValue(String key,String value)
	{
		try {
        PropertiesConfiguration properties = new PropertiesConfiguration("src\\\\main\\\\resources\\\\config.properties");
        properties.setProperty(key,value);
        properties.save();
        System.out.println("config.properties updated Successfully!!");
    } catch (ConfigurationException e) {
        System.out.println(e.getMessage());
    }
	}
	
	public static int getIntValue(String key) {
		File file = new File("src\\main\\resources\\config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String intValueOfKey = prop.getProperty(key);
		return Integer.parseInt(intValueOfKey);
	}

}
