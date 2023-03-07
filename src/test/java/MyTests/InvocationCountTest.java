package MyTests;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 10)
	public void getUserInfoTest() {
		System.out.println("get user.....");
		//get api call
	}

}
