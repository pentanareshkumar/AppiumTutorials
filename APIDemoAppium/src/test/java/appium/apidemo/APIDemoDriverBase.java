package appium.apidemo;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class APIDemoDriverBase {
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
		capabilities.setCapability("appPackage", "com.hmh.api");
		capabilities.setCapability("appActivity", "com.hmh.api.ApiDemos");

		driver = new AndroidDriver<AndroidElement>(new URL(service_url), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterTest
	public void End() throws Exception {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}
}
