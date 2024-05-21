package practice.Assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sampleTest {

	@Test
	public void homePageTest(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  String expectedPage = "Home Page";	
	  
	  WebDriver driver =new FirefoxDriver();
	  driver.get("http://localhost:8888/");
	  
	  driver.findElement(By.name("user_name")).sendKeys("admin");
	  driver.findElement(By.name("user_password")).sendKeys("admin");
	  driver.findElement(By.id("submitButton")).click();
	  
	  String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	  
	  Assert.assertEquals(actTitle, expectedPage);
	/*  if(actTitle.trim().equals(expectedPage)) {
		  System.out.println(expectedPage+" page is verified ===PASS");
	  }else {
		  System.out.println(expectedPage+" page is not verified ===FAIL");
	  }*/
	  driver.close();
	  System.out.println(mtd.getName() + " TestEnd");	
			  
	}
	
	@Test
	public void verifyLogoHomePageTest
	(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  
	  WebDriver driver =new FirefoxDriver();
	  driver.get("http://localhost:8888/");
	  
	  driver.findElement(By.name("user_name")).sendKeys("admin");
	  driver.findElement(By.name("user_password")).sendKeys("admin");
	  driver.findElement(By.id("submitButton")).click();
	  
	  boolean flag = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	 /* if(flag){
		  System.out.println("Logo  is verified ===PASS");
	  }else {
		  System.out.println("Logo is not verified ===FAIL");
	  }*/
	  
	  
	  //Assert.assertEquals(true, flag);
	  Assert.assertTrue(flag);
	  driver.close();
	  System.out.println(mtd.getName() + " TestEnd");	
	}
	
}
