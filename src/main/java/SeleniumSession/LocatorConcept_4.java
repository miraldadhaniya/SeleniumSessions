package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept_4 {
    static WebDriver driver;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		//create the webelement + actions (click, sendkeys, gettext, isdisplayed,  isenabled)
		
		//1.id
		
		//1st:
   //     driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
	//	  driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2nd--advantage can reuse this webelemnts as many times
	//	WebElement emailId = driver.findElement(By.id("input-email"));
	//	WebElement password = driver.findElement(By.id("input-password"));
		
	//	emailId.sendKeys("test@gmail.com");
	//	password.sendKeys("test@123");
		
		//3rd: By locator: Best approch
//		By username=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		WebElement emailId = driver.findElement(username);
//		WebElement password = driver.findElement(pwd);
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		// 4th:By locator with generic method (getElement())
		
//		By username=By.id("input-email");
// 	    By pwd=By.id("input-password");
//		
// 	    getElement(username).sendKeys("test@gmail.com");
// 	    getElement(pwd).sendKeys("test@123");
//		
 	    
 	    //5th:By locator with generic method(getElement() with action methods) 
 	    
// 	    By username=By.id("input-email");
//	    By pwd=By.id("input-password");
//	    
//	    doSendKeys(username, "test@gmail.com");
//	    doSendKeys(pwd,"test@123");
	    
	    //6th:ElementUtil class with generic methods
	    
//	    By username=By.id("input-email");
//	    By pwd=By.id("input-password");
//	    
//	    ElementUtil eleU = new ElementUtil(driver);
//	    eleU.doSendKeys(username, "test@gamil.com");
//	    eleU.doSendKeys(pwd,"test@123");
	    
	    //7th:String locator values:
	    
	    String usernameId = "input-email";
	    String PasswordId = "input-password";
	    
	    doSendKeys("id", usernameId, "miral@gmail.com");
	    doSendKeys("id", PasswordId, "miral@123");
	    
	    
	}
	
	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			System.out.println("Please pass correct locator type and value");
			break;
		}
		
		return locator;
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public static void doSendKeys(By locator, String Value) {
		getElement(locator).sendKeys(Value);
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String Value) {
		getElement(locatorType, locatorValue).sendKeys(Value);
	}
}
