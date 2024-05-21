package pracice.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dP2Test {

	@Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName, long phoneNumber) {
		System.out.println("FirstName:" + firstName + ",LastName:" + lastName + ",PhoneNumber:" + phoneNumber);
	}
    
    @DataProvider
    public Object[][] getData(){
    	Object[][] objAry = new Object[3][3];
    	
    	objAry[0][0] = "kaveri";
    	objAry[0][1] = "hr";
    	objAry[0][2] = 9739891792l;
    	
    	objAry[1][0] = "stuti";
    	objAry[1][1] = "vr";
    	objAry[1][2] = 9739342523l;
    	
    	objAry[2][0] = "bindu";
    	objAry[2][1]=   "vh";
    	objAry[2][2] = 8792935414l;
    	
		return objAry;
    	
    }
}
