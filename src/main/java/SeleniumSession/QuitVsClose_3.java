package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitin\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.google.com"); // launch url
		String title = driver.getTitle(); // get the title
		System.out.println("page Title is: " + title);
		
		//driver.close();
		//driver.quit(); // make the sessionID null
			
		System.out.println(driver.getTitle()); // NoSuchSessionException: invalid session id

	}

}
