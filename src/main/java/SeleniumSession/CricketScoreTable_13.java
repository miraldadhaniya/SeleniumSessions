package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable_13 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/india-in-ireland-2022-1303299/ireland-vs-india-2nd-t20i-1303308/full-scorecard");
		
		System.out.println(getWicketTakerName("Deepak Hooda"));
		System.out.println(getPlayerScoreCard("Sanju Samson"));

	}
	
	public static String getWicketTakerName(String playerName) {
		String xpath = "//span[text()='"+playerName+"']/ancestor::td/following-sibling::td/span/span";
		return driver.findElement(By.xpath(xpath)).getText();
		
	}
	
	public static List<String> getPlayerScoreCard(String playerName) {
		String xpath = "//span[text()='"+playerName+"']/ancestor::td/following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(xpath));
		List<String> scorevalList = new ArrayList<String>();
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scorevalList.add(text);
		}
		return scorevalList;
	}

}
