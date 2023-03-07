package SeleniumSession;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept_16 {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By username = By.name("username");
		By password = By.xpath("//input[@name='password']");
		By loginBtn = By.xpath("//input[@type='submit']");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement userName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));
//		userName_ele.sendKeys("miraldadhaniya");
//		doPrecenceOfElementLocated(username, 10).sendKeys("miralDadhaniya");
//		doSendKeys(username, 10, 1000, "miraldadhaniya");
//		
//		driver.findElement(password).sendKeys("Letmein4study");
//		driver.findElement(loginBtn).click();
		
		//TimeoutException: Expected condition failed: waiting for presence of element located by: By.name : username11
		//(tried for 10 second(s) with 500 milliseconds interval)
		
		By footer = By.xpath("//div[@class='row footer_links']//ul//a");
//		List<WebElement> footerList = WaitForElementsToBeVisible(footer, 5);
//		for(WebElement e : footerList) {
//			System.out.println(e.getText());
//		}
		if(getElementsTextListWithWait(footer, 5).contains("Testimonials")) {
			System.out.println("PASS");
		}

	}
	public static void doSendKeys(By locator,int timeOut,String value) {
		doPrecenceOfElementLocated(locator, timeOut).sendKeys(value);
	}
	public static void doSendKeys(By locator,int timeOut,long intervalTime,String value) {
		doPrecenceOfElementLocated(locator, timeOut,intervalTime).sendKeys(value);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement doPrecenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement doPrecenceOfElementLocated(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static WebElement isElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement WaitForElementToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement WaitForElementToBeVisibleWithWebElement(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	

	public static List<WebElement> WaitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<WebElement> WaitForElementsToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement> eleList = WaitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

}
