package base.utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class EnvironmentFileUtil {
	static String filePath=System.getProperty("user.dir")+"//src//test//resources//environment.properties";
	static  FileWriter myWriter=null;
	static String browser;
	static String platform;
	static String env;
	
	public static void setUp(String browser,String platform,String env)
	{
		EnvironmentFileUtil.browser=browser;
		EnvironmentFileUtil.platform=platform;
		EnvironmentFileUtil.env=env;
	}
	public static void createFile()
	{
		try {
			
		      File myObj = new File(filePath);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void openFileStream()
	{
		 try {
			myWriter = new FileWriter(filePath);
			System.out.println("Opened successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void writePropToFile(String key,String value)
	{	
		try {
				 myWriter.write(key+"="+value+"\n");
				 System.out.println("Written successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static  void closefileStream()
	{
			 try {
				myWriter.close();
				System.out.println("Closed successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void generateEnvironmentPropFile()
	{
		createFile();
		openFileStream();
		writePropToFile("Browser",EnvironmentFileUtil.browser);
		writePropToFile("Environment",EnvironmentFileUtil.env);
		writePropToFile("Platform",EnvironmentFileUtil.platform);
		writePropToFile("TestEnvironmentURL", ConfigReader.getValue("BASE_URL"));
		closefileStream();
	}

	}


