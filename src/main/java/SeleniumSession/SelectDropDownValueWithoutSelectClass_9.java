package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValueWithoutSelectClass_9 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// drop down--html tag --> select
		// Select class in selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

	    By countryOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");
	    selectDropDownValueWithoutSelect(countryOptions,"Cuba");
		
	}
	
	public static void selectDropDownValueWithoutSelect(By locator,String value) {
		
		List<WebElement> countryList = driver.findElements(locator);
	    System.out.println(countryList.size());
	    
	    for(WebElement e : countryList) {
			String text = e.getText();
		    if(text.equals(value)) {
				e.click();
				break;
			}
		}
		
	}
	
	

}
