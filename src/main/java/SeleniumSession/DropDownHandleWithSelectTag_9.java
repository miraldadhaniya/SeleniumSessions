package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelectTag_9 {
    static WebDriver driver;
    
	public static void main(String[] args) {
		
		//drop down--html tag -->  	select
		//Select class in selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		//Select select = new Select(country);
		//select.selectByIndex(5);               //days, month for fixed number of dropdown list
		//select.selectByVisibleText("India");    //text of the option
		//select.selectByValue("Cuba");             //value attribute 
		
		
		//Using below generic method
		
		By country = By.id("Form_submitForm_Country");
		doDropDownByIndex(country, 5);
		doDropDownByText(country, "India");
		doDropDownByValue(country, "Cuba");
	}

	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doDropDownByText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	
}
