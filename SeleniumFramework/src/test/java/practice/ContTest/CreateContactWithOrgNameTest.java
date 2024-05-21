package practice.ContTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgNameTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Desktop\\CommonData.properties");
		Properties Obj= new Properties();
		Obj.load(fis);
		
		String Browser= Obj.getProperty("browser");
		String Url=Obj.getProperty("url");
		String Username=Obj.getProperty("username");
		String Password=Obj.getProperty("password");
	
				Random random=new Random();
				int randomInt = random.nextInt(1000);
	
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\Desktop\\ExcelData.xlsx");
		Workbook Wb = WorkbookFactory.create(fis1);
		Sheet sh=Wb.getSheet("Contact");
		Row row= sh.getRow(7);
		String orgName= row.getCell(2).toString() + randomInt;
		String lastName= row.getCell(3).toString();
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
		
		//login
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//create orgname
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	     
	      //verify Header msg Expected result
	      		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	      		if(headerInfo.contains(orgName)) {
	      			System.out.println(orgName + "  is created == PASS");
	      		}else {
	      			System.out.println(orgName + "  is not created == FAIL");
	      		}
	
		
		// navigate to contact module
        driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
		    String windowID= it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); //using dynamic xpah
		
		//switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1=set1.iterator();
		
		while(it1.hasNext()) {
		    String windowID1= it1.next();
			driver.switchTo().window(windowID1);
			
			String actUrl1 = driver.getCurrentUrl();
			if(actUrl1.contains("Contacts&action")) {
				break;
			}
		}
		
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
      //verify Header msg Expected result
      		String headerInfo1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
      		if(headerInfo1.contains(lastName)) {
      			System.out.println(lastName + "  is created == PASS");
      		}else {
      			System.out.println(lastName + "  is not created == FAIL");
      		}
      		
        //verify the header
        String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName   + "   is verified== PASS");
		}else {
			System.out.println(orgName  +  "  is not verrified ===FAIL");
		}
		
		
        //step5 logout
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	
		}  

		

	}
