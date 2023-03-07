package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTextUtil_7 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//you have to get the count of all the links/images  of the page
		//return a list<String>  --> this will hold the text of each link
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
//		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		
		//using generic methods for getElements
		By mylinks = By.tagName("a");
		System.out.println(getElementsCount(mylinks));
		
		
		List<String> actlist = getElementsTextList(mylinks);
		for(String em : actlist) {
			System.out.println(em);
		}
		
//		if(getElementsTextList(mylinks).contains("Photography")) {
//			System.out.println("Photography link is present");
//		}
		
	}
	
	//Generic methods
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String eleText = e.getText();
			    if(!eleText.isEmpty()) {
				eleTextList.add(eleText);	
			    }
		}
		return eleTextList;
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
		
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}


}
