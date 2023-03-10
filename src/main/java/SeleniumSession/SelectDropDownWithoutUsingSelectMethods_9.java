package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownWithoutUsingSelectMethods_9 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// drop down--html tag --> select
		// Select class in selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		//WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
         By country = By.id("Form_submitForm_Country");
         doSelectDropDownValue(country,"India");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownValue(By locactor, String value) {
		Select select = new Select(getElement(locactor));
		List<WebElement> OptionList = select.getOptions();
		
		for(WebElement e : OptionList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
