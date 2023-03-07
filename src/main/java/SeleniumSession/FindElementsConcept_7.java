package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept_7 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//you have to get the count of all the links/images  of the page
		//then print the text of each link on the console
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
//		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		
		//using generic methods for getElements
		By mylinks = By.tagName("a");
		List<WebElement> linklist = getElements(mylinks);
		
		System.out.println("total links: " + linklist.size());
		
//		for(int i=0; i<linklist.size(); i++){
//			String text = linklist.get(i).getText();
//			
//			if(!text.isEmpty()) {
//				System.out.println(text);
//			}
//			
//		}
		
		//with for each:
		for(WebElement e : linklist) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
