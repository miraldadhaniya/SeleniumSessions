package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics_1 {

	public static void main(String[] args) {

		// open chrome
		// enter url
		// get the title --> validation point(act vs exp)
         
		// for Windows
	
		System.setProperty("webdriver.chrome.driver","N:\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.google.com"); // launch url
		String title = driver.getTitle(); // get the title
		System.out.println("page Title is: " + title);

		// validation point/checkpoint:(act vs exp):
		if (title.equals("Google")) {
			System.out.println("PASS - Corect title");
		} else {
			System.out.println("FAIL - IN-Corect title");
		}

		// Automation steps + validation point ==> automation testing
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.quit();           //session id null
		driver.close();            //session id expired so got exception as invalid session id
	}

}
