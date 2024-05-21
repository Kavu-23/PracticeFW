package pratice.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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

public class CreateOrgWithPhoneNumTest {

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
		Sheet sh=Wb.getSheet("Org");
		Row row= sh.getRow(7);
		String orgName= row.getCell(2).toString() + randomInt;
		String phoneNum= row.getCell(3).toString();
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
		
	
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// enter all the details and create org
		driver.findElement(By.name("accountname")).sendKeys(orgName);
        driver.findElement(By.id("phone")).sendKeys(phoneNum);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        String actPhoneNum=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actPhoneNum.equals(phoneNum)) {
			System.out.println(phoneNum   + "   is verified== PASS");
		}else {
			System.out.println(phoneNum  +  "  is not verrified ===FAIL");
		}
	
	//step5 logout
			Actions act =new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();

}
}
