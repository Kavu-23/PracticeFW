package xmlFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vTigerXmlTestNGTest {
	
	@Test
	public void sampleTest(XmlTest test) {
		//read data from xml file
		String URL= test.getParameter("url");
		String BROWSER= test.getParameter("browser");
		String USERNAME= test.getParameter("username");
		String PASSWORD= test.getParameter("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.quit();
	}

}
