package crm.generic.fileUility;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis= new FileInputStream("./conFigApp/CommonData.properties");
		Properties Obj= new Properties();
		Obj.load(fis);
		String data =Obj.getProperty(key);
		
		return data;
		
	}
}
