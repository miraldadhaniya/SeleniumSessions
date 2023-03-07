package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseClass {
	
	
	
	@Test(priority = 1)
	public void searchTest() {
		//driver.get("https://google.com");
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);		
	}
	
	@Test
	public void googleSearchBtnTest() {	
		boolean flag = driver.findElement(By.name("btnK")).isDisplayed();
		Assert.assertTrue(flag);		
	}
	
	@Test
	public void urlTest() {	
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"));		
	}
	
	

}
