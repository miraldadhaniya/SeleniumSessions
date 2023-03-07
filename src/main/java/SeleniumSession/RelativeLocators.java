package SeleniumSession;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.linkText("St.-Catharines, Canada"));
		
		String aqNum = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(aqNum);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		String belowcity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowcity);
		
		String cityColName = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(cityColName);
		
		String name = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(name);
		
	}

}
