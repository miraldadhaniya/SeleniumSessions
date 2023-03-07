package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept_8 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
//		String hrefValue = driver.findElement(By.linkText("Today's Deals")).getAttribute("href");
//		System.out.println(hrefValue);
		
		By todayDeal = By.linkText("Today's Deals");
		String hrefVal = getAttributeValue(todayDeal, "href");
		if(hrefVal.contains("goldbox")) {
		System.out.println("yes this is correct href");
	    }
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public static String getAttributeValue(By locator,String attrName) {
		String attrVal = getElement(locator).getAttribute(attrName);
		System.out.println(attrVal);
		return attrVal;
	}

}
