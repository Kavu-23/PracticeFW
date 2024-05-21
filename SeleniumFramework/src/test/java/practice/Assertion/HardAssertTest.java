package practice.Assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void homePageTest(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  System.out.println("step-1");
	  System.out.println("step-2");
	  Assert.assertEquals("Home", "Home-Page");
	  System.out.println("step-3");
	  Assert.assertEquals("Home-CRM", "Home-CRM");
	  System.out.println("step-4");
	  System.out.println(mtd.getName() + " TestEnd");	
			  
	}
	
	@Test
	public void logoVerificationTest(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  System.out.println("step-1");
	  System.out.println("step-2");
	  Assert.assertTrue(true);
	  System.out.println("step-3");
	  System.out.println("step-4");
	  System.out.println(mtd.getName() + " TestEnd");	
			  
	}
}
