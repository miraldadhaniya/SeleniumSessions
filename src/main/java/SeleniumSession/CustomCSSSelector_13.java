package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSSSelector_13 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//CSS Selector : its not an attribute
		

		//id --> #id
		//tagname#id --> you can associate tagname before id/classname
		//class --> .classname
		//tagname.classname
		
		//Ex: #input-email
		    //input#input-email
		    //.form-control
			//input.form-control
		
		//#id.classname
		//eg: #input-email.form-control
		//tag#id.classname
		//eg:input#input-email.form-control
		
		//.classname#id
		//eg: .form-control#input-email
		//eg: input.form-control#input-email
		
		//.c1.c2.c3....cn
		//.from-control.private-form_control.login-email
		//tagname.c1.c2.c3....cn
		//input.from-control.private-form_control.login-email
		//input.from-control.private-form_control.login-email#username
		//input#username.from-control.private-form_control.login-email
		
		
		//if id and class not available
		//tag[attr='value']
		//input[name='Name']  ---css selector
		//input[@name='Name']  ---xpath
		//By.cssSelector("input[name='Name']");
		//input[name='Name'][type='text']
		
		//tag[attr*='value']
		//input[id*='_Name'] --- * means contains
		//input[placeholder^='E-mail']---^ means starts-with
		//input[placeholder$='Address'] --$ means ends-with
		//input[id$='email']
		
		//parent to child:
		//div.private-form_input-wrapper input --2 (direct+indirect child)
		//div.private-form_input-wrapper > input --2 (only 2 direct)
		//form#hs-login div --20(direct + indirect divs)
		//form#hs-login > div (8 direct divs)
		
		//child to parent: not allowed
		//backward traversing not allowed in css
		//preceding-sibling is not allowed
		
		//following-sibling is allowed
		//div.private-form_input-wrapper+div
		//footer > .container > .row > div > ul.list-unstyled > li + li
		
		//comma in css:
		//input#username, input#password, button#loginBtn, label#UIFormControl-label-4
		List<WebElement> formFields = driver.findElements(By.cssSelector("input#username, input#password, button#loginBtn, label#UIFormControl-label-4"));
		System.out.println(formFields.size());
		if(formFields.size() == 4) {
			System.out.println("All the required fields are present on the page");
		}
		
        
		//nth-of-type:
		//div.footer-main ul li:nth-of-type(2)
		
	}

}


                       // xpath              |              css
 
//syntax              complex                           simple 
//function            better                            limited
//text                yes-text()                         N/A
//backward TR .       yes                               N/A
//WebTable            better handling                  limited options
//performance         good                             good
//diff tag check      NA                               comma
//attr validation     good                            better