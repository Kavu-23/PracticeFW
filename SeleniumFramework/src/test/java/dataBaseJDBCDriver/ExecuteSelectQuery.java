package dataBaseJDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQuery {
	public static void main(String[] args) throws Throwable {
		
	
	//proper syntax to execute querry in jdbc ...when sql statements are wrong
	
	  Connection conn=null;
	  
	  try {
	  
	  Driver driverRef= new Driver();
	  DriverManager.registerDriver(driverRef);
	  
	  conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	  System.out.println("=======Done====");
		
	  Statement stat= conn.createStatement();
	  
	  ResultSet resultset=stat.executeQuery("select * from project");
	  while(resultset.next()) {
		  System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3) + "\t" + resultset.getString(4) + "\t" + resultset.getString(5) + "\t" + resultset.getString(6));
	  }
	  }
	  catch(Exception e) {
		  System.out.println("handle exception");
	  }finally {
		  conn.close();
		  System.out.println("====close the connetion===");
	  
	  }
}

}
