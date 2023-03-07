package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed_7 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		By emailId = By.id("input-email");
//		boolean flag = driver.findElement(emailId).isDisplayed();
//		System.out.println(flag);

		//with generic method 
		if(doIsDisplayed(emailId)) {
			System.out.println("Displayed");
		}
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean doIsDisplayed(By locator ) {
		return getElement(locator).isDisplayed();
	}

}
