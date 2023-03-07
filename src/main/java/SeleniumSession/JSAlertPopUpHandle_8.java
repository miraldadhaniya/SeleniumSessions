package SeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopUpHandle_8 {

	public static void main(String[] args) throws InterruptedException  {
		
		//alert
		//confirmation pop up
		//warning/error  pop up
		//submition pop up
		// save password pop up
		//modal dialog
		//JS pop up
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if(text.contains("Please enter a valid user name")) {
			System.out.println("correct validation message");
		}
		
		//alert.accept(); //click on ok button
		alert.dismiss();  //press esc/click on cancel/dismiss  the alert


	}

}
