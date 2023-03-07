package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongLocatorSyntax_8 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By firstName = By.xpath("//*[id=\"Form_submitForm_Name\"]");
		By lastName = By.cssSelector("#Form_submitForm_Name");
		
		driver.findElement(firstName).sendKeys("Miral");
		
		//*[@id="Form_submitForm_Name"] --yes
		//*[id="Form_submitForm_Name"] -- no such element:unable to locate element
		//if locator syntax is wrong selenium version belwo 4 giving InvalidSelectorException
		
		
		
	}

}
