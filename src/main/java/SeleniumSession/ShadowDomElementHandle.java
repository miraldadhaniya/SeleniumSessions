package SeleniumSession;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElementHandle {

	public static void main(String[] args) {
		
		//br-->page-->iframe-->shadow dom-->element
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		//driver.findElement(By.id("tea")).sendKeys("masala tea");
		driver.switchTo().frame("pact");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement teaEle = (WebElement) jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		teaEle.sendKeys("masala tea");
	}

}
