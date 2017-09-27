package appium.apidemo;

import java.text.DateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

@Listeners(utility.ListenerUtility.class)
public class APIDemo extends APIDemoDriverBase {

	String destDir;
	DateFormat dateFormat;

	@Test(enabled=false)
	public void typeInText() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Typing in text box using sendKeys command.
		driver.findElement(By.id("com.hmh.api:id/edit")).sendKeys("Test");
	}

	@Test(enabled = false)
	public void checkboxCheck() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Click on check-box to select it.
		driver.findElement(By.id("com.hmh.api:id/check1")).click();
	}

	@Test(enabled = false)
	public void hideAndroidKeyboard() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Typing in text box using sendKeys command.
		driver.findElement(By.id("com.hmh.api:id/edit")).sendKeys("Test");
		driver.findElement(By.id("com.hmh.api:id/edit")).sendKeys("Test1");
		// To hide keyboard.
		driver.hideKeyboard();
	}

	@Test(enabled = false)
	public void selectItemFromDropDownList() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Click on dropdown to open list.
		driver.findElement(By.id("com.hmh.api:id/spinner1")).click();
		// Select item "Mars" from drop down list.
		driver.findElement(By.name("Mars")).click();
	}

	@Test(enabled = false)
	public void RetriveDropDownListValues() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();

		// Click on dropdown to open list.
		driver.findElement(By.id("com.hmh.api:id/spinner1")).click();
		// Locate all drop down list elements
		List<AndroidElement> dropList = driver.findElements(By.id("android:id/select_dialog_listview"));
		// Extract text from each element of drop down list one by one.
		for (int i = 0; i < dropList.size(); i++) {
			MobileElement listItem = (MobileElement) dropList.get(i);
			System.out.println(listItem.getText());
		}
	}

	@Test(enabled = false)
	public void selectRadioButton() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Controls" text If It Is not
		// visible on screen.
		driver.scrollTo("Controls");
		// Click on Controls.
		driver.findElement(By.name("Controls")).click();
		// Scroll till element which contains "2. Dark Theme" text If It Is not
		// visible on screen.
		driver.scrollTo("2. Dark Theme");
		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Click on RadioButton 2 to select it.
		driver.findElement(By.name("RadioButton 2")).click();
	}

	@Test(enabled = false)
	public void tapSwitchOnOff() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Switches" text If It Is not
		// visible on screen.
		driver.scrollTo("Switches");
		// Click on Switches.
		driver.findElement(By.name("Switches")).click();

		// Get status of switch using it's text.
		String switchStatus1 = driver.findElementById("io.appium.android.apis:id/monitored_switch").getText();
		System.out.println(switchStatus1);
		// If switchStatus1 = Monitored switch OFF, Execute inner code.
		if ((switchStatus1.trim()).equals("Monitored switch OFF")) {
			System.out.println("Doing Monitored switch ON");
			// Locate switch button element by name = Monitored switch OFF.
			MobileElement swt = (MobileElement) driver.findElementByName("Monitored switch OFF");
			// Tap on switch button "Monitored switch OFF" to make it ON.
			swt.tap(1, 1);
			System.out.println("Monitored switch is ON now.");
		}
		// Pause test for 5 seconds to put switch ON for 5 seconds.
		Thread.sleep(5000);

		// Get status of switch using it's text.
		String switchStatus2 = driver.findElementById("io.appium.android.apis:id/monitored_switch").getText();
		System.out.println(switchStatus2);
		// If switchStatus1 = Monitored switch ON, Execute inner code.
		if ((switchStatus2.trim()).equals("Monitored switch ON")) {
			System.out.println("Doing Monitored switch OFF");
			// Locate switch button element by name = Monitored switch ON.
			MobileElement swt = (MobileElement) driver.findElementByName("Monitored switch ON");
			// Tap on switch button "Monitored switch OFF" to make it OFF.
			swt.tap(1, 1);
			System.out.println("Monitored switch is OFF now.");
		}
	}

	@Test(enabled = false)
	public void ScrollToView() {
		// Scroll till element which contains
		// "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");

		// Click on Views.
		driver.findElement(By.name("Views")).click();
	}

	@Test(enabled = false)
	public void ControlSeekBar() {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Seek Bar" text If It Is not
		// visible on screen.
		driver.scrollTo("Seek Bar");
		// Click on Seek Bar.
		driver.findElement(By.name("Seek Bar")).click();

		// Locate SeekBar element.
		WebElement seekBar = driver.findElementById("com.hmh.api:id/seek");
		// Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX);
		// Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		// Set sllebar move to position.
		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * 0.6);
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(startX, yAxis).moveTo(moveToXDirectionAt, yAxis).release().perform();
	}

	@Test(enabled = false)
	public void performOrientation() throws InterruptedException {
		// Get and print current screen orientation.
		System.out.println("*--*--*-- Current screen orientation Is : " + driver.getOrientation());
		System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		// Changing screen Orientation to LANDSCAPE.
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());
		Thread.sleep(5000);
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		// Changing screen Orientation to PORTRAIT.
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());
		Thread.sleep(5000);
	}

	// Check element App is present or not on page.
	@Test(enabled = false)
	public void checkAppElementPresent() {
		// There is element with name App on screen.
		// So iselementpresent will be set to true.
		Boolean iselementpresent = driver.findElementsByName("App").size() != 0;
		// iselementpresent will be true so assertion will pass and so test
		// method will pass too.
		Assert.assertTrue(iselementpresent, "Targeted element App is not present on screen");
		System.out.println("Targeted element App is present on screen.");
	}

	// Check element Loader is present or not on page.
	@Test(enabled = false)
	public void checkLoaderElementPresent() {
		// There is not any element like Loader on screen.
		// So iselementpresent will be set to false.
		Boolean iselementpresent = driver.findElementsByName("Loader").size() != 0;
		// iselementpresent will be false so assertion will fail and so test
		// method will fail too.
		Assert.assertTrue(iselementpresent, "Targeted element Loader is not present on screen");
		System.out.println("Targeted element Loader is present on screen.");
	}

	@Test(enabled = false)
	public void okOnAlert() {
		// Scroll till element which contains "App" text.
		driver.scrollTo("App");
		// Click on App.
		driver.findElement(By.name("App")).click();
		// Scroll till element which contains "Alert Dialogs" text.
		driver.scrollTo("Alert Dialogs");
		// Click on Alert Dialogs.
		driver.findElement(By.name("Alert Dialogs")).click();
		// Click on "OK Cancel dialog with a message" button.
		driver.findElement(By.name("OK Cancel dialog with a message")).click();
		// Get the text from alert dialog.
		String result = driver.findElementById("android:id/alertTitle").getText();
		System.out.println("Alert text Is -> " + result);
		// Click on OK button of alert dialog.
		driver.findElement(By.name("OK")).click();
		// Click on Cancel button of alert dialog.
		// driver.findElement(By.name("Cancel")).click();
	}

	@Test(enabled = false)
	public void dateSet() {
		// Scroll till element which contains "Views" text.
		driver.scrollTo("Views");
		// Click on Views.
		driver.findElement(By.name("Views")).click();
		// Scroll till element which contains "Date Widgets" text.
		driver.scrollTo("Date Widgets");
		// Click on element which contains "Date Widgets" text.
		driver.findElement(By.name("Date Widgets")).click();
		// Scroll till element which contains "1. Dialog" text.
		driver.scrollTo("1. Dialog");
		// Click on element which contains "1. Dialog" text.
		driver.findElement(By.name("1. Dialog")).click();
		// Click on button which contains "change the date" text.
		driver.findElement(By.name("change the date")).click();
		// Set Date = 25.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("25");
		// Set Month = Aug.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("Aug");
		// Set Year = 2009.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("2009");
		// Click on Done button.
		driver.findElement(By.id("android:id/button1")).click();
	}

	@Test(enabled = false)
	public void timeSet() {
		// Click on button which contains "change the time" text.
		driver.findElement(By.name("change the time")).click();
		// Set Hours = 1.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("1");
		// Set Minutes = 25.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("25");
		// Set pm.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("pm");
		// Click on Done button.
		driver.findElement(By.id("android:id/button1")).click();
	}

	// Set 3 StarRatingbar = 1 star.
	@Test(enabled=false)
	public void set3StarRatingbar() {
		// Locate threeStarRatingbar.
		WebElement threeStarRatingbar = driver.findElement(By.id("com.hmh.api:id/ratingbar1"));
		// Get start point of threeStarRatingbar.
		int startX = threeStarRatingbar.getLocation().getX();
		System.out.println(startX);
		// Get end point of threeStarRatingbar.
		int endX = threeStarRatingbar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of threeStarRatingbar.
		int yAxis = threeStarRatingbar.getLocation().getY();

		// Set threeStarRatingbar tap position to set Rating = 1 star.
		// You can use endX * 0.3 for 1 star, endX * 0.6 for 2 star, endX * 1
		// for 3 star.
		int tapAt = (int) (endX * 0.3);
		// Set threeStarRatingbar to Rating = 1.0 using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(tapAt, yAxis).release().perform();
	}

	// Set 5 StarRatingbar = 4 star.
	@Test(enabled=false)
	public void set5StarRatingbar() {
		// Locate fiveStarRatingbar.
		WebElement fiveStarRatingbar = driver.findElement(By.id("com.hmh.api:id/ratingbar2"));
		// Get start point of fiveStarRatingbar.
		int startX = fiveStarRatingbar.getLocation().getX();
		System.out.println(startX);
		// Get end point of fiveStarRatingbar.
		int endX = fiveStarRatingbar.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of fiveStarRatingbar.
		int yAxis = fiveStarRatingbar.getLocation().getY();

		// Set fiveStarRatingbar tap position to set Rating = 4 star.
		// You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6
		// for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
		int tapAt = (int) (endX * 0.8);
		// Set fiveStarRatingbar to Rating = 4 star using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(tapAt, yAxis).release().perform();
	}
	
	@Test(enabled=false)
	public void ScrollToTab() throws InterruptedException {
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.scrollTo("Views");
		// Click on Views/.
		driver.findElement(By.name("Views")).click();
		System.out.println("Vertical scrolling has been started to find text -> Tabs.");
		// Scroll till element which contains "Tabs" text.
		driver.scrollTo("Tabs");
		System.out.println("Tabs text has been found and now clicking on It.");
		// Click on Tabs
		driver.findElement(By.name("Tabs")).click();
		// Click on Scrollable text element.
		driver.findElement(By.name("5. Scrollable")).click();
		System.out.println("Horizontal scrolling has been started to find tab -> Tab 11.");
		// Used for loop to scroll tabs until Tab 11 displayed.
		for (int i = 0; i <= 10; i++) {
			// Set implicit wait to 2 seconds for fast horizontal scrolling.
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (driver.findElements(By.name("Tab 11")).size() != 0) {
				// If Tab 11 Is displayed then click on It.
				System.out.println("Tab 11 has been found and now clicking on It.");
				driver.findElement(By.name("Tab 11")).click();
				break;
			} else {
				// If Tab 11 Is not displayed then scroll tabs from right to
				// left direction by calling ScrollTabs() method.
				ScrollTabs();
			}
		}
		// Set implicit wait to 15 seconds after horizontal scrolling.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Locate parent element of text area.
		WebElement ele1 = (WebElement) driver.findElements(By.id("android:id/tabcontent")).get(0);
		// Locate text area of Tab 11 using It's parent element.
		WebElement ele2 = ele1.findElement(By.className("android.widget.TextView"));
		// Get text from text area of Tab 11 and print It In console.
		System.out.println("Text under selected tab is -> " + ele2.getText());
	}

	// To scroll tabs right to left In horizontal direction.
	public void ScrollTabs() {
		// Get the size of screen.
		size = driver.manage().window().getSize();

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Set Y Coordinates of screen where tabs display.
		int YCoordinates = 150;

		// Swipe tabs from Right to Left.
		driver.swipe(startx, YCoordinates, endx, YCoordinates, 3000);
	}

}