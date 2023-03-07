package SeleniumSession;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait1_18 {
   
	static WebDriver driver;
	public static void main(String[] args) {
		
		//while loop
		//sleep(static wait) -->Dynamic wait 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
        driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email11");
		retryingElement(emailId, 10).sendKeys("miral@gmail.com");
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement retryingElement(By locator,int timeOut) {
		WebElement element = null; 
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch(NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + " : " + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				}
				attempts++;
			}
		if (element == null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Element is not found Exception...tried for : " + timeOut + "with the interval of : "+ 500 +"ms");
			}
		}
		return element;
	}

}
