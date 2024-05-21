package practice.screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class sampleTest {

	@Test
	public void amazonTest() throws Throwable {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		
		//step1: create an object to eventFiring webDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//step-2: use getscreenshotAs method to get file type of screenshot
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		File dst =new File("./ScreenShot/test.png");
		//step 3: store screenshot in local drive
		FileUtils.copyFile(src, dst);
		
	}
}
