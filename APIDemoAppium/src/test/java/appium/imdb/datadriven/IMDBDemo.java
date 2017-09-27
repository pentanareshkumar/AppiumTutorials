package appium.imdb.datadriven;

import java.io.File;
import java.util.Set;

import org.testng.annotations.Test;

import appium.imdb.pages.HomePage;
import appium.imdb.pages.SignInPage;
import utility.ExcelUtils;

public class IMDBDemo extends IMDBDriverBase {

	HomePage homePage = new HomePage();
	SignInPage signInPage = new SignInPage();

	@Test
	public void SignInIDMB() throws Exception {
		// Scroll till element which contains "Views" text If It Is not visible

		Thread.sleep(5000);
		homePage.clickMenuAccount();
		homePage.clickOverFlow();
		homePage.clickSignInLink();

		signInPage.clickSigninWithIMDBBtn();
		Thread.sleep(5000);

		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total No of Context Found After we reach to WebView = " + availableContexts.size());

		for (String context : availableContexts) {
			if (context.contains("WEBVIEW")) {
				System.out.println("Context Name is " + context);
				// Call context() method with the id of the context you want
				// to access and change it to WEBVIEW_1
				// (This puts Appium session into a mode where all commands are
				// interpreted as being intended for automating the web view)
				driver.context(context);
				System.out.println("Context switched to Web View");
				break;
			}
		}

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("TestData.xlsx").getFile());		
		ExcelUtils.setExcelFile(file.getAbsolutePath(),"IMDB_Login");
		
		System.out.println(ExcelUtils.getCellData(1, 0));
		System.out.println(ExcelUtils.getCellData(1, 1));
		
		/*signInPage.enterEmailId("naresh5252003@gmail.com");
		signInPage.enterPassword("N@resh525");*/
		signInPage.enterEmailId(ExcelUtils.getCellData(1, 0));
		signInPage.enterPassword(ExcelUtils.getCellData(1, 1));
		signInPage.clickSignInBtn();

		// To stop automating in the web view context we can simply call the
		// context again with id NATIVE_APP.
		for (String context : availableContexts) {
			if (context.contains("NATIVE")) {
				System.out.println("We are Back to " + context);
				driver.context(context);
				System.out.println("Context switched back to Native_app");
				break;
			}
		}
		Thread.sleep(10000);
	}

	@Test
	public void SignOutIDMB() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible

		Thread.sleep(5000);
		homePage.clickMenuAccount();
		homePage.clickOverFlow();
		homePage.clickSignOutLink();

		Thread.sleep(10000);
	}

}
