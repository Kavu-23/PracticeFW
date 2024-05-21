package practice.conFigAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class practiceBaseClass {


	@BeforeSuite
	public void conFigBS() {
		System.out.println("===== connect to db, Report config====");
	}
	
	@BeforeClass
	public void conFigBC() {
		System.out.println("====Launch Browser=====");
	}
	
	@BeforeMethod
	public void conFigBM() {
		System.out.println("===Login to App===");
	}
	
	@AfterMethod
	public void conFigAM() {
		System.out.println("===LogOut to app====");
	}
	
	@AfterClass
	public void conFigAC() {
		System.out.println("===close the browser===");
	}
	
	@AfterSuite
	public void conFigAS() {
		System.out.println("===close db connection, report Backup====");
	}
}
