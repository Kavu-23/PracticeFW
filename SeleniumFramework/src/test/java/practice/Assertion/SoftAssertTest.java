package practice.Assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void homePageTest(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  SoftAssert assertObj = new SoftAssert();
	  Reporter.log("step-1");
	  System.out.println("step-2");
	  Assert.assertEquals("Home-Page", "Home-Page"); //HardAssert
	  System.out.println("step-3");
	  assertObj.assertEquals("Home-CRM", "Home-CRM");
	  Reporter.log("step-4",true);
	  assertObj.assertAll();
	  System.out.println(mtd.getName() + " TestEnd");	
			  
	}
	
	@Test
	public void logoVerificationTest(Method mtd) {
	  
	  System.out.println(mtd.getName() + " TestStart");	
	  SoftAssert assertObj = new SoftAssert();
	  System.out.println("step-1");
	  System.out.println("step-2");
	  Assert.assertTrue(true);
	  System.out.println("step-3");
	  System.out.println("step-4");
	  assertObj.assertAll();
	  System.out.println(mtd.getName() + " TestEnd");	
			  
	}
}
