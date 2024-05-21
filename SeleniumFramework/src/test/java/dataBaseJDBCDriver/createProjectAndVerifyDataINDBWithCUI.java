package dataBaseJDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;



public class createProjectAndVerifyDataINDBWithCUI {

	public static void main(String[] args) throws Throwable {
		
		//create project in GUI(front end)
		String projectName="Insta_67";
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://106.51.90.215:8084");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Vidhya");
		
		Select sel= new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		//verify the project in DB(back end)
		
		  boolean flag=false;
		  Driver driverRef= new Driver();
		  DriverManager.registerDriver(driverRef);
		 
		  Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		  System.out.println("=======Done====");
		
		  Statement stat= conn.createStatement();
		  
		  ResultSet resultset=stat.executeQuery("select * from project");
		  while(resultset.next()) {
			  String actProjectName = resultset.getString(4);
			  if(projectName.equals(actProjectName)) {
				  flag=true;
				  
				  System.out.println(projectName + " is available==PASS");
			  }
		  }
		  
		  if(flag==false) {
			  System.out.println(projectName + " is available==FAIL");
			  
		  }
		 // conn.close();
		
	}

}
