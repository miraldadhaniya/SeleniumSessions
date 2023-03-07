package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WeddriverManagerTest_3 {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitin\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
		
        WebDriverManager.chromedriver().setup();   // automation of driver exe version file updation
        WebDriverManager.firefoxdriver().setup();
        
        
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
		//driver.close();            //session id expired so got exception as invalid session id
	}

	}


