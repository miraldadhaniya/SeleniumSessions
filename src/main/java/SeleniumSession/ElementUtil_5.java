package SeleniumSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil_5 {
	
	private WebDriver driver;
	
	public ElementUtil_5(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;	
		default:
			System.out.println("Please pass correct locator type and value");
			break;
		}
		
		return locator;
		
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement getElement(By locator, int timeOut) {
		return doPrecenceOfElementLocated(locator, timeOut);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	
	public  WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public void doSendKeys(By locator, String Value) {
		getElement(locator).sendKeys(Value);
	}
	
	public void doSendKeys(String locatorType, String locatorValue, String Value) {
		getElement(locatorType, locatorValue).sendKeys(Value);
	}
	
	public void doSendKeys(By locator,int timeOut,String value) {
		doPrecenceOfElementLocated(locator, timeOut).sendKeys(value);
	}
	
	public void doClick(By locator) {
		  getElement(locator).click();
	  }
	
	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}
	
	public void doClick(By locator, int timeOut) {
		doPrecenceOfElementLocated(locator, timeOut).click();
	  }
	
	public String doGetText(By locator) {
		  return getElement(locator).getText();
	  }
	
	public String getAttributeValue(By locator,String attrName) {
		String attrVal = getElement(locator).getAttribute(attrName);
		System.out.println(attrVal);
		return attrVal;
	}
	
	public boolean doIsDisplayed(By locator ) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean isElementExist(By locator) {
		//int elementCount = driver.findElements(locator).size();
		//int elementCount = getElements(locator).size();
		
		int elementCount = getElementsCount(locator);
		System.out.println("total elements found: " + elementCount);
		
		if(elementCount>=1) {
			System.out.println("element is found " + locator);
			return true;
		}else {
			System.out.println("element is not found " + locator);
			return false;
		}
	}
	
	public int getElementsCount(By locator) {
		return getElements(locator).size();	
	}
	
	public void printElementValues(List<String> eleList) {
		for(String e : eleList) {
			System.out.println(e);
		}
	}
	
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String eleText = e.getText();
			    if(!eleText.isEmpty()) {
				eleTextList.add(eleText);	
			    }
		}
		return eleTextList;
	}
	
	public List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> attrList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
	}
	
	/******************************Drop Down Utils******************************/
	
	public void doDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doDropDownByText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public void doSelectDropDownValue(By locactor, String value) {
		Select select = new Select(getElement(locactor));
		List<WebElement> OptionList = select.getOptions();
		
		for(WebElement e : OptionList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public void selectDropDownValueWithoutSelect(By locator, String value) {

		List<WebElement> optionList = getElements(locator);
		System.out.println(optionList.size());
		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
/***********************************Links Util*********************************/
	
	public List<String> getLinksTextList(By locator) {
		List<WebElement> linksList = getElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		System.out.println(linksList.size());
		for(WebElement e : linksList) {
			String text = e.getText().trim();
			linksTextList.add(text);
		}
		return linksTextList;
		
	}
		
	public void clickOnElement(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		
		for(WebElement e : langList) {
			String text = e.getText().trim();
			System.out.println(text);
				if(text.equals(linkText)) {
					e.click();
				break;
			}
		}
	}
	
	/**************************Web Table Util**************************************/
	
	
	public  void printTable(By rowLocator, By colLocator,String beforeXpath, String afterXpath) {
		int rowCount = getElements(rowLocator).size();
		int colCount = getElements(colLocator).size();
		for(int row=2; row<=rowCount; row++) {
			for(int col=1; col<=colCount; col++) {
				String xpath = beforeXpath+row+afterXpath+col+"]" ;
				String text = doGetText(By.xpath(xpath));
				System.out.println(text+"    |     ");
						
			}
			System.out.println();
		}
		
	}
	
	
	/***********************Action Util*************************************/
	
	public void doMoveToElement(By locator) {
		Actions act =new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}
	
	public void doClickOnChildMenu(By parentMenuLocator , By childMenuLocator) throws InterruptedException {
		doMoveToElement(parentMenuLocator);
		Thread.sleep(3000);
		doClick(childMenuLocator);
	}
	
	public void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}
	
	public void doActionsSendKeysOnActiveElement(By locator,String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	
/*Click on the middle of the Element*/
	
	public void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	public void doActionMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}
	
	/***********************Wait Util***************************/
	
	
	
	public WebElement doPrecenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement doPrecenceOfElementLocated(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	

	
	public WebElement WaitForElementToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
//	public WebElement WaitForElementToBeVisibleWithWebElement(By locator, int timeOut, long intervalTime) {
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
//	return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
//}
	
	public List<WebElement> WaitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public List<WebElement> WaitForElementsToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement> eleList = WaitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	/***********************Wait Util For Non Web-Elements***************************/
	
	public boolean waitForURLToContain(String urlFraction, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public boolean waitForURLToBe(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public  String doGetTitleWithFraction(String titleFraction , int timeOut) {
		if(waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	public String doGetTitle(String title , int timeOut) {
		if(waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public boolean waitForTitleContains(String titleFraction , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	
	public boolean waitForTitleToBe(String title , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public void doAlertAccept(int timeOut) {
	   waitForAlert(timeOut).accept();
	}
	
	public void doAlertDismiss(int timeOut) {
		   waitForAlert(timeOut).dismiss();
		}
	
	public void enterAlertText(String text,int timeOut) {
		   waitForAlert(timeOut).sendKeys(text);
		}
	
	/*******************************wait util for Frame***************************/
	
	public void waitForFrameByNameOrId(String nameOrID, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
	}
	
	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public void waitForFrameByLocator(int frameLocator, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public void waitForFrameByElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void clickElementWhenReady(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofSeconds(intervalTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/********************Fluet wait utility**********************/
	
	public WebElement waitForElementPresntUsingFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
             	.withTimeout(Duration.ofSeconds(timeOut))
             	.pollingEvery(Duration.ofSeconds(pollingTime))
             	.ignoring(NoSuchElementException.class)
             	.ignoring(StaleElementReferenceException.class)
             	.withMessage(Error_18.ELEMENT_NOT_FOUND_ERROR_MESSG);
		
		  return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/********************WebDriver wait utility**********************/
	
	public WebElement waitForElementUsingWebDriverWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait
     	.pollingEvery(Duration.ofSeconds(pollingTime))
     	.ignoring(NoSuchElementException.class)
     	.ignoring(StaleElementReferenceException.class)
     	.withMessage(Error_18.ELEMENT_NOT_FOUND_ERROR_MESSG);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

}

