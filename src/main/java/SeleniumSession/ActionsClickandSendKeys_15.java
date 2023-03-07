package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickandSendKeys_15 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		Actions act = new Actions(driver);
		
//		WebElement firstName = driver.findElement(By.id("input-firstname"));
//		WebElement lastName = driver.findElement(By.id("input-lastname"));
		
		//act.sendKeys(firstName, "Miral").build().perform();
		//act.sendKeys(lastName, "Dadhaniya").build().perform();
		             //OR
//		act.click(firstName).sendKeys("Miral").build().perform();
//		act.click(lastName).sendKeys("Dadhaniya").build().perform();
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By checkBox = By.name("agree");
		
		doActionsSendKeys(firstName, "Jainavi");
		doActionsSendKeysOnActiveElement(lastName,"Patel");
		
		act.click(driver.findElement(checkBox)).build().perform();

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}
	
	public static void doActionsSendKeysOnActiveElement(By locator,String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	
	/*Click on the middle of the Element*/
	
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	public static void doActionMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}

}
