package practice.conFigAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class createCustomerTest extends practiceBaseClass {
	
	
	@Test
	public void createCustomer() {
		System.out.println(" execute cc test and verify");
	}
	
	@Test
	public void createCustomerDate() {
		System.out.println(" execute cc date test and Verify");
	}
	

}
