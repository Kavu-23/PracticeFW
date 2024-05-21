package pracice.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dP1Test {

    @Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName) {
		System.out.println("FirstName:" + firstName + ",LastName:" + lastName);
	}
    
    @DataProvider
    public Object[][] getData(){
    	Object[][] objAry = new Object[3][2];
    	objAry[0][0] = "kaveri";
    	objAry[0][1] = "hr";
    	objAry[1][0] = "stuti";
    	objAry[1][1] = "vr";
    	objAry[2][0] = "bindu";
    	objAry[2][1]=   "vh";
    	
		return objAry;
    	
    }
	

}
