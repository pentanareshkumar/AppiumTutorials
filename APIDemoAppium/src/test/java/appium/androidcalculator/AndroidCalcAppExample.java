package appium.androidcalculator;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidCalcAppExample {
	public static AndroidDriver<AndroidElement> driver;

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
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		driver = new AndroidDriver<AndroidElement>(new URL(service_url), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}	

	@Test
	public void Sum() {
		System.out.println("Calculate sum of two numbers");
		// Locate elements to enter data and click +/= buttons
		driver.findElement(By.xpath("//*[@text='1']")).click();
		driver.findElement(By.xpath("//*[@text='+']")).click();
		driver.findElement(By.xpath("//*[@text='2']")).click();
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();

		// Get the result text
		WebElement sumOfNumbersEle = driver.findElement(By.className("android.widget.EditText"));
		String sumOfNumbers = sumOfNumbersEle.getText();

		// verify if result is 3
		Assert.assertTrue(sumOfNumbers.endsWith("3"));
	}

	@AfterTest
	public void End() throws Exception {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}
}