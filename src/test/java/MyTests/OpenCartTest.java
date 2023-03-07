package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseClass {
	
	@Test(priority = 1)
	public void registerLinkTest() {
		//driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		boolean flag = driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertTrue(flag);		
	}
	
	@Test
	public void urlTest() {	
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("account/login"));		
	}

}
