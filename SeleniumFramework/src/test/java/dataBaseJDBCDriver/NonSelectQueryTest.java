package dataBaseJDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
	
		  Driver driverRef= new Driver();
		  DriverManager.registerDriver(driverRef);
		  
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		  System.out.println("=======Done====");
			
		  Statement stat= conn.createStatement();
		  
		  int result = stat.executeUpdate("insert into project values('Tp_PROJ_2007','Nisha','04/28/2024','Vtiger_07','on going','890');");
		  System.out.println(result);
		  
		  conn.close();

	}

}
