package MyTests;

import java.lang.System.Logger;
import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
WebDriver driver;
    
   //Logger LOGGER = LogManager.getLogger(BaseClass.class);


    @Parameters({"url","browser"})
	@BeforeTest
	public void setup(String url,String browser) {
    	if(browser.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver =  new ChromeDriver();
    	}else if(browser.equals("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver =  new FirefoxDriver();
    	}else {
    		System.out.println("please pass the right browser...");
    	}
    		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
