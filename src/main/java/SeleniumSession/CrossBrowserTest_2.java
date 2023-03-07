package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest_2 {
     
	static WebDriver driver;
	
	public static void main(String[] args) {
		String browser = "firefox";
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nitin\\Downloads\\chromedriver_win32\\chromedriver.exe");

			 driver = new ChromeDriver(); // launch chrome
		}else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\nitin\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			
		    driver = new FirefoxDriver(); //launch firefox
		}else {
			System.out.println("Please Pass Right Browser : " + browser);
		}
		
		driver.get("https://www.gmail.com"); // launch url
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
		
		//driver.quit();           //close browser
		//driver.close();

	}

}
