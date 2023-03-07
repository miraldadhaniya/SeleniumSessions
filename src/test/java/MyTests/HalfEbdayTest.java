package MyTests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HalfEbdayTest { 
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void HotelRegPageTest(String favname,String fullname, String email, String contact) {
		
		
		
		//enter data
		driver.findElement(By.xpath("//*[@id='Form_getForm_subdomain']")).clear();
		driver.findElement(By.xpath("//*[@id='Form_getForm_subdomain']")).sendKeys(favname);
		
		driver.findElement(By.xpath("//*[@id='Form_getForm_Name']")).clear();
		driver.findElement(By.xpath("//*[@id='Form_getForm_Name']")).sendKeys(fullname);
		
		driver.findElement(By.xpath("//*[@id='Form_getForm_Email']")).clear();
		driver.findElement(By.xpath("//*[@id='Form_getForm_Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='Form_getForm_Contact']")).clear();
		driver.findElement(By.xpath("//*[@id='Form_getForm_Contact']")).sendKeys(contact);
		
		
	}
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
