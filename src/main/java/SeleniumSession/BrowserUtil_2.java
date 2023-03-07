package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil_2 {
	
	static WebDriver driver;
	
	/**
	 * This method is used to launch browser on he basis of given browser name
	 * @param browser
	 * @return This will return the driver
	 */
	public WebDriver launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			/*System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nitin\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
			WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); // launch chrome
		}else if(browser.equalsIgnoreCase("Firefox")) {
			/*System.setProperty("webdriver.gecko.driver","C:\\Users\\nitin\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");*/
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); //launch firefox
		}else {
			System.out.println("Please Pass Right Browser : " + browser);
		}
		
		return driver;
	}

	/**
	 * This method id used to enter the url
	 * @param url
	 */
	public void enterUrl(String url) {
		if(url == null) {
			System.out.println("Url is NUll");
			return;
		}
		if(url.indexOf("http")==-1) {
			System.out.println("http is missing in url");
			return;
		}
		driver.get(url);
	}
	
	
	public String getAppCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
