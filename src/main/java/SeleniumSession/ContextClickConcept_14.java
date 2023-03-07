package SeleniumSession;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept_14 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		//actions class is used to handle user actions like right click,double click and drag and drop
		Actions act = new Actions(driver);
		act.contextClick(rightClickMe).build().perform();  //without build and perform method in action class will not work
		
		List<WebElement> optList = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-item context-menu-icon')]/span"));
        for(WebElement e : optList) {
        	String text= e.getText();
        	System.out.println(text);
        	e.click();
        	Thread.sleep(2000);
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    		act.contextClick(rightClickMe).build().perform();
        	}
        
	}

}
