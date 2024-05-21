package dataBaseJDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ConditionBasedSelectQuerryTest {

	@Test
	
	public void projectCheckTest() throws Throwable {
		  
		  String expectedProjectName= "Vtiger_05";
		  boolean flag= false;
		  
		  Driver driverRef= new Driver();
		  DriverManager.registerDriver(driverRef);
		 
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		  System.out.println("=======Done====");
		
		  Statement stat= conn.createStatement();
		  
		  ResultSet resultset=stat.executeQuery("select * from project");
		  while(resultset.next()) {
			  String actProjectName = resultset.getString(4);
			  if(expectedProjectName.equals(actProjectName)) {
				  flag=true;
				  
				  System.out.println(expectedProjectName + " is available==PASS");
			  }
		  }
		  
		  if(flag==false) {
			  System.out.println(expectedProjectName + " is available==FAIL");
			  Assert.fail();
		  }
		  conn.close();
	}
}
