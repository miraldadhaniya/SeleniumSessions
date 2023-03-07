package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle_12 {
  
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//a[text() = 'Miral Dadhaniya']/parent::td/preceding-sibling::td/input
		//a[text() = 'Ram Kapoor']/parent::td/preceding-sibling::td/input   -->
		//a[text() = 'Ram Kapoor']/../preceding-sibling::td/child::input    --> both are similar
		//input[@id='username']//ancestor::div
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("miraldadhaniya");
		driver.findElement(By.name("password")).sendKeys("Letmein4study");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		Thread.sleep(3000);
		//hardcoded
		//String xpath = "//a[text() = 'Ram Kapoor']/parent::td/preceding-sibling::td/input";
		//driver.findElement(By.xpath(xpath)).click();
		
		selectContact("Nitin Patel");
		selectContact("Ram Kapoor");
		
		System.out.println(getCompanyName("Miral Dadhaniya"));
		System.out.println(getContactList("Priya Kapoor"));
		
		System.out.println(getEmailId("Ram Kapoor"));

	}
	
	public static void selectContact(String contactName) {
		String xpath = "//a[text() = '"+contactName+"']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static String getCompanyName(String contactName) {
		String xpath = "//a[text() = '"+contactName+"']/parent::td/following-sibling::td/a[@context = 'company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> getContactList(String contactName) {
		String xpath = "//a[text() = '"+contactName+"']/parent::td/following-sibling::td/span[@context='phone']";
		List<WebElement> phoneList = driver.findElements(By.xpath(xpath));
		List<String> phonevalList = new ArrayList<String>();
		for(WebElement e: phoneList) {
			String text = e.getText();
			phonevalList.add(text);
		}
		return phonevalList;
	}
	
	public static String getEmailId(String contactName) {
		String xpath = "//a[text() = '"+contactName+"']/parent::td/following-sibling::td/a[contains(@href,'mailto')]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	

}
