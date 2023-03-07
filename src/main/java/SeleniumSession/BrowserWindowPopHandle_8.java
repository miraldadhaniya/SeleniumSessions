package SeleniumSession;

import java.util.Set;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopHandle_8 {

	public static void main(String[] args) {
		//browser window pop up/new tab window/new browser window
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/"); //parent window
		
		driver.findElement(By.className("orangehrm-login-forgot-header")).click();
        //child window - twitter page
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator(); //used to get value from object which does not follow order/seq and stored in iterator 
		
		String parentWindowID = it.next();
		System.out.println("Parent window id is: " + parentWindowID);
		
		
		String childWindowID = it.next();
		System.out.println("Child window id is: " + childWindowID);
		
		//Switching:
		driver.switchTo().window(childWindowID);
		System.out.println("chile window url : " + driver.getCurrentUrl());
		
		driver.close(); // close the child window
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());
	}

}
