package SeleniumSession;

import java.net.URL;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebdriverCasting_2 {

	public static void main(String[] args) {
		//1. WD - CD
		//WebDriver driver = new ChromeDriver();
	
		//2.ChromeDriver driver = new ChromeDriver();
		
		//3.RWD - CD
		//RemoteWebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		//4. WD - RWD--- remote machine/server/virtual machine/docker/cloud/cloud vendor
		//WebDriver driver = new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
		
		//5. SC - CD
		//SearchContext driver = new ChromeDriver();
		
		//6.SC - RWD
		//SearchContext driver = new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
		
		
		

	}

}
