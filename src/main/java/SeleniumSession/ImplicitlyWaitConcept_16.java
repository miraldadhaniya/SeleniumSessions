package SeleniumSession;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept_16 {

	static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//imp wait:
		//dynamic wait
		//global wait --it will be applicable for all web elements by default
		//can not be applied for non webelements:alerts, url, title
		
		
		
		
		driver.get("https://classic.crmpro.com/index.html");
		//login page: 10 sec
		driver.findElement(By.name("username")).sendKeys("naveen");
		driver.findElement(By.name("password")).sendKeys("naveen123");
		
		//click on login
		
		//home page:15 secs for each and every element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //override
		//driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS);      //Sel 3
		//ele4
		//ele5
		//ele6
		
		//contact page:5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //override
		//ele7
		//ele8
		
		//home page:15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //override

	}

}
