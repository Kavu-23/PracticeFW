package pratice.OrgTest;

import java.io.FileInputStream;
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

public class CreateOrganisationTest {

	public static void main(String[] args) throws Throwable {
		
		//Read common data from property file
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
		Row row= sh.getRow(1);
		String orgName= row.getCell(2).toString() + randomInt;
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
		
		//Step login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//Step2 navigate to organisation
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step3 Click on  create organisation 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step4 enter all details and create new organisation
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify Header msg Expected result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName + "  is created == PASS");
		}else {
			System.out.println(orgName + "  is not created == FAIL");
		}
		
		//verify Header oorgName info Expected result
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created == PASS");
		}else {
			System.out.println(orgName + "  is not created == FAIL");
		}
		
		//step5 logout
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
        

}
