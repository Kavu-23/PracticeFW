package practice.ExtentReport;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampleReportTest {
     public ExtentReports report;
    
     @BeforeSuite
     
     public void configBS() {
		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("RM report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER","Firefox-115");
     }
     
     @AfterSuite
     public void configAS() {
    	 report.flush();
     }

		@Test
		public void createContactTest() {
		
			WebDriver driver = new FirefoxDriver();
			driver.get("http://localhost:8888");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			TakesScreenshot eDriver = (TakesScreenshot)driver;
			String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
				
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFdd".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		}else {
			test.log(Status.FAIL, "contact is not created");
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		
		driver.close();
	}
	
}
