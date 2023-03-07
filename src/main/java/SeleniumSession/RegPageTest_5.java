package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest_5 {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil_2 brUtil = new BrowserUtil_2();
		WebDriver driver = brUtil.launchBrowser("Chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
        String title = brUtil.getPageTitle();
        System.out.println(title);
		
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		
		ElementUtil_5 eleUtil = new ElementUtil_5(driver);
		eleUtil.doSendKeys(firstname, "Miral");
		eleUtil.doSendKeys(lastname, "Dadhaniya");
		eleUtil.doSendKeys(email, "miral@gmail.com");
		
		Thread.sleep(5000);
		
		brUtil.closeBrowser();
		
	}

}
