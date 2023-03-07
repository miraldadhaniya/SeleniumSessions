package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseClass{
	
	@Test(priority = 1)
	public void contactSalesLinkTest() {
		//driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		boolean flag = driver.findElement(By.linkText("CONTACT SALES")).isDisplayed();
		Assert.assertTrue(flag);		
	}
	
	@Test
	public void urlTest() {	
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("trial"));		
	}

}
