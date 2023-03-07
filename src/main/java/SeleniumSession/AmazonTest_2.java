package SeleniumSession;

public class AmazonTest_2 {

	public static void main(String[] args) {
	 
		BrowserUtil_2 br = new BrowserUtil_2();
		br.launchBrowser("Chrome");
		br.enterUrl("http://www.amazon.com");
		String title = br.getPageTitle();
		System.out.println(title);
		
		if(title.contains("Amazon")) {
			System.out.println("correct title");
		}
		
		String url = br.getAppCurrentUrl();
		System.out.println(url);
		
		br.closeBrowser();

	}

}
