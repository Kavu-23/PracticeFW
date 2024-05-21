package practice.ContTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Desktop\\CommonData.properties");
		Properties Obj= new Properties();
		Obj.load(fis);
		
		String Browser= Obj.getProperty("browser");
		String Url=Obj.getProperty("url");
		String Username=Obj.getProperty("username");
		String Password=Obj.getProperty("password");
		
		//generate random number
				Random random=new Random();
				int randomInt = random.nextInt(1000);
				
		//Read Test Script Data from Excel
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Workbook Wb = WorkbookFactory.create(fis1);
		Sheet sh=Wb.getSheet("Contact");
		Row row= sh.getRow(4);
		String lastName= row.getCell(2).toString() + randomInt;
	    Wb.close();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		/*WebDriver driver= null;
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
		}else if(Browser.equals("edge")) {
			driver= new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}else  {
			driver= new ChromeDriver();
			} */
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
	
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//inserting date
		Date d=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
		String startDate = sim.format(d);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sim.format(cal.getTime());
		
	
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//enter details for support date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
       // verify start date and end date
        String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.equals(startDate))
		{
			System.out.println(startDate   + "   is verified== PASS");
		}else {
			System.out.println(startDate  +  "  is not verrified ===FAIL");
		}
		
        String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.equals(endDate)) {
			System.out.println(endDate   + "   is verified== PASS");
		}else {
			System.out.println(endDate  +  "  is not verrified ===FAIL");
		}
	
	//step5 logout
			Actions act =new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();


	}

}
