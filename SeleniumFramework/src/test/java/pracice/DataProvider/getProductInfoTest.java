package pracice.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.generic.fileUility.ExcelFileUtility;

public class getProductInfoTest {

	@Test(dataProvider = "getData")
	public void getproductInfo(String brandName, String productName) {
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		
		//capture product info
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
	}
	
	 @DataProvider
	    public Object[][] getData() throws Throwable {
	    	ExcelFileUtility eLib = new ExcelFileUtility();
	    	int rowCount = eLib.getRowCount("Product");
	    	
	    	Object[][] objAry= new Object[rowCount][2];
	    	
	    	for (int i = 0; i<rowCount; i++) {
	    	objAry[i][0] = eLib.getDataFromExcelFile("Product", i+1, 0);
	    	objAry[i][1] = eLib.getDataFromExcelFile("Product", i+1, 1);
	    	
	    	}
			return objAry;
	    	
	    }
}
