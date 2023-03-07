package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest_9 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Naveen automationLabs");
		
		Thread.sleep(5000);
		
		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li//div[@class=\"wM6W7d\"]/span"));
		System.out.println(suggList.size());
		
		for(WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
		    if(text.equals("naveen automationlabs youtube")) {
				e.click();
				break;
			}
		}
		
		
	}

}
