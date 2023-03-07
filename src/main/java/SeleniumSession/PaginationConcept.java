package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://babynames.merschat.com/popular.cgi");
		
		List<WebElement> nameList = driver.findElements(By.xpath("//a[contains(text(), 'Hela')]"));
		
		while(true){
			
			if(!(nameList.size() == 1)) {
				driver.findElement(By.linkText("Next")).click();
				nameList = driver.findElements(By.xpath("//a[contains(text(), 'Hela')]"));
			}
			else {
				String meaning = driver.findElement(By.xpath("//a[contains(text(), 'Hela')]/../parent::td/following-sibling::td[3]//a")).getText();
				System.out.println(meaning);
				break;
			}
		}
		

	}

}
