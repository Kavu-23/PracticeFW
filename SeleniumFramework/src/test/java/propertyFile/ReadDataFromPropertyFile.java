package propertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException   {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Desktop\\CommonData.properties");
		Properties Obj= new Properties();
		Obj.load(fis);
		
		System.out.println(Obj.getProperty("browser"));
		System.out.println(Obj.getProperty("url"));
	    System.out.println(Obj.getProperty("username"));
	    System.out.println(Obj.getProperty("password"));
		
		
	}

}
