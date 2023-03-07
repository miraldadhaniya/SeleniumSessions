package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(5000);
		String svgXpath = "//*[local-name() = 'svg' and @id='map-svg']//*[name()='g' and @id = 'states']/*[name()='g']/*[name() = 'path']";
        String countyXpath = "//*[local-name() = 'svg' and @id='map-svg']//*[name()='g' and @id = 'states']/*[name()='g']/*[name() = 'g' and @class = 'counties']/*[name() = 'path']";
		
		List<WebElement> stateList = driver.findElements(By.xpath(svgXpath));
		List<WebElement> countyList = driver.findElements(By.xpath(countyXpath));
		Actions act = new Actions(driver);
		for(WebElement e : stateList)
		{
			act.moveToElement(e).perform();
			String name = e.getAttribute("name");
			System.out.println(name);
				if(name.equals("California")) {
					e.click();
					break;
					}
				
		}
	}

}
