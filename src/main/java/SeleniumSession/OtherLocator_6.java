package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocator_6 {
    static WebDriver driver;
	public static void main(String[] args) {
		//id--(its a unique attribute)--I
		
		//2.name---II
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		driver.findElement(By.name("username")).sendKeys("test@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("test@123");
		
//		By emailId = By.name("username");
		ElementUtil_5 eleUtil = new ElementUtil_5(driver);
//		eleUtil.doSendKeys(emailId, "Miral@gmail.com");
		
		//3. className:---III
		//but its not mandatory its unique
		//we can have same class name for diffrent elements
//		driver.findElement(By.className("form-contrl")).sendKeys("naveen");
		
		//4. xpath: its not an attribute
		//address of the element inside HTML DOM
		
		//*[@id="loginForm"]/div/input[1]
//		/html/body/div[2]/div/div[3]/form/div/input[1]----absolute xpath
		// we will never use  absolute xpath
//		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[2]")).sendKeys("test@123");
		
//		By emailId = By.xpath("//*[@id=\\\"loginForm\\\"]/div/input[1]");
//	  	eleUtil.doSendKeys(emailId, "Miral@gmail.com");
		
		//5.CSSSelector :its not an attribute
		//we have to use attributes to create the css selector
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("miral@gmail.com");
		
		//6.linkText :only for links, its not attribute
		//text of the links
//		driver.findElement(By.linkText("Register")).click();
		
//		By regLink = By.linkText("Register");
//		doClick(regLink);
		
//		String reg = "Register";
//		eleUtil.doClick("linktext", reg);
		
		//7.partialLinkText: only for links but its not attribute
		//partial text of the link
//		driver.findElement(By.partialLinkText("Executive")).click();
		
		//8. tagName: html tag
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
//		if(header.contains("Your free trial")) {
//			System.out.println("h1 header is correct");
//			}
		
		By header = By.tagName("h1");
		if(doGetText(header).contains("Your free trial")) {
			System.out.println("h1 header is correct");
		}
				
		
		}

	
	  public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		}
	  
	  public static void doClick(By locator) {
		  getElement(locator).click();
	  }
	  
	  public static String doGetText(By locator) {
		  return getElement(locator).getText();
	  }

}
