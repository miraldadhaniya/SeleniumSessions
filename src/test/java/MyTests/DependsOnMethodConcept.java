package MyTests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	@Test
	public void createUserTest() {
		System.out.println("Create user test");
	}
	
	
	@Test
	public void loginTest() {
		System.out.println("login to app");
		//int a = 9/0;
	}
	
	@Test(dependsOnMethods = {"loginTest","createUserTest"} , priority = 1)
	public void homePageTest() {
		System.out.println("home page test");
	}
	
	@Test(dependsOnMethods = "loginTest", priority = 2)
	public void searchTest() {
		System.out.println("home page test");
	}

}

//depends on method having more importance than priority

//unit test:
//test case should be independent 
//never create any dependency
//every test should have its own pre condition,test steps,assertion,status


