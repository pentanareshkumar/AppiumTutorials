package appium.hybrid.app;

import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.By;

public class WebviewTest extends WebviewTestDriverBase {
	@Test
	public void AppLogin() throws InterruptedException {
		Thread.sleep(10000);

		Set<String> availableContexts1 = driver.getContextHandles();
		System.out.println("Total No of Context Found Before reaching WebView = " + availableContexts1.size());
		System.out.println("Context Name is " + availableContexts1);

		// 4.1 Navigate to a portion of your app where a web view is active
		driver.findElement(By.id("com.snc.test.webview2:id/action_go_website")).click();
		Thread.sleep(10000);

		// 4.2 Call getContext() method which will returns a list of contexts we
		// can access, like 'NATIVE_APP' or 'WEBVIEW_1'
		driver.findElement(By.id("com.snc.test.webview2:id/input_url")).sendKeys("www.google.com");
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(10000);

		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total No of Context Found After we reach to WebView = " + availableContexts.size());

		for (String context : availableContexts) {
			if (context.contains("WEBVIEW")) {
				System.out.println("Context Name is " + context);
				// 4.3 Call context() method with the id of the context you want
				// to access and change it to WEBVIEW_1
				// (This puts Appium session into a mode where all commands are
				// interpreted as being intended for automating the web view)
				driver.context(context);
				System.out.println("Context switched to Web View");
				break;
			}
		}

		driver.findElement(By.id("lst-ib")).sendKeys("Hello World");
		driver.findElement(By.id("tsbb")).click();

		Thread.sleep(10000);

		// 4.4 To stop automating in the web view context we can simply call the
		// context again with id NATIVE_APP.
		for (String context : availableContexts) {
			if (context.contains("NATIVE")) {
				System.out.println("We are Back to " + context);
				driver.context(context);
				System.out.println("Context switched back to Native_app");
				break;
			}
		}
		driver.findElement(By.id("com.snc.test.webview2:id/action_go_website")).click();
	}
}
