package base.utils;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class ScreenshotUtil {
	@Attachment(value="Screenshot", type="image/png")
	public static synchronized byte[] takeScreenshotForAllure(WebDriver driver) throws IOException {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			}
}
