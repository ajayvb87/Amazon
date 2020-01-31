package com.appium.utilities;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import com.appium.base.BaseSettings;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidTouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Keywords extends BaseSettings {

	// Global variable
	public AndroidDriver<AndroidElement> driver1;
	public AndroidElement a1;
	public AndroidTouchAction t1;
	public Properties p1;
	public TakesScreenshot t;

	// Constructor
	public Keywords() {

		try {
			p1 = new Properties();
			// FileInputStream class will read the data from properties file in byte code
			// format
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\com\\appium\\config\\ObjectRepo.properties");
			// Load method of properties class is to load the properties file
			p1.load(fis);

			// Read
			// p1.getProperty("Xpath_Preference_OptionElement_Tap");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// To run the capability based on platform and device type
	// Platform - Android, IOS
	// Device Type - Real Device, Simulator/Emulators
	// DeviceType - real of IOS, ANDROID, emulator of Android
	// PlatformType - android, ios
	// CapabilityRunFile - Extension files --> apk(android), app (IOS), ipa (IOS)
	// Capability for IOS Real Time, Android Real Time, Android Emulator
	public void CapabilityRunFile(String deviceType, String platformType, String deName, String UID)
			throws MalformedURLException {
		if (deviceType.equals("real") && platformType.equals("android")) {
			driver1 = Keywords.InstallInvokeApk(deName, UID);
			driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else if (deviceType.equals("emulator") && platformType.equals("android")) {
			driver1 = Keywords.InstallInvokeApk(deName, UID);
			driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	}

	// Capability for ANDORID PACKAGE AND ACTIVITY for Emulator as well as for Real
	// time
	public void CapabilityRunFileAndoidPackage(String deName, String UID, String pac, String act)
			throws MalformedURLException {
		driver1 = Keywords.PackageActivity(deName, UID, pac, act);
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Keyword Function for tapping on an Element - tapElement - Buttons, CHeckbox,
	// Radio buttons
	public void tapElement(String platform, String locator, String locatorValue) {
		if (platform.equals("android") && locator.equals("xpath")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.xpath(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
		} else if (platform.equals("android") && locator.equals("id")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.id(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
		} else if (platform.equals("android") && locator.equals("className")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.className(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
		} else if (platform.equals("android") && locator.equals("androiduiautomator")) {
			// Keep the address of the element
			a1 = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
		}
	}

	// Keyword Function for typing on an Element - using TAP to blink the cursor on
	// the element followed by setting the value
	public void tapTypeElement(String platform, String locator, String locatorValue, String typeValue) {
		if (platform.equals("android") && locator.equals("xpath")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.xpath(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
			a1.setValue(typeValue);
		} else if (platform.equals("android") && locator.equals("id")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.id(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
			a1.setValue(typeValue);
		} else if (platform.equals("android") && locator.equals("className")) {
			// Keep the address of the element
			a1 = driver1.findElement(By.className(p1.getProperty(locatorValue)));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
			a1.setValue(typeValue);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")) {
			// Keep the address of the element
			a1 = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue));
			// Tap on the Element
			t1 = new AndroidTouchAction(driver1);
			t1.tap(tapOptions().withElement(element(a1))).perform();
			a1.setValue(typeValue);
		}
	}

	// Function to close the application
	public void closeApplication(String platform) {
		if (platform.equals("android")) {
			driver1.closeApp();
		}
	}

	// Function for static wait
	public static void staticTime(long val) {

		try {
			Thread.sleep(val);
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

	}

	// Function for taking Step Wise Screenshot

	public void stepScreenshot(String stepName, String platformType) {

		Date d = new Date();
		String dFormat = d.toString().replace(":", "_").replace("", "_");
		try {
			if (platformType.equals("android")) {

				t = (TakesScreenshot) driver1;
				File tempLoc = t.getScreenshotAs(OutputType.FILE);
				File permLoc = new File(
						"C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\Step_Screenshot\\"
								+ platformType + "_" + stepName + "_" + dFormat + ".png");
				// URL-->
				// https://jar-download.com/artifacts/commons-io/commons-io/2.6/source-code
				FileUtils.copyFile(tempLoc, permLoc);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Validation based function
	// 1.Validate by text
	// 2.Validate by attribute and its value

	// Function to validate by text - android ,ios
	public void validationText(String platform, String expectedText, String locator, String locatorValue, String msg) {
		if (platform.equals("android") && locator.equals("xpath")) {
			String actualText = driver1.findElement(By.xpath(p1.getProperty(locatorValue))).getText();
			Assert.assertTrue(actualText.equals(expectedText), msg);
		} else if (platform.equals("android") && locator.equals("id")) {

			String actualText = driver1.findElement(By.id(p1.getProperty(locatorValue))).getText();
			Assert.assertTrue(actualText.equals(expectedText), msg);
		} else if (platform.equals("android") && locator.equals("className")) {

			String actualText = driver1.findElement(By.className(p1.getProperty(locatorValue))).getText();
			Assert.assertTrue(actualText.equals(expectedText), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")) {

			String actualText = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue)).getText();
			Assert.assertTrue(actualText.equals(expectedText), msg);
		}
	}

	// Function to validate by attribute value - android ,ios
	public void validationAttributeValue(String platform, String expectedAttributeValue, String locator,
			String locatorValue, String msg, String attributeName) {
		if (platform.equals("android") && locator.equals("xpath") && attributeName.equals("resource-id")) {
			String actualAttributeValue = driver1.findElement(By.xpath(p1.getProperty(locatorValue)))
					.getAttribute("resource-id");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("xpath") && attributeName.equals("index")) {
			String actualAttributeValue = driver1.findElement(By.xpath(p1.getProperty(locatorValue)))
					.getAttribute("index");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("xpath") && attributeName.equals("text")) {
			String actualAttributeValue = driver1.findElement(By.xpath(p1.getProperty(locatorValue)))
					.getAttribute("text");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("xpath") && attributeName.equals("class")) {
			String actualAttributeValue = driver1.findElement(By.xpath(p1.getProperty(locatorValue)))
					.getAttribute("class");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("xpath") && attributeName.equals("package")) {
			String actualAttributeValue = driver1.findElement(By.xpath(p1.getProperty(locatorValue)))
					.getAttribute("package");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("id") && attributeName.equals("resource-id")) {
			String actualAttributeValue = driver1.findElement(By.id(p1.getProperty(locatorValue)))
					.getAttribute("resource-id\"");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("id") && attributeName.equals("index")) {
			String actualAttributeValue = driver1.findElement(By.id(p1.getProperty(locatorValue)))
					.getAttribute("index");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("id") && attributeName.equals("text")) {
			String actualAttributeValue = driver1.findElement(By.id(p1.getProperty(locatorValue))).getAttribute("text");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("id") && attributeName.equals("package")) {
			String actualAttributeValue = driver1.findElement(By.id(p1.getProperty(locatorValue)))
					.getAttribute("package");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("id") && attributeName.equals("class")) {
			String actualAttributeValue = driver1.findElement(By.id(p1.getProperty(locatorValue)))
					.getAttribute("class");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("className") && attributeName.equals("resource-id")) {
			String actualAttributeValue = driver1.findElement(By.className(p1.getProperty(locatorValue)))
					.getAttribute("resource-id");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("className") && attributeName.equals("class")) {
			String actualAttributeValue = driver1.findElement(By.className(p1.getProperty(locatorValue)))
					.getAttribute("class");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("className") && attributeName.equals("text")) {
			String actualAttributeValue = driver1.findElement(By.className(p1.getProperty(locatorValue)))
					.getAttribute("text");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("className") && attributeName.equals("package")) {
			String actualAttributeValue = driver1.findElement(By.className(p1.getProperty(locatorValue)))
					.getAttribute("package");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("className") && attributeName.equals("index")) {
			String actualAttributeValue = driver1.findElement(By.className(p1.getProperty(locatorValue)))
					.getAttribute("index");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")
				&& attributeName.equals("resource-id")) {
			String actualAttributeValue = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue))
					.getAttribute("resource-id");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")
				&& attributeName.equals("index")) {
			String actualAttributeValue = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue))
					.getAttribute("index");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")
				&& attributeName.equals("class")) {
			String actualAttributeValue = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue))
					.getAttribute("class");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator")
				&& attributeName.equals("package")) {
			String actualAttributeValue = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue))
					.getAttribute("package");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		} else if (platform.equals("android") && locator.equals("androiduiautomator") && attributeName.equals("text")) {
			String actualAttributeValue = driver1.findElementByAndroidUIAutomator(p1.getProperty(locatorValue))
					.getAttribute("text");
			Assert.assertTrue(actualAttributeValue.equals(expectedAttributeValue), msg);
		}

	}

	// public void FailScreenshot(String name, String platformType) {

	public String FailScreenshot(String name, String platformType) {
		Date d = new Date();
		String dFormat = d.toString().replace(":", "_").replace(" ", "_");
		String path = "C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\FailScreenshot\\"
				+ platformType + "_" + name + "_" + dFormat + ".png";

		try {
			if (platformType.equals("android")) {
				t = (TakesScreenshot) driver1;
				File tempLoc = t.getScreenshotAs(OutputType.FILE);

				File permLoc = new File(path);
				// URL-->
				// https://jar-download.com/artifacts/commons-io/commons-io/2.6/source-code
				FileUtils.copyFile(tempLoc, permLoc);
				return path;

			}

		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
			return msg;

		}
		return path;

	}
	
	
	//Keyword function for scrolling
	public void androidScrolling(String text) {
		//driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));").click();
		driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
	}
	
	//Keyword for pressing keys of Android device
	@SuppressWarnings("deprecation")
	public void androidKeyPress(int i) {
		//driver1.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER );
		//driver1.pressKeyCode(KeyEvent.VK_ENTER);
		//driver1.pressKeyCode(AndroidKeyCode.ENTER);
		driver1.pressKeyCode(i);
	}
	
	//Keyword function for changing orientation
	public void androidOrientation() {
		driver1.rotate(ScreenOrientation.LANDSCAPE);
	}

}
