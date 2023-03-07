package SeleniumSession;

import org.openqa.selenium.By;

public class CustomXpath_11 {

	public static void main(String[] args) {
		
		//class Examples
		
		By x1 = By.xpath("//input[@class='form-control private-form_control login-email']");    //right
		By x2 = By.className("form-control private-form_control login-email");      //wrong
		By x3 = By.className("login-email");                 //right
		By x4 = By.className("form-control");       //right
		
		
		
	}

}
