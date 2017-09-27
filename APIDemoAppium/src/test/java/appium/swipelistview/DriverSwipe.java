package appium.swipelistview;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverSwipe {

	public static AndroidDriver<AndroidElement> driver;
	Dimension size;

	static String Appium_Node_Path = "C:\\Program Files (x86)\\Appium\\node.exe";
	static String Appium_JS_Path = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	static AppiumDriverLocalService service;
	static String service_url;

	public static void appiumStart() throws Exception {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(0)
				.usingDriverExecutable(new File(Appium_Node_Path)).withAppiumJS(new File(Appium_JS_Path)));
		service.start();
		Thread.sleep(25000);
		service_url = service.getUrl().toString();

		System.out.println("Appium Server Started with URL: " + service_url.toString());
	}

	public static void appiumStop() throws Exception {
		service.stop();
		System.out.println("Appium Server Stopped..");
	}

	@BeforeTest
	public void setUp() throws Exception {
		// Stop appium server If It Is already running.
		/* appiumStop(); */
		// Start appium server.
		appiumStart();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "192.168.223.101:5555");
		// capabilities.setCapability("browserName", "Android");
		// capabilities.setCapability("platformVersion", "6.0");
		// capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		capabilities.setCapability("appActivity",
				"com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");

		driver = new AndroidDriver<AndroidElement>(new URL(service_url), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}

	@Test(enabled=false)
	public void swipingHorizontal() throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;
		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		// Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(2000);

		// Swipe from Left to Right.
		driver.swipe(endx, starty, startx, starty, 3000);
		Thread.sleep(2000);
	}

	@Test(enabled=false)
	public void swipingVertical() throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		// Swipe from Bottom to Top.
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		// Swipe from Top to Bottom.
		driver.swipe(startx, endy, startx, starty, 3000);
		Thread.sleep(2000);
	}

	@Test
	public void swipingHorizontalUsingTouchAction() throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe x points from screen's with and height.
		// Find x1 point which is at right side of screen.
		int x1 = (int) (size.width * 0.20);
		// Find x2 point which is at left side of screen.
		int x2 = (int) (size.width * 0.80);

		// Create object of TouchAction class.
		TouchAction action = new TouchAction(driver);

		// Find element to swipe from right to left.
		WebElement ele1 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front")
				.get(3);
		// Create swipe action chain and perform horizontal(right to left)
		// swipe.
		// Here swipe to point x1 Is at left side of screen. So It will swipe
		// element from right to left.
		action.longPress(ele1).moveTo(x1, 580).release().perform();

		// Find element to swipe from left to right.
		WebElement ele2 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back")
				.get(3);
		// Create swipe action chain and perform horizontal(left to right)
		// swipe.
		// Here swipe to point x2 Is at right side of screen. So It will swipe
		// element from left to right.
		action.longPress(ele2).moveTo(x2, 580).release().perform();
	}

	@AfterTest
	public void End() throws Exception {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}

}
