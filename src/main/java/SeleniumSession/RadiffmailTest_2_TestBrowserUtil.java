package SeleniumSession;

public class RadiffmailTest_2_TestBrowserUtil {

	public static void main(String[] args) {
		
		BrowserUtil_2 br = new BrowserUtil_2();
		br.launchBrowser("Chrome");
		br.enterUrl("http://www.rediffmail.com");
		String title = br.getPageTitle();
		System.out.println(title);
		
		if(title.contains("Rediff")) {
			System.out.println("correct title");
		}
		
		String url = br.getAppCurrentUrl();
		System.out.println(url);
		
		br.closeBrowser();

	}

}
