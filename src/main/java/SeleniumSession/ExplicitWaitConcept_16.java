package SeleniumSession;

public class ExplicitWaitConcept_16 {

	public static void main(String[] args) {
		
		//Explicit wait is a high level wait 
		//its a concept
		//its dynamic 
		//not a global wait 
		//it can be applied for a specific element
		//it can be customized for a specific element as per the use case
		//e1- 5 sec
		//e2- no wait
		//e3- 10 secs
		//it can be applied for all non web elements :alert , url, title
		
		//WebDriverWait (C) - extends -> FluentWait (C) - implements-> Wait(I) --> until() -> abstract method
		
		//FluentWait(C) --> imp -->Wait(I) -- until(); method
		//until -- overridden
		//individual methods: ignoring(), withMessage(), pollingEvery()
		
		//WebDriverWait(C)--extends --> FluentWait(C)
		//timeoutException()  -- protected
		//1.until()--inherited
		//2.inherited methods :ignoring(), withMessage(), pollingEvery()
		

	}

}
