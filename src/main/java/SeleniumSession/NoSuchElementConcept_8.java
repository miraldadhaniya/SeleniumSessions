package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept_8 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_Name11"));
//		//NoSuchElementException
//		firstName.sendKeys("Miral");
		
		List<WebElement> list = driver.findElements(By.className("text11")); 
		//no exception will be thrown here if element is not found or wrong
		System.out.println(list.size());

	}

}
