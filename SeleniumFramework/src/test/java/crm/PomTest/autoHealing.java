package crm.PomTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoHealing {

		@FindBy(name="user_name")
		WebElement ele1;
		
		@FindBy(name="user_password")
		WebElement ele2;
		
		@FindAll({@FindBy(id = "submi"), @FindBy(xpath = "//input[@value='Login'")}) // we are using multiple locaters even though if one is wrong other locators will execute the sripts
		private WebElement ele3;
		
		@Test
		public void sampleTest() {
			
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.get("http://localhost:8888/");
			
			sampleTestWithPom s =PageFactory.initElements(driver, sampleTestWithPom.class);
			
			s.ele1.sendKeys("admin");
			s.ele2.sendKeys("admin");
			
			s.ele3.click();
		}
}
